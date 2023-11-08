# YorkU Parking Booking System

The **YorkU Parking Booking System** is a Java-based GUI project designed to meet the parking management needs of York University. This system allows users, including students, faculty members, non-faculty staff, and visitors, to [book parking spaces online](#usage), [manage parking lots](#usage), and [make payments](#usage). This README provides an overview of the project, its requirements, and instructions for usage.

## Table of Contents
- [Project Description](#project-description)
- [Features](#features)
- [System Requirements](#system-requirements)
- [Installation](#installation)
- [Usage](#usage)
- [Project Diagrams](#project-diagrams)
- [Contributing](#contributing)
- [License](#license)

## Project Description

The **YorkU Parking Booking System** aims to provide better online booking services to clients, including students, faculty members, non-faculty staff, and visitors. It fulfills the following [requirements](#requirements):

### Requirements
1. **Client Registration**
   - Any client can register with a unique/valid email and a strong password.
   - The system supports four client types and allows for future additions.
   - Special validation is required for students, faculty members, and non-faculty staff.

2. **Auto Account Generation**
   - The system generates management accounts for super managers to maintain parking services.

3. **Parking Space Booking**
   - Registered clients can book available parking spaces.
   - Different pricing is applied based on the client type.

4. **Deposit and Refund**
   - Booking a parking space requires a deposit equivalent to an hour of parking fees, which is not refundable in case of a no-show within the first hour. Otherwise, the deposit is deducted during checkout.

5. **Sensor Integration**
   - Each parking space is equipped with a sensor to detect occupancy and scan basic car information.

6. **Parking Lot Management**
   - System managers can add, enable, disable parking lots, each containing 100 parking spaces.
   - Individual parking spaces can be enabled or disabled for maintenance.

7. **Unique Identification**
   - Each parking space has a unique identification number, location, and parking lot details for client navigation.

8. **Licence Plate Requirement**
   - To book a parking space, clients must provide a valid license plate number.
   - Clients can edit or cancel bookings before the booking's start time.

9. **Time Extension**
   - Clients have the option to extend their parking time before it expires.

10. **Multiple Payment Options**
    - Clients can pay their parking fees using debit cards, credit cards, mobile payments, and other available options.

## System Requirements

Before using the YorkU Parking Booking System, ensure that you have the following prerequisites:

- [Java Development Kit (JDK)](#system-requirements)
- A compatible IDE (e.g., [IntelliJ IDEA](#system-requirements), [Eclipse](#system-requirements))
- [MySQL](#system-requirements) or another relational database management system

## Installation

1. Clone the repository to your local machine:

   ```shell
   git clone https://github.com/yourusername/YorkU-Parking-System.git
Open the project in your chosen IDE.

Configure the database connection in the project settings.

Build and run the project.

Usage
Register as a client with a unique email and strong password.

Log in to your account.

Browse available parking spaces and select one.

Provide a valid license plate number.

Make a deposit payment.

Manage your bookings, extend parking time, or make payments using available options.

Project Diagrams
The project includes various diagrams to aid in understanding the system's structure and functionality. You can find these diagrams in the "diagrams" folder within the project repository:

Use Case Diagram
Class Diagram
Sequence Diagram
Contributing
Contributions to the project are welcome. If you'd like to contribute, please follow these steps:

Fork the repository.

Create a new branch for your feature or fix.

Make your changes.

Test your changes thoroughly.

Submit a pull request.

License
This project is licensed under the MIT License. Feel free to use, modify, and distribute it according to the terms of the license.

Thank you for using the YorkU Parking Booking System! If you have any questions or encounter issues, please don't hesitate to reach out to the project maintainers.

Happy parking! 🚗🅿️




