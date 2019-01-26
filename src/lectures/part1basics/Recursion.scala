package lectures.part1basics
package tailrecfunc

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println(s"Computing factorial of $n. I first need factorial of ${n - 1}")

      val result = n * factorial(n - 1)

      println(s"Computed factorial of $n")

      result
    }

  println(factorial(10))

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factorialHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factorialHelper(x - 1, x * accumulator) // TAIL RECURSION
    }

    factorialHelper(n, 1)
  }

  // anotherFactorial(10) = factorialHelper(10, 1)
  // = factorialHelper(9, 10 * 1)
  // = factorialHelper(8, 9 * 10 * 1)
  // = factorialHelper(7, 8 * 9 * 10 * 1)
  // ...
  // = factorialHelper(2, 3 * 4 * ... * 8 * 9 * 10 * 1)
  // = factorialHelper(1, 1 * 2 * 3 * 4 * ... * 8 * 9 * 10 * 1)
  // = 1 * 2 * ... * 10 // Which is the answer!

  println(anotherFactorial(20000))

  // When you think you need a LOOP, use TAIL RECURSION

  def aTailRecursiveRepeater(aString: String, n: Int): String = {
    @tailrec
    def inner(aString: String, n: Int, accumulatingString: String): String = {
      if (n == 1) accumulatingString
      else inner(aString, n - 1, accumulatingString + aString)
    }

    inner(aString, n, aString)
  }

  println(aTailRecursiveRepeater("COCKS! ", 3))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean = {
      if (! isStillPrime) false
      else if  (t <= 1) true
      else isPrimeTailRec(t - 1, isStillPrime && n % t != 0)
    }

    isPrimeTailRec(n / 2, true)
  }

  println(isPrime(15))

  def fibonacci(n: Int): Int = {
    @tailrec
    def fibRec(i: Int, acc1: Int, acc2: Int): Int = {
      if (i >= n) acc1
      else fibRec(i + 1, acc1 + acc2, acc1)
    }

    if (n <= 2) 1
    fibRec(2, 1, 1)
  }


  println(fibonacci(8))
}
