/**
 * Created by jianzchen on 2015/6/25.
 */
object answer12 {
  def main(args: Array[String]) {
    println("#1")
    def values(fun:(Int) => Int, low:Int,high:Int) = (low to high).map(x => Map(x -> fun(x)))
    println(values(x => x*x , -5 , 5))

    println("#2")
    println(Array(4,5,6,123,1,2,3).reduceLeft( (x,y) => if (x>y) x else y))

    println("#3")
    println((1 to 10).reduceLeft(_ * _))

    println("#4")
    //println((-1 to 10).foldLeft(1)((a,b) => ))
    def factorial(n: Int) = (1 to n).foldLeft(1)(_ * _)
    println(factorial(-3))
    println(factorial(5))

    println("#5")
    def largest(fun:(Int) => Int, inputs: Seq[Int]) = inputs.map(fun(_)).max
    println(largest(x => 10 * x - x * x, 1 to 10))

    println("#6")
    def largestAt(fun:(Int) => Int, inputs: Seq[Int]) = inputs.map(x => (x,fun(x))).reduce((x,y) => if (x._2 > y._2) x else y)._1
    //println(largestAt(x => 10 * x - x * x, 1 to 10))
    println(largestAt( (x:Int) => 10*x - x*x, 1 to 10))

    println("#7")
    val pairs = (1 to 10) zip (11 to 20)
    def adjustToPair(fun:(Int,Int) => Int) = (x:(Int,Int)) => fun(x._1,x._2)
    //println(adjustToPair(_ * _)((6,7)))
    println(adjustToPair( (x,y) => x + y)((6,7)))
    println(pairs.map(adjustToPair(_ + _)))

    println("#8")
    val str = Array("hello","scala","world")
    val num = Array(6,6,6)
    println(str.corresponds(num)((str,num) => str.length == num))

    println("#9")
    def corresponds[A,B](a:Seq[A], b:Seq[B],f:(A,B) => Boolean):Boolean = (a zip b).map(x => f(x._1,x._2)).count(!_) == 0
    println(corresponds(str,num,(x:String, y:Int)=> x.length == y))

    println("#10")
    def unless(condition : => Boolean)(block: => Unit) { if (!condition) { block } }
    unless (0 > 1) { println("Unless!") }
  }
}
