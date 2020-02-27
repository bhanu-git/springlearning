package com.sb.todos;

import java.util.Date;

public class Todo {

	private int id;
	private String name;
	private Date targetData;
	public Todo() {
		
	}
	public Todo(int id, String name, Date date) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.targetData = date;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTargetData(Date date) {
		this.targetData = date;
	}
	
	public int getId() {
		return id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public String getName() {
		return name;
	}
	public Date getTargetData() {
		return targetData;
	}
}
