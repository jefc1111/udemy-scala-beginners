package lectures.part2oop

object Generics extends App {

  // Generic class
  class MyList[+A] {
    // Use type A in the class definition

    def add[B >: A](el: B): MyList[B] = ???
  }

  val listOfInt = new MyList[Int]
  val listOfStr = new MyList[String]

  // Generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfInt = MyList.empty[Int]

  // Variance problem
  class Animal

  class Cat extends Animal

  class Dog extends Animal

  // SOME OPTIONS
  // 1. Yes List[Cat] extends List[Animal is COVARIANCE

  class CovariantList[+A]

  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  // animalList.add(new Dog) is this ok???? HARD QUESTION - answer is to return a list of Animal, which is superclass of Dog and Cat

  // 2. No - INVARIANCE
  class InvariantList[A]
  val invariantList: InvariantList[Animal] =  new InvariantList[Animal]

  // 3. Hell, no! CONTRAVARIANCE
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // Bounded types (upper bounded, lower bounded)
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)




}
