package basics

object LazyList extends App {

  val naturals : LazyList[Int] = 1 #:: naturals.map(_ + 1)

  naturals take 10 foreach println

}
