package kuhn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TreeGenerator {

	Collection<NodePath> generate() {
		
		NodePath path = NodePath.of(new RootNode());
		
		Collection<NodePath> paths = new ArrayList<>();
		paths.add(path);
		
		// compute all child nodes and paths for startNode
		paths = new DealCardGenerator().generateChildPaths(paths);
		System.out.println(paths);
		paths = new DealCardGenerator().generateChildPaths(paths);
		System.out.println(paths);
		paths = new PlayerActionGenerator().generateChildPaths(paths);
		System.out.println(paths);
		paths = new PlayerActionGenerator().generateChildPaths(paths);
		System.out.println(paths);
		paths = new PlayerActionGenerator().generateChildPaths(paths);
		
		dump(paths);

		// compute all child paths
		
		// until we arrive to the payoff
		
		// 
		return paths;
	}

	private void dump(Collection<NodePath> paths) {
		for(var p:paths) {
			System.out.println(p);
		}
	}
}
