package net.raphy.puzzlers.rectangles

case class Point(x: Int, y:Int)

case class Rectangle(ref: Point, height: Int, width: Int) {

  val xProjection: Range = ref.x to ref.x + width
  val yProjection: Range = ref.y to ref.y + height

  def overlaps(other: Rectangle): Boolean =
    if (this == other || ref == other.ref)
      true
    else
      {
        def intersects(range1: Range, range2: Range): Boolean = {
          (range1 contains range2.start) || (range2 contains range1.start)
        }
        intersects(xProjection, other.xProjection) && intersects(yProjection, other.yProjection)
      }

}
