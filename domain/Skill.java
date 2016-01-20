package domain;

public class Skill {
 
	int id, departmentId;
	String name;
	
	public Skill(int id, String name, int departmentId) {
		this.id = id;
		this.name = name;
		this.departmentId = departmentId;
	}
	
	public Skill(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Skill(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
 
	public void setId(int id)  {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	
	
	
}
