package com.sb.todos;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface TodoJpaRepository extends JpaRepository<Todo, Integer>{

	List<Todo> findByName(String username);  //Searching by username
}
