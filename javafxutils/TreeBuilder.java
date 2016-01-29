package javafxutils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import domain.Department;

public class TreeBuilder {

	private List<Integer> keysToRemove = new ArrayList<>();
	
	public void buildTree(Map<Integer, Department> map) {
		buildTree(0, map);
		for (Integer integer : keysToRemove) {
			map.remove(integer);
		}
	}
	
	private void buildTree(int i, Map<Integer, Department> map) {
		Iterator<Integer> itr = map.keySet().iterator();
		while (itr.hasNext()) {
			Department d = map.get(itr.next());
			int parent_id = d.getParent_id();
			if (map.containsKey(parent_id)) {
				map.get(parent_id).addChild(d.getId(), d);
				if (parent_id > 0) {
					keysToRemove.add(d.getId());
				}
				buildTree(i++, map.get(parent_id).getChildren());
			}
		}
	}
}
