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
   * Convenience conversion, so that you can use a Scala Seq[Element] where the API expects a js.Array[Element].
   */
  implicit def seq2Selector(seq:Seq[Element]):Selector = seq.toJSArray
  implicit def seq2ElementDesc(seq:Seq[Element]):ElementDesc = seq.toJSArray
}
