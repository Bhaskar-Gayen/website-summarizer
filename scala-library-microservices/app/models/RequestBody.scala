package models

import play.api.libs.json._

case class RequestBody(weblink: String)

object RequestBody {
  implicit val reads: Reads[RequestBody] = Json.reads[RequestBody]
}