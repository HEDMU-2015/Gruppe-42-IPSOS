package domain;

public class Department {
//
	String name;
	int parent_id;
	int id;
	
	
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
	
	
	

}
