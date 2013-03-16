package code.snippet

import net.liftweb.util.Helpers._
import net.liftweb.http.SHtml
import net.liftweb.http.js.{JsCmd, JE}
import net.liftweb.common.Loggable
import net.liftweb.json.JsonAST._
import net.liftweb.http.js.JsCmds.Alert
import net.liftweb.json.DefaultFormats

object JsonCall extends Loggable {

  def render = {

    implicit val formats = DefaultFormats

    case class Question(first: Int, second: Int, answer: Int) {
      def valid_? = first + second == answer
    }

    def validate(value: JValue) : JsCmd = {
      logger.info(value)
      value.extractOpt[Question].map(_.valid_?) match {
        case Some(true) => Alert("Looks good")
        case Some(false) => Alert("That doesn't add up")
        case None => Alert("That doesn't make sense")
      }
    }

    "button [onclick]" #>
      SHtml.jsonCall( JE.Call("currentQuestion"), validate _ )

  }

}
