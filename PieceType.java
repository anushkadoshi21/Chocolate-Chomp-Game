/**
 * Represents the types of pieces used in the game board.
 * Valid- Player can chomp at that position
 * Invalid - Player cannot chomp on the position since it has already been chomped
 * Poison - Lowe left chocolate piece which is filled with poison
 */
public enum PieceType {
    Valid,
    Invalid,
    Poison;
}
