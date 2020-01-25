package implicits

object Conversions extends App {
  println("-" * 50)

  final case class Apple(weight: Int, colour: String)
  final case class Orange(weight: Int)

  def printOrange(orange: Orange): Unit = {
    println("-" * 50)
    println(orange)
    println("-" * 50)
  }

  // implicit conversion (implicit implicit)
  implicit def appleCanBeUsedAsOrange(apple: Apple): Orange =
    Orange(apple.weight)

  printOrange(
    Apple(
      weight = 300,
      colour = "Green"
    )
  )

  println("-" * 50)

  // explicit conversion (explicit implicit, or extension methods),
  // can avoid to declare the following method if the wrapper AppleOps class is declared as implicit.
  // The name of the method and the one of the class don't have to be equal.
  // The class extends AnyVal to improve performance
  //
  //  implicit def appleOps(apple: Apple): AppleOps = {
  //    AppleWrapper(apple)
  //  }

  final implicit class AppleOps(private val self: Apple) extends AnyVal {
    def toOrange: Orange = Orange(self.weight)
  }

  printOrange(
    Apple(
      weight = 300,
      colour = "Green"
    ).toOrange
  )

  println("-" * 50)
}
