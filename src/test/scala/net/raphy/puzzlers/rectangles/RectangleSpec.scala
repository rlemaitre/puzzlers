package net.raphy.puzzlers.rectangles

import org.scalatest.{Matchers, FlatSpec}
import Rectangle.overlap

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

  "A single rectangle" should "overlap" in {
    val rect1 = Rectangle(Point(2, 2), 2 , 2)
    overlap(List(rect1)) should be (true)
  }

  "Two intersecting rectangles" should "overlap" in {
    val rect1 = Rectangle(Point(2, 2), 2 , 2)
    val rect2 = Rectangle(Point(3, 3), 2 , 2)
    overlap(List(rect1, rect2)) should be (true)
  }

  "Two disjoint rectangles" should "not overlap" in {
    val rect1 = Rectangle(Point(2, 2), 2 , 2)
    val rect2 = Rectangle(Point(30, 3), 2 , 2)
    overlap(List(rect1, rect2)) should be (false)
  }

  "Three disjoint rectangles" should "not overlap each others" in {
    val rect1 = Rectangle(Point(2, 2), 2 , 2)
    val rect2 = Rectangle(Point(30, 30), 2 , 2)
    val rect3 = Rectangle(Point(10, 10), 2 , 2)
    overlap(List(rect1, rect2, rect3)) should be (false)
  }

  "A rectangle intersecting two disjoint rectangles" should "not overlap together" in {
    val rect1 = Rectangle(Point(2, 2), 10 , 2)
    val rect2 = Rectangle(Point(1, 2), 2 , 2)
    val rect3 = Rectangle(Point(11, 2), 2 , 2)
    overlap(List(rect1, rect2, rect3)) should be (false)

  }

  "Three intersecting rectangles" should "overlap each others" in {
    val rect1 = Rectangle(Point(2, 2), 2 , 2)
    val rect2 = Rectangle(Point(3, 3), 2 , 2)
    val rect3 = Rectangle(Point(3, 2), 2 , 2)
    overlap(List(rect1, rect2, rect3)) should be (true)
  }
}
