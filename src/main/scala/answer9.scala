import java.io.PrintWriter

import scala.io.Source

/**
 * Created by jianzchen on 2015/6/23.
 */
object answer9 {
  def main(args: Array[String]) {
    val csv = Source.fromFile("data/input/test.csv")
    for (c <- csv) println(c)
    println("###################################")
    for (l <- csv.reset.getLines()) println(l)
    println("###################################")
    val tokens = csv.reset.getLines.mkString("\n").split("""[,\s]""")
    val regex = """[\"]+(.+)[\"]+""".r
    for (token <- tokens) {
      token match {
        case regex(value) => println(value)
        case _ => println(token)
      }
    }

    println("#1")
    val reversedLines = csv.reset.getLines.toArray.reverse
    reversedLines.foreach(println _)
    //val pw = new PrintWriter("data/output")
    //reversedLines.foreach( l => pw.write(l + "\n"))

    println("#2")
    val tsv = Source.fromFile("data/input/test.tsv")
    val lines = tsv.getLines.toArray
    lines.foreach(line => {
      val replacedLine = line.replaceAll("\\t", "    ")
      println(replacedLine)
    })

    println("#3")
    Source.fromFile("data/input/test.csv").getLines().toArray.filter(_.length > 14).foreach(println _)

    println("#4")
    val allDouble = Source.fromFile("data/input/double.csv").getLines().flatMap( l => l.split(",")).map(_.toDouble).toArray
    printf("sum %.2f avg %.2f max %.2f min %.2f \n",allDouble.sum,allDouble.sum/allDouble.size,allDouble.max,allDouble.min)

    println("#5")
    //val maxLength = (x:Int) => { if (x > 20) 20 else x }
    def pow2(x:Int):BigDecimal =  { BigDecimal(2).pow(x)}
    val pow2dao = (x:BigDecimal) => { 1/x }
    (0 to 20).foreach(x => printf("%20s %20s \n",pow2(x),pow2dao(pow2(x))))

    println("#6")
}
}
