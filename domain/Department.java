package domain;

import java.util.ArrayList;
import java.util.List;

public class Department {
//
	String name;
	int parent_id;
	int id;
	List<Department> children = new ArrayList<>();
	Department parent = null;
	
	
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
	
	public void addChild(Department department) {
		this.children.add(department);
	}

	public List<Department> getChildren() {
		return children;
	}

	public void setChildren(List<Department> children) {
		this.children = children;
	}

	public Department getParent() {
		return parent;
	}

	public void setParent(Department parent) {
		this.parent = parent;
	}
	
	public void printChildren() {
		for(Department department : children) {
			System.out.println(" " + department);
		}
	}
	

}
