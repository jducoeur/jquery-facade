package org.querki.jquery

import scala.scalajs.js
import js.{undefined, UndefOr, |}
import js.annotation.JSName
import org.scalajs.dom
import dom.Element

@js.native
@JSName("jQuery")
object JQueryStatic extends js.Object {
  
  /**
   * Perform an asynchronous HTTP (Ajax) request.
   */
  def ajax():JQueryXHR = js.native
  def ajax(settings:JQueryAjaxSettings):JQueryXHR = js.native
  def ajax(url:String, settings:UndefOr[JQueryAjaxSettings] = undefined):JQueryXHR = js.native
  
  /**
   * Handle custom Ajax options or modify existing options before each request is sent and before they are processed by $.ajax().
   */
  def ajaxPrefilter(handler:js.Function3[JQueryAjaxSettings with js.Dynamic, JQueryAjaxSettings, JQueryXHR, Any]):Unit = js.native 
  def ajaxPrefilter(dataTypes:String, handler:js.Function3[JQueryAjaxSettings with js.Dynamic, JQueryAjaxSettings, JQueryXHR, Any]):Unit = js.native 

  /**
   * Set default values for future Ajax requests. Its use is not recommended.
   */
  def ajaxSetup(options:JQueryAjaxSettings):Unit = js.native
  
  def ajaxTransport(dataType:String, handler:js.Function3[JQueryAjaxSettings, JQueryAjaxSettings, JQueryXHR, JQueryTransport]):Unit = js.native
  
  /**
   * Accepts a string containing a CSS selector which is then used to match a set of elements.
   */
  def apply(): JQuery = js.native
  def apply(selector: ElementDesc): JQuery = js.native
  def apply(selector: String, context: Element | JQuery): JQuery = js.native
  
  /**
   * Creates DOM elements on the fly from the provided string of raw HTML.
   * 
   * Note that the HTML-only signature works, but happens to match one of the above cases. If the
   * contents of "selector" happens to contain HTML, it creates instead of matching.
   */
  def apply(html:String, ownerDocument:dom.html.Document):JQuery = js.native
  def apply(html:String, attributes:js.Dictionary[js.Any]):JQuery = js.native
  def apply(obj: js.Object): JQuery = js.native
  
  /**
   * Binds a function to be executed when the DOM has finished loading.
   */
  def apply(func: js.Function): JQuery = js.native
  
  /**
   * A multi-purpose callbacks list object that provides a powerful way to manage callback lists.
   * 
   * TODO: we ought to add a strongly-typed extension that defines the flags properly.
   */
  def Callbacks(flags:UndefOr[String] = js.undefined):JQueryCallbacks = js.native
  
  /**
   * Check to see if a DOM element is a descendant of another DOM element.
   */
  def contains(container:Element, contained:Element):Boolean = js.native
  
  /**
   * Hook directly into jQuery to override how particular CSS properties are retrieved or set, 
   * normalize CSS property naming, or create custom properties.
   */
  def cssHooks:js.Dynamic = js.native
  
  /**
   * An object containing all CSS properties that may be used without a unit. 
   * The .css() method uses this object to see if it may append px to unitless values.
   */
  def cssNumber:js.Dictionary[Boolean] = js.native
  
  /**
   * Store arbitrary data associated with the specified element. Returns the value that was set.
   */
  def data(element:Element, key:String, v:js.Any):js.Any = js.native
  /**
   * Returns value at named data store for the element, as set by jQuery.data(element, name, value), 
   * or the full data store for the element.
   */
  def data(element:Element):js.Dictionary[js.Any] = js.native
  def data(element:Element, key:String):js.Any = js.native
  
  /**
   * A factory function that returns a chainable utility object with methods to register multiple 
   * callbacks into callback queues, invoke callback queues, and relay the success or failure state 
   * of any synchronous or asynchronous function.
   */
  def Deferred(beforeStart:UndefOr[js.Function1[JQueryDeferred, _]] = js.undefined):JQueryDeferred = js.native
  
  /**
   * Execute the next function on the queue for the matched element.
   * 
   * Note: This is a low-level method, you should probably use .dequeue() instead.
   */
  def dequeue(element:Element, queueName:UndefOr[String] = "fx"):Unit = js.native
  
  /**
   * A generic iterator function, which can be used to seamlessly iterate over both objects and arrays. 
   * Arrays and array-like objects with a length property (such as a function's arguments object) are 
   * iterated by numeric index, from 0 to length-1. Other objects are iterated via their named properties.
   */
  def each[A](collection: js.Array[A], callback: js.Function2[Int, A, _]): Unit = js.native
  def each[A](collection: js.Array[A], callback: js.ThisFunction0[A, _]): Unit = js.native
  def each[A](collection: js.Dictionary[A], callback: js.Function2[String, A, _]): Unit = js.native
  def each[A](collection: js.Dictionary[A], callback: js.ThisFunction0[A, _]): Unit = js.native  

  /**
   * Takes a string and throws an exception containing it.
   */
  def error(message:String):Unit = js.native
  
  def Event(name:String):JQueryEventObject = js.native
  def Event(name:String, init:JQueryEventObject):JQueryEventObject = js.native
  
  /**
   * Poorly-documented internal bit, used to construct fancy selectors.
   */
  var expr: js.Dynamic = js.native
  
  /**
   * Merge the contents of two or more objects together into the first object.
   */
  def extend(target:js.Object, objects:js.Object*):js.Object = js.native
  def extend(deep:Boolean, target:js.Object, objects:js.Object*):js.Object = js.native
  
  /**
   * Access to jQuery's own prototype, so you can extend it with additional functions.
   */
  def fn:JQueryFN = js.native
  
  /**
   * Provides access to the underlying FX engine.
   */
  def fx:JQueryFX = js.native
  
  /**
   * Load data from the server using a HTTP GET request.
   */
  def get():JQueryXHR = js.native
  def get(settings:JQueryAjaxSettings):JQueryXHR = js.native
  def get(url:String, data:js.Object, success:js.Function3[js.Object, String, JQueryXHR, Any], dataType:String):JQueryXHR = js.native
  def get(
    url:String, 
    data:String, 
    success:UndefOr[js.Function3[js.Object, String, JQueryXHR, Any]] = undefined, 
    dataType:UndefOr[String] = undefined):JQueryXHR = js.native
  
  /**
   * Load JSON-encoded data from the server using a GET HTTP request.
   */
  def getJSON(url:String):JQueryXHR = js.native
  def getJSON(url:String, data:String | js.Object):JQueryXHR = js.native
  def getJSON(url:String, data:String | js.Object, success:js.Function3[js.Object, String, JQueryXHR, Any]):JQueryXHR = js.native
  
  /**
   * Load a JavaScript file from the server using a GET HTTP request, then execute it.
   */
  def getScript(url:String, success:UndefOr[js.Function3[String, String, JQueryXHR, Any]] = undefined):JQueryXHR = js.native
  
  /**
   * Execute some JavaScript code globally.
   */
  def globalEval(code:String):Unit = js.native
  
  /**
   * Finds the elements of an array which satisfy a filter function. The original array is not affected.
   */
  def grep(
    array:js.Array[js.Any] | js.Object, 
    func:js.ThisFunction2[Element, js.Object, Integer, Boolean], 
    invert:UndefOr[Boolean] = false):js.Array[js.Any] = js.native
  
  /**
   * Determine whether an element has any jQuery data associated with it.
   */
  def hasData(element:Element):Boolean = js.native
  
  /**
   * Holds or releases the execution of jQuery's ready event.
   */
  def holdReady(hold:Boolean):Unit = js.native
  
  /**
   * Search for a specified value within an array and return its index (or -1 if not found).
   */
  def inArray(value:js.Any, array:js.Array[js.Any], fromIndex:UndefOr[Int] = 0):Int = js.native
  
  /**
   * Check to see if an object is empty (contains no enumerable properties).
   */
  def isEmptyObject(obj:js.Any):Boolean = js.native
  
  /**
   * Determine if the argument passed is a JavaScript function object.
   */
  def isFunction(obj:js.Any):Boolean = js.native
  
  /**
   * Determines whether its argument is a number.
   */
  def isNumeric(obj:js.Any):Boolean = js.native
  
  /**
   * Check to see if an object is a plain object (created using "{}" or "new Object").
   */
  def isPlainObject(v:Any):Boolean = js.native
  
  /**
   * Determine whether the argument is a window.
   */
  def isWindow(v:Any):Boolean = js.native
  
  /**
   * Check to see if a DOM node is within an XML document (or is an XML document).
   */
  def isXMLDoc(node: dom.Node): Boolean = js.native
  
  /**
   * Convert an array-like object into a true JavaScript array.
   */
  def makeArray(obj:js.Object):js.Array[js.Any] = js.native
  
  /**
   * Translate all items in an array or object to new array of items.
   */
  def map[A, B](collection: js.Array[A], callback: js.Function2[A, Int, B]): js.Array[B] = js.native
  def map[A, B](collection: js.Array[A], callback: js.Function1[A, B]): js.Array[B] = js.native
  def map[A, B](collection: js.Dictionary[A], callback: js.Function2[A, String, B]): js.Dictionary[B] = js.native
  def map[A, B](collection: js.Dictionary[A], callback: js.Function1[A, B]): js.Dictionary[B] = js.native
  
  /**
   * Merge the contents of two arrays together into the first array.
   */
  def merge(first:js.Array[js.Any] | js.Object, second:js.Array[js.Any] | js.Object):js.Array[js.Any] = js.native
  
  /**
   * Relinquish jQuery's control of the $ variable.
   */
  def noConflict(removeAll:UndefOr[Boolean] = undefined):js.Object = js.native
  
  /**
   * An empty function.
   */
  def noop():Unit = js.native
  
  /**
   * Return a number representing the current time.
   */
  def now():Double = js.native
  
  /**
   * Create a serialized representation of an array, a plain object, or a jQuery object suitable 
   * for use in a URL query string or Ajax request. In case a jQuery object is passed, 
   * it should contain input elements with name/value properties.
   */
  def param(obj:js.Dictionary[js.Any] | JQuery | js.Array[JQuerySerializeArrayElement], traditional:UndefOr[Boolean] = false):String = js.native
  
  /**
   * Parses a string into an array of DOM nodes.
   */
  def parseHTML(data:String, context:UndefOr[Element] = js.undefined, keepScripts:UndefOr[Boolean] = false):js.Array[dom.Node] = js.native
  
  /**
   * Takes a well-formed JSON string and returns the resulting JavaScript value.
   */
  def parseJSON(json:String):js.Any = js.native
  
  /**
   * Parses a string into an XML document.
   */
  def parseXML(xml:String):dom.Document = js.native
  
  /**
   * Load data from the server using a HTTP POST request.
   */
  def post():JQueryXHR = js.native
  def post(settings:JQueryAjaxSettings):JQueryXHR = js.native
  def post(url:String, data:js.Object, success:js.Function3[js.Object, String, JQueryXHR, Any], dataType:String):JQueryXHR = js.native
  def post(
    url:String, 
    data:String, 
    success:UndefOr[js.Function3[js.Object, String, JQueryXHR, Any]] = undefined, 
    dataType:UndefOr[String] = undefined):JQueryXHR = js.native
    
  /**
   * Takes a function and returns a new one that will always have a particular context.
   */
  def proxy(func:js.Function, context:UndefOr[js.Object], additionalArguments:Any*):js.Function = js.native
  def proxy(context:UndefOr[js.Object], name:String, additionalArguments:Any*):js.Function = js.native
    
  /**
   * Show the queue of functions to be executed on the matched element.
   * 
   * Note: This is a low-level method, you should probably use .queue() instead.
   */
  def queue(element:Element, queueName:UndefOr[String] = "fx"):js.Array[js.Function] = js.native
  
  /**
   * Remove a previously-stored piece of data.
   */
  def removeData(element:Element, name:UndefOr[String] = js.undefined):JQuery = js.native
  
  /**
   * Remove the whitespace from the beginning and end of a string.
   */
  def trim(str:String):String = js.native
  
  /**
   * Determine the internal JavaScript [[Class]] of an object.
   * 
   * TODO: we ought to have a strongly-typed way to test the results from this, in an extension method.
   */
  @JSName("type")
  def jqType(obj:js.Any):String = js.native
  
  /**
   * Sorts an array of DOM elements, in place, with the duplicates removed. 
   * Note that this only works on arrays of DOM elements, not strings or numbers.
   */
  def unique(array:js.Array[Element]):js.Array[Element] = js.native
    
  /**
   * Provides a way to execute callback functions based on one or more objects, usually Deferred objects that represent asynchronous events.
   * 
   * In the unusual case that you want to pass in arbitrary objects, use the "whenAny" form.
   */
  def when(deferreds:JQueryDeferred*):JQueryPromise = js.native
  @JSName("when")
  def whenAny(deferreds:js.Object*):JQueryPromise = js.native
}

@js.native
trait JQueryTransport extends js.Object {
  def send(headers: js.Dictionary[js.Any], completeCallback: js.Function4[Int, String, UndefOr[js.Dictionary[js.Any]], UndefOr[String], Unit]): Unit = js.native
  def abort(): Unit = js.native
}

@js.native
trait JQueryCallbacks extends js.Object {
  def add(callbacks: js.Function*):JQueryCallbacks = js.native
  def disable():JQueryCallbacks = js.native
  def disabled():Boolean = js.native
  def empty():JQueryCallbacks = js.native
  def fire(arguments:Any*):JQueryCallbacks = js.native
  def fired(): Boolean = js.native
  def fireWith(context: js.Any, args: js.Any*):JQueryCallbacks = js.native
  def has(callback: UndefOr[js.Function] = js.undefined): Boolean = js.native
  def lock():JQueryCallbacks = js.native
  def locked(): Boolean = js.native
  def remove(callbacks: js.Function*):JQueryCallbacks = js.native
}

@js.native
trait JQueryFX extends js.Object {
  var interval:Number = js.native
  var off:Boolean = js.native
}

@js.native
trait JQueryFN extends js.Object {
  def extend(obj:js.Object):js.Object = js.native
}
