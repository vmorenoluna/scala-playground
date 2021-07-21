package patternmatch

object ToUnderstand extends App {

  case class Foo(i: Int, j: Int, k: Int)

  val res0: Foo = Foo(1,2,3)

  println(
    res0 match {
      case 1 Foo (2,3) => true
      case _ => false
    }
  )

  object Bar {
    def unapply(f: Foo): Option[(Int,Int,Int)] = Some(f.i,f.j,f.k)
  }

  println(
    res0 match {
      case 1 Bar (2,3) => true
      case _ => false
    }
  )

}
