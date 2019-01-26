package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // Anonymous class, on the fly
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("hahahahaha")
  }

  println(funnyAnimal.getClass)

  // See that it works for abstract AND non-abstract classes
  class Person(name: String) {
    def sayHi: Unit = println(s"Hi ${name}")
  }

  val fred = new Person("fred") {
    override def sayHi: Unit = println("OVERRIDE DONED")
  }

  println(fred.sayHi)
}
