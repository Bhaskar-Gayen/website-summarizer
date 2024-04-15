package repositories


import scala.concurrent.Future
import models.WebsiteSummarizeLog

trait WebsiteSummarizeLogRepository {
  def getAllLogs: Future[Seq[WebsiteSummarizeLog]]
  def addLog(websiteSummarizeLog: WebsiteSummarizeLog): Future[Int]
}


//