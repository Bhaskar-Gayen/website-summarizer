# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the sbt configuration and project files
COPY build.sbt /app/
COPY project /app/project

# Copy the rest of your application code
COPY . /app

# Install required packages
RUN apt-get update && apt-get install -y wget gnupg2

# Download and install sbt manually
RUN wget https://github.com/sbt/sbt/releases/download/v1.5.5/sbt-1.5.5.tgz && \
    tar xzf sbt-1.5.5.tgz && \
    mv sbt /usr/local/bin/sbt && \
    ln -s /usr/local/bin/sbt/bin/sbt /usr/bin/sbt

# Build the application
RUN sbt compile

# Stage the application
RUN sbt stage

# Expose the port the application runs on
EXPOSE 9000

# Define the command to run the application
CMD ["sbt", "run"]