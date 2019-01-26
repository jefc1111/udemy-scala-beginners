package lectures.part2oop

object OOBasics extends App {

  val person = new Person("Geoff", 39)

  println(person.age + person.x)

  println(person.greet("COCKS!"))
  println(person.greet)

  val anotherPerson = new Person("Bob")

  println(anotherPerson.greet + anotherPerson.age.toString)

  val writer = new Writer("Dave", "Matthews", 1979)

  println(writer.fullName)

  val novel = new Novel("Watership Down", 1990, writer)

  println(novel.authorAge)

  val anotherWriter = new Writer("Pete", "Poppins", 1965)

  println(novel.isWrittenBy(writer))

  val counter = new Counter(0)

  counter.increment(99).decrement.print
}

// A constructor
class Person(name: String, val age: Int) {
  // class body

  val x = 2 // This is a field
  var s = "don't go changing (actually do)"

  println("I got constructed!")

  def greet(name: String): Unit = println(s"${this.name} says HI $name")
  def greet(): Unit = println(s"Mein name ist $name")

  // Multiple constructors
  // Auxiliary constructor HAS TO call another constructor. Lame.
  def this(name: String) = this(name, 0)
}

class Writer(firstName: String, surname: String, val birthYear: Int) {
  def fullName(): String = s"$firstName $surname"
}

class Novel(name: String, releaseYear: Int, author: Writer) {
  def authorAge= releaseYear - author.birthYear
  def isWrittenBy(author: Writer)= this.author == author
  def copy(newReleaseYear: Int): Novel = new Novel(name, newReleaseYear, author)
}

class Counter(val i: Int) {

  def increment: Counter = {
    println("inc")
    new Counter(i + 1) // Immutability
  }

  def decrement: Counter = {
    println("dec")
    new Counter(i - 1) // Immutability
  }

  def increment(n: Int): Counter = {
    if (n <= 0) this
    else increment.increment(n - 1)
  }
  def decrement(n: Int): Counter = {
    if (n <= 0) this
    else decrement.decrement(n - 1)
  }

  def print = println(i)
}

// Class parameters are NOT fields