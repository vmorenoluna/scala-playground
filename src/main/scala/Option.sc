sealed trait Person
case class Employee(name: String, department: Department, manager: Option[String]) extends Person
case class Employer(name: String) extends Person
case class Department(name: String)

val persone = List(
  Employee("Marta", Department("IT"), None),
  Employee("Pietro", Department("IT"), None)
)

persone.map(p => pippo(p)).filter(n => n == 1)

def pippo(p: Person): Int = p match {
  case Employee("Marta", Department("IT"), manager) => 1
  case Employee(name, Department("IT"), manager) => 0
  case Employer(name) => 0
}

def lookupByName(name: String): Option[Employee] = name match {
  case "Joe" => Some(Employee("Joe", "Finances", Some("Julie")))
  case "Mary" => Some(Employee("Mary", "IT", None))
  case "Izumi" => Some(Employee("Izumi", "IT", Some("Mary")))
  case _ => None
}

def getManager: (Option[Employee]) => Option[String] = _.flatMap(_.manager)

