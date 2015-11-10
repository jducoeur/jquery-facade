package org.querki.jquery

import scala.scalajs.js
import js.UndefOr
import org.scalajs.dom
import dom.{Element, Event}
import org.querki.jsext._

/**
 * The facade over an event from JQuery.
 */
@js.native
trait JQueryEventObject extends Event {
  /**
   * Is the alt key pressed? Only defined on certain events.
   */
  def altKey:UndefOr[Boolean] = js.native
  
  /**
   * Provides the horizontal coordinate within the application's client area at which the 
   * event occurred (as opposed to the coordinates within the page).
   * 
   * Only defined on certain events.
   */
  def clientX:UndefOr[Int] = js.native
  
  /**
   * Provides the vertical coordinate within the application's client area at which the 
   * event occurred (as opposed to the coordinates within the page).
   * 
   * Only defined on certain events.
   */
  def clientY:UndefOr[Int] = js.native
  
  /**
   * Is the ctrl key pressed? Only defined on certain events.
   */
  def ctrlKey:UndefOr[Boolean] = js.native
  
  /**
   * An optional object of data passed to an event method when the current executing handler is bound.
   */
  def data: Any = js.native
  
  /**
   * The element where the currently-called jQuery event handler was attached.
   */
  def delegateTarget: Element = js.native
  
  /**
   * Returns additional numerical information about the event, depending on the type of event.
   */
  def detail: Any = js.native
  
  /**
   * Returns whether event.preventDefault() was ever called on this event object.
   */
  def isDefaultPrevented(): Boolean = js.native
  
  /**
   * Returns whether event.stopImmediatePropagation() was ever called on this event object.
   */
  def isImmediatePropagationStopped(): Boolean = js.native
  
  /**
   * Returns whether event.stopPropagation() was ever called on this event object.
   */
  def isPropagationStopped(): Boolean = js.native
  
  /**
   * Indicates whether the META key was pressed when the event fired.
   */
  def metaKey: Boolean = js.native
  
  /**
   * The namespace specified when the event was triggered.
   */
  def namespace: String = js.native
  
  /**
   * Provides the offset in the X coordinate of the mouse pointer between that event and the padding edge of the target node.
   */
  def offsetX: UndefOr[Int] = js.native
  
  /**
   * Provides the offset in the Y coordinate of the mouse pointer between that event and the padding edge of the target node.
   */
  def offsetY: UndefOr[Int] = js.native
  
  /**
   * The mouse position relative to the left edge of the document.
   */
  def pageX: Int = js.native
  
  /**
   * The mouse position relative to the top edge of the document.
   */
  def pageY: Int = js.native
  
  /**
   * If this method is called, the default action of the event will not be triggered.
   */
  override def preventDefault(): Unit = js.native
  
  /**
   * The other DOM element involved in the event, if any.
   */
  def relatedTarget: Element = js.native
  
  /**
   * The last value returned by an event handler that was triggered by this event, unless the value was undefined.
   */
  def result: UndefOr[Any] = js.native
  
  /**
   * Provides the horizontal coordinate of the mouse pointer in global (screen) coordinates.
   * Only defined on certain events.
   */
  def screenX: UndefOr[Int] = js.native
  
  /**
   * Provides the vertical coordinate of the mouse pointer in global (screen) coordinates.
   * Only defined on certain events.
   */
  def screenY: UndefOr[Int] = js.native

  /**
   * Is the shift key pressed? Only defined on certain events.
   */
  def shiftKey:UndefOr[Boolean] = js.native
  
  /**
   * Keeps the rest of the handlers from being executed and prevents the event from bubbling up the DOM tree.
   */
  override def stopImmediatePropagation(): Unit = js.native
  
  /**
   * Prevents the event from bubbling up the DOM tree, preventing any parent handlers from being notified of the event.
   */
  override def stopPropagation(): Unit = js.native
  
  /**
   * For key or mouse events, this property indicates the specific key or button that was pressed.
   */
  def which: Int = js.native
}

/**
 * Constructor facade for JQueryEventObject. See the documentation of the JQueryEventObject trait for more
 * information about the various constructor methods.
 * 
 * TBD: does this need to use jsext? Possibly not. Look at this more closely, and see if switching to a more
 * straightforward constructor is more appropriate in this case. If all of the parameters are singly-typed,
 * then jsext is overkill.
 * 
 * In general, this is rather half-baked, and needs enhancement and sanity-checking.
 */
object JQueryEventObject extends JQueryEventObjectBuilder(noOpts)
class JQueryEventObjectBuilder(val dict:OptMap) extends JSOptionBuilder[JQueryEventObject, JQueryEventObjectBuilder](new JQueryEventObjectBuilder(_)) {
  def data(v:Any) = jsOpt("data", v)
  def delegateTarget(v:Element) = jsOpt("delegateTarget", v)
  def namespace(v:String) = jsOpt("namespace", v)
  def relatedTarget(v:Element) = jsOpt("relatedTarget", v)
  def result(v:Any) = jsOpt("result", v)
  def pageX(v:Int) = jsOpt("pageX", v)
  def pageY(v:Int) = jsOpt("pageY", v)
  def which(v:Int) = jsOpt("which", v)
  def metaKey(v:Boolean) = jsOpt("metaKey", v)
}
