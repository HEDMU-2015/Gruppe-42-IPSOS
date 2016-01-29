package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import domain.Department;

public class TestMain {
	static List<Integer> keysToRemove = new ArrayList<>();

	public static void main(String[] args) {
		Test testClass = new Test();
		Map<Integer, Department> tree;

		tree = testClass.test();

		buildTree(tree);
		for (Integer integer : keysToRemove) {
			tree.remove(integer);
		}
		printTree(tree, "");
		// Iterator<Integer> itr =
		// tree.get(1).getChildren().keySet().iterator();
		// while(itr.hasNext()) {
		// Department d =
		// tree.get(itr.next());
		// System.out.println(d.getName());
		// }
	}

	public static void buildTree(Map<Integer, Department> map) {
		Iterator<Integer> itr = map.keySet().iterator();
		while (itr.hasNext()) {
			Department d = map.get(itr.next());
			int parent_id = d.getParent_id();
			if (map.containsKey(parent_id)) {
				map.get(parent_id).addChild(d.getId(), d);
				if (parent_id > 0) {
					keysToRemove.add(d.getId());
				}
				buildTree(map.get(parent_id).getChildren());
			}
		}
	}

	public static void printTree(Map<Integer, Department> tree, String de) {
		Iterator<Integer> itr = tree.keySet().iterator();
		while (itr.hasNext()) {
			Department d = tree.get(itr.next());
			System.out.println(de + d.getName());
			if (!d.getChildren().isEmpty()) {
				printTree(d.getChildren(), de + " ");
			}
		}
	}
}
