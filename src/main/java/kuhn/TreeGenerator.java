package kuhn;

import java.util.ArrayList;
import java.util.Collection;

public class TreeGenerator {

	Collection<NodePath> generate() {
		
		NodePath path = NodePath.of(new RootNode());
		
		Collection<NodePath> paths = new ArrayList<>();
		paths.add(path);
		
		// compute all child nodes and paths for startNode
		paths = new DealCardGenerator().generateChildPaths(paths);
		paths = new DealCardGenerator().generateChildPaths(paths);
		paths = new PlayerActionGenerator().generateChildPaths(paths);
		paths = new PlayerActionGenerator().generateChildPaths(paths);
		paths = new PlayerActionGenerator().generateChildPaths(paths);
		
		computePayoffs(paths);
		
		dump(paths);
		
		return paths;
	}

	private void computePayoffs(Collection<NodePath> paths) {
		for(var p:paths) {
			p.computePayoff();
		}
	}

	private void dump(Collection<NodePath> paths) {
		VarsCollector v = new VarsCollector();
		for(var p:paths) {
			//System.out.println(p);
			//System.out.println(p.listVars());
			System.out.println(p.getPayoffComponentExpression(v));
			System.out.println("+");
		}
		System.out.println(0);
		System.out.println();
		v.dumpVarsAsDoubles();
	}
}
