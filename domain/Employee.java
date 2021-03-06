package domain;

import java.util.ArrayList;
import java.util.List;

public class Employee {
//
	private int id, matchingSkillsCount;
	private String name, email;
	private List<Skill> skills = new ArrayList<Skill>();
	
	public Employee(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public Employee(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public int getMatchingSkillsCount() {
		return matchingSkillsCount;
	}

	public void setMatchingSkillsCount(int matchingSkillsCount) {
		this.matchingSkillsCount = matchingSkillsCount;
	}

	
	
}
