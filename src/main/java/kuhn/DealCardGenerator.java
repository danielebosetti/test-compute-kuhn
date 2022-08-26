package kuhn;

import java.util.Collection;
import java.util.LinkedList;

public class DealCardGenerator implements PathGenerator {

	@Override
	public Collection<NodePath> generateChildPaths(NodePath paths) {
		LinkedList<NodePath> res = new LinkedList<>();
		Node lastNode = paths.lastNode();
		for (String card:Cards.CARDS) {
			NodePath newPath;
			switch (lastNode.getType()) {
			case ROOT:
				newPath = paths.withChild(new DealCard(Players.PLAYER_A, card));
				res.add(newPath);
				break;
			case CARD:
				if(card.equals(lastNode.getValue()))
					// card is already dealt
					continue;
				else
					newPath = paths.withChild(new DealCard(Players.PLAYER_B, card));
					res.add(newPath);
				break;
			default:
				throw new RuntimeException("cards are only dealt after root or after a card");
			}
		}
		return res;
	}

}
