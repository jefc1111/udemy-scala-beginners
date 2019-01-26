package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2 // RHS is an expression

  println(x)

  println(2 + 3 * 4) // Math expression: + - * / & | ^ << >> >>>

  println(1 == x)
  // == != > >= < <=

  println(! (1 == x))
  // ! && ||

  var aVariable = 2

  aVariable += 3

  println(aVariable)

  // Instructions (DO) vs Expressions (VALUE)

  // IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3

  println(aConditionedValue)

  println(if(aCondition) 5 else 3)

  var i = 0

  val aWhileLoop = while (i < 10) {
    println(i)
    i += 1
  }
  // NEVER WRITE THAT ^^^ AGAIN. Is imperative programming.

  println(aWhileLoop)

  // EVERYTHING in Scala is an expression

  val aWeirdValue = (aVariable = 3)

  print(aWeirdValue)

  // Code blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "Hi" else "Byw"
  }
  // The value of a block is the type of the LAST expression
  // y and z not visible outside the block
}
