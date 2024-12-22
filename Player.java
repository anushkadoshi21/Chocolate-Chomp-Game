/**
 * Represents a player in the Chocolate Chomp game.
 * Each player has a unique mark indicating their identity.
 */
class Player {
    private PlayerMark player;

    /**
     * Creates a player with the specified mark.
     *
     * @param player the mark assigned to the player
     */
    public Player(PlayerMark player) {
        this.player = player;
    }

    /**
     * Gets the mark of the player.
     *
     * @return player's mark
     */
    public PlayerMark getPlayer() {
        return this.player;
    }
}