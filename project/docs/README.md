# LPOO_T7G6 - MINESWEEPER
The game we are developing is a version of the popular classic game MineSweeper, in which 
a single player tries to clear a mined board knowing only the number of neighbouring mines for 
each tile, and without detonating any of them.

The project was made for the Object-Oriented Programming Laboratory Curricular Unit (LPOO 20/21) at FEUP,
by André Santos (up201907879@edu.fe.up.pt), Maria Carneiro (up201907726@edu.fe.up.pt) and Rodrigo
Andrade (up201904967@edu.fe.up.pt).

## Implemented Features
### Menu Options
* **Start Game** - Play the game with a random board, with default dimensions 10x10 and 5 mines.
* **Settings** - Customize the game, changing the board dimensions and the total number of mines.
* **Highscore** - Shows the top 3 players with the best score. The score is calculated using the time passed
and the density of mines for each board dimensions.
* **Controls** - Shows all the relevant controls to ease the understanding of the gameplay.
* **Exit** - Closes the terminal window and ends the game.
  
![MainMenu](/docs/screenshots/mainMenu.png)

> **Board height and width range from 6 to 20 tiles. The number of mines ranges from 1 to 399 mines.**

![SettingsMenu](/docs/screenshots/settingsMenu.png)

> **Best scores are smaller numbers since the score takes into account winning the game in less time.**

![HighscoresMenu](/docs/screenshots/highscoresMenu.png)

![ControlsMenu](/docs/screenshots/controlsMenu.png)

### Keyboard Controls
* **Moving** - Arrows are used to move between tiles as well as moving in the menus and selecting different
  values in the settings menu.
* **Open** - Key 'A' opens a selected tile.
* **Flags** - Key 'S' flags and "unflags" a selected tile.
* **Going Back** - Key 'Z' undoes the last move, except when the player looses or wins. 
* **Menu Selection** - Enter Key selects each menu option.
* **Back to Main Menu** - Escape Key, while in the game, goes back to the main menu.
* **New Highscore** - All the letter keys can be pressed to write the new highscore player's name.

> **Cursor, Opened and Flagged tiles**

![Tiles](/docs/screenshots/tiles.png)

> **The line is where the name is written on screen. Inserted names have a maximum of 10 letters.**

![NewHighScore](/docs/screenshots/newhighscoreMenu.png)

### Game Features
* **Timer** - The time passed since the start of each game is counted and displayed on the screen.
* **Tiles left** - Number of closed tiles that still need to be opened to win the game.
* **Cascade Open** - Tiles cascade open if the selected tile and its adjacent ones don't have any surrounding mines.
* **GameOver** - If a mined tile is selected, the player looses. If all the tiles with no mines are revealed, the
  player wins, showing the score obtained.

> **Flagged tiles are the mined tiles, and the total number of tiles left corresponds to the unopened safe ones.
> Unnumbered tiles were cascaded open, since they have no surrounding mines. 58 seconds have elapsed since 
> the beginning of the game.**

![GameFeatures](/docs/screenshots/gameFeatures.png)

> **The score obtained is only shown if the player wins the game.**

![GameOverMenu](/docs/screenshots/gameoverMenu.png)

### Overall Features
* **Quit** - Closing the terminal window at any point ends the program.
## Design
### Interface
#### Problem in context
One of the main problems the game brings up is the interface management. When a game like Minesweeper is programmed,
there's a need to think in both the interaction with the user and the structure itself. For example, when a tile is
pressed, all the user sees is the number of unsafe tiles nearby, or if that place was mined. Behind that there's complex
code which processes the information. If we directly access our deep classes and subsystems, there will be a
considerable number of different calls that will get more confusing as the complexity of the system increases. If we had
a way of layering down our structure, so that when we were to run the game, every interaction would be simplified, the 
values would be read and changed with greater ease. In this context, all the actions in the game generate updates, which
means that the task execution order should be deeply organized. Therefore, we need to implement our structure accordingly.

#### The Pattern - Facade
The design pattern chosen to deal with this kind of problem was **Facade**. This pattern allows us to work with a 
small part of the game features, even though their constitution is bigger. This way, we can implement an interface 
responsible for simplifying the access to the existent classes. The important interactions between the user and the 
function calls will be redirected to the Facade class, this way it will both be easier to make changes and to layer down 
the program in subsystems.

#### Implementation
The diagram shows the pattern applied to the game. To avoid using the Lanterna framework directly in every part of the 
code that requested it, we used it as a Facade class, representing a single terminal window.

![Facade](/docs/UML/Facade.png)

The classes can be found in the following files:
* [GUI](/src/main/java/lpoo/gui/GUI.java)
* [LanternaGUI](/src/main/java/lpoo/gui/LanternaGUI.java)

#### Consequences
By using the Facade design pattern, we will lose the ability to interact directly with the base of our code and to
access all kinds of information, but the most important components of the game will be heavily organized afterwards, 
increasing the interaction between the user and the game processing quality, making the trade absolutely worth.

### Tile Behaviour depends on State Changes
#### Problem in context
Tiles behave differently according to the state they are currently in. At any given moment, each tile can be
in three distinct states: opened, closed or flagged. Dealing with state changes is closely related with the concept of
state machines which are usually implemented with conditional operators, such as _if_ or _switch_ statements. This, 
however, would violate the **Single Responsibility Principle** by delegating all duties to a single module, creating 
code that is hard to maintain and update.

#### The Pattern - State
The design pattern chosen to deal with this kind of problem was **State**. This pattern divides each state in its 
own subclass, composed of all state-specific behaviour. The particular states are aware of each other and interact
accordingly, encompassing the various state changes throughout the game. 

#### Implementation
The following State Machine diagram represents the transitions between states in each tile. Each tile can either be 
open, closed or flagged. State transitions happen between tiles in different states.
> **Open tiles are either numbered tiles or mined tiles, so they can´t change their state.
> Closed tiles can become open or flagged, depending on which key the player presses.
> Flagged tiles only change state when their flag is removed, becoming closed tiles again.**

![StateMachineTiles](/docs/UML/TilesStateMachine.png)

The diagram shows the pattern applied to the game.

![StateTiles](/docs/UML/StateTiles.png)

The classes can be found in the following files:
* [Tile](/src/main/java/lpoo/model/game/Tile.java)
* [TileState](/src/main/java/lpoo/model/game/tilestate/TileState.java)
* [OpenState](/src/main/java/lpoo/model/game/tilestate/OpenState.java)
* [ClosedState](/src/main/java/lpoo/model/game/tilestate/ClosedState.java)
* [FlaggedState](/src/main/java/lpoo/model/game/tilestate/FlaggedState.java)

#### Consequences
Using the State pattern, we manage to avoid the violation of the Single Responsibility Principle, by distributing the
different duties for each state subclass. That added modularity also makes the transitions explicit, without using flags
or long conditional statements, which are known code smells. Although the number of classes increased, their management
is still simple, since there are only 3 different states associated with a tile.

### Handling Commands Execution and their Reversibility
#### Problem in context
The game execution is highly dependent on different user actions such as moving the cursor and flagging/opening tiles.
Condensing those actions in a single class would violate not only the **Single Responsibility Principle**, but also the 
**Open/Closed Principle**, since adding a new command would require updating various other commands that depend on its
execution. This last concern was very present in our code, since the reversibility of commands was an important feature
in our game.
#### The pattern - Command
The design pattern chosen to deal with this kind of problem was **Command**. This design pattern allows for a 
reduction of responsibility and knowledge in the [GameController](/src/main/java/lpoo/controller/game/GameController.java),
helping with the tracking history of commands and easing their reversibility, if needed. Each command is responsible 
for their own actions, making the structure of the Game Controller simpler, since it's built on primitive operations,
like pushing and popping commands from a stack holder.
#### Implementation
The diagram shows the pattern applied to the game. GameController acts as the invoker, client and receiver
of the Concrete Commands Open, Flag and all the Cursor Commands, that implement the Command interface.

![Command](/docs/UML/Command.png)

The classes can be found in the following files:

* [Command](/src/main/java/lpoo/controller/game/commands/Command.java)
* [CursorMoveCommand](/src/main/java/lpoo/controller/game/commands/CursorMoveCommand.java)
* [MoveUpCommand](/src/main/java/lpoo/controller/game/commands/MoveUpCommand.java)
* [MoveDownCommand](/src/main/java/lpoo/controller/game/commands/MoveDownCommand.java)
* [MoveLeftCommand](/src/main/java/lpoo/controller/game/commands/MoveLeftCommand.java)
* [MoveRightCommand](/src/main/java/lpoo/controller/game/commands/MoveRightCommand.java)
* [OpenCommand](/src/main/java/lpoo/controller/game/commands/OpenCommand.java)
* [FlagCommand](/src/main/java/lpoo/controller/game/commands/FlagCommand.java)
* [GameController](/src/main/java/lpoo/controller/game/GameController.java)

#### Consequences
Using the Command Pattern, we avoid both of the violations of the Open/Closed Principle and the Single Responsibility 
Principle, by delegating responsibilities and distributing execution knowledge to each Command Class instead of
the Game Controller class. Commands can also be easily stored in data structures, like a stack, which aids with tracking
the history of actions, helpful to the reversibility factor of our game.

### Assembling Game and Menu Components
#### Problem in Context
In the game development process, a point is reached where the menus and the game components need to be merged, in order
to provide a simple and pleasant interface to satisfy the overall playing experience. Assembling the menu and game 
components requires a knowledge of the state the program is in, such as the different menu options or the game itself.
#### The Pattern - State
The design pattern chosen to deal with this kind of problem will be **State**. This pattern divides each state in its
own subclass, composed of all state-specific behaviour. The particular states are aware of each other and interact
accordingly, encompassing the various state changes throughout the game.
#### Implementation
The following State Machine diagram represents the transitions between distinct game stages. Although the exit menu 
option closes the game so it represents the final state, that is not the only way to end the game. Throughout
the execution, closing the terminal window also closes the game and, therefore, also reaches the final state. 
On that account, the diagram should have a connection from all the states to the final state, but we chose not to display it 
since it hinders the visualization of the diagram. 

![GameStateMachine](/docs/UML/GameStateMachine.png)

The diagram shows the pattern applied to the game.

![GameState](/docs/UML/GameState.png)

The classes can be found in the following files:

* [Application](/src/main/java/lpoo/Application.java)
* [State](/src/main/java/lpoo/states/State.java)
* [ControlsState](/src/main/java/lpoo/states/ControlsState.java)
* [GameOverState](/src/main/java/lpoo/states/GameOverState.java)
* [GameState](/src/main/java/lpoo/states/GameState.java)
* [HighScoreState](/src/main/java/lpoo/states/HighScoreState.java)
* [MenuState](/src/main/java/lpoo/states/MenuState.java)
* [RankingState](/src/main/java/lpoo/states/RankingState.java)
* [SettingsState](/src/main/java/lpoo/states/SettingsState.java)

#### Consequences
Using the State design pattern to connect all the game components helps with modularity and eases state changes, 
allowing the user to effortlessly travel through the game. The behaviour of the application is organized and efficient, 
proving the relevance of the design pattern in this context.

### Architectural Style of the Software
#### Problem in context
Structuring and organizing the program into neatly and distinct sections is necessary in order to manage, enhance, 
maintain and adapt the code to future changes. For that reason, using an architectural design pattern is an attractive 
solution, since it provides a set of strategies and knowledge to create flexible and reusable code.

#### The Pattern - MVC
The design pattern chosen to solve this problem was **MVC**, which stands for **Model** - **View** - **Control**. 
The idea behind MCV is that the code is divided into three different sections with different purposes, decoupling 
components and allowing for efficient code reuse. Those three elements can be defined as follows:
* **Model** - holds, represents and manages the data, received from the user by the Controller.
* **View** - directly interacts with the user, displaying Model's data and sending actions to the Controller.
* **Controller** - acts as a liaison between the Model and View, by interpreting user input and providing Model data to 
  the View.
  
#### Implementation
Each element of the MVC corresponds to a directory containing the files that implement each part of the Model, View and
Controller.

![MVC](/docs/UML/MVC.png)

#### Consequences
Using MVC can be complex when considering big scale programs, where the time it takes to explore its implementation and 
to model to each specific case might not be worthy when comparing with other architectural styles. However, that does not
apply to our case, since the game is not of elevated complexity. Therefore, using MVC allows for the reusability, modularity 
and scalability of the code, making it more organized and structured.

## Known Code Smells and Refactoring Suggestions
In the current version of our game, some code smells can be found throughout our code:
### Switch Statements
The Switch Statements code smell happens when complex _switch_ or _if_ statements are used. We used multiple switch 
statements to mostly deal with different user related actions and choosing different game states and menus. The smell 
remains in our code since using conditionals is necessary when dealing with different actions. Refactoring these
instances using the **Replacing Conditionals with Polymorphism** method seemed excessive for our specific cases and could 
eventually lead to **Shotgun Surgeon** code smells.
### Lazy Class
The Lazy Class code smell is present when a class has a small amount of insignificant methods that don't justify its 
existence. Previously, we considered implementing a Factory Pattern to produce different views, but we decided that the 
design pattern didn't bring any benefit to our game design, so we removed the Factory classes, and effectively reduced 
the number of lazy classes in our code (That previous implementation can be found 
[here](https://github.com/FEUP-LPOO-2021/lpoo-2021-g76/tree/cc6672985831c57e205cbfc452a56fe1e7dd37ef/src/main/java/lpoo/Viewer)).
In the current version of our code, the [Element](/src/main/java/lpoo/model/Element.java) interface is a lazy class
because it is empty. The refactoring of this particular smell won't be considered since the [Element](/src/main/java/lpoo/model/Element.java)
interface allows for a generalization of all the game model components and its useful in creating serialized views and 
controlling global state changes.
### Message Chains
The Message Chains code smell occurs when there are a series of chained calls to different methods. This smell is present
throughout our code in various instances, such as getting the [Position](/src/main/java/lpoo/model/Position.java)
or getting the height and width of a particular [Configuration](/src/main/java/lpoo/model/Configuration.java). This 
smell could be refactored using the **Hide Delegate** method, creating new methods in intermediate classes that access 
the deeper chain members, but that solution was not considered since excessive hiding could cause a **Middle Man** code 
smell.
### Feature Envy
The Feature Envy code smell happens when a method accesses the data of another object more than its own data. This smell 
is present in the [LanternaGUI](/src/main/java/lpoo/gui/LanternaGUI.java) class, since it frequently uses the objects 
present in the Lanterna framework. As a result, the refactoring of this particular smell will not be considered since 
the LanternaGUI class is useful as a facade class for the Lanterna framework.

### Refused Bequest
When a subclass is only using part of the inherited methods from a parent, a Refused Bequest code smell happens. This is
present in the [BackField](/src/main/java/lpoo/model/settings/BackField.java) class, whose parent class
[Field](/src/main/java/lpoo/model/settings/Field.java) declares the "increase" and "decrease" functions, even though the
Backfield class doesn't provide them with any utility. One way to solve this issue, would be to **Replace Inheritance
with Delegation**. Other option would consist in the **Extract Superclass** method, which would create a new superclass,
using the relevant functions of the original parent. Defining these methods in the 
[BackField](/src/main/java/lpoo/model/settings/BackField.java) class is pointless, but the parent class forces
their existence, and the current inheritance structure advantages are more important and useful to the overall 
implementation, so possible refactorings were ignored.

### Duplicate Code

The Duplicate Code is a common smell and can happen for a lot of reasons. There are many options to solve this issue,
depending on where the duplicated code is written. It can be spotted on the menus, which are same level subclasses, for
example. To fix it, we could use the **Extract Method** and the **Pull up Field**, which would transfer the common fields
to the parent class. We paid close attention to all of the occurences and minimized the code duplication, but there are
a few situations where merging the code didn't pay off, because it would compromise code readability and the global
menu interface look.

## Game Demo
![GameDemo](/docs/screenshots/game-demo.gif)

## Testing
* [Test Report](https://rodrigotuna.github.io/test/)
* [Test Coverage Report](https://rodrigotuna.github.io/html/)
* [Pitest Report](https://rodrigotuna.github.io/202105301702/)

## Contributions

| Name             | Contributions  |
| ---------------- | -------------- |
| André Santos     |       30       |
| Maria Carneiro   |       30       |
| Rodrigo Tuna     |       40       |

----

