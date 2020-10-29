package scala

import org.junit.Assert.{ assertArrayEquals, assertFalse, assertTrue }
import org.junit.Test

import scala.runtime.BoxedUnit

class ArrayTest {

  @Test
  def testArrayIsEmpty(): Unit = {
    assertTrue(Array[Int]().isEmpty)
    assertTrue(Array[Char]().isEmpty) // scala/bug#12172
    assertTrue(Array[String]().isEmpty)

    assertFalse(Array(1).isEmpty)
    assertFalse(Array[Char](1).isEmpty)
    assertFalse(Array("").isEmpty)

    def ge[T](a: Array[T]) = a.isEmpty

    assertTrue(ge(Array[Int]()))
    assertTrue(ge(Array[Char]()))
    assertTrue(ge(Array[String]()))

    assertFalse(ge(Array(1)))
    assertFalse(ge(Array[Char]('x')))
    assertFalse(ge(Array("")))
  }
}
