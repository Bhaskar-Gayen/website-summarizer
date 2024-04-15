import google.generativeai as genai
from dotenv import load_dotenv
import os
import json

load_dotenv()

API_KEY = os.getenv('GOOGLE_API_KEY')
genai.configure(api_key=API_KEY)



# print(API_KEY)

def summarize_function(web_link):
    model = genai.GenerativeModel('gemini-pro')
    
    response = model.generate_content("Summarize this website: "+ web_link)
    # response=json.loads(response.text)
    return json.dumps(response.text)
