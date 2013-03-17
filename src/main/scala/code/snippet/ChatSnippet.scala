package code.snippet

import net.liftweb.http.SHtml
import code.comet.ChatServer
import net.liftweb.http.js.JsCmds.SetValById

object ChatSnippet {

  def render = SHtml.onSubmit(s => {
    ChatServer ! s
    SetValById("message", "")
  })
}
