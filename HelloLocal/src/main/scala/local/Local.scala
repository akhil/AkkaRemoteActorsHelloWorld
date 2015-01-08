package local

import akka.actor._

object Local extends App {

  implicit val system = ActorSystem("LocalSystem")
  val localActor1 = system.actorOf(Props(new LocalActor(1)),  name = "LocalActor1")  // the local actor
  val localActor2 = system.actorOf(Props(new LocalActor(2)),  name = "LocalActor2")  // the local actor
  val localActor3 = system.actorOf(Props(new LocalActor(3)),  name = "LocalActor3")  // the local actor
  val localActor4 = system.actorOf(Props(new LocalActor(4)),  name = "LocalActor4")  // the local actor
  val localActor5 = system.actorOf(Props(new LocalActor(5)),  name = "LocalActor5")  // the local actor
  localActor1 ! 1                                                     // start the action
  localActor2 ! 1                                                     // start the action
  localActor3 ! 1                                                     // start the action
  localActor4 ! 1                                                     // start the action
  localActor5 ! 1                                                     // start the action

  val localActor6 = system.actorOf(Props(new LocalActor(6)),  name = "LocalActor6")  // the local actor
  localActor6 ! 1                                                     // start the action
  val localActor7 = system.actorOf(Props(new LocalActor(7)),  name = "LocalActor7")  // the local actor
  localActor7 ! 1                                                     // start the action
  val localActor8 = system.actorOf(Props(new LocalActor(8)),  name = "LocalActor8")  // the local actor
  localActor8 ! 1                                                     // start the action
  val localActor9 = system.actorOf(Props(new LocalActor(9)),  name = "LocalActor9")  // the local actor
  localActor9 ! 1                                                     // start the action
  val localActor10 = system.actorOf(Props(new LocalActor(10)),  name = "LocalActor10")  // the local actor
  localActor10 ! 1                                                     // start the action
}

class LocalActor(c: Int) extends Actor {

  // create the remote actor
  val remote = context.actorFor(s"akka.tcp://HelloRemoteSystem@127.0.0.1:5150/user/RemoteActor$c")
  var counter = 0

  var s = System.nanoTime();

  def receive = {
    case "START" => 
        remote ! "Hello from the LocalActor"
    case msg: String => 
        println(s"LocalActor received message: '$msg'")
        if (counter < 5) {
            sender ! "Hello back to you"
            counter += 1
        }
    case 100000 =>
      val e = System.nanoTime()
      println("stop")
      print((e - s)/1000000000 + " " + new java.util.Date() + "\n")

    case 1 =>
      s = System.nanoTime();
      remote ! 1

    case i: Int =>
      remote ! i
  }
}


