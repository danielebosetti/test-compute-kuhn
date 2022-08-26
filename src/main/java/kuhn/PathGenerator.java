package kuhn;

import java.util.Collection;
import java.util.LinkedList;

public interface PathGenerator {
	
	default public Collection<NodePath> generateChildPaths(Collection<NodePath> paths) {
		LinkedList<NodePath> res = new LinkedList<>();
		for(NodePath path:paths) {
			res.addAll(generateChildPaths(path));
		}
		return res;
	}

	Collection<NodePath> generateChildPaths(NodePath paths);

}
