package kuhn;

public class PlayerAction implements Node {

	String player;
	ActionType value;
	NodeType type;

	public NodeType getType() {
		return type;
	}
	
	public PlayerAction(String player, ActionType action) {
		this.player = player;
		value = action;
		type = NodeType.ACTION;
	}

	enum ActionType {
		CHECK("K"), BET("B"), CALL("C"), FOLD("F");

		ActionType(String code) {
			this.code = code;
		}

		String code;

		public String getCode() {
			return code;
		}
		
		@Override
		public String toString() {
			return code;
		}
	}

	@Override
	public boolean isPublic() {
		return true;
	}

	// player's action is public
	@Override
	public String playerInfoset() {
		return null;
	}

	@Override
	public ActionType getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return player+":"+ value.getCode();
	}

	@Override
	public String playerTurn() {
		return player;
	}

	@Override
	public String targetPlayer() {
		return player;
	}
}
