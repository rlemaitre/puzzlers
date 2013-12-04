package net.raphy.puzzlers.rectangles

// Given two rectangles, each with an x,y coordinate as well as a height and width, determine if they are overlapping.
// Extend you solution so that it can copy with n rectangles.

case class Point(x: Int, y: Int)

case class Rectangle(ref: Point, height: Int, width: Int) {
  private val xProjection: Range = ref.x to ref.x + width
  private val yProjection: Range = ref.y to ref.y + height

  def overlaps(other: Rectangle): Boolean = xProjection.intersect(other.xProjection).nonEmpty && yProjection.intersect(other.yProjection).nonEmpty
}

object Rectangle {
  def overlap(rectangles: List[Rectangle]): Boolean = rectangles match {
    case Nil => true
    case r :: rest => rest.forall(_.overlaps(r)) && overlap(rest)
  }
}
