package comprehension

object Comprehension extends App {

  val countries = List("Italy", "Cuba", "Spain", "Japan")

  //  A single generator expression without a yield expression after the comprehension
  //  corresponds to an invocation of foreach on the collection.

  for (c <- countries)
    println(c)

  println()

  for {
    c <- countries
  } println(c)

  println()

  countries foreach println

  println("─" * 50)

  //  A single generator expression with a yield expression corresponds to an invocation
  //  of map . Note that when yield is used to construct a new container, the type of the first
  //  generator expression determines the final resulting collection.

  val list =  for {
    c <- countries
  } yield c.toUpperCase
  println(list)

  println(
    countries map (_.toUpperCase)
  )

  println("─" * 50)

  //  When there are multiple generators, all but the last are converted to flatMap invocations.
  //  The last is a map invocation.

  println(
    for {
      c <- countries
      v <- c              // The second generator iterates through each character in the string c
    } yield s"$v-${v.toUpper}"
  )

  println(
    countries flatMap (_.toSeq map (v => s"$v-${v.toUpper}"))
  )

  println("─" * 50)

  // If we use a guard, the withFilter invocation is injected before the final map invocation.

  println(
    for {
      c <- countries
      v <- c
      if v.isLower
    } yield s"$v-${v.toUpper} "
  )

  println(
    countries flatMap (_.toSeq withFilter (_.isLower) map (v => s"$v-${v.toUpper} "))
  )

  println("─" * 50)

// Define a variable

  println(
    for {
      c <- countries
      v <- c
      if v.isLower
      d = s"$v-${v.toUpper} "
    } yield d
  )

  println(
    countries flatMap (_.toSeq withFilter (_.isLower)
      map { v =>
        val d = s"$v-${v.toUpper} "
        d
      }
    )
  )

  println("─" * 50)


}
