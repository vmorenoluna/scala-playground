package advanced

object FixedPoint extends App {

  def fix[A](f: (=> A) => A): A = {
    lazy val a: A = f(a)
    a
  }

  val fac: Int => Int = n => if (n == 0) 1 else n * fac(n - 1)

  val gac: (=> Int => Int) => Int => Int =
    fac => n => if (n == 0) 1 else n * fac.apply(n - 1)

  val facF = fix[Int => Int](fac => n => if (n == 0) 1 else n * fac.apply(n - 1))

}
