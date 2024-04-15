package models

import java.time.LocalDateTime
import play.api.libs.json.{ Json, OFormat }

// Define a case class to represent the data model
 case class WebsiteSummarizeLog( timestamp: LocalDateTime, website: String)
object WebsiteSummarizeLog{
  implicit val websiteSummarizeLog: OFormat[WebsiteSummarizeLog] =Json.format[WebsiteSummarizeLog]
}

