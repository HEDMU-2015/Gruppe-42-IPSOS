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
		printTree(tree, new Integer(0));
		// Iterator<Integer> itr =
		// tree.get(2).getChildren().get(4).getChildren().keySet().iterator();
		// while(itr.hasNext()) {
		// Department d =
		// tree.get(2).getChildren().get(4).getChildren().get(itr.next());
		// System.out.println(d.getName());
		// }
	}

	public static void buildTree(Map<Integer, Department> tree) {
		Iterator<Integer> itr = tree.keySet().iterator();
		while (itr.hasNext()) {
			Department d = tree.get(itr.next());
			int parent_id = d.getParent_id();
			if (tree.containsKey(parent_id)) {
				tree.get(parent_id).addChild(d.getId(), d);
				if (parent_id > 0) {
					keysToRemove.add(d.getId());
				}
				buildTree(tree.get(parent_id).getChildren());
			}
		}
	}

	public static void printTree(Map<Integer, Department> tree, Integer level) {
		Iterator<Integer> itr = tree.keySet().iterator();
		while (itr.hasNext()) {
			Department d = tree.get(itr.next());
			if (!d.getChildren().isEmpty()) {
				if (level == 0) {
					System.out.println(d.getName());
					level++;
				} else {
					if (d.getParent_id() == 0) {
						level = 0;
					}
					System.out.println(String.join("", Collections.nCopies(level++, " ")) + d.getName());
				}
				printTree(d.getChildren(), level);
			} else {
				System.out.println(String.join("", Collections.nCopies(level--, " ")) + d.getName());
			}
		}
	}
}
