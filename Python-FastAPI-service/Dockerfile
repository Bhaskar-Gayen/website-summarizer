# Use an official Python runtime as a parent image
FROM python:3.10-slim

# Set the working directory
WORKDIR /app

# Copy the requirements file and create a virtual environment
COPY requirements.txt .
RUN python -m venv venv && \
    . venv/bin/activate && \
    pip install --no-cache-dir -r requirements.txt

# Copy the source code
COPY . .

# Expose port 8000
EXPOSE 8000

# Command to run the FastAPI application using Uvicorn
CMD ["./venv/bin/uvicorn", "main:app", "--host", "0.0.0.0", "--port", "8000"]
