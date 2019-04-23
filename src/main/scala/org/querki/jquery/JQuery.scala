package org.querki.jquery

import scala.scalajs.js
import js.UndefOr
import js.|
import js.annotation.{JSName, ScalaJSDefined}

import org.scalajs.dom
import dom.Element

/**
 * A facade for the main jQuery object.
 * 
 * This is a reimplementation, very loosely based on the existing scalajs-jquery. It aims to be much
 * more strongly and precisely typed, while being as literal a translation of the functionality of jQuery
 * as possible. It is intentionally pretty close to scalajs-jquery, and many files can be switched over
 * by simply switching the import, but compatibility has *not* been a priority, and a modest number of
 * functions have changed in breaking ways. (This is one reason why I treated this as a rewrite rather
 * than as an evolution of the existing library.)
 * 
 * TODO: as of this writing, this is *quite* incomplete; I am only adding functions as I use them, and
 * at least half of them are currently missing. Pull requests are greatly welcomed. In particular, we are
 * lacking many overloads -- I've added some of them, but many jQuery functions have a considerable number
 * of potential overloads.
 * 
 * Many parameters are polymorphic. We often use | (type union) to define these, but | and UndefOr don't mix,
 * so we often have to spell things out in more detail. Also, you can't use a js.Function or js.ThisFunction
 * in a | expression, because it interferes with the compiler's implicit conversion from a Scala function
 * to a js.Function. Note that there are several common unions such as Selector defined in package.scala.
 * 
 * Things are also often spelled out more explicitly than you might expect, because Scala restricts us to
 * one overload per method with default parameters; this limits our usage of UndefOr.
 * 
 * We don't necessarily spell out every possible overload here, although we've made a serious effort to
 * make every version of the JS calls possible. In some cases, we only have versions that involve some
 * extra parameters. If you find yourself really wanting an overload that takes fewer parameters, pull
 * requests are welcome.
 * 
 * NOTE: discussion on scalajs Gitter, 1/28/15, says that facades should *return* Any, but
 * *take* js.Any *if* the Javascript is going to process the value in any way. This is the guiding principle here.
 * 
 * Also: when a facade function takes a property bag, if it is understood to be name/value pairs
 * in JS, declare it as js.Dictionary[T]. Often, we can constrain T; if not, just put js.Any, and it
 * is at least explicit that it is name/value pairs.
 * 
 * Long-deprecated functions are, by and large, simply omitted. Please see the jQuery documentation to see
 * what to use instead.
 */
@js.native
trait JQuery extends js.Object {
  
  /**
   * Create a new jQuery object with elements added to the set of matched elements.
   */
  def add(selector:ElementDesc):JQuery = js.native
  def add(selector:String, context:Element):JQuery = js.native
  
  /**
   * Add the previous set of elements on the stack to the current set, optionally filtered by a selector.
   */
  def addBack(selector:String = ???):JQuery = js.native
  
  /**
   * Adds the specified class(es) to each of the set of matched elements.
   */
  def addClass(classNames:String):JQuery = js.native
  def addClass(func:js.ThisFunction2[Element, Int, String, String]):JQuery = js.native
  
  /**
   * Insert content, specified by the parameter, after each element in the set of matched elements.
   */
  def after(content:ElementDesc*):JQuery = js.native
  def after(func:js.ThisFunction0[Element, ElementDesc]):JQuery = js.native
  def after(func:js.ThisFunction1[Element, Int, ElementDesc]):JQuery =  js.native
  
  /**
   * Register a handler to be called when Ajax requests complete.
   */
  def ajaxComplete(handler:js.Function3[JQueryEventObject, JQueryXHR, JQueryAjaxSettings, Any]):JQuery = js.native
  
  /**
   * Register a handler to be called when Ajax requests complete with an error.
   */
  def ajaxError(handler:js.Function4[JQueryEventObject, JQueryXHR, JQueryAjaxSettings, String, Any]):JQuery = js.native
  
  /**
   * Attach a function to be executed before an Ajax request is sent.
   */
  def ajaxSend(handler:js.Function3[JQueryEventObject, JQueryXHR, JQueryAjaxSettings, Any]):JQuery = js.native
  
  /**
   * Register a handler to be called when the first Ajax request begins.
   */
  def ajaxStart(handler:js.Function0[Any]):JQuery = js.native
  
  /**
   * Register a handler to be called when all Ajax requests have completed.
   */
  def ajaxStop(handler:js.Function0[Any]):JQuery = js.native
  
  /**
   * Attach a function to be executed whenever an Ajax request completes successfully.
   */
  def ajaxSuccess(handler:js.Function4[JQueryEventObject, JQueryXHR, JQueryAjaxSettings, js.Object, Any]):JQuery = js.native
  
  /**
   * Perform a custom animation of a set of CSS properties.
   */
  def animate(
    properties:js.Dictionary[js.Any], 
    duration:Number | String, 
    easing:String = ???, 
    complete:js.ThisFunction0[Element, Any] = ???):JQuery = js.native
  def animate(properties:js.Dictionary[js.Any], options:JQueryAnimationSettings):JQuery = js.native
    
  /**
   * Insert content, specified by the parameter, to the end of each element in the set of matched elements.
   */
  def append(content:ElementDesc*):JQuery = js.native
  def append(func:js.ThisFunction2[Element, Int, String, js.Any]):JQuery = js.native

  /**
   * Insert every element in the set of matched elements to the end of the target.
   */
  def appendTo(target:ElementDesc):JQuery = js.native
  
  /**
   * Shorthand for get(x), lifted from scalajs-jquery
   */
  @js.annotation.JSBracketAccess
  def apply(x: Int): dom.html.Element = js.native
  
  /**
   * Get the value of an attribute for the first element in the set of matched elements.
   * 
   * Note that this returns UndefOr -- it is entirely legal for this to return undefined if
   * the attribute is not present, and that causes things to crash if it is not UndefOr.
   */
  def attr(attributeName:String):UndefOr[String] = js.native
  def attr(attributes:js.Dictionary[String]):JQuery = js.native
  /**
   * Set an attribute for the set of matched elements.
   */
  def attr(attributeName:String, v:AttrVal):JQuery = js.native
  def attr(attributeName:String, func:js.ThisFunction2[Element, Int, String, AttrVal]):JQuery = js.native
  
  /**
   * Insert content, specified by the parameter, before each element in the set of matched elements.
   */
  def before(content:ElementDesc, addlContent:ElementDesc*):JQuery = js.native
  def before(func:js.ThisFunction2[Element, Integer, String, String | Element | JQuery]):JQuery = js.native
  
  /**
   * Attach a handler to an event for the elements.
   */
  def bind(eventType:String, handler:js.ThisFunction1[Element, JQueryEventObject, Any]):JQuery = js.native
  def bind(eventType:String, eventData:Any, handler:js.ThisFunction1[Element, JQueryEventObject, Any]):JQuery = js.native
  def bind(eventType:String, preventBubble:Boolean):JQuery = js.native
  def bind(events:js.Dictionary[js.ThisFunction1[Element, JQueryEventObject, Any]]):JQuery = js.native
  
  /**
   * Bind an event handler to the "blur" JavaScript event, or trigger that event on an element.
   */
  def blur():JQuery = js.native
  def blur(handler:EventHandler):JQuery = js.native
  def blur(eventData:Any, handler:EventHandler):JQuery = js.native
  
  /**
   * Bind an event handler to the "change" JavaScript event, or trigger that event on an element.
   * 
   * NOTE: the jQuery documentation is very fuzzy on this point, but implies in an example that "this" gets
   * set appropriately.
   */
  def change():JQuery = js.native
  def change(handler:EventHandler):JQuery = js.native
  def change(eventData:Any, handler:EventHandler):JQuery = js.native
  
  /**
   * Get the children of each element in the set of matched elements, optionally filtered by a selector.
   */
  def children(selector:String = ???):JQuery = js.native
  
  /**
   * Remove from the queue all items that have not yet been run.
   */
  def clearQueue(queueName:String = ???):JQuery = js.native
    
  /**
   * Bind an event handler to the "click" JavaScript event, or trigger that event on an element.
   * 
   * This is the simpler version, and usually what you want.
   */
  def click():JQuery = js.native
  def click(handler:EventHandler):JQuery = js.native
  
  /**
   * Create a deep copy of the set of matched elements.
   * 
   * Note that this requires an override because Scala.Object declares a clone() method which
   * is entirely unrelated.
   */
  override def clone():JQuery = js.native
  def clone(withDataAndEvents:Boolean):JQuery = js.native
  def clone(withDataAndEvents:Boolean, deepWithDataAndEvents:Boolean):JQuery = js.native
  
  /**
   * For each element in the set, get the first element that matches the selector 
   * by testing the element itself and traversing up through its ancestors in the DOM tree.
   */
  def closest(selector:String | Element | JQuery):JQuery = js.native
  def closest(selector:String, context:Element):JQuery = js.native
  
  /**
   * Get the children of each element in the set of matched elements, including text and comment nodes.
   */
  def contents():JQuery = js.native
  
  /**
   * Get the computed style properties for the first element in the set of matched elements.
   */
  def css(propertyName:String):String = js.native
  def css(propertyNames:Array[String]):js.Dictionary[String] = js.native
  def css(propertyName:String, value:String | Int):JQuery = js.native
  def css(properties:js.Dictionary[js.Any]):JQuery = js.native
  
  /**
   * Store arbitrary data associated with the matched elements.
   * 
   * undefined is not recognised as a data value. Calls such as .data( "name", undefined )
   * will return the corresponding data for "name", and is therefore the same as .data( "name" ).
   */
  def data(key: String, value: js.Any): JQuery = js.native
  def data(obj: js.Dictionary[js.Any]): JQuery = js.native
  /**
   * Return the value at the named data store for the first element in the jQuery collection, 
   * as set by data(name, value) or by an HTML5 data-* attribute. Undefined if that key is not set.
   */
  def data(key: String): UndefOr[js.Any] = js.native
  /**
   * Calling .data() with no parameters retrieves all of the values as a JavaScript object. 
   * This object can be safely cached in a variable as long as a new object is not set with .data(obj). 
   * Using the object directly to get or set values is faster than making individual calls to .data() 
   * to get or set each value.
   */
  def data(): js.Dictionary[js.Any] = js.native
  
  /**
   * Bind an event handler to the "dblclick" JavaScript event.
   */
  def dblclick():JQuery = js.native
  def dblclick(handler:EventHandler):JQuery = js.native
  def dblclick(eventData:Any, handler:EventHandler):JQuery = js.native

  /**
   * Set a timer to delay execution of subsequent items in the queue.
   */
  def delay(duration:Int, queueName:String = ???):JQuery = js.native
  
  // NOTE: delegate() has been superceded by on().
  
  /**
   * Execute the next function on the queue for the matched elements.
   */
  def dequeue(queueName:String = ???):JQuery = js.native
  
  /**
   * Remove the set of matched elements from the DOM.
   */
  def detach():JQuery = js.native
  def detach(selector:String):JQuery = js.native
  
  /**
   * Iterate over a jQuery object, executing a function for each matched element.
   * 
   * Note that we do not bother with the full jQuery signature, since the "element" parameter
   * simply matches "this".
   * 
   * You can stop the loop from within the callback function by returning false. Otherwise, the return
   * value is irrelevant.
   */
  def each(func:js.ThisFunction0[Element, Any]):JQuery = js.native
  def each(func:js.ThisFunction1[Element, Int, Any]):JQuery = js.native
  
  /**
   * Remove all child nodes of the set of matched elements from the DOM.
   */
  def empty():JQuery = js.native
  
  /**
   * End the most recent filtering operation in the current chain and return the set of matched elements to its previous state.
   */
  def end():JQuery = js.native
  
  /**
   * Reduce the set of matched elements to the one at the specified index.
   */
  def eq(index:Integer):JQuery = js.native
  
  /**
   * Display the matched elements by fading them to opaque.
   */
  def fadeIn():JQuery = js.native
  def fadeIn(easing:String):JQuery = js.native
  def fadeIn(easing:String, complete:js.ThisFunction0[Element, Any]):JQuery = js.native
  def fadeIn(
    duration:Number | String,
    easing:String = ???,
    complete:js.ThisFunction0[Element, Any] = ???):JQuery = js.native
  def fadeIn(options:JQueryAnimationSettings):JQuery = js.native
  
  /**
   * Hide the matched elements by fading them to transparent.
   */
  def fadeOut():JQuery = js.native
  def fadeOut(easing:String):JQuery = js.native
  def fadeOut(easing:String, complete:js.ThisFunction0[Element, Any]):JQuery = js.native
  def fadeOut(
    duration:Number | String,
    easing:String = ???,
    complete:js.ThisFunction0[Element, Any] = ???):JQuery = js.native
  def fadeOut(options:JQueryAnimationSettings):JQuery = js.native
  
  /**
   * Adjust the opacity of the matched elements.
   */
  def fadeTo(
    duration:String | Number, 
    opacity:Number, 
    easing:String = ???, 
    complete:js.ThisFunction0[Element, Any] = ???):JQuery = js.native

  /**
   * Display or hide the matched elements by animating their opacity.
   */
  def fadeToggle():JQuery = js.native
  def fadeToggle(easing:String):JQuery = js.native
  def fadeToggle(easing:String, complete:js.ThisFunction0[Element, Any]):JQuery = js.native
  def fadeToggle(
    duration:Number | String,
    easing:String = ???,
    complete:js.ThisFunction0[Element, Any] = ???):JQuery = js.native
  def fadeToggle(options:JQueryAnimationSettings):JQuery = js.native

  /**
   * Reduce the set of matched elements to those that match the selector or pass the function's test.
   */
  def filter(selector:Selector):JQuery = js.native
  def filter(func:js.ThisFunction0[Element, Boolean]):JQuery = js.native
  def filter(func:js.ThisFunction1[Element, Int, Boolean]):JQuery = js.native
  
  /**
   * Get the descendants of each element in the current set of matched elements, filtered by a selector, jQuery object, or element.
   */
  def find(selector:Selector):JQuery = js.native
  
  /**
   * Stop the currently-running animation, remove all queued animations, and complete all animations for the matched elements.
   */
  def finish(queue:String = "fx"):JQuery = js.native
  
  /**
   * Reduce the set of matched elements to the first in the set.
   */
  def first():JQuery = js.native
  
  /**
   * Bind an event handler to the "focus" JavaScript event, or trigger that event on an element.
   */
  def focus():JQuery = js.native
  def focus(handler:EventHandler):JQuery = js.native
  def focus(eventData:Any, handler:EventHandler):JQuery = js.native
  
  /**
   * Bind an event handler to the "focusin" event.
   */
  def focusin():JQuery = js.native
  def focusin(handler:EventHandler):JQuery = js.native
  def focusin(eventData:Any, handler:EventHandler):JQuery = js.native  
  
  /**
   * Bind an event handler to the "focusout" event.
   */
  def focusout():JQuery = js.native
  def focusout(handler:EventHandler):JQuery = js.native
  def focusout(eventData:Any, handler:EventHandler):JQuery = js.native  

  /**
   * Retrieve one of the elements matched by the jQuery object.
   * 
   * If the value of index is out of bounds - less than the negative number of elements or equal to 
   * or greater than the number of elements - it returns undefined.
   */
  def get(index:Int):UndefOr[Element] = js.native
  /**
   * Retrieve the elements matched by the jQuery object.
   */
  def get():js.Array[_] = js.native
  
  /**
   * Reduce the set of matched elements to those that have a descendant that matches the selector or DOM element.
   */
  def has(selector:Selector):JQuery = js.native
  
  /**
   * Determine whether any of the matched elements are assigned the given class.
   */
  def hasClass(className:String):Boolean = js.native
  
  /**
   * Get the current computed height for the first element in the set of matched elements.
   */
  def height():Double = js.native
  /**
   * Set the CSS height of every matched element.
   */
  def height(value:Double | String):JQuery = js.native
  def height(value:js.ThisFunction2[Element, Integer, Integer, Number | String]):JQuery = js.native
  
  /**
   * Hide the matched elements.
   */
  def hide():JQuery = js.native
  def hide(duration:String | Int, complete:js.Function):JQuery = js.native
  def hide(duration:String | Int, easing:String = ???, complete:js.Function = ???):JQuery = js.native
  
  /**
   * Bind two handlers to the matched elements, to be executed when the mouse pointer enters and leaves the elements.
   */
  def hover(handlerIn:EventHandler, handlerOut:EventHandler):JQuery = js.native
  /**
   * Bind a single handler to the matched elements, to be executed when the mouse pointer enters or leaves the elements.
   */
  def hover(handlerInOut:EventHandler):JQuery = js.native
  
  /**
   * Get the HTML contents of the first element in the set of matched elements.
   */
  def html():String = js.native
  /**
   * Set the HTML contents of every matched element.
   */
  def html(t:String):JQuery = js.native
  def html(func:js.ThisFunction2[Element, Int, String, String]):JQuery = js.native
  
  /**
   * Search for a given element from among the matched elements.
   */
  def index():Int = js.native
  def index(selector:ElementDesc):Int = js.native

  /**
   * Get the current computed inner height (including padding but not border) for the first element
   * in the set of matched elements.
   */
  def innerHeight():Double = js.native

  /**
   * Get the current computed inner width (including padding but not border) for the first element
   * in the set of matched elements.
   */
  def innerWidth():Double = js.native
  
  /**
   * Insert every element in the set of matched elements after the target.
   */
  def insertAfter(target:ElementDesc):JQuery = js.native
  
  /**
   * Insert every element in the set of matched elements before the target.
   */
  def insertBefore(target:ElementDesc):JQuery = js.native
  
  /**
   * Check the current matched set of elements against a selector, element,
   * or jQuery object and return true if at least one of these elements matches the given arguments.
   */
  def is(selector:Selector):Boolean = js.native
  /**
   * Note that this overload doesn't precisely match the jQuery documentation; we
   * elide the redundant Element param, since you have Element as the this parameter.
   */
  def is(func:js.ThisFunction1[Element, Int, Boolean]):Boolean = js.native
  
  /**
   * A string containing the jQuery version number.
   */
  def jquery:String = js.native
  
  /**
   * Bind an event handler to the "keydown" JavaScript event, or trigger that event on an element.
   */
  def keydown(handler:EventHandler):JQuery = js.native
  def keydown(eventData:Any, handler:EventHandler):JQuery = js.native
  def keydown():JQuery = js.native
  
  /**
   * Bind an event handler to the "keypress" JavaScript event, or trigger that event on an element.
   */
  def keypress(handler:EventHandler):JQuery = js.native
  def keypress(eventData:Any, handler:EventHandler):JQuery = js.native
  def keypress():JQuery = js.native
  
  /**
   * Bind an event handler to the "keyup" JavaScript event, or trigger that event on an element.
   */
  def keyup(handler:EventHandler):JQuery = js.native
  def keyup(eventData:Any, handler:EventHandler):JQuery = js.native
  def keyup():JQuery = js.native
  
  /**
   * Reduce the set of matched elements to the final one in the set.
   */
  def last():JQuery = js.native
  
  /**
   * The number of elements in the jQuery object.
   */
  def length:Int = js.native
  
  /**
   * Load data from the server and place the returned HTML into the matched element.
   */
  def load(url:String):JQuery = js.native
  def load(url:String, data:String | js.Object):JQuery = js.native
  def load(url:String, data:String | js.Object, complete:js.ThisFunction3[Element, String, String, JQueryXHR, Any]):JQuery = js.native
  
  /**
   * Pass each element in the current matched set through a function, producing a new jQuery object
   * containing the return values.
   * 
   * For Scala code, it is often more convenient to use the mapElems() extension function.
   * 
   * Within the callback function, this refers to the current DOM element for each iteration. The function
   * can return an individual data item or an array of data items to be inserted into the resulting set.
   * 
   * If a js.Array is returned, the elements inside the array are inserted into the set.
   * If the function returns null or undefined, no element will be inserted. (Note the implication: this
   * doesn't quite match the usual Scala semantics of map() -- there is a flatten component as well.) 
   */
  def map(func:js.ThisFunction0[Element, Any]):JQuery = js.native
  def map(func:js.ThisFunction1[Element, Int, Any]):JQuery = js.native
  
  /**
   * Bind an event handler to the "mousedown" JavaScript event, or trigger that event on an element.
   */
  def mousedown():JQuery = js.native
  def mousedown(handler:EventHandler):JQuery = js.native
  def mousedown(eventData:Any, handler:EventHandler):JQuery = js.native
  
  /**
   * Bind an event handler to the "mouseenter" JavaScript event, or trigger that event on an element.
   */
  def mouseenter():JQuery = js.native
  def mouseenter(handler:EventHandler):JQuery = js.native
  def mouseenter(eventData:Any, handler:EventHandler):JQuery = js.native
  
  /**
   * Bind an event handler to the "mouseleave" JavaScript event, or trigger that event on an element.
   */
  def mouseleave():JQuery = js.native
  def mouseleave(handler:EventHandler):JQuery = js.native
  def mouseleave(eventData:Any, handler:EventHandler):JQuery = js.native
  
  /**
   * Bind an event handler to the "mousemove" JavaScript event, or trigger that event on an element.
   */
  def mousemove():JQuery = js.native
  def mousemove(handler:EventHandler):JQuery = js.native
  def mousemove(eventData:Any, handler:EventHandler):JQuery = js.native
  
  /**
   * Bind an event handler to the "mouseout" JavaScript event, or trigger that event on an element.
   */
  def mouseout():JQuery = js.native
  def mouseout(handler:EventHandler):JQuery = js.native
  def mouseout(eventData:Any, handler:EventHandler):JQuery = js.native
  
  /**
   * Bind an event handler to the "mouseover" JavaScript event, or trigger that event on an element.
   */
  def mouseover():JQuery = js.native
  def mouseover(handler:EventHandler):JQuery = js.native
  def mouseover(eventData:Any, handler:EventHandler):JQuery = js.native
  
  /**
   * Bind an event handler to the "mouseup" JavaScript event, or trigger that event on an element.
   */
  def mouseup():JQuery = js.native
  def mouseup(handler:EventHandler):JQuery = js.native
  def mouseup(eventData:Any, handler:EventHandler):JQuery = js.native
  
  /**
   * Get the immediately following sibling of each element in the set of matched elements. 
   * If a selector is provided, it retrieves the next sibling only if it matches that selector.
   */
  def next(selector:String = ???):JQuery = js.native
  
  /**
   * Get all following siblings of each element in the set of matched elements, optionally filtered by a selector.
   */
  def nextAll(selector:String = ???):JQuery = js.native
  
  /**
   * Get all following siblings of each element up to but not including the element matched by the selector, DOM node, or jQuery object passed.
   */
  def nextUntil():JQuery = js.native
  def nextUntil(selector:String):JQuery = js.native
  def nextUntil(selector:String, filter:String):JQuery = js.native
  def nextUntil(element:Element | JQuery, filter:String = ???):JQuery = js.native
  
  /**
   * Remove elements from the set of matched elements.
   */
  def not(selector:ElementDesc):JQuery = js.native
  def not(func:js.ThisFunction2[Element, Integer, Element, Boolean]):JQuery = js.native

  /**
   * Remove an event handler.
   */
  def off(events: String): JQuery = js.native
  def off(events: String, selector: String): JQuery = js.native
  def off(events: String, selector: String, handler:EventHandler): JQuery = js.native
  def off(events: String, handler:EventHandler): JQuery = js.native
  def off(eventsMap: js.Dictionary[EventHandler], selector: String = ???): JQuery = js.native
  def off(event:JQueryEventObject):JQuery = js.native
  def off(): JQuery = js.native
  
  /**
   * Get the current coordinates of the first element in the set of matched elements, relative to the document.
   */
  def offset():JQueryPosition = js.native
  def offset(coordinates:JQueryPosition):JQuery = js.native
  def offset(func:js.Function2[Integer, JQueryPosition, JQueryPosition]):JQuery = js.native
  
  /**
   * Get the closest ancestor element that is positioned.
   */
  def offsetParent():JQuery = js.native
  
  /**
   * Attach an event handler function for one or more events to the selected elements.
   * 
   * Note that this contains overloads for up to 2 "extra" parameters to the handler, but the number is
   * potentially unlimited. If we ever care about more, we could add them.
   * 
   * 
   * IMPORTANT: this first signature allows you to specify a sub-selector, and some data to pass. There
   * data parameter is *not* optional -- you must pass something in order for the compiler to pick it up!
   * (At least, put in js.undefined there.) For example, something like:
   * 
   * $("body").on("click", ".element", js.undefined, { (elem:Element, evt:JQueryEventObject) => {...} )
   * 
   * We can't write jQuery's (String, String, ThingFunction1) version of the signature here, because it conflicts with the
   * (String, String, Any) version further down, which does something very different. (jQuery is 
   * sometimes too clever for its own good.)
   * 
   * So remember to pass something for the data parameter, in order to get the compiler to do the right thing. 
   * If you don't, your function *will* match the (String, String, Any) version of the signature, but it won't work correctly.
   */
  def on(events:String, selector: String, data: Any, handler:EventHandler): JQuery = js.native
  def on(events:String, handler:EventHandler):JQuery = js.native
  def on(events:String, handler: js.ThisFunction2[Element, JQueryEventObject, Any, Any]): JQuery = js.native
  def on(events:String, handler: js.ThisFunction3[Element, JQueryEventObject, Any, Any, Any]): JQuery = js.native
  def on(events:String, handler: js.Function2[JQueryEventObject, Any, Any]): JQuery = js.native
  def on(events:String, handler: js.Function3[JQueryEventObject, Any, Any, Any]): JQuery = js.native
  /**
   * Attach an event handler function for one or more events to the selected elements.
   * 
   * This version of the signature allows you to pass in "false" as the handler. This is kind of
   * magical in jQuery -- it is shorthand for a function that just does "return false", which
   * stops propagation on the event. Note that true is *not* a legal value, only false.
   */
  def on(events: String, selector: String, data: Any, turnOff:Boolean): JQuery = js.native
  def on(events: String, selector: String, data: Any): JQuery = js.native
  def on(events: String, selector: String): JQuery = js.native
  def on(events: String, turnOff:Boolean): JQuery = js.native
  def on(events: String): JQuery = js.native
  def on(eventsMap: js.Dictionary[EventHandler], selector: String, data: Any): JQuery = js.native
  def on(eventsMap: js.Dictionary[EventHandler], selector: String): JQuery = js.native
  def on(eventsMap: js.Dictionary[EventHandler]): JQuery = js.native

  /**
   * Attach a handler to an event for the elements. The handler is executed at most once per element per event type.
   */
  def one(events:String, selector: String, data: Any, handler:EventHandler): JQuery = js.native
  def one(events:String, handler:EventHandler):JQuery = js.native
  def one(events:String, handler: js.ThisFunction2[Element, JQueryEventObject, Any, Any]): JQuery = js.native
  def one(events:String, handler: js.ThisFunction3[Element, JQueryEventObject, Any, Any, Any]): JQuery = js.native
  def one(events:String, handler: js.Function2[JQueryEventObject, Any, Any]): JQuery = js.native
  def one(events:String, handler: js.Function3[JQueryEventObject, Any, Any, Any]): JQuery = js.native
  def one(events: String, selector: String, data: Any, turnOff:Boolean): JQuery = js.native
  def one(events: String, selector: String, data: Any): JQuery = js.native
  def one(events: String, selector: String): JQuery = js.native
  def one(events: String, turnOff:Boolean): JQuery = js.native
  def one(events: String): JQuery = js.native
  def one(eventsMap: js.Dictionary[EventHandler], selector: String, data: Any): JQuery = js.native
  def one(eventsMap: js.Dictionary[EventHandler], selector: String): JQuery = js.native
  def one(eventsMap: js.Dictionary[EventHandler]): JQuery = js.native
  
  /**
   * Get the current computed height for the first element in the set of matched elements, including
   * padding, border, and optionally margin.
   */
  def outerHeight():Double = js.native
  def outerHeight(includeMargin:Boolean):Double = js.native

  /**
   * Get the current computed width for the first element in the set of matched elements, including
   * padding, border, and optionally margin.
   */
  def outerWidth():Double = js.native
  def outerWidth(includeMargin:Boolean):Double = js.native

  /**
   * Get the parent of each element in the current set of matched elements, optionally filtered by a selector.
   * 
   * TBD: is the parameter really a Selector, or just a String? The JQuery API docs are unclear.
   */
  def parent(selector: String): JQuery = js.native
  def parent(): JQuery = js.native
  
  /**
   * Get the ancestors of each element in the current set of matched elements, optionally filtered by a selector.
   */
  def parents(selector:String):JQuery = js.native
  def parents():JQuery = js.native
  
  /**
   * Get the ancestors of each element in the current set of matched elements, up to but not 
   * including the element matched by the selector, DOM node, or jQuery object.
   */
  def parentsUntil():JQuery = js.native
  def parentsUntil(selector:String):JQuery = js.native
  def parentsUntil(selector:String, filter:String):JQuery = js.native
  def parentsUntil(element:Element | JQuery, filter:String = ???):JQuery = js.native
  
  /**
   * Get the current coordinates of the first element in the set of matched elements, relative to the offset parent.
   */
  def position():JQueryPosition = js.native
  
  /**
   * Insert content, specified by the parameters, to the beginning of each element in the set of matched elements.
   */
  def prepend(contents:ElementDesc*):JQuery = js.native
  def prepend(func:js.ThisFunction2[Element, Int, String, Selector]):JQuery = js.native
  
  /**
   * Insert every element in the set of matched elements to the beginning of the target.
   */
  def prependTo(target:ElementDesc):JQuery = js.native
  
  /**
   * Get the immediately preceding sibling of each element in the set of matched elements, optionally filtered by a selector.
   */
  def prev(selector:UndefOr[String] = js.undefined):JQuery = js.native
  
  /**
   * Get all preceding siblings of each element in the set of matched elements, optionally filtered by a selector.
   */
  def prevAll(selector:UndefOr[String] = js.undefined):JQuery = js.native
  
  /**
   * Get all preceding siblings of each element up to but not including the element matched by the selector, DOM node, or jQuery object.
   */
  def prevUntil():JQuery = js.native
  def prevUntil(selector:String):JQuery = js.native
  def prevUntil(selector:String, filter:String):JQuery = js.native
  def prevUntil(element:Element | JQuery, filter:String = ???):JQuery = js.native

  /**
   * Return a Promise object to observe when all actions of a certain type bound to the collection, queued or not, have finished.
   */
  def promise(tpe:String = ???, target:js.Object = ???):JQueryPromise = js.native
  
  /**
   * Get the value of a property for the first element in the set of matched elements.
   */
  def prop(propertyName:String):UndefOr[Any] = js.native
  /**
   * Set one or more properties for the set of matched elements.
   */
  def prop(propertyName:String, value:js.Any):JQuery = js.native
  def prop(properties:js.Dictionary[js.Any]):JQuery = js.native
  def prop(propertyName:String, func:js.ThisFunction2[Element, Int, Any, js.Any]):JQuery = js.native
  
  /**
   * Add a collection of DOM elements onto the jQuery stack.
   */
  def pushStack(elements:js.Array[Element]):JQuery = js.native
  def pushStack(elements:js.Array[Element], name:String, arguments:js.Array[js.Any]):JQuery = js.native
  
  /**
   * Show the queue of functions to be executed on the matched elements.
   */
  def queue(queueName:String = ???):js.Array[js.Function] = js.native
  def queue(newQueue:Array[js.Function]):JQuery = js.native
  def queue(queueName:String, newQueue:Array[js.Function]):JQuery = js.native
  def queue(callback:js.Function1[js.Function0[js.Any], Any]):JQuery = js.native
  
  /**
   * Specify a function to execute when the DOM is fully loaded.
   */
  def ready(handler:js.Function0[Any]):JQuery = js.native
  
  /**
   * Remove the set of matched elements from the DOM.
   */
  def remove():JQuery = js.native
  def remove(childSelector:String):JQuery = js.native
  
  /**
   * Remove an attribute from each element in the set of matched elements.
   */
  def removeAttr(attributeName:String):JQuery = js.native
  
  /**
   * Remove a single class, multiple classes, or all classes from each element in the set of matched elements.
   */
  def removeClass():JQuery = js.native
  def removeClass(classNames:String):JQuery = js.native
  def removeClass(func:js.ThisFunction2[Element, Int, String, String]):JQuery = js.native
  
  /**
   * Remove a previously-stored piece of data.
   */
  def removeData():JQuery = js.native
  def removeData(name:String):JQuery = js.native
  def removeData(list:js.Array[String]):JQuery = js.native
  
  /**
   * Remove a property for the set of matched elements.
   */
  def removeProp(propertyName:String):JQuery = js.native
  
  /**
   * Replace each target element with the set of matched elements.
   */
  def replaceAll(target:ElementDesc):JQuery = js.native
  
  /**
   * Replace each element in the set of matched elements with the provided new content and return the set of elements that was removed.
   */
  def replaceWith(content:ElementDesc):JQuery = js.native
  def replaceWith(func:js.ThisFunction0[Element, ElementDesc]):JQuery = js.native

  /**
   * Bind an event handler to the "resize" JavaScript event, or trigger that event on an element.
   */
  def resize(func:EventHandler):JQuery = js.native
  def resize(eventData:Any, handler:EventHandler):JQuery = js.native
  def resize():JQuery = js.native
  
  /**
   * Bind an event handler to the "scroll" JavaScript event, or trigger that event on an element.
   */
  def scroll():JQuery = js.native
  def scroll(handler:EventHandler):JQuery = js.native
  def scroll(eventData:Any, handler:EventHandler):JQuery = js.native
  
  /**
   * Get the current horizontal position of the scroll bar for the first element in the set of matched elements.
   */
  def scrollLeft():Double = js.native
  /**
   * Note that this intentionally takes Double -- since recent browsers takes a Double (a full JS Number)
   */
  def scrollLeft(value:Double):JQuery = js.native

  /**
   * Get the current vertical position of the scroll bar for the first element in the set of
   * matched elements or set the vertical position of the scroll bar for every matched element.
   */
  def scrollTop():Double = js.native
  /**
   * Set the current vertical position of the scroll bar for each of the set of matched elements.
   *
   * Note that this intentionally takes Double -- since recent browsers takes a Double (a full JS Number)
   */
  def scrollTop(value:Double):JQuery = js.native

  /**
   * Bind an event handler to the "select" JavaScript event, or trigger that event on an element.
   */
  def select():JQuery = js.native
  def select(handler:EventHandler):JQuery = js.native
  def select(eventData:Any, handler:EventHandler):JQuery = js.native
  
  /**
   * Encode a set of form elements as a string for submission.
   */
  def serialize():String = js.native
  
  /**
   * Encode a set of form elements as an array of names and values.
   */
  def serializeArray():Array[JQuerySerializeArrayElement] = js.native
  
  /**
   * Hide the matched elements.
   */
  def show():JQuery = js.native
  def show(duration:String | Int, complete:js.Function):JQuery = js.native
  def show(duration:String | Int, easing:String = ???, complete:js.Function = ???):JQuery = js.native

  /**
   * Get the siblings of each element in the set of matched elements, optionally filtered by a selector.
   */
  def siblings(selector:String = ???):JQuery = js.native
  
  /**
   * Reduce the set of matched elements to a subset specified by a range of indices.
   */
  def slice(start:Integer, end:Integer = ???):JQuery = js.native
  
  /**
   * Display the matched elements with a sliding motion.
   */
  def slideDown():JQuery = js.native
  def slideDown(duration:String | Int, complete:js.Function = ???):JQuery = js.native
  
  /**
   * Display or hide the matched elements with a sliding motion.
   */
  def slideToggle():JQuery = js.native
  def slideToggle(
    duration:Number | String,
    easing:String = "swing",
    complete:js.ThisFunction0[Element, Any] = ???):JQuery = js.native
  def slideToggle(options:JQueryAnimationSettings):JQuery = js.native
  
  /**
   * Hide the matched elements with a sliding motion.
   */
  def slideUp():JQuery = js.native
  def slideUp(duration:String | Int, complete:js.Function = ???):JQuery = js.native
  
  /**
   * Stop the currently-running animation on the matched elements.
   */
  def stop():JQuery = js.native
  def stop(clearQueue:Boolean):JQuery = js.native
  def stop(clearQueue:Boolean, jumpToEnd:Boolean):JQuery = js.native
  def stop(queue:String, clearQueue:Boolean = false, jumpToEnd:Boolean = false):JQuery = js.native
  
  /**
   * Bind an event handler to the "submit" JavaScript event, or trigger that event on an element.
   */
  def submit():JQuery = js.native
  def submit(handler:js.ThisFunction1[Element, JQueryEventObject, Any]):JQuery = js.native
  def submit(eventData:Any, handler:js.ThisFunction1[Element, JQueryEventObject, Any]):JQuery = js.native
  
  /**
   * Get the combined text contents of each element in the set of matched elements, including their descendants.
   */
  def text():String = js.native
  /**
   * Set the content of each element in the set of matched elements to the specified text.
   */
  def text(t:String):JQuery = js.native
  // TBD: the JQ docs don't say that this is a ThisFunction. Is it? Probably, based on html()?
  def text(func:js.Function2[Int, String, String]):JQuery = js.native
  
  /**
   * Retrieve all the elements contained in the jQuery set, as an array.
   */
  def toArray():js.Array[Element] = js.native
  
  /**
   * Add or remove one or more classes from each element in the set of matched elements, 
   * depending on either the class's presence or the value of the state argument.
   */
  def toggleClass():JQuery = js.native
  def toggleClass(className:String, state:Boolean = ???):JQuery = js.native
  def toggleClass(state:Boolean):JQuery = js.native
  def toggleClass(func:js.Function3[Integer, String, Boolean, String]):JQuery = js.native
  def toggleClass(func:js.Function3[Integer, String, Boolean, String], state:Boolean):JQuery = js.native
  
  /**
   * Execute all handlers and behaviors attached to the matched elements for the given event type.
   */
  def trigger(eventType:String, extraParameters:Any*):JQuery = js.native
  def trigger(event:JQueryEventObject, extraParameters:Any*):JQuery = js.native
  
  /**
   * Execute all handlers attached to an element for an event.
   */
  def triggerHandler(eventType:String, extraParameters:Any*):JQuery = js.native
  def triggerHandler(event:JQueryEventObject, extraParameters:Any*):JQuery = js.native
  
  /**
   * Remove a previously-attached event handler from the elements.
   */
  def unbind():JQuery = js.native
  def unbind(event:JQueryEventObject):JQuery = js.native
  def unbind(eventType:String, falsing:Boolean):JQuery = js.native
  def unbind(eventType:String, handler:js.ThisFunction1[Element, JQueryEventObject, Any] = ???):JQuery = js.native
  
  /**
   * Remove the parents of the set of matched elements from the DOM, leaving the matched elements in their place.
   */
  def unwrap():JQuery = js.native
  
  /**
   * Shorthand modifier, lifted from scalajs-jquery.
   */
  @js.annotation.JSBracketAccess
  def update(x: Int, v: dom.html.Element): Unit = js.native
  
  /**
   * Get the value of this JQuery.
   * 
   * "value" is highly context-dependent. The signature is loose because it can return a
   * String, a Number (?) or an Array, depending on circumstances. See the extension methods
   * in JQueryExtensions for more strongly-typed versions that you can use when you expect
   * a specific return type.
   */
  def `val`(): js.Dynamic = js.native
  def `val`(value: js.Array[String]): JQuery = js.native
  def `val`(value: String): JQuery = js.native
  def `val`(func: js.Function2[Int, String, String]): JQuery = js.native
  @JSName("val") def value(): js.Dynamic = js.native
  @JSName("val") def value(value: js.Array[String]): JQuery = js.native
  @JSName("val") def value(value: String): JQuery = js.native
  @JSName("val") def value(func: js.Function2[Int, String, String]): JQuery = js.native
  
  
  /**
   * Get the current computed width for the first element in the set of matched elements.
   */
  def width():Double = js.native
  /**
   * Set the CSS width of every matched element.
   */
  def width(value:Double | String):JQuery = js.native
  def width(value:js.ThisFunction2[Element, Integer, Integer, Number | String]):JQuery = js.native
  
  /**
   * Wrap an HTML structure around each element in the set of matched elements.
   */
  def wrap(wrappingElement:String | Element | JQuery):JQuery = js.native
  def wrap(func:js.ThisFunction1[Element, Integer, String | JQuery]):JQuery = js.native
  
  /**
   * Wrap an HTML structure around all elements in the set of matched elements.
   */
  def wrapAll(wrappingElement:String | Element | JQuery):JQuery = js.native
  def wrapAll(func:js.ThisFunction1[Element, Integer, String | JQuery]):JQuery = js.native
  
  /**
   * Wrap an HTML structure around the content of each element in the set of matched elements.
   */
  def wrapInner(wrappingElement:String | Element | JQuery):JQuery = js.native
  def wrapInner(func:js.ThisFunction1[Element, Integer, String | JQuery]):JQuery = js.native
}

/**
 * Returned by offset() and position().
 * 
 * Note that the values in here are intentionally not Integers. From the JQuery docs:
 * 
 * "The number returned by dimensions-related APIs, including .offset(), may be fractional in some
 *  cases. Code should not assume it is an integer. Also, dimensions may be incorrect when the page
 *  is zoomed by the user; browsers do not expose an API to detect this condition."
 */
@js.native
trait JQueryPosition extends js.Object {
  val left:Double
  val top:Double
}

/**
 * Returned by serializeArray().
 */
@js.native
trait JQuerySerializeArrayElement extends js.Object {
  def name:String = js.native
  def value:String = js.native
}
