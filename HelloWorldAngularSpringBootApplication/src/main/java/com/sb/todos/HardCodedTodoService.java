package com.sb.todos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class HardCodedTodoService {
	
	private static List<Todo> todos = new ArrayList<>();
	private static int count =0;
	
	static {
		todos.add(new Todo(++count,"BHANU",new Date()));
		todos.add(new Todo(++count,"PRAKASH",new Date()));
		todos.add( new Todo(++count,"KOLLI",new Date()));
	}
	
	//get the Todo list
	public List<Todo> findAll(){
		return todos;
	}
	
	//Create or Update Todo details logic
	public Todo save(Todo todo) {
		if(todo.getId()==-1 || todo.getId()==0) {
			todo.setId(++count);
			todos.add(todo);
		}else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
	
	//delete Todo logic
	public Todo deleteById(int id) {
		Todo todo = findById(id);
		if(todo == null) return null;
		if(todos.remove(todo)) {
			return todo;
		}
		
		return null;
	}

	public Todo findById(int id) {
		// TODO Auto-generated method stub
		for(Todo todo: todos) {
			if(todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
}
