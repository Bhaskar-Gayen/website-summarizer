package SummarizeLogRepoImp;
import models.WebsiteSummarizeLog
import services.Connection
import java.time.LocalDateTime
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.Future

  class SummarizeLogRepoImpl(tag: Tag) extends Table[WebsiteSummarizeLog](tag, "website_summarize_logs") {
    def this()=this(null)
    def timestamp = column[LocalDateTime]("timestamp")

    def website = column[String]("website")

    //Mapping function to the case class
    override def * = (timestamp, website) <> ((WebsiteSummarizeLog.apply _).tupled, WebsiteSummarizeLog.unapply)

    //API entry point
    lazy val websiteSummarizeLogs = TableQuery[SummarizeLogRepoImpl]

    //get all row
     def getAllLogs: Future[Seq[WebsiteSummarizeLog]] = {

      Connection.db.run(websiteSummarizeLogs.result)

    }

    //insert a row
    def addLog(websiteSummarizeLog: WebsiteSummarizeLog): Future[Int] = {
      Connection.db.run(websiteSummarizeLogs += websiteSummarizeLog)
    }
  }