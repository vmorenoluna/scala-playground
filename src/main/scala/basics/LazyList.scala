package basics

object LazyList extends App {

  val naturals : LazyList[Int] = 1 #:: naturals.map(_ + 1)

  naturals take 10 foreach println

  println("\u2500" * 50)

  def getAt[A](s: LazyList[A], i: Int): A = (s, i) match {
    case (h #:: _, 0) => h
    case (_ #:: t, _) => getAt(t, i - 1)
    case _ => throw new NoSuchElementException("getAt(empty)")
  }

  println(
    getAt[Int](naturals take 10, 5)
  )

}
