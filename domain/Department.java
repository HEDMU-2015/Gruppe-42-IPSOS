package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Department {
//
	String name;
	int parent_id;
	int id;
	Map<Integer, Department> children = new HashMap<>();
	
	
	public Department(int id, String name, int parent_id) {
		this.name = name;
		this.parent_id = parent_id;
		this.id = id;
	}
	
	public Department(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return name;
	}
	
	public boolean isChild() {
		return this.parent_id != 0;
	}
	
	public void addChild(Integer id, Department department) {
		this.children.put(id, department);
	}

	public Map<Integer, Department> getChildren() {
		return children;
	}

	public void setChildren(Map<Integer, Department> children) {
		this.children = children;
	}

}
