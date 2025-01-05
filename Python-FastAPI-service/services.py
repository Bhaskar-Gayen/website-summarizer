from selenium.webdriver.chrome.options import Options
from selenium import webdriver
import openai
from bs4 import BeautifulSoup
from dotenv import load_dotenv
import os

load_dotenv()

API_KEY = os.getenv('OPENAI_API_KEY')


def fetch_web_content(url):
    options = Options()
    options.add_argument("--headless")
    options.add_argument("--no-sandbox")
    options.add_argument("--disable-dev-shm-usage")
    options.add_argument("--disable-gpu")  # Disable GPU acceleration
    options.add_argument("--disable-software-rasterizer")  # Disable rasterizer
    options.add_argument("--disable-logging")  # Disable logging

    driver = webdriver.Chrome(options=options)
    driver.get(url)
    content = driver.page_source
    driver.quit()

    soup = BeautifulSoup(content, "html.parser")
    return soup.get_text(separator="\n").strip()

# Function to summarize content using OpenAI


def summarize_content(content):
    if len(content) > 3000:  # Truncate content to fit token limits
        content = content[:3000]
    try:
        openai.api_key = API_KEY
        response = openai.ChatCompletion.create(
            model="gpt-4o-mini",
            messages=[
                {"role": "system",
                    "content": "You are an assistant that summarizes web content."},
                {"role": "user", "content": f"Create a concise summary from this content with key points within 100 words:\n{content}"}
            ]
        )
        return response["choices"][0]["message"]["content"]
    except Exception as e:
        return f"Error during summarization: {e}"

def summarize_function(url):
    content=  fetch_web_content(url)
    return summarize_content(content)

# print(summarize_function("https://www.cimba.ai/"))