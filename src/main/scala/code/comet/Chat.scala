package code.comet

import net.liftweb.http.{ListenerManager, CometListener, CometActor}
import net.liftweb.actor.LiftActor

class ChatClient extends CometActor with CometListener {

  def registerWith = ChatServer

  private var msgs : Vector[String] = Vector()

  override def lowPriority = {
    case xs: Vector[String] =>
      msgs = xs
      reRender()
  }

  def render = "li *" #> msgs

}


object ChatServer extends LiftActor with ListenerManager {

  private var msgs = Vector("Welcome")

  def createUpdate = msgs

  override def lowPriority = {
    case s: String =>
      msgs :+= s
      updateListeners()
  }

}