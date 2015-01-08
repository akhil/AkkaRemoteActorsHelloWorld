package remote

import akka.actor._

object HelloRemote extends App  {
  val system = ActorSystem("HelloRemoteSystem")
  val remoteActor = system.actorOf(Props[RemoteActor], name = "RemoteActor1")
  remoteActor ! "The RemoteActor is alive"
  val remoteActor1 = system.actorOf(Props[RemoteActor], name = "RemoteActor2")
  val remoteActor2 = system.actorOf(Props[RemoteActor], name = "RemoteActor3")
  val remoteActor3 = system.actorOf(Props[RemoteActor], name = "RemoteActor4")
  val remoteActor4 = system.actorOf(Props[RemoteActor], name = "RemoteActor5")
  val remoteActor5 = system.actorOf(Props[RemoteActor], name = "RemoteActor6")
  val remoteActor6 = system.actorOf(Props[RemoteActor], name = "RemoteActor7")
  val remoteActor7 = system.actorOf(Props[RemoteActor], name = "RemoteActor8")
  val remoteActor8 = system.actorOf(Props[RemoteActor], name = "RemoteActor9")
  val remoteActor9 = system.actorOf(Props[RemoteActor], name = "RemoteActor10")
}

class RemoteActor extends Actor {
  def receive = {
    case msg: String => 
        println(s"RemoteActor received message '$msg'")
        sender ! "Hello from the RemoteActor"
    case i: Int =>
       sender ! i+1
  }
}


