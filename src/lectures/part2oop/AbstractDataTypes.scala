package lectures.part2oop

object AbstractDataTypes extends App {

  // Abstract classes
  abstract class Animal {
    val creatureType: String

    def eat: Unit
  }

  class Dog extends Animal {
    // 'override' is optional
    override val creatureType: String = "Canine"
    def eat: Unit = println("Crunch Crunch")
  }


  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredmeal: String = "Fresh meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    val creatureType: String = "Croc"
    def eat: Unit = println("NomNomNom")
    def eat(animal: Animal): Unit = println(s"Croc is eating a ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile

  croc.eat(dog)

  // Abstract classes and Traits can each have both abstract
  // and non-abstract members
  // The differences are
  // 1 - Traits don't have constructor parameters
  // 2 - You can only extend one class, but you can mix in multiple traits
  // 3 - Choose traits for BEHAVIOUR, abstract classes for THINGS
}
