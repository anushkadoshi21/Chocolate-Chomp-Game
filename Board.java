
/**
 * Represents the game board for the Chocolate Chomp game.
 * The board consists of a grid of pieces that can be valid, invalid, or poisonous.
 */
public class Board {
    private int rows;
    private int cols;
    private PieceType[][] pieces;

    /**
     * Initializes a game board with the specified number of rows and columns.
     * All pieces are set to valid except for the bottom-left corner, which is poison.
     *
     * @param rows the number of rows on the board
     * @param cols the number of columns on the board
     */
    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        pieces = new PieceType[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.pieces[i][j]=PieceType.Valid;
            }
        }
        this.pieces[rows-1][0]=PieceType.Poison;
    }

    /**
     * Gets the piece type at a specific position.
     *
     * @param row the row index (1-based)
     * @param col the column index (1-based)
     * @return the type of the piece at the specified position
     */
    public PieceType getPiece(int row, int col) {
        return pieces[row-1][col-1];
    }

    /**
     * Sets the piece type at a specific position.
     *
     * @param row the row index (1-based)
     * @param col the column index (1-based)
     */
    private void setPiece(int row, int col, PieceType piece) {
        this.pieces[row-1][col-1] = piece;
    }

    /**
     * Removes pieces from the specified position and all above rows to the right.
     * The affected pieces are marked as invalid.
     *
     * @param row the row index (1-based) of the piece to remove
     * @param col the column index (1-based) of the piece to remove
     */
    public void removepiece(int row, int col) {
        for (int i=0; i<row; i++) {
            for (int j=col-1; j<this.cols; j++) {
                this.setPiece(i+1,j+1,PieceType.Invalid);
            }
        }
    }

    /**
     * Checks if the position contains a valid piece for the move.
     *
     * @param row the row index (1-based)
     * @param col the column index (1-based)
     * @return true if the piece at the position is valid, false otherwise
     */
    public boolean isValidPosition(int row, int col) {
        if (this.pieces[row-1][col-1]==PieceType.Valid){
            return true;
        }
        return false;
    }

    /**
     * Gets the number of rows on the board.
     *
     * @return the number of rows
     */
    public int getRows(){
        return rows;
    }

    /**
     * Gets the number of columns on the board.
     *
     * @return the number of columns
     */
    public int getCols(){
        return cols;
    }
}


