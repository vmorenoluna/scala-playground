package cats.typeclass

object TypeClass {

  //  A type class is an interface or API that represents some functionality we want
  //  to implement. In Cats a type class is represented by a trait with at least one
  //  type parameter.

  // The "serialize to JSON" behaviour is encoded in this trait
  trait JsonWriter[A] {
    def write(value: A): Json
  }

}
