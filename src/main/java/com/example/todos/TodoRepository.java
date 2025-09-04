package com.example.todos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Marks this as a Spring Data repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    // By extending JpaRepository, we get all standard CRUD methods for free.
    // No code is needed here.
}
