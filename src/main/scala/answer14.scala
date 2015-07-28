import scala.collection.JavaConversions.propertiesAsScalaMap
import scala.math.sqrt

/**
 * Created by jianzchen on 2015/6/30.
 */
object answer14 {
  def main(args: Array[String]) {
    //for ( (k,v) <- System.getProperties) println(k + " ->" + v)

    println("#2")
    //def swap(x:(Int,Int)):(Int,Int) = { (x._2,x._1)}
    def swap(x:(Int,Int)):(Int,Int) = x match {
        case (a, b) => (b, a)
      }
    println(swap (1,2))

    println("#3")
    def swapArray(x:Array[Int]):Array[Int] = x match {
      case Array(a,b, rest @ _*) => Array(b,a) ++ rest
      case _ => x
    }
    println(swapArray(Array(1,2,3,4)).mkString(","))

    println("#4")
    abstract class Item
    case class Article(descrption:String,price:Double) extends Item
    case class Bundle(description:String,discount:Double,items:Item*) extends Item
    case class Multiple(amt:Int,item:Item) extends Item

    def price(it:Item) : Double = it match {
      case Article(_,p) => p
      case Bundle(_,disc,its @ _*) => its.map(price _).sum - disc
      case Multiple(amt,it) => price(it) * amt
    }

    val x = Bundle("Special for 6 articles", 60.0,
      Multiple(2, Article("Scala", 50.00)),
      Multiple(2,Bundle("Special for EBAY", 10.0,Article("EBAY MARKETPLACE", 100.00),Article("EBAY ENTERPRISE", 200.00)))
    )
    println(price(x))

    println("#5")
    /*def leafSum(tree:List[Any]):Int = tree match {
      case List(leaf1:Int)                  => leaf1
      case List(leaf1:Int,leaf2:Int)        => leaf1 + leaf2
      case List(leaf1:Int,leaf2 @ _*)       => leaf1 + leafSum(leaf2.toList)
      case List(leaf1:List[Any])            => leafSum(leaf1)
      case List(leaf1:List[Any],leaf2 @ _*) => leafSum(leaf1) + leafSum(leaf2.toList)
    }
*/
    def leafSum(tree:List[Any]):Int = {
      (for ( leaf:Any <- tree ) yield (leaf match {
        case x:Int => x
        case x:List[Any] => leafSum(x)
      })
      ).sum
    }

    val tree:List[Any] = List(List(3,8),2,List(5))
    println(leafSum(tree))

    println("#6")
    sealed abstract class BinaryTree
    case class Leaf(value:Int) extends BinaryTree
    case class Node(left:BinaryTree,right:BinaryTree) extends BinaryTree

    def leafSum2(tree:BinaryTree):Int = tree match {
      case Leaf(x) => x
      case Node(x,y) => leafSum2(x) + leafSum2(y)
    }
    val tree2 = Node(Node(Leaf(3),Leaf(8)),Leaf(2))
    println(leafSum2(tree2))


    println("#7")
    sealed abstract class Tree2
    case class Leaf2(value:Int) extends Tree2
    case class Node2(leafs:Tree2*) extends Tree2

    def leafSum3(tree:Tree2):Int = tree match {
      case Leaf2(x) => x
      case Node2(x @ _*) => x.map(leafSum3 _).sum
    }
    val tree3 = Node2(Node2(Leaf2(3), Leaf2(8)), Leaf2(2), Node2(Leaf2(5)))
    println(leafSum3(tree3))


    println("#8")
    sealed abstract class Tree3
    case class Leaf3(value:Int) extends Tree3
    case class Node3(op:Char,leafs:Tree3*) extends Tree3

    def eval(tree:Tree3):Int = tree match {
      case Leaf3(x) => x
      case Node3('+',x @ _*) => x.map(eval _).sum
      case Node3('-',x @ _*) => -x.map(eval _).sum
      case Node3('*',x @ _*) => x.map(eval _).product
      case Node3('/',x @ _*) => x.map(eval _).foldLeft(1)(_ / _ )
    }

    val tree4 = Node3('+',Node3('*',Leaf3(3),Leaf3(8)),Leaf3(2),Node3('-',Leaf3(5))   )
    println(eval(tree4))

    println("#9")
    def listSum(list:List[Option[Int]]):Int = list.map(x => x.getOrElse(0)).sum

    val list = List(Some(1),Some(2),Some(3),None)
    println(listSum(list))

    println("#10")
    def compose(x : (Double) => Option[Double], y:(Double) => Option[Double])(input:Double):Option[Double] = {
      if (x(input) != None && y(input) != None) x(input) else None
    }

    def f(x:Double) = if (x >= 0) Some(sqrt(x)) else  None
    def g(x:Double) = if (x != 1) Some(1 / (x -1)) else None

    val h = compose(f,g)_
    println(h(2))
    println(h(1))
    println(h(0))
    println(h(-1))

  }
}
