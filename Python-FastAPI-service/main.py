from fastapi import FastAPI, Request

import services

app = FastAPI()

web_link="https://www.cimba.ai/"

@app.post("/summarize")
async def summarize(payload: Request):
    try:
        # Extract the JSON payload
        data = await payload.json()
        print(data)  # You can remove this in production

        # Ensure the 'weblink' key is in the payload
        if 'weblink' not in data:
            return {"error": "Missing 'weblink' key in the payload"}

        # Call the summarization service with the provided URL
        summary =  services.summarize_function(data['weblink'])
        print(summary)  # You can remove this in production

        return { "weblink":data['weblink'],
        "summary": summary}

    except Exception as e:
        # Log the error message for debugging
        print(f"Error during summarization: {str(e)}")
        return {"error": f"Internal server error: {str(e)}"}

    
    
@app.get("/")
async def index():
    return {"res":"python microservice is up"} 
 
if __name__ == "__main__":
    import uvicorn
    uvicorn.run(app, host="1summary27.0.0.1", port=8000)