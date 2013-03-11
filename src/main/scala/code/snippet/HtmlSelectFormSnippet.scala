package code.snippet

import net.liftweb.common.Empty
import net.liftweb.util.Helpers._
import net.liftweb.http.SHtml._
import net.liftweb.http.js.JsCmd
import net.liftweb.http.js.JsCmds.SetHtml
import xml.Text
import net.liftweb.http.S

class HtmlSelectFormSnippet {

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

    val blankOption = ("" -> "")

    val options : List[(String,String)] =
      blankOption ::
      database.keys.map(p => (p,p)).toList

    val default = Empty

    def handler(selected: String) : JsCmd = {
      SetHtml("distance", Text(database(selected) + " light years"))
    }

    var selectedValue : String = ""

    "select" #> onEvents("onchange")(handler) {
        select(options, default, selectedValue = _)
     } &
    "type=submit" #> onSubmitUnit( () => S.notice("Destination "+selectedValue))

  }
}
