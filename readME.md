🍫 Chocolate Chomp Game

Chocolate Chomp is an interactive and engaging grid-based game built in Java. The player’s goal is to avoid eating the "poisoned" chocolate piece while taking turns chomping chocolate from a grid. This project showcases clean object-oriented design and a user-friendly GUI.
📜 Table of Contents

    Features
    Technologies Used
    Class Diagram and Design
    Design Patterns
    How to Run the Game
    Screenshots
    Acknowledgments

🎮 Features

    Interactive Gameplay: Two-player alternating turns with intuitive mouse-based interactions.
    Customizable Grid: Configure the size of the grid before starting.
    Dynamic UI: Visually responsive and engaging chocolate-grid graphics.
    Game Logic: Automatically determines when the game ends and highlights the losing player.

🛠️ Technologies Used

    Programming Language: Java
    Framework: Java Swing (for GUI development)
    IDE: IntelliJ IDEA / Eclipse
    Tools:
        UML Diagramming for class structure visualization.
        Git for version control and collaboration.

📐 Class Diagram and Design

The design follows a clear separation of concerns to promote maintainability and scalability:

    Model: Encapsulates the core game logic and data.
        Grid: Manages the grid structure and state.
        ChocolatePiece: Represents each piece of chocolate on the grid.

    View: Handles the user interface.
        ChompView: Displays the grid and updates visuals based on user actions.

    Controller: Manages interaction between the model and view.
        ChompController: Processes user input and updates the model and view accordingly.

🌀 Design Patterns

This project incorporates the following design patterns:

    Model-View-Controller (MVC):
    Ensures separation of game logic, user interface, and user input for maintainable and scalable design.

    Observer Pattern:
    The view observes the model to update the grid whenever the state changes.

    Factory Pattern:
    Simplifies the creation of grid objects and chocolate pieces with a factory class.

🚀 How to Run the Game

    Clone the Repository:

    git clone https://github.com/username/chomp-game.git  
    cd chomp-game  

    Build the Project:
    Open the project in your preferred IDE and build the source files.

    Run the Application:
    Run the ChompGame.java file.


Happy Chomping! 🍫