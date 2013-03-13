package code.snippet

import net.liftweb.util.Helpers._
import net.liftweb.http.SHtml
import net.liftweb.http.js.JE.ValById
import net.liftweb.http.js.JsCmds._

object AjaxCall {

  def increment(in: String) : String =
    asInt(in).map(_ + 1).map(_.toString) openOr in

   def render = "button [onclick]" #>
     SHtml.ajaxCall(ValById("num"), s => SetValById("num", increment(s)) )

 }
