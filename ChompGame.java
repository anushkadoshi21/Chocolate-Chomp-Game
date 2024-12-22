
/**
 * Management of gameplay logic for the Chocolate Chomp game.
 * Has/Contains the board state, players, and game rules.
 *
 * Deviation from class diagram by implementing additional method to interact with GUI & paint the buttons accordingly.
 * Method added - int getBoardPiece(int row,int col)
 */
public class ChompGame {
    private Board board;
    private Player currPlayer;
    private GameState gameState;
    private java.util.List <Player> players;

    /**
     * Initializes a new game with a board of the specified size.
     * The game starts with two players and conventionally sets the initial turn to Player 1.
     *
     * @param rows the number of rows on the board
     * @param cols the number of columns on the board
     */
    public ChompGame(int rows,int cols) {
        board = new Board(rows,cols);
        gameState=GameState.Playing;
        players=new java.util.ArrayList() ;
        players.add(new Player(PlayerMark.Player_1));
        players.add(new Player(PlayerMark.Player_2));
        currPlayer=players.get(0);
    }

    /**
     * Gets piece type of specified index of the chocolate board (1-based index).
     *
     * @return 0 if it is Invalid else 1
     */
    public int getBoardPiece(int row,int col){
        PieceType p=board.getPiece(row,col);
        if (p.equals(PieceType.Invalid)){
            return 0;
        }
        return 1;
    }

    /**
     * Makes a move at the specified position.
     * Updates the board and switches the player turn if valid.
     * Ends the game if the move hits the poisonous piece.
     *
     * @param row the row index (1-based)
     * @param col the column index (1-based)
     * @return 0 if the move is valid, 1 otherwise
     */
    public int makeMove(int row,int col){
        if (this.isMoveValid(row,col)) {
            board.removepiece(row, col);
            this.switchPlayerTurn();
            gameState=GameState.Playing;
            return 0;
        }
        else{
            PieceType p= board.getPiece(row,col);
            if (p.equals(PieceType.Poison)){
                if (currPlayer.getPlayer().equals(PlayerMark.Player_1)){
                    gameState=GameState.Player_2_won;
                }
                else{
                    gameState=GameState.Player_1_won;
                }
                board.removepiece(row, col);
                return 0;
            }
            return 1;
        }
    }

    /**
     * Fetches the player whose turn it is.
     *
     * @return the current player
     */
    public Player getCurrPlayer(){
        return currPlayer;
    }

    /**
     * Gets the current game state.
     *
     * @return the current game state
     */
    public GameState getGameState(){
        return gameState;
    }

    /**
     * Switches the turn to the other player.
     */
    public void switchPlayerTurn(){
        if (currPlayer.getPlayer().equals(PlayerMark.Player_1)){
            System.out.println("Player1, switching to 2");
            currPlayer=players.get(1);
        }
        else{
            System.out.println("Player2, switching to 1");
            currPlayer=players.get(0);
        }
    }

    /**
     * Checks if the move is valid.
     *
     * @param row the row index (1-based)
     * @param col the column index (1-based)
     * @return true if the move is valid, false otherwise
     */
    public boolean isMoveValid(int row,int col){
        return board.isValidPosition(row,col) && gameState.equals(GameState.Playing);
    }
    }
