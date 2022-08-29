package kuhn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import kuhn.PlayerAction.ActionType;

public class NodePath {

	List<Node> nodes;
	int[] antes = { 0, 0 };
	// whether the player is in the hand
	GamePlayerResult[] playerState = { null, null };
	int[] points = { 0, 0 };
	int[] payoffs = { 0, 0 };

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
		// playerState
		System.arraycopy(playerState, 0, res.playerState, 0, playerState.length);
		// points
		System.arraycopy(points, 0, res.points, 0, points.length);
		// antes
		System.arraycopy(antes, 0, res.antes, 0, antes.length);
		// add ante
		int playerTurnIndex = mapPlayerToIndex(node.playerTurn());
		int playerTargetIndex = mapPlayerToIndex(node.targetPlayer());
		switch (node.getType()) {
		case CARD:
			DealCard dealCard = (DealCard) node;
			res.antes[playerTargetIndex]++;
			int point = mapCardToPointStrength(dealCard.getValue());
			res.points[playerTargetIndex] = point;
			res.playerState[playerTargetIndex] = GamePlayerResult.IN;
			break;
		case ACTION:
			ActionType action = ((PlayerAction) node).getValue();
			switch (action) {
			case BET:
			case CALL:
				if (playerTurnIndex == -1) {
					System.out.println(-1);
				}
				res.antes[playerTurnIndex]++;
				break;
			case FOLD:
				res.playerState[playerTurnIndex] = GamePlayerResult.OUT;
			default:
			}
		default:
		}
		return res;
	}

	private int mapCardToPointStrength(String card) {
		switch (card) {
		case Cards.CARD_J:
			return 1;
		case Cards.CARD_Q:
			return 2;
		case Cards.CARD_K:
			return 3;
		default:
			return -1;
		}
	}

	private int mapPlayerToIndex(String player) {
		if (player == null) {
			return -1;
		}
		switch (player) {
		case Players.PLAYER_A:
			return 0;
		case Players.PLAYER_B:
			return 1;
		default:
			return -1;
		}
	}

	static final boolean PRINT_ANTE_POINTS_STATES = false;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("NodePath[");
		/*
		 * for (Node node : nodes) { sb.append(node); sb.append(" "); } sb.append("]");
		 */
		// antes
		if (PRINT_ANTE_POINTS_STATES) {
			sb.append(" antes=");
			sb.append(Arrays.toString(antes));
			// points
			sb.append(" points=");
			sb.append(Arrays.toString(points));
			// states
			sb.append(" states=");
			sb.append(Arrays.toString(playerState));
		}
		// compact infoset
		sb.append(" compact=");
		sb.append(compactCompleteInfoSet());
		// infoset playerA
		sb.append("\tinfoA=");
		sb.append(infosetPlayerA());
		// infoset playerB
		sb.append("\tinfoA=");
		sb.append(infosetPlayerB());
		// payoffs
		sb.append(" payoffs=");
		sb.append(Arrays.toString(payoffs));

		return sb.toString();
	}

	private String infosetPlayerB() {
		return infoSetPlayer(Players.PLAYER_B);
	}

	private String infosetPlayerA() {
		return infoSetPlayer(Players.PLAYER_A);
	}

	enum GamePlayerResult {
		IN, OUT;
	}

	void computePayoff() {
		int playerA = 0;
		int playerB = 1;

		payoffs = new int[] { 0, 0 };
		payoffs[playerA] -= antes[playerA];
		payoffs[playerB] -= antes[playerB];
		int potSize = antes[0] + antes[1];

		int playerWihStrongestPoint = points[playerA] > points[playerB] ? playerA : playerB;

		int winningPlayer;
		if (playerState[playerA] == GamePlayerResult.OUT)
			winningPlayer = playerB;
		else if (playerState[playerB] == GamePlayerResult.OUT)
			winningPlayer = playerA;
		else
			winningPlayer = playerWihStrongestPoint;

		payoffs[winningPlayer] += potSize;
	}

	public String compactCompleteInfoSet() {
		StringBuilder res = new StringBuilder();
		for (var node : nodes) {
			Object value = node.getValue();
			res.append(value);
		}
		// pad to length 6
		while (res.length() < 6)
			res.append(" ");
		return res.toString();
	}

	public String infoSetPlayerA() {
		return in
	}

	public String infoSetPlayer(String player) {
		StringBuilder res = new StringBuilder();
		for (var node : nodes) {
			String playerInfosetNode = node.playerInfoset();
			res.append(playerInfosetNode == null || playerInfosetNode.equals(player) ? node.getValue() : "?");
		}
		// pad to length 6
		while (res.length() < 6)
			res.append(" ");
		return res.toString();
	}

	/*
	 * given a path (compact=RJKKBF infoA=RJ?KBF infoA=R?KKBF), it prints the
	 * variable names to be used as "edge probabilities". take into account the
	 * active players's turn and its infoset
	 */
	public List<String> listVars() {
		List<String> res = new LinkedList<>();
		String full = compactCompleteInfoSet();
		String infoA = infosetPlayerA();
		String infoB = infosetPlayerB();

		StringBuilder varA = new StringBuilder();
		StringBuilder varB = new StringBuilder();
		
		int c = 0;
		for (var node : nodes) {
			
			
			if(node.getType())
		}
		return res;
	}

}
