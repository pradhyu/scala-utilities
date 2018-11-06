object StringUtils {
  val seqString = "scala".drop(2).take(2).capitalize
  seqString.toUpperCase()

/* Creating Multi line Strings */
val foo = """This is 
  a multiline 
  String """
  // this contains white space
val fooWoWhitespace = """This is
|a multiline
|String """.stripMargin('|')
// this will get rid of the white space
// s interpolator to use variables/expressions inside the string 
// The f string interpolator (prinf style formatting)
 println(f" this is ${1+1.5/2.0}%.2f")


}

