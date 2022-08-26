package kuhn;

public class DealCard implements Node {
	
	// the player this card is dealt to
	String player;
	
	// the card dealt to the player
	String card;
	
	public DealCard(String player, String card) {
		this.player = player;
		this.card = card;
	}

	@Override
	public NodeType getType() {
		return NodeType.CARD;
	}

	@Override
	public boolean isPublic() {
		return false;
	}

	@Override
	public String playerInfoset() {
		return player;
	}
	
	@Override
	public Object getValue() {
		return card;
	}
	
	@Override
	public String toString() {
		return player+":"+card;
	}
}
