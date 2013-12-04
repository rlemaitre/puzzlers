package net.raphy.puzzlers.rectangles

import org.scalatest.{Matchers, FlatSpec}

class RectangleSpec extends FlatSpec with Matchers {

  "A Rectangle" should "overlaps with itself" in {
    val rect = Rectangle(Point(1, 1), 1, 1)
    rect overlaps rect should be (true)
  }

  it should "overlaps with a rectangle having the same reference point" in {
    val ref = Point(1, 1)
    val rect = Rectangle(ref, 1, 2)
    val rect2 = Rectangle(ref, 5, 6)
    rect overlaps rect2 should be (true)
  }

  it should "overlaps with a rectangle with reference point on its x edge" in {
    val rect1 = Rectangle(Point (1, 1), 2, 2)
    val rect2 = Rectangle(Point (2, 1), 2, 2)
    rect1 overlaps rect2 should be (true)
  }

  it should "overlaps with a rectangle with reference point on its y edge" in {
    val rect1 = Rectangle(Point (1, 1), 2, 2)
    val rect2 = Rectangle(Point (1, 2), 2, 2)
    rect1 overlaps rect2 should be (true)
  }

  it should "overlaps with a rectangle having its x edge containing on its reference point" in {
    val rect1 = Rectangle(Point (1, 1), 2, 2)
    val rect2 = Rectangle(Point (2, 1), 2, 2)
    rect2 overlaps rect1 should be (true)
  }

  it should "overlaps with a rectangle having its y edge containing on its reference point" in {
    val rect1 = Rectangle(Point (1, 1), 2, 2)
    val rect2 = Rectangle(Point (1, 2), 2, 2)
    rect2 overlaps rect1 should be (true)
  }

  it should "not overlaps with a disjoint rectangle" in {
    val rect1 = Rectangle(Point (1, 1), 1, 1)
    val rect2 = Rectangle(Point (10, 10), 1, 1)
    rect1 overlaps rect2 should be (false)
  }

  it should "not overlaps with a disjoint rectangle below" in {
    val rect1 = Rectangle(Point (1, 10), 1, 1)
    val rect2 = Rectangle(Point (1, 1), 1, 1)
    rect1 overlaps rect2 should be (false)
  }

  it should "not overlaps with a disjoint rectangle above" in {
    val rect1 = Rectangle(Point (1, 1), 1, 1)
    val rect2 = Rectangle(Point (1, 10), 1, 1)
    rect1 overlaps rect2 should be (false)
  }

  it should "not overlaps with a disjoint rectangle at right" in {
    val rect1 = Rectangle(Point (1, 1), 1, 1)
    val rect2 = Rectangle(Point (10, 1), 1, 1)
    rect1 overlaps rect2 should be (false)
  }

  it should "not overlaps with a disjoint rectangle at left" in {
    val rect1 = Rectangle(Point (10, 1), 1, 1)
    val rect2 = Rectangle(Point (1, 1), 1, 1)
    rect1 overlaps rect2 should be (false)
  }
}
