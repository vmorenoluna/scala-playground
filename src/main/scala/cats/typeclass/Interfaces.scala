package cats.typeclass

import cats.typeclass.TypeClass.JsonWriter

//  A type class interface is any functionality we expose to users. Interfaces are
//  generic methods that accept instances of the type class as implicit parameters.
//  There are two common ways of specifying an interface: Interface Objects and
//  Interface Syntax.

//  Interface Object
object Json {
  def toJson[A](value: A)(implicit w: JsonWriter[A]): Json =
    w.write(value)
}

// Interface Syntax
object JsonSyntax {
  implicit class JsonWriterOps[A](value: A) {
    def toJson(implicit w: JsonWriter[A]): Json =
      w.write(value)
  }
}

