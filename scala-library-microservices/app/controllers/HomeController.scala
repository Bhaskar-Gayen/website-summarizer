package controllers

import javax.inject._
import play.api.mvc._
import play.api.libs.json._
import models._
import play.api.libs.ws.{WSClient, WSResponse}

import java.time.LocalDateTime
import scala.concurrent.{ExecutionContext, Future}


@Singleton
class HomeController @Inject()(repo: LogRepository, cc: MessagesControllerComponents, ws: WSClient)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {


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
        //python microservice api call
        ws.url("http://localhost:8000/summarize").post(request.body)
          .map{ response=>
            println(response.body)
            Ok(response.body)
          }
          .recover{
            case ex: Exception =>{
              InternalServerError("An error occurred")
            }
          }
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
