import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * Provides a graphical user interface using Swing for the Chocolate Chomp game.
 * Handles user interactions, board visualization, and game state updates.
 *
 *
 * Slight Deviation in this class w.r.t class diagram provided to make program more efficient.
 *
 * 1. Since the chocolate grid is initialized as grid of JButtons, we only need either MouseListener or ActionListener.
 * 2. I've implemented it using ActionListener.
 * 3. Since actionListener is embedded inside the button using anonymous invocation, we do not need to implement it directly in GUI class
 * 4. Again because JButtons are used for grid, we do not need paintComponent(Graphics g) method to repaint the buttons.
 *    Instead, setBackgroundColor(Color c) method of JButton takes care of repainting the board
 */
public class GUI extends JFrame{
    JFrame jFrame;
    JLabel label;
    JButton[][] boardButtons;
    ChompGame game;
    JPanel buttonPanel;


    /**
     * Initializes the GUI for a game with the specified board dimensions.
     *
     * @param row the number of rows on the board
     * @param col the number of columns on the board
     */
    public GUI(int row, int col){
        game=new ChompGame(row,col);
        boardButtons=new JButton[row][col];
    }

    /**
     * Configures and displays the GUI components.
     */
    public void initGUI(){
        jFrame = new JFrame("Chocolate Chomp");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new BorderLayout());
        label = new JLabel("Welcome to Chocolate Chomp", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBorder(new EmptyBorder(10, 0, 10, 0));
        jFrame.add(label, BorderLayout.NORTH);
        buttonPanel = new JPanel(new GridLayout(boardButtons.length, boardButtons[0].length));
        buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        for (int i=0;i<boardButtons.length;i++){
            for (int j=0;j<boardButtons[0].length;j++){
                JButton button = new JButton();
                if ((i==boardButtons.length-1) && (j==0)){
                    button.setText("POISON");
                }
                button.setBackground(new Color(139, 69, 19));
                button.setFocusPainted(false);
                button.setMargin(new Insets(5, 5, 5, 5));
                final int ii=i+1;
                final int jj=j+1;
                button.addActionListener(new ActionListener(){  // Embed actionListener directly in JButton
                    @Override                                   //and handle click directly using this anonymous function
                    public void actionPerformed(ActionEvent e) {
                        handleButtonClick(ii, jj);
                    }
                });

                buttonPanel.add(button);
                boardButtons[i][j]=button;
            }
        }
        jFrame.add(buttonPanel, BorderLayout.CENTER);
        jFrame.setVisible(true);
        jFrame.setSize(600, 400);
        jFrame.setLocationRelativeTo(null);
    }

    /**
     * Handles a button click on the board.
     * Updates Label & board state when move is valid
     *
     * @param row the row index (1-based)
     * @param col the column index (1-based)
     */
    public void handleButtonClick(int row, int col){
        int result=game.makeMove(row,col);
        if (result==0) {
            updateLabel();
            updateBoard();
        }
    }

    /**
     * Updates the label based on the game state.
     */
    public void updateLabel(){
        String state=game.getGameState().toString();
        if (state.equals("Playing")){
            label.setText(game.getCurrPlayer().getPlayer().toString()+" Turn");
        }
        else{
            label.setText(state);
        }

    }

    /**
     * Updates the board display based on the game state.
     */
    public void updateBoard(){
        for (int i=0;i<boardButtons.length;i++){
            for (int j=0;j<boardButtons[0].length;j++) {
                if (game.getBoardPiece(i+1, j+1)==0) {
                    boardButtons[i][j].setBackground(Color.LIGHT_GRAY); //Directly used JButton method to repaint
                }
            }
        }
    }
}
