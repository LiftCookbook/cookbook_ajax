package code.snippet

import net.liftweb.common.Empty
import net.liftweb.util.Helpers._
import net.liftweb.http.SHtml.ajaxSelect
import net.liftweb.http.js.JsCmd
import net.liftweb.http.js.JsCmds.SetHtml
import xml.Text

class HtmlSelectSnippet {

  type Planet = String
  type LightYears = Double

  val database = Map[Planet,LightYears](
    "Alpha Centauri Bb" -> 4.23,
    "Tau Ceti e" -> 11.90,
    "Tau Ceti f" -> 11.90,
    "Gliese 876 d" -> 15.00,
    "82 G Eridani b" -> 19.71
  )

  def render = {

    val options : List[(String,String)] = database.keys.map(p => (p,p)).toList
    val default = Empty

    def handler(selected: String) : JsCmd = {
      SetHtml("distance", Text(database(selected).toString))
    }

    "select" #> ajaxSelect(options, default, handler)

  }
}
