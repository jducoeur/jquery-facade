# jquery-facade
A strongly-typed Scala.js facade for jQuery

### Using the Library

To use jquery-facade, add this line to your libraryDependencies:
```
"org.querki" %%% "jquery-facade" % "1.0-RC3"
```
**Important:** jquery-facade no longer automatically includes the underlying JavaScript jQuery library, because doing so was causing versioning problems for applications. So you will also need to include the jQuery in your jsDependencies. How you do so depends on how you want to include it. For example, in order to fetch the most recent version (as of this writing, 2.2.1) from the online WebJars collection, add the following line:
```
jsDependencies += "org.webjars" % "jquery" % "2.2.1" / "jquery.js" minified "jquery.min.js"
```
Note that jquery-facade and the underlying jQuery library do *not* need to be exactly in sync, but I recommend using a reasonably recent version of the library.

### Using jquery-facade

**The Important bit:** mostly, this facade should just work as expected. We discuss the details a lot
below, but mostly those details are there so that it *does* work as expected. The objective is a facade
that matches idiomatic JavaScript examples reasonably well, but is strongly-typed at the Scala level.

In general, to use jQuery, I recommend simply putting

```
import org.querki.jquery._
```

at the top of your file. While individual pieces *can* be imported, this facade uses a fair number of implicits
in order to do its thing, so it is usually easier to just import the entire thing.

Note that the entry points in here are only lightly documented, usually with the headline of what the function
does. I'm not going to try to duplicate everything, so I strongly recommend keeping [the official jQuery API
documentation](http://api.jquery.com/) open while you're working with this facade -- it is the official word
on how things are supposed to work, and helps explain some of the odder nuances. (Eg, entry points that do
different things depending on the format of the string you pass in.) If you find inconsistencies between the
API documentation and this facade, please raise Issues.

The most important function in this facade is `$()`, which works the same way it does in JavaScript: it
"selects" the given Element, or the Elements indicated by the String Selector. 
(Or creates a node from a given HTML String, although I recommend using Scalatags for that instead -- 
it's more strongly-typed and Scala-ish.) `$` is an alias for the underlying
JQueryStatic object, which is the facade for the global JQuery object in JavaScript. I recommend using
the `$` alias, since that matches JavaScript idiom, and means that much JS documentation matches the
resulting Scala code.

By and large, this is a straightforward facade, so you can use jQuery as you would expect, chaining calls
together to do what you want.

Note that some methods take odd types, most often Selector. There are pseudo-type-unions, which allow you
to pass any of several types in to this parameter. The type unions currently in use are:

* Selector -- this defines a way to get to an Element. It can be a String (using jQuery's [enhanced version of CSS Selectors](http://api.jquery.com/category/selectors/), an actual Element, or a js.Array[Element].
* ElementDesc -- this is a sort of enhanced version of Selector that some methods use. It takes all of Selector, or another JQuery.
* AttrVal -- this is any of the types that can be in an Attribute: String or Int or Boolean.

For ease of use, there are implicit defs for Selector and ElementDesc so that you can pass a Seq[Element] instead of a 
js.Array[Element], and it will be auto-converted.

As of this writing, jquery-facade is roughly complete: it includes at least most known entry points in jQuery.
That said, the majority of those entry points have not yet been tested from Scala, and I haven't gone through
the library with a fine-toothed comb looking for omissions. If you come across bugs or missing bits (both quite
plausible), please enter an Issue on GitHub, and pull requests for fixes are greatly welcomed.

#### Extensions

There is also a JQueryExtensions trait, as another implicit conversion from JQuery. This contains methods
that are *not* straightforward facades, but which I have found useful in working with jQuery from Scala.js.
While I'm not going hog-wild with this, I'm slowly adding to it. Pull Requests are welcomed. (Also, consider
these a bit experimental at the moment -- most of them predate SJS 0.6 and this being pulled out into a library,
and some might be redundant at this point.)

Note that, as of this writing, I am pondering the notion of fleshing out a proper JQuery Monad, so that you
could use JQuery inside for comprehensions. I don't think the idea is crazy; opinions are welcomed.

### Why this library?

JQuery is one of the most central components in the JavaScript ecosystem: not only is it used directly by many
web applications, a large fraction of the other major libraries are built on top of it. So while it isn't
strictly necessary for Scala.js development, complex projects often find that they need it.

The original facade for jQuery -- scala-js-jquery -- was one of the first facades promulgated as Scala.js began
to be ready for real use. It is more or less complete, but it was written fairly quickly, and the result is that
it is very loosely typed. That is, it functions, but it doesn't provide a lot of type support for the compiler
and IDE. This is mostly because the type-union problem was mostly dealt with by simply defining these parameters
as js.Any. It is also slightly inaccurate in a few details -- in particular, some facade signatures return T where
they should return UndefOr[T], which would cause surprising crashes in Scala.js code when the function returned
undefined.

Over the course of several months of using it very heavily, I got somewhat frustrated by this, and gradually decided
to do a rewrite. I originally thought about trying to update scala-js-jquery in place, but the desired changes
were *so* dramatic, sometimes breaking, that the authors of scala-js-jquery and I agreed that I should create a new
library instead, which folks could opt into.

### Caveats

As of this writing, this facade is roughly complete, but much of it is in a first-draft state. The majority of the entry
point were blown in quickly, based on the jQuery documentation. So it is likely that there are some bugs here and there.
Please report any that you come across.

### Converting from scala-js-jquery

By and large, I tried to avoid *gratuitous* incompatibilities between the libraries (after all, I had a large code
base of my own to convert), but some code change is necessary:

* At the least, you need to change the libraryDependency, and change the imports in your .scala files to `import org.querki.jquery._`.
* If you weren't already aliasing `jQuery` to `$`, you'll want to change your calls.
* A number of methods have subtly different signatures. Most importantly, attr() returns UndefOr[String] here, where it returns String in scala-js-jquery. You will need to add a `.get` to such a call, or (better) treat it like an Option and use something like `.map`.
* The larger "options" objects that you sometimes need to create, such as JQueryAjaxSettings and JQueryAnimationSettings, are written in JSOptionBuilder style. This means that, to create one of these objects, you use a series of chained function calls, like this:
```
$(myElement).fadeIn(JQueryAnimationSettings.
  duration(1000).
  queue("myAnimationQueue").
  complete({elem => println("I'm done fading in!")})
)
```
* Smaller objects, that require you to fill in all fields, use @ScalaJSDefined style instead. For example, to set an offset:
```
$(myElement).offset(new JQueryPosition {
  val left = 400
  val top = 50
})
```

### Contributing to jquery-facade

Pull Requests are welcome, but please observe the style guidelines of this library:

* When the underlying jQuery call takes a parameter matching one of the type unions (especially Selector), please use that union type. However, please note that the jQuery API documentation is very inconsistent: when they say a parameter takes "Selector", they sometimes really mean a Selector -- String or Element or js.Array[Element] -- but sometimes just mean String. And sometimes they *don't* say that it takes Selector, but instead spell out the possible types and leave you to infer that they mean Selector. Read the API docs carefully, and try to interpret them correctly.
* JQuery and JQueryStatic are in alphabetical order, to make it easier to find things; please keep it that way.
* Please include a brief comment with each entry point, to remind folks of what it does. I usually use the summary line from the actual jQuery API.
* You do *not* have to include every possible overload for a function, but thoroughness is appreciated.
* Accuracy is paramount: all overloads should be strictly typed to match the jQuery documentation as best possible.
* If a parameter takes "anything", try to figure out whether jQuery is processing that parameter in any way. If it is, the parameter should be js.Any; if not (if it is completely opaque), then it should be scala.Any. For example, a "data" parameter, that jQuery is simply passing along to callbacks, should usually be scala.Any.
* If a callback parameter ignores its return value, the return type should be scala.Any.
* Be careful about the return value from a method. Most JQuery methods return JQuery, but not all.
* When a facade function takes a property bag, if it is understood to be name/value pairs in JS, declare it as js.Dictionary[T]. Often, we can constrain T; if not, just put js.Dictionary[js.Any], and it is at least explicit that it is name/value pairs.

### What's New

* **1.0-RC3** -- Fix to the facade for `each`; this had been combining js.Function types with `|`, and that turns out to interfere with the compiler's ability to infer the cast from Scala to JavaScript function types. So switched this to a couple of overloads instead.

* **1.0-RC2** -- Introduced the `EventHandler` pseudo-union type, and switched to use that for all of the event-binding entry points. This should make the facade more consistent about letting you use any of the sensible callback signatures for those functions. See the definition of `EventHandler` (in `package.scala`) for the possible signatures.

    Also, switched away from declaring optional parameters as `UndefOr` and `= js.undefined`, to using `= ???` instead. This has the advantage of allowing me to use `|` for those parameters, which allows consolidation of quite a number of duplicate signatures. This change is *mostly* innocuous, but does mean you can't just pass `undefined` into those parameters. (This should never be necessary.)

* **1.0-RC1** -- Decided that I was tired of the scalajs-jquery / jquery-facade split, so blew in the rest of the missing entry points. At this point, I believe that jquery-facade is more or less complete, but bugs are fairly likely: I've roughly tripled the size of the library, and none of the new stuff is tested yet. Please test, and report any problems you find.

* **0.11** -- Added `load()`, and tweaked `prop()`.

* **0.10** -- Added more overloads of `on()`.

* **0.8** -- Fleshed out JQueryEventObject facade with more of the fields. Updated to jQuery 2.1.4.

* **0.7** -- introduced the new `\/` type-union mechanism, which is currently in testing to go into the main Scala.js release. This simplifies the jquery-facade considerably, and allows us to get rid of JQueryTyped. Besides resulting in clearer code, this new mechanism should be much more efficient than the old approach, since it focuses on proving the conversions to the compiler without introducing all those extra runtime objects.

### License

Copyright (c) 2015 Querki Inc. (justin at querki dot net)

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
