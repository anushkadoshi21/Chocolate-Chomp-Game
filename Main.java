/**
 * The entry point for the Chocolate Chomp game.
 * Initializes the game with a graphical user interface (GUI).
 */
public class Main {
    /**
     * The main method to launch the Chocolate Chomp game.
     * Creates a GUI for a board with specified dimensions and initializes it.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        GUI g=new GUI(4,4);
        g.initGUI();
    }
}