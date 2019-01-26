package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala."

  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hell"))
  println(str.replace("," ,"").replace(" ", ""))
  println(str.toLowerCase)

  val aStringNumber = 666

}
