package code.snippet

import java.text.NumberFormat
import java.util.Locale

import scala.xml.{NodeSeq, Text}

import net.liftweb.util.Helpers._
import net.liftweb.util.{Cell, ValueCell}
import net.liftweb.http.{S, WiringUI}
import net.liftweb.http.SHtml.ajaxInvoke
import net.liftweb.http.js.JsCmd

class Wiring {

  val cost = ValueCell(1.99)
  val quantity = ValueCell(1)
  val subtotal = cost.lift(quantity)(_ * _)

  val formatter = NumberFormat.getCurrencyInstance(Locale.US)

  def currency(cell: Cell[Double]): NodeSeq => NodeSeq =
    WiringUI.toNode(cell)((value, ns) => Text(formatter format value))

  def increment(): JsCmd  = {
    quantity.atomicUpdate(_ + 1)
    S.notice("Added One")
  }

  def render =
    "#add [onclick]" #> ajaxInvoke(increment) &
    "#quantity *" #> WiringUI.asText(quantity) &
    "#subtotal *" #> currency(subtotal)

}
