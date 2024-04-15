package controllers

import SummarizeLogRepoImp._

import javax.inject._
import play.api.mvc._
import play.api.libs.json._
import models._
import scala.concurrent.ExecutionContext.Implicits.global
import java.time.LocalDateTime
import scala.concurrent.Future

@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents, val summaryLogRepo: SummarizeLogRepoImpl) extends BaseController {


  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def addLog() = Action.async(parse.json) { request =>
    val requestBodyResult = request.body.validate[RequestBody]
    println("Incoming request" + request)
    requestBodyResult.fold(
      errors => {
        Future.successful(BadRequest(Json.obj("message" -> JsError.toJson(errors))))
      },
      requestBody => {
        // Process the request body
        val website = requestBody.weblink
        // Insert data to database
        summaryLogRepo.addLog(WebsiteSummarizeLog(LocalDateTime.now(), website))
        println(s"Website link: $website")
        Future.successful(Ok(Json.obj("message" -> "Request processed successfully")))
      }
    )
  }


  def getHistory(): Action[AnyContent] = Action.async {implicit request=>
    summaryLogRepo.getAllLogs.map { logs =>
      // Convert the logs to JSON
      Ok(Json.toJson(logs))
    }
  }


}
