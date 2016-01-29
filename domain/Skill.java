package domain;

public class Skill {
 //
	int id;
	String name;
	Department department;
	int departmentId;
	
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return name;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	
	
}
