package code.snippet

import net.liftweb.util.Helpers._
import net.liftweb.http.{SHtml, Templates}
import net.liftweb.http.js.JsCmds.{SetHtml, Noop}
import net.liftweb.http.js.JsCmd

object TemplateLoad {

  def content : JsCmd =
    Templates("index" :: Nil).map(ns => SetHtml("inject", ns)) openOr Noop

  def render = "button [onclick]" #> SHtml.ajaxInvoke(content _)

}
