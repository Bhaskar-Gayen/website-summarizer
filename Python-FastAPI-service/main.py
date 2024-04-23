from fastapi import FastAPI, Request

import services

app = FastAPI()

web_link="https://www.cimba.ai/"

@app.post("/summarize")
async def summarize(payload: Request):
    #  Call the summarization service and return the result
    data =await payload.json()
    print(data)
    return services.summarize_function(data['weblink'])
    
@app.get("/")
async def index():
    return {"res":"python microservice is up"} 
 
if __name__ == "__main__":
    import uvicorn
    uvicorn.run(app, host="127.0.0.1", port=8000)