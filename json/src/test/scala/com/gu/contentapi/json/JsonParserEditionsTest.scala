package com.gu.contentapi.json

import com.gu.contentapi.json.utils.JsonLoader.loadJson
import org.scalatest.{FlatSpec, Matchers}

class JsonParserEditionsTest extends FlatSpec with Matchers {

  val editionsResponse = JsonParser.parseEditions(loadJson("editions.json"))

  "editions parser" should "parse basic response fields" in {
    editionsResponse.status should be ("ok")
    editionsResponse.userTier should be ("developer")
    editionsResponse.total should be (3)
  }

  it should "parse the editions" in {
    editionsResponse.results.size should be (3)
    val edition = editionsResponse.results.head
    edition.id should be ("au")
    edition.edition should be ("AU")
    edition.path should be ("au")
    edition.webTitle should be ("new guardian australia front page")
    edition.webUrl should be ("http://www.theguardian.com/au")
    edition.apiUrl should be ("http://content.guardianapis.com/au")
  }

}
