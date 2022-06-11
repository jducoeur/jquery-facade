package org.querki.jquery

import scala.scalajs.js
import js.|
import org.scalajs.dom.XMLHttpRequest

// TBD: is this signature correct?
@js.native
trait JQueryXHR extends XMLHttpRequest with JQueryDeferred {
  // The signature of always is deeply unfortunate; the parameters are highly contextual:
  def always(handler:js.Function3[js.Any, String, JQueryXHR | String, Any]):JQueryXHR = js.native
  def done(handler:js.Function3[js.Any, String, JQueryXHR, Any]):JQueryXHR = js.native
  def fail(handler:js.Function3[JQueryXHR, String, String, Any]):JQueryXHR = js.native
  def overrideMimeType(): js.Dynamic = js.native
  def `then`(doneCallback:js.Function3[js.Any, String, JQueryXHR, Any], failCallback:js.Function3[JQueryXHR, String, String, Any]):JQueryXHR = js.native
}
