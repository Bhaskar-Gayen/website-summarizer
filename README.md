# website-Summarizer

## Overview

This project is a collection of microservices designed to provide AI-powered services for summarizing websites and managing request history. The project consists of the following microservices:

1. **Spring Boot API Service**
   - Technology: Java, Spring Boot
   - Description: Provides REST APIs for summarizing websites and managing request history. Integrates with Scala and Python services.

2. **Scala Library Microservice**
   - Technology: Scala
   - Description: Contains a Scala library for summarizing websites. Used as a dependency in the Spring Boot API service.

3. **Python Service**
   - Technology: Python, FastAPI
   - Description: Provides a REST API for summarizing website content using OpenAI or other language model (LLM) endpoints.

## Architecture

The project follows a microservices architecture with each service responsible for a specific functionality. The services communicate over HTTP and are deployed on Kubernetes for scalability and reliability.

![Architecture Diagram](https://github.com/Bhaskar-Gayen/website-summarizer/assets/84518595/ea36e5e6-5941-49b1-8f9b-e4a15d1f85cd)


## APIs

The Spring Boot API service exposes the following REST APIs:

- `POST /summarize`: Summarizes a given website URL.
- `GET /history`: Retrieves the request history.

The Python service exposes the following REST API:

- `POST /summarize`: Summarizes website content using OpenAI or other LLM endpoints.

## Screenshots

### Homepage
![Homepage](https://github.com/Bhaskar-Gayen/website-summarizer/assets/84518595/e82f30a0-78f6-46a4-86a1-593e06b1c775)


### Summarize Form
![Summarize Form](https://github.com/Bhaskar-Gayen/website-summarizer/assets/84518595/9c060657-39e4-4e91-8299-b04d06718ca0)


### History Logs
![History Page](https://github.com/Bhaskar-Gayen/website-summarizer/assets/84518595/1a2544a9-ba49-48b9-ba98-d17e365e5757)


## Usage

To run the project locally, follow these steps:

1. Clone the repository.
2. Install the necessary dependencies for each microservice.
3. Run each microservice using the appropriate command (`./gradlew bootRun` for Spring Boot, `sbt run` for Scala, `uvicorn main:app --reload` for Python).

## Contributors

- Bhaskar Gayen


