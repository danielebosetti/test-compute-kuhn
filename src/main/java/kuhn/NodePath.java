package kuhn;

import java.util.ArrayList;
import java.util.List;

public class NodePath {

	List<Node> nodes;

	public NodePath() {
		nodes = new ArrayList<>();
	}
	public static NodePath of(Node node) {
		return new NodePath().withChild(node);
	}
	
	int size() {
		return nodes.size();
	}
	
	Node lastNode() {
		return nodes.size() > 0 ? nodes.get(nodes.size() - 1) : null;
	}

	// build a copy of this path, followed by the given node
	public NodePath withChild(Node node) {
		NodePath res = new NodePath();
		res.nodes.addAll(nodes);
		res.nodes.add(node);
		return res;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("NodePath[");
		for (Node node : nodes) {
			sb.append(node);
			sb.append(" ");
		}
		sb.append("]");
		return sb.toString();
	}

}
