package lectures.part2oop

object IneritanceAndTraits extends App {

  // Single class inheritance
  class Animal {
    val creatureType = "wild"

    protected def eat = println("nom nom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  // How to extend a class with parameters
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  val cat = new Cat

  println(cat.crunch)

  class Dog(override val creatureType: String) extends Animal {
    //override val creatureType = "domestic"

    override def eat = {
      super.eat
      println("crucnh crucnh")
    }
  }

  val dog = new Dog("madness")

  println(dog.eat)
  println(dog.creatureType)

  // Type substitution (polymorphism)
  val unknownAnimal: Animal = new Dog("K9")

  // This is great because we can have an array of Animal which consists
  // of some Dog and some Cat. Calling method 'eat' on each will use
  // the overridden version where appropriate

  // NOTE
  // overRIDING is supplying different implementation with same signature
  // in derived classes (subclasses)
  // overLOADING is having multiple methods in same class but with different
  // signatures

  // Preventing overrides
  // 1 - Keyword 'final' on member: final eat =
  // 2 - Keyword 'final' on the class itself: final class Animal
  // 3 - Seal the class. Can extend class in THIS file, but not other files
}
