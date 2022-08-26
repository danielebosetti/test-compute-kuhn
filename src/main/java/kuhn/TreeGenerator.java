package kuhn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class TreeGenerator {

	List<NodePath> generate() {
		
		NodePath path = NodePath.of(new RootNode());
		
		Collection<NodePath> paths = new ArrayList<>();
		paths.add(path);
		
		// compute all child nodes and paths for startNode
		paths = new DealCardGenerator().generateChildPaths(paths);
		paths = new DealCardGenerator().generateChildPaths(paths);
		paths = new PlayerActionGenerator().generateChildPaths(paths);
		paths = new PlayerActionGenerator().generateChildPaths(paths);
		paths = new PlayerActionGenerator().generateChildPaths(paths);
		
		for(var p:paths) {
			System.out.println(p);
		}

		// compute all child paths
		
		// until we arrive to the payoff
		
		// 
		
		return null;
	}
}
