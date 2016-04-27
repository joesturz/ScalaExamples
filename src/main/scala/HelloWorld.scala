import scala.math._
object HelloWorld
{
  val string1 = "values cant change..."
  //string1 = "yes we can" // compilation error
  var string2 = "variables can!"
  //string2 = 23 //compilation error
  var myString :String = "Hello World!"
  def main(args: Array[String]): Unit = {
    printHello
    println(add(1,3)) // prints 4
    
  }
  def printHello() = println(myString)
  def add(a :Int, b :Int): Int = {
    a + b
  }
}





abstract class Shape
{
  def getSides: Double
  def getArea : Double
}

class Circle(radius: Double) extends Shape
{
  val pi = Pi

  def getSides = Double.PositiveInfinity
  def getArea = pi*(radius*radius)
}

class Square(height: Int) extends Shape
{
  def getSides: Double = 4

  def getArea: Double = height * height
}

class Rectangle(height: Int, width: Int) extends Square(height: Int)
{
  override def getArea: Double = height * width
}

class Triangle(sideLength: Int, side1: Int) extends Shape
{
  val _side1 = side1
  val _side2 = side1
  val _side3 = side1

  override def getSides: Double = 3

  def getArea: Double = {
    val p = (_side1 + _side2 + _side3)/3
    sqrt(p*(p-_side1)*(p-_side2)*(p-_side3))
  }
}

class IsoTriangle(sideLength: Int, side1: Int, side2: Int) extends Triangle(sideLength: Int, side1: Int)
{
  override val this._side1 = side1
  override val this._side3 = side1
  override val this._side2 = side2
}
class ScaleneTriangle(sideLength: Int, side1: Int, side2: Int, side3: Int) extends IsoTriangle(sideLength: Int, side1: Int, side2: Int)
{
  override val this._side1 = side1
  override val this._side2 = side2
  override val this._side3 = side3
}

