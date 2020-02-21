package basics

object Assignment extends App {

  val v = (1 -> 2)
  println(v)

  // z @ pattern = ...
  // assign to variable z the value corresponding to the whole
  // expression that pattern matches. Inside pattern , there might be other variables bound
  // to the constituent parts.
  val z @ (x, y) = (1 -> 2)
  println(z)
  println(x)
  println(y)

}
