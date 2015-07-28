/**
 * Created by jianzchen on 2015/7/28.
 */
object sorting {
  def main(args: Array[String]): Unit = {
    def insertSort(input:Array[Int],a:Int) = {
      (0 +: input :+ a).distinct.sortWith(_ < _)
    }
    val insertSortResult = insertSort(Array(0,1,2,4,5),3)
    insertSortResult.foreach(println _)
    println(insertSortResult.size)

    def shellSort

  }
}
