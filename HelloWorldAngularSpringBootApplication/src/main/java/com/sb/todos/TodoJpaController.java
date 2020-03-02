package com.sb.todos;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoJpaController {
	
	@Autowired
	private HardCodedTodoService todoService;
	
	@Autowired
	private TodoJpaRepository todoJpaRepository;
	
	//http://localhost:8080/jpa/users/bhanu/todos
	@GetMapping("/jpa/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){
		//return todoService.findAll();
		return todoJpaRepository.findByName(username);
	}
	
	//http://localhost:8080/jpa/users/bhanu/todos/2
	@GetMapping("/jpa/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username, @PathVariable int id){
		//return todoService.findById(id);
		//Optional<Todo> o = todoJpaRepository.findById(id);
		return todoJpaRepository.findById(id).get();
	}
	
	//http://localhost:8080/users/bhanu/todos/1
	@DeleteMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity deleteTodos(@PathVariable String username, @PathVariable int id) {
		
//		Todo todo =  todoService.deleteById(id);
//		if(todo!= null) {
//			return ResponseEntity.noContent().build();
//		}
//		
//		return ResponseEntity.notFound().build();
		todoJpaRepository.deleteById(id);
		return ResponseEntity.noContent().build();
		
	}
	
	//Edit/Update a TODO
	//PUT users/{username}/todos/{id}
	@PutMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable int id, @RequestBody Todo todo){
		//Todo updatedTodo = todoService.save(todo);
		Todo updatedTodo = todoJpaRepository.save(todo);
		return new ResponseEntity<Todo>(todo,HttpStatus.OK);
	}
	
	//create Todo
	//POST users/{username}/todos
	@PostMapping("/jpa/users/{username}/todos")
	public ResponseEntity<Void> updateTodo(@PathVariable String username, @RequestBody Todo todo){
		//Todo createdTodo = todoService.save(todo);
		Todo createdTodo = todoJpaRepository.save(todo);
		//location
		//get current url + {id}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
