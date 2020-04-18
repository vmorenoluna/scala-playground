package catslib.typeclass

import java.time.Instant
import java.time.temporal.ChronoUnit.HOURS
import cats.kernel.Eq
import cats.implicits._
import catslib.typeclass.pattern.Person

object EqObject extends App {

  implicit val dateEq: Eq[Instant] =
    Eq.instance[Instant] {
      (instant1, instant2) =>
        // compare longs with cats eq istance for long
        // "equals" would work as well
        instant1.getEpochSecond === instant2.getEpochSecond
    }

  val x = Instant.now()
  val y = Instant.now().plus(1, HOURS)

  println(x === x)

  println(x =!= y)

  implicit val eqFoo: Eq[Person] = Eq.fromUniversalEquals

  println(
    Person("Dave", "dave@example.com") === Person("Dave", "dave@example.com")
  )

  println(
    Person("Dave", "dave@example.com") =!= Person("John", "john@example.com")
  )

}