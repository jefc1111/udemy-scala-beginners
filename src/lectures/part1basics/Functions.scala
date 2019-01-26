package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int) =
    a + " " + b

  def aFunctionAlt(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("COSKS", 44))

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction)

  def aRepeater(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeater(aString, n - 1)
  }

  println(aRepeater("Hello", 3))

  // WHEN YOU NEED LOOPS: USE RECURSION

  def aFunctionWithSideEffects(aString: String): Unit = println("COCKS!")

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1)
  }

  def aGreeting(name: String, age: Int): String =
    s"Hi, I am $name, I am $age years old."

  println(aGreeting("Geoff", 39))

  def factorial(n: Int): Int = {
    if (n == 1) n
    else n * factorial(n - 1)
  }

  println(factorial(12))

  def fibonnaci(n: Int): Int = {
    if (n <= 2) 1
    else fibonnaci(n - 1) + fibonnaci(n - 2)
  }

  println(fibonnaci(10))

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)
    }

    isPrimeUntil(n / 2)
  }

  println(isPrime(100))
}
