package code.snippet

import net.liftweb.util.Helpers._
import net.liftweb.http.js.JsCmds.{Alert, RedirectTo}
import net.liftweb.http.js.JE

object ClientSide {

  def render = "button [onclick]" #> "$('button').fadeOut()"

  def combined =
    "button [onclick]" #> (Alert("Here we go...") & RedirectTo("http://liftweb.net"))

  def callgreet =
    "button [onclick]" #> JE.Call("greet", "World!", 3)

}
