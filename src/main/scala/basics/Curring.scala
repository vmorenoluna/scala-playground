package basics

object Curring extends App {

  // Curring: a function that takes multiple arguments can be translated into a series of function calls
  // that each take a single argument.
  //
  // A partially-applied function is a function that you manually create by supplying fewer
  // parameters than the initial function defines. In other words, a partially applied function is a
  // function that takes a function with multiple parameters and returns a function with fewer parameters

  example1
  println("─" * 50)

  example2
  println("─" * 50)

  example3
  println("─" * 50)

  example4
  println("─" * 50)

  private def example1(): Unit = {

    def plus(a: Int)(b: Int): Int = a + b

    println(
      "Calling a method with group parameters passing a placeholder for one of the group parameters creates a partially applied function"
    )

    def plus2: Int => Int = plus(2)(_)

    def plus3: Int => Int = plus(3) _

    println(
      plus2(3)
    )
    println(
      plus3(4)
    )

  }

  private def example2(): Unit = {

    def wrap(prefix: String)(html: String)(suffix: String) = {
      prefix + html + suffix
    }

    val hello = "Hello, world"

    println("It is possible to partially-apply parameters to a general function with group parameters to make a specific function")

    val wrapWithDiv: String => String = wrap("<div>")(_: String)("</div>")
    val wrapWithPre: String => String = wrap("<pre>")(_: String)("</pre>")

    println(wrapWithDiv(hello))
    println(wrapWithPre(hello))

  }

  private def example3(): Unit = {

    def add(x: Int, y: Int): Int = x + y

    println(
      "Passing \"_\" to a method, converts the method to a function: " +
        (add _).isInstanceOf[Function2[_, _, _]]
    )

    val addCurried = (add _).curried // addCurried: Int => (Int => Int) = <function1>

    println(
      "Calling \"curried\" method on a function returns a curried version of the function: " +
        addCurried.isInstanceOf[Function1[_, _]]
    )

    println(
      "addCurried(1)(2) = " +
        addCurried(1)(2)
    )

    val addCurriedTwo = addCurried(2) // addCurriedTwo: Int => Int = <function1>

    println(
      "addCurriedTwo = addCurried(2) is a partial function: " +
        addCurriedTwo.isInstanceOf[Function1[_, _]]
    )

    println(
      "addCurriedTwo(10) = " +
        addCurriedTwo(10)
    )

  }

  private def example4(): Unit = {

    def wrap(prefix: String, html: String, suffix: String) = {
      prefix + html + suffix
    }

    val hello = "Hello, world"

    println("It is possible to partially-apply parameters to the general function to make a specific function")

    val wrapWithDiv: String => String = wrap("<div>", _: String, "</div>")
    val wrapWithPre: String => String = wrap("<pre>", _: String, "</pre>")

    println(wrapWithDiv(hello))
    println(wrapWithPre(hello))

  }

}
