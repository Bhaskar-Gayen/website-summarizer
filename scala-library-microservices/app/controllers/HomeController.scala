package controllers



import javax.inject._
import play.api.mvc._
import play.api.libs.json._
import models._

import java.time.LocalDateTime
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class HomeController @Inject()(repo: LogRepository, cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {


  def index = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def addLog = Action.async(parse.json) { implicit request =>
    val requestBodyResult = request.body.validate[RequestBody]
    println("Incoming request body: " + request.body)
    requestBodyResult.fold(
      errors => {
        Future.successful(BadRequest(Json.obj("message" -> JsError.toJson(errors))))
      },
      requestBody => {
        // Process the request body
        val website = requestBody.weblink
        // Insert data to database
        repo.addLog(WebsiteSummarizeLog(LocalDateTime.now(), website))
        println(s"Website link: $website")
        Future.successful(Ok(Json.obj("message" -> "Request processed successfully")))
      }
    )
  }


  def getLogs: Action[AnyContent] = Action.async { implicit request=>
    repo.getAllLogs.map { logs =>
      // Convert the logs to JSON
      Ok(Json.toJson(logs))
    }
  }


}
