package com.sb.todos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Todo {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="username")
	private String name; //name means Username.
	@Column(name = "target_date")
	private Date targetData;
	
	public Todo() {
		
	}
	public Todo(int id, String name, Date date) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.targetData = date;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTargetData(Date date) {
		this.targetData = date;
	}
	
	public Integer getId() {
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
