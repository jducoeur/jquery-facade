# jquery-facade
A strongly-typed Scala.js facade for jQuery

### Installing the Library

To use jquery-facade, add this line to your libraryDependencies:
```
"org.querki" %%% "jquery-facade" % "0.1"
```
The jquery-facade library will import the underlying jQuery code; you do not need to (and shouldn't) repeat it in
your own build.sbt. This will be exposed as "jquery.js", and you can depend on that in jsDependencies.

### Using jquery-facade

In general, to use jQuery, I recommend simply putting

```
import org.querki.jquery._
```

at the top of your file. While individual pieces *can* be imported, this facade uses a fair number of implicits
in order to do its thing, so it is usually easier to just import the entire thing.

The most important function in this facade is `$()`, which works the same way it does in JavaScript: it
wraps the given Element as a JQuery object. (Or creates a node from a given String, although I recommend
using Scalatags instead -- it's more strongly-typed and Scala-ish.) `$` is an alias for the underlying
JQueryStatic object, which is the facade for the global JQuery object in JavaScript. I recommend using
the `$` alias, since that matches JavaScript idiom, and means that much JS documentation matches the
resulting Scala code.

Note that the facade is actually broken up into several different traits. This isn't terribly obvious from
a code point of view, but important for reading the documentation and finding the signatures. On the one hand,
there is the **JQuery** trait -- the "real" facade, which represents an actual JS jQuery object. Then there is
**JQueryTyped** -- a supplemental class, which adds many more overloads on top of "internal" entry points in JQuery.

The reason for this division is that jQuery uses overloading *heavily*, in a way that doesn't play well with
Scala. Essentially, a number of jQuery entry points define parameters as type unions: you can use any of several
types in the parameter, and jQuery will do the right thing depending on the type actually passed in. The problem
is, this leads to a combinatoric explosion of overloads in Scala, which is difficult to maintain.

jquery-facade deals with this problem by using a sort of imitation type union, built on top of Scala's standard
Either type. At the moment, there are several of these type unions defined in package.scala. The most important
is Selector, which is a common and explicit parameter type in jQuery, but ElementDesc and AttrVal have also
proved quite useful.

### Why this library?

JQuery is one of the most central components in the JavaScript ecosystem: not only is it used directly by many
web applications, a large fraction of the other major libraries are built on top of it. So while it isn't
strictly necessary for Scala.js development, complex projects often find that they need it.

The original facade for jQuery -- scala-js-jquery -- was one of the first facades promulgated as Scala.js began
to be ready for real use. It is more or less complete, but it was written fairly quickly, and the result is that
it is pretty loosely typed. That is, it functions, but it doesn't provide a lot of type support for the compiler
and IDE. This is mostly because the type-union problem was mostly dealt with by simply defining these parameters
as js.Any. It is also slightly inaccurate in a few details -- in particular, some facade signatures return T where
they should return UndefOr[T], which would cause surprising crashes in Scala.js code when the function returned
undefined.

Over the course of several months of using it very heavily, I got somewhat frustrated by this, and gradually decided
to do a rewrite. I originally thought about trying to update scala-js-jquery in place, but the desired changes
were *so* dramatic, sometimes breaking, that the authors of scala-js-jquery and I agreed that I should create a new
library instead, which folks could opt into.

### Caveats

As of this writing, this facade is quite incomplete.  jQuery is enormous and complex, and the philosophy behind this
facade has been that doing it right is more important than shoving it all out the door quickly. There are a bunch
of functions entirely missing, and a substantial number of overloaded signatures that need to be filled in. If you
need a few specific functions, drop me a line and I'll see about adding them. (And Pull Requests are welcomed.)

The type unions such as Selector are a bit inefficient -- they wind up creating and then unwinding some small objects
in the course of invocation. I haven't found this to be a problem in practice, and it's likely a drop in the bucket
compared to the function-indirection weight inside jQuery itself, but it's not a trivial consideration. If you care
about squeezing every cycle out of your Scala.js code, you may want to pay attention to this.

### License

Copyright (c) 2015 Querki Inc. (justin at querki dot net)

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
