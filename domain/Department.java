package domain;

public class Department {

	String name;
	String parent_id;
	int id;
	
	
	public Department(int id, String name, String parent_id) {
		this.name = name;
		this.parent_id = parent_id;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	

}
