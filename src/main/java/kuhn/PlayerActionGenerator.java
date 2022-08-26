package kuhn;

import java.util.Collection;
import java.util.LinkedList;

import kuhn.PlayerAction.ActionType;

public class PlayerActionGenerator implements PathGenerator {

	@Override
	public Collection<NodePath> generateChildPaths(NodePath path) {
		LinkedList<NodePath> res = new LinkedList<>();
		Node lastNode = path.lastNode();

		switch (lastNode.getType()) {
		case CARD:
			res.add(path.withChild(new PlayerAction(ActionType.CHECK)));
			res.add(path.withChild(new PlayerAction(ActionType.BET)));
			break;
		case ACTION:
			ActionType lastAction = (ActionType) lastNode.getValue();
			switch (lastAction) {
			case CHECK:
				// playerA can only act if playerB didn't check
				if (path.size() == 4) {
					res.add(path.withChild(new PlayerAction(ActionType.CHECK)));
					res.add(path.withChild(new PlayerAction(ActionType.BET)));
				} else {
					res.add(path);
				}
				break;
			case BET:
				res.add(path.withChild(new PlayerAction(ActionType.FOLD)));
				res.add(path.withChild(new PlayerAction(ActionType.CALL)));
				break;
			default:
				break;
			}

		default:
			break;
		}

		return res;
	}

}
