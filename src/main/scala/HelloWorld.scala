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

    val mySquare = new Square(3)
    val myEqTriangle = new Triangle(2)
    val myIsoTriangle = new IsoTriangle(3,4)
    val myScaleneTriangle = new ScaleneTriangle(3,4,5)
    val myCircle = new Circle(3.0)

    printShape(mySquare)
    printShape(myEqTriangle)
    printShape(myIsoTriangle)
    printShape(myScaleneTriangle)
    printShape(myCircle)
    
  }
  def printHello() = println(myString)
  def add(a :Int, b :Int): Int = {
    a + b
  }





  def printShape(s: Shape): Unit = s match
  {
    case a: ScaleneTriangle => println("That's a Scalene Triangle!")
    case b: IsoTriangle => println("That's a Isosceles Triangle!")
    case c: Triangle => println("That's an Eq Triangle")
    case d: Square => println("That's a Square!")
    case _ => println("Never seen that shape before...")
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
  def getSides: Double = 4.0

  def getArea: Double = height * height
}

class Rectangle(height: Int, width: Int) extends Square(height: Int)
{
  override def getArea: Double = height * width
}

class Triangle(side: Int) extends Shape
{
  override def getSides: Double = 3.0

  override def getArea: Double = {
    val p = side
    sqrt(p*(p-side)*(p-side)*(p-side))
  }
}

class IsoTriangle(side: Int, otherSide: Int) extends Triangle(side: Int)
{
  override def getArea: Double = {
    val p = (side + (otherSide*2))/3
    sqrt(p*(p-side)*(p-otherSide)*(p-otherSide))
  }

}
class ScaleneTriangle(side1: Int, side2: Int, side3: Int) extends IsoTriangle(side1: Int, side2: Int)
{
  override def getArea: Double = {
    val p = (side1 + side2 + side3)/3
    sqrt(p*(p-side1)*(p-side2)*(p-side3))
  }
}

