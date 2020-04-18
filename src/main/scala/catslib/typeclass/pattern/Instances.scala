package catslib.typeclass.pattern

import TypeClass.JsonWriter

object JsonWriterInstances {

  //  The instances of a type class provide implementations for the types we care
  //  about, including types from the Scala standard library and types from our
  //  domain model.
  //  In Scala we define instances by creating concrete implementations of the type
  //  class and tagging them with the implicit keyword.

  implicit val stringWriter: JsonWriter[String] =
    new JsonWriter[String] {
      def write(value: String): Json =
        JsString(value)
    }

  implicit val personWriter: JsonWriter[Person] =
    new JsonWriter[Person] {
      def write(value: Person): Json =
        JsObject(Map(
          "name" -> JsString(value.name),
          "email" -> JsString(value.email)
        ))
    }

  // Moreover, we can actually define instances in two ways:
  //  1. by defining concrete instances as implicit vals of the required type (see above vals)
  //  2. by defining implicit methods to construct instances from other type class instances
  implicit def optionWriter[A](implicit writer: JsonWriter[A]): JsonWriter[Option[A]] =
    new JsonWriter[Option[A]] {
      def write(option: Option[A]): Json =
        option match {
          case Some(aValue) => writer.write(aValue)
          case None
          => JsNull
        }
    }

}
