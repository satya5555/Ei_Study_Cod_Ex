# Ei_Study_Cod_Ex
Behavioral Design Patterns
Strategy Pattern
Description: Demonstrates the Strategy Pattern by allowing users to choose different payment methods for a shopping cart. It includes two payment strategies: Credit Card and PayPal.

Observer Pattern
Description: Illustrates the Observer Pattern by creating a messaging system where multiple users can subscribe to receive messages. When a message is sent, all subscribed users receive the notification.

Creational Design Patterns
Singleton Pattern
Description: Showcases the Singleton Pattern through a logging mechanism, ensuring that only one instance of the logger exists throughout the application. Users can log messages dynamically.

Factory Method Pattern
Description: Demonstrates the Factory Method Pattern by allowing users to create instances of different animal types (Dog or Cat) and invoke their behavior (speak method).


Structural Design Patterns
Adapter Pattern
Description: Implements the Adapter Pattern to allow an old car object to be used as a modern car interface. Users can choose to drive the old car, which starts its engine and drives.

Composite Pattern
Description: Demonstrates the Composite Pattern by allowing users to create a composite graphic of different shapes (Circle and Square). Users can input the shapes they want to draw.



# Smart Hub System

## Overview

The Smart Hub System is a Java-based application designed to manage and control various smart devices, including lights, thermostats, and door locks. It utilizes the Observer design pattern to enable dynamic responses to environmental conditions, making it a versatile solution for home automation.

## Features

- **Device Management**: Register and control multiple smart devices.
- **Dynamic Observers**: Automatically update device states based on predefined conditions.
- **Command Execution**: Send commands to devices to turn them on/off and schedule tasks.
- **Logging**: Track device status changes and actions taken through a logger.
- **Flexible Scheduling**: Schedule tasks for specific devices based on time or conditions.
- **Extensible**: Easily add new device types and observers.

## Technologies Used

- Java 11 or higher
- Object-Oriented Programming (OOP) principles
- Observer design pattern
- Logging via Java's built-in logging framework

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/smart-hub.git
   cd smart-hub
