import scala.collection.immutable.StringOps

/**
 * Created by jianzchen on 2015/7/3.
 */
object answer2 {
  def main(args: Array[String]) {
    println("#1")
    val signnum = (x:Int) => { if (x > 0) 1 else if (x < 0) -1 else 0 }
    println(signnum(5))
    println(signnum(-5))
    println(signnum(0))

    println("#4")
    Range(5,0,-1).foreach(println _)

    println("#5")
    def countdown(n:Int):Unit = {
      Range(n,0,-1).foreach(println _)
    }
    countdown(5)

    println("#6")
    val product = (s:String) => {
      (for (c <- s) yield c).map(_.toLong).product
    }
    println(product("Hello"))
    println("Hello".foldLeft(1L)(_ * _))

    println("#9")
    def prod(s: String) : Long = {
      if (s.size > 0)
        prod(s.tail) * s.head.toLong
      else
        1
    }
    println(prod("Hello"))

    println("#10")


  }
}
