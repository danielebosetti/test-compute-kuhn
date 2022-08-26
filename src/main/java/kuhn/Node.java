package kuhn;

public interface Node {

	NodeType getType();
	boolean isPublic();
	// if public, the playerInfoset is null and it is never used
	String playerInfoset();
	Object getValue();
	
}
