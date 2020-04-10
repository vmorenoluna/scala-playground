package basics

object Parameters extends App {

  println("To pass operators as parameters, without having to use the underscores, you need to define the functions as values")

  val + = (a:Int, b: Int) => a + b
  val - = (a:Int, b: Int) => a - b

  def f(a: Int, b: Int, fn: (Int, Int) => Int): Int = fn(a, b)

  val i = 2
  println(f(i, i, +))
  println(f(i, i, -))
  println(f(i, i, _ * _))
  println(f(i, i, _ / _))

}
