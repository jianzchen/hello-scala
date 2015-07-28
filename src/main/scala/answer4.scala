import scala.collection.mutable
import scala.collection.immutable
import scala.io.Source

/**
 * Created by jianzchen on 2015/6/30.
 */
object answer4 {
  def main(args: Array[String]) {
    println("#1")
    val equips = Map("shoe" -> 400, "shirt" -> 200, "ball" -> 100)
    val discount = equips.toArray.map(x => (x._1,x._2 * 0.9)).toMap
    println(discount)
    /*for partten-match*/
    val discount2 = for ( (k,v) <- equips ) yield (k,v*0.9)
    println(discount2)

    println("#2")
    val scanner = new java.util.Scanner(new java.io.File("data/input/myfile.txt"))
    val words = scala.collection.mutable.HashMap[String,Int]()
    while (scanner.hasNext) {
      val w = scanner.next
      words.update(w,words.getOrElse(w,0)+1)
    }
    println(words)
    /* using scala Source.fromFile */
    val scanner2 = Source.fromFile("data/input/myfile.txt","UTF-8")
    val words2 = mutable.HashMap[String,Int]()
    scanner2.mkString.split("\\s+").foreach(
      x => if (words2.contains(x))
        words2(x) += 1
    else
        words2(x) = 1
    )
    println(words2)

    println("#3")
    var words3 = immutable.HashMap[String,Int]()
    scanner2.reset.mkString.split("\\s+").foreach(
      x => words3 += (x -> (words3.getOrElse(x,0) + 1) )
    )
    println(words3)

    println("#4")
    var words4 = immutable.SortedMap[String,Int]()
    scanner2.reset.mkString.split("\\s+").foreach(
      x => words4 += (x -> (words4.getOrElse(x,0) + 1) )
    )
    println(words4)

    println("#5")


  }
}
