package patternmatch

object InfixConstructor extends App {

  /**
   * The :: class
   *
   * Class ::, pronounced "cons" for "construct," represents non-empty lists. It's named that way in order to
   * support pattern matching with the infix ::.
   * So the pattern x :: xs is treated as ::(x, xs) where :: is a case class.
   * Here is the definition of the :: class:
   *
   * final case class ::[T](head: T, tail: List[T]) extends List[T] {
   *  override def isEmpty: Boolean = false
   * }
   *
   */

  println(
    1 :: List(2,3)    // def ::[B >: A] (x: B): List[B] = new scala.collection.immutable.::(x, this)
  )
  println(
    List(2,3).::(1)
  )

  List(1, 2, 3) match {
    case Nil => println(false)
    case ::(head, next) => println(true)
  }

}
