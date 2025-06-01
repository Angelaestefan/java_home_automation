# 🏠 Home Automation System

This project is a simple Java-based Home Automation System designed to demonstrate the implementation of key object-oriented design patterns for improved structure, maintainability, and scalability.

## 🎯 Objectives

The main goals of this project are:

1. **Manage the instantiation** of critical classes to ensure only one instance exists (Singleton Pattern).
2. **Create complex objects** with optional parameters in a flexible and readable manner (Builder Pattern).
3. **Provide a simplified interface** to interact with multiple components or subsystems (Facade Pattern).

## 🧠 Design Patterns Used

| Pattern         | Purpose                                                                 |
|----------------|-------------------------------------------------------------------------|
| Singleton       | Ensures only one instance of the `AutomationController` exists.        |
| Builder         | Allows flexible creation of `LightSource` with optional parameters.     |
| Facade          | Simplifies client interaction via the `HomeSystem` interface.          |
| Command         | Encapsulates actions (e.g., turning on lights) as command objects.     |
| Factory         | Creates devices dynamically based on type input.                       |

---

## 🧱 Components

### 1. `AutomationController` (Singleton)
Controls the entire system lifecycle and ensures only one instance is active.

### 2. `LightSource` (Builder)
Allows building of a light object with customizable hue, brightness level, and status.

### 3. `DeviceFactory` (Factory)
Generates device objects such as `LightDevice` from input type and attributes.

### 4. `Command` Interface + Implementations (Command)
Encapsulates actions such as turning on a light into executable command objects.

### 5. `HomeSystem` (Facade)
Provides a single access point to initiate the system and perform operations.

---

## 🚀 How to Run

1. Clone or download the project files.
2. Ensure you have JDK 8+ installed.
3. Compile all `.java` files:

```bash
javac HomeAutomationApp.java
