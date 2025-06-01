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
## 🔧 Modifications Summary

### 1. **Singleton Pattern** – `AutomationController`  
- Ensures only **one controller instance** manages the system.  
- Prevents conflicts or inconsistent state due to multiple instances.

```java
public class AutomationController {
    private static AutomationController instance;

    private AutomationController() {}

    public static AutomationController getInstance() {
        if (instance == null) {
            instance = new AutomationController();
        }
        return instance;
    }
}
```
### 2. Builder Pattern – LightSource
- Enables flexible object creation with optional parameters.
- Improves readability when configuring devices with multiple attributes.

```java
LightSource light = new LightSource.Configurator("White")
                      .setLevel(75)
                      .setStatus("ON")
                      .build();
```

### 3. Command Pattern – Command, ActivateLightCommand
- Encapsulates actions as objects, allowing commands to be queued, logged, or reused.
- Decouples the request sender (HomeSystem) from the action performer (LightSource).

```java
Command activate = new ActivateLightCommand(light);
homeSystem.activateDevice(activate);
```

### 4. Facade Pattern – HomeSystem
- Provides a simplified interface to interact with subsystems.
- Reduces complexity for the main application (HomeAutomationApp).

```java
HomeSystem home = new HomeSystem();
home.activateDevice(command);
```
---

## ✨Benefits

- Improved modularity and separation of concerns.

- Easy to extend system functionality (add more commands, devices, or systems).

- Cleaner and centralized interaction via the Facade.

- Simplified testing and maintenance.

---

## 🚀 How to Run

1. Clone or download the project files.
2. Ensure you have JDK 8+ installed.
3. Compile all `.java` files in src:

```bash
javac -d bin src/**/*.java
```
4. Run your program
```bash
cd bin
java Main.HomeAutomationApp

```

