/**
 * Created by jianzchen on 2015/7/6.
 */
object answer17 {
  def main(args: Array[String]) {
    class Pair[T <: Comparable[T]](val first:T,val second: T) {
      def smaller = if (first.compareTo(second) < 0) first else second
    }


    println("#1")

  }
}
