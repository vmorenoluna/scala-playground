package implicits

object Parameters extends App {
  println("─" * 50)

  def method(a: Int)(implicit b: Int, c: Int): Int =
    a + b + c

  println(method(1)(2,3))

  println("─" * 50)

  implicit val number: Int = 4

  println(method(1))  // println(method(1)(4,4))
  println("The implicit in scope for type Int is " + implicitly[Int])

  println("─" * 50)


}
