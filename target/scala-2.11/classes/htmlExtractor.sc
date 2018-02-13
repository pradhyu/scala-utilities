import net.ruippeixotog.scalascraper.browser.JsoupBrowser

import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL.Parse._

import net.ruippeixotog.scalascraper.model._

val browser = JsoupBrowser()
//val doc2 = browser.get("http://example.com")

val doc2 =browser.parseFile("/Users/pkshrestha/workspace/scala-utilities/src/example.html")
doc2.toHtml

doc2 >> text ("#header")


