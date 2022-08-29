package kuhn;

public interface Node {

	NodeType getType();
	boolean isPublic();
	// if public, the information belongs to all player's infosets
	String playerInfoset();
	// the node belongs to the turn of this player
	// if null, it is the dealer's turn
	String playerTurn();
	// the player target of a dealer's action
	String targetPlayer();
	Object getValue();
	
}
