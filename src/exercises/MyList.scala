package exercises

abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](num: B): MyList[B]

  def printElements: String

  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: MyTransformer[A, B]): MyList[B]
  def flatMap[B](transformer: MyTransformer[A, MyList[B]], myPredicate: MyPredicate[A]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]
}

object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](num: B): MyList[B] = new Cons(num, Empty)

  override def printElements: String = ""

  def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]], myPredicate: MyPredicate[Nothing]): MyList[B] = Empty
  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](num: B): MyList[B] = new Cons(num, this)

  override def printElements: String = {
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
  }

  def filter(predicate: MyPredicate[A]): MyList[A] =
    if (predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  def map[B](transformer: MyTransformer[A, B]): MyList[B] =
    new Cons(transformer.transform(h), t.map(transformer))

  def flatMap[B](transformer: MyTransformer[A, MyList[B]], myPredicate: MyPredicate[A]): MyList[B] =


}

trait MyPredicate[-T] {
  def test(el: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(el: A): B
}
object ListTest extends App {
  val listOfInt: MyList[Int] = new Cons(1, new Cons(3, new Cons(5, Empty)))
  val listOfString: MyList[String] = new Cons("Hi", new Cons("Geoff", new Cons("5", Empty)))

  println(listOfInt.toString)
  println(listOfString.toString)
}

/*
object ListTest extends App {
  val list = new Cons(1, new Cons(3, new Cons(5, Empty)))

  println(list.tail.head)
  println(list.add(4).head)
  println(Empty.isEmpty)

  println(list.toString)
}
*/