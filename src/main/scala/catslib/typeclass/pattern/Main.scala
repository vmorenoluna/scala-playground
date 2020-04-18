package catslib.typeclass.pattern

import JsonSyntax._
import JsonWriterInstances._

object TypeClassMain extends App{

  // There are three important components to the type class pttern: the type class
  // itself, instances for paticular types, and the interface methods that we expose
  // to users.

  // Conversion through Interface Object
  JsonInterface.toJson(Person("Dave", "dave@example.com"))

  // Conversion through Interface Sintax
  Person("Dave", "dave@example.com").toJson

}
