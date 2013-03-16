package code.snippet

import net.liftweb.util.Helpers._
import net.liftweb.http.js.JsCmds.FocusOnLoad

class Focus {

  def render = "name=username" #>
    FocusOnLoad(<input type="text"/>)

}
