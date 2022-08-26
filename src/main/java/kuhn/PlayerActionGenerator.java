package kuhn;

import java.util.Collection;
import java.util.LinkedList;

import kuhn.PlayerAction.ActionType;
import static kuhn.PlayerAction.ActionType.*;
import static kuhn.Players.*;

public class PlayerActionGenerator implements PathGenerator {

	@Override
	public Collection<NodePath> generateChildPaths(NodePath path) {
		LinkedList<NodePath> res = new LinkedList<>();
		Node lastNode = path.lastNode();

		switch (lastNode.getType()) {
		case CARD:
			res.add(path.withChild(new PlayerAction(PLAYER_A, CHECK)));
			res.add(path.withChild(new PlayerAction(PLAYER_A, BET)));
			break;
		case ACTION:
			ActionType lastAction = (ActionType) lastNode.getValue();
			switch (lastAction) {
			case CHECK:
				// only playerB can check after a check
				if (path.size() == 4) {
					res.add(path.withChild(new PlayerAction(PLAYER_B, CHECK)));
					res.add(path.withChild(new PlayerAction(PLAYER_B, BET)));
				} else {
					res.add(path);
				}
				break;
			case BET:
				String nextPlayer = path.size() % 2 == 1 ? PLAYER_A : PLAYER_B;
				res.add(path.withChild(new PlayerAction(nextPlayer, FOLD)));
				res.add(path.withChild(new PlayerAction(nextPlayer, CALL)));
				break;
			default:
				// case fold
				res.add(path);
				break;
			}

		default:
			break;
		}

		return res;
	}

}
