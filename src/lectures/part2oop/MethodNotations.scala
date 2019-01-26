package lectures.part2oop

object MethodNotations extends App {
  class Person(val name: String, favouriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favouriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck!"
    def isAlive: Boolean = true // No parameters! So can be used as postfix!
    def apply(): String = s"Hi, I am $name and I love $favouriteMovie" // Need those parentheses
    def +(nickname: String): Person = new Person(s"$name (${nickname})", favouriteMovie)
    def unary_+ : Person = new Person(name, favouriteMovie, age + 1)
    def learns(subject: String): String = s"${name} learns ${subject}"
    def learnsScala: String = this.learns("Scala")
    def apply(count: Int): String = s"${name} watched ${favouriteMovie} ${count} times."
  }


  val mary = new Person("Mary", "Jaws")

  println(mary.likes("Jaws"))
  println(mary likes "jaws")
  // Infix notation = operator notation. Only when SINGLE PARAMETER (syntactic sugar)

  // "operators" in Scala. Are really methods that act like operators
  val tom = new Person("Tom", "Alien")

  println(mary + tom)
  println(mary.+(tom)) // Same as previous
  println(99.+(100))

  // ALL OPERATORS ARE METHODS
  // Akk actors have operators like ! and ?

  // prefix notation
  val x = -1 // "-" is a unary operator
  val y = 1.unary_- // Same as above
  // unary_ prefix only works with - + ~ !

  println(!tom)

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive) // Same as above. Rarely used.

  // apply
  println(mary.apply())
  println(mary()) // Same as above!

  println((mary + "poogles")())
  println((+(+mary)).age)

  println(mary learnsScala)
  println(tom(2))
}
