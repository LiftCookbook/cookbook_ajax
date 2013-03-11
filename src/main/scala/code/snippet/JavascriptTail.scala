package code.snippet

import net.liftweb.util.Helpers._
import net.liftweb.http.js.JsCmds.Alert
import net.liftweb.http.S
import xml.NodeSeq

class JavascriptTail {

  // An alternative:
  //def render = "*" #> <lift:tail>{Script(OnLoad(Alert("Hi")))}</lift:tail>

  def render = {
    S.appendJs(Alert("Hi"))
    "*" #> NodeSeq.Empty
  }

}
