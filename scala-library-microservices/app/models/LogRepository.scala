package models

import com.google.inject.Inject
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import java.time.LocalDateTime
import scala.concurrent.{ExecutionContext, Future}

class LogRepository @Inject()(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {

  private val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  private class HistoryLogTable(tag: Tag) extends Table[WebsiteSummarizeLog](tag, "website_summarize_logs") {

    def timestamp = column[LocalDateTime]("timestamp")

    def website = column[String]("website")

    //Mapping function to the case class
    override def * = (timestamp, website) <> ((WebsiteSummarizeLog.apply _).tupled, WebsiteSummarizeLog.unapply)
  }

  //API entry point
  private val historyLogTable = TableQuery[HistoryLogTable]

  //insert a row
  def addLog(websiteSummarizeLog: WebsiteSummarizeLog): Future[Int] = db.run {
    historyLogTable += websiteSummarizeLog
  }


  //get all row
  def getAllLogs: Future[Seq[WebsiteSummarizeLog]] = db.run {
    historyLogTable.result
  }
}
