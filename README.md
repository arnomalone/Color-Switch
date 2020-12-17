# Color-Switch
## Details
**Created by:
[Abhishek Saini](https://www.github.com/arnomalone) and [Raghav Nakra](https://www.github.com/ragh-a-void)**

This is a clone of the famous arcade game 'Color-Switch' made using java, javafx and essential principles of object oriented programming.

Made as a part of end-term project in Advanced Programming Course (CSE201) at IIIT Delhi.


## Features
- Difficulty starts increasing after 10 stars are earned in a game.
- Colors available are red, yellow, blue, purple.
- Obstacles available are square, circle, triangle and cross.
- User can unlock and choose between different shapes of the ball.
- User can save multiple game states and reload or restart them at any time.
- Cool background music.
- The user can see top 5 highest scores ever reached in the game.
- Users that are new to the game are provided with a guide to start off good.
- Obstacles will be changing sizes every second to make the game more interesting and difficult.

## Implementation
- Navigation: navigation of on-screen components done using FXML.
- Saving/Loading a game: every time a user saves a game, the game state is added in the database along with the count of stars earned, which is then serialized using I/O streams. 
- Delete: game state is automatically removed in which the user loses the game and is unable to revive.
- Difficulty: levels become harder as the user progresses through the game. Rotation rates of obstacles start increasing along with consistent change in their sizes.
- Revive: The user can revive if he/she has enough stars (10 stars per revival) and feels like continuing or start afresh otherwise.

## Design Patterns
- Iterator - Ordered accessing of lists when required.
- Template - Used in interface and in-game interactions.
- Facade - Distribution of tasks between entities.
- Decorator - Scanner and File streams used to save the game.
- Composite - Current game holds object of its own type.
- Observer - Event handler and Key listeners as observers.
- Chain of responsibility - Event handlers and key listeners use chain of responsibility internally to function.
- State - Game is implemented using various states such as collision, state saving, revival.
- Threading - All the in-game animations are done using AnimationTimers each being an individual thread in JVM


## Screenshots from the game

## License
### GNU General Public License v3.0
You may copy, distribute and modify the software as long as you track changes/dates in source files. Any modifications to or software including (via compiler) GPL-licensed code must also be made available under the GPL along with build & install instructions.
