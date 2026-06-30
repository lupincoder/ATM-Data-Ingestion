# ATM Data Processing Application

## Overview

This project is a Java Spring Boot application that reads ATM data from a text file and saves it into a database. I created this project to practice backend development concepts like reading files, using scheduled tasks, working with services and repositories, and storing data in a database.

The application processes ATM information such as an ATM ID and a DCC value. It reads the data, turns it into ATM records, and saves it so the information can be stored and used later.

## Project Purpose

The purpose of this project was to get more hands-on experience with building a structured backend application using Spring Boot. As a software engineering student, this helped me better understand how applications can take in data from a file, process it, and save it into a database.

## Features

- Reads ATM data from a text file
- Processes ATM ID and DCC value information
- Saves ATM records into a database
- Uses a service layer to organize business logic
- Uses a repository layer for database operations
- Runs automatically using scheduled tasks
- Demonstrates a basic backend data-processing workflow

## Technologies Used

- Java
- Spring Boot
- Spring Data JDBC
- Maven
- SQL Database

## What I Learned

While working on this project, I learned more about:

- Building a backend application with Spring Boot
- Reading and processing text files in Java
- Using scheduled tasks to run code automatically
- Creating entities, services, and repositories
- Saving data into a database
- Organizing a project into different layers
- Handling simple data processing workflows

## How It Works

1. The application reads ATM data from a text file.
2. Each line of data contains an ATM ID and a DCC value.
3. The application creates ATM records from the data.
4. The records are saved into the database.
5. This process runs automatically on a schedule.

