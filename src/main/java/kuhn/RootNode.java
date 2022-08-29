package kuhn;

public class RootNode implements Node {

	@Override
	public NodeType getType() {
		return NodeType.ROOT;
	}

	@Override
	public boolean isPublic() {
		return true;
	}

	@Override
	public String playerInfoset() {
		return null;
	}

	@Override
	public Object getValue() {
		return "R";
	}
	
	@Override
	public String toString() {
		return "R";
	}

	@Override
	public String playerTurn() {
		return null;
	}
	@Override
	public String targetPlayer() {
		return null;
	}
}
