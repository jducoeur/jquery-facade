package org.querki

import scala.scalajs.js
import js.|
import js.JSConverters._
import org.scalajs.dom
import dom.Element

package object jquery {
  /**
   * The main entry point into jQuery. We alias it to $, to match jQuery idiom.
   */
  val $ = JQueryStatic
  
  /**
   * A shorter alias for JQuery events, just to reduce keystrokes.
   */
  type JQEvt = JQueryEventObject
  
  implicit def builder2DialogOptions(builder:JQueryEventObjectBuilder) = builder._result

  implicit def jQuery2Ext(jq:JQuery):JQueryExtensions = new JQueryExtensions(jq)
  
  /**
   * This is a particularly important union type. Selector is a common parameter type
   * in jQuery, meaning essentially a filter for choosing some elements. It can be a string
   * describing a kind of node (using a CSS-ish syntax), an Element, or an Array of Elements.
   * 
   * Note that the jQuery API documentation is *extremely* inconsistent about
   * how it treats the term "Selector" -- sometimes it just uses the term to mean Strings,
   * sometimes it means all of the possible types. So use this with some care.
   */
  type Selector = String | Element | js.Array[Element]
  
  /**
   * This union type gets used for several functions that really allow anything that can describe an
   * Element. This is similar to Selector, but allows you to pass in a JQuery as well.
   */
  type ElementDesc = String | Element | JQuery | js.Array[Element]
  
  /**
   * This union type represents valid types that you can set an attribute to.
   */
  type AttrVal = String | Int | Boolean
  
  /**
   * This union type covers the possible signatures of functions to pass into event-registration
   * functions like "click" or "hover".
   */
  type EventHandler = 
    js.Function0[Any] | 
    js.Function1[JQueryEventObject, Any] |
    js.ThisFunction0[Element, Any] |
    js.ThisFunction1[Element, JQueryEventObject, Any]
  // The | operator interferes with the inferred converters from Scala functions to JS ones, so we
  // need to give it a hand:
  implicit def f02EventHandler(func:scala.Function0[Any]):EventHandler = { func:js.Function0[Any] }
  implicit def f12EventHandler(func:scala.Function1[JQueryEventObject, Any]):EventHandler = { func:js.Function1[JQueryEventObject, Any] }
  implicit def ft02EventHandler(func:scala.Function1[Element, Any]):EventHandler = { func:js.ThisFunction0[Element, Any] }
  implicit def ft12EventHandler(func:scala.Function2[Element, JQueryEventObject, Any]):EventHandler = { func:js.ThisFunction1[Element, JQueryEventObject, Any] }
  
  type Number = Double | Int
  
  /**
   * Convenience conversion, so that you can use a Scala Seq[Element] where the API expects a js.Array[Element].
   */
  implicit def seq2Selector(seq:Seq[Element]):Selector = seq.toJSArray
  implicit def seq2ElementDesc(seq:Seq[Element]):ElementDesc = seq.toJSArray
}
