package lectures.part1basics

object ValuesVariablesTypes extends App {
  val x: Int = 42

  println(x)

  // VALS ARE IMMUTABLE

  // Compiler can infer types

  val aString: String = "Hello there"; // Semicolons are allowed!
  val anotherString = "Hello, Geoff" // Type is inferred by compiler

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 567
  val aLong: Long = 9876544378979879L // Note the 'L' at the end
  val aFloat: Float = 2.82348F // Note the 'F'
  val aDouble: Double = 1.124578

  // Variables
  var aVariable: Int = 4

  aVariable = 5 // I reassigned it because is var!
  // Use vars to for side-effects

}
