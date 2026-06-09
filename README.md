# 🏙️ Cities Game

A simple Java Swing implementation of the classic **Cities Game**.

The player enters a city name, and the computer responds with another city that starts with the last valid letter of the previous city.

---

## How to Run?

### Using Gradle

```bash
./gradlew run
```

### Using JAR File

```bash
java -jar Application-1.0-SNAPSHOT.jar
```

---

## Game Rules

* Enter a valid city name.
* The computer responds with a city starting with the last valid letter of your city.
* Cities cannot be used more than once.
* The city entered by the player must start with the last valid letter of the computer's previous city.
* Enter **"здаюсь"** to surrender and end the game.

---

## Winning Conditions

### Player Wins

The player wins when the computer has no remaining cities available for a valid response.

### Computer Wins

The computer wins when the player enters:

```text
здаюсь
```

---

## Adding New Cities

All cities are stored in:

```text
src/main/resources/cities.txt
```

To add new cities:

1. Open the file.
2. Add one city per line.
3. Save the file.
4. Restart the application.

Example:

```text
Київ
Львів
Одеса
Харків
Дніпро
```

---

## Technologies Used

* Java 21
* Java Swing
* Gradle

---

## Project Structure

```text
src
├── 📁main
│   └── 📁java
│       └── 📁org
│           └── 📁example
│               └── 📁game
│                   ├── CityRepository.java
│                   ├── GameEngine.java
│                   ├── GameResult.java
│               └── 📁ui
│                   ├── CityRepositoryException.java
│                   ├── GameFrame.java
│                   ├── InvalidCityException.java
│                   ├── WelcomeFrame.java
│               └── AppLauncher.java
│       └── 📁resources
│           ├── cities.txt
│           └── icon.png
```