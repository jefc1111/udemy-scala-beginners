package lectures.part2oop

object Objects {

 // Scala does not have class-level functionality. Doesn't have 'static'.

  object Person { // Singleton BY DEFINITION
    // "static" / "class-level" functionality
    val N_EYES = 2

    def canFly: Boolean = false

    // Factory method
    def apply(mother: Person, father: Person): Person = new Person("A lovely son")
  }

  class Person(val name: String) {
    // Instance-level functionality
  }
  // The above class and object definition are COMPANIONS

  def main(args: Array[String]): Unit = {
    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object is a SINGLETON instance

    val mary = Person
    val john = Person

    println(mary == john)

    val bob = new Person("Bob")
    val kate = new Person("Kate")

    println(bob == kate)

    val quin = Person(bob, kate)

    println(quin.name)
  }


  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit
}
