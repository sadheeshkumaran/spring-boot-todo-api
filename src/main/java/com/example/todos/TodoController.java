package com.example.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos") // All endpoints in this class will start with /api/todos.
public class TodoController {

    @Autowired // Spring automatically injects an instance of TodoRepository.
    private TodoRepository todoRepository;

    // GET /api/todos - Get all to-do items
    @GetMapping
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    // POST /api/todos - Create a new to-do item
    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        // The check has been removed. If the 'completed' field is omitted in the
        // request body, it will automatically default to 'false' which is the desired behavior.
        return todoRepository.save(todo);
    }

    // GET /api/todos/{id} - Get a single to-do item
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        return todoRepository.findById(id)
                .map(ResponseEntity::ok) // If found, return 200 OK with the todo
                .orElse(ResponseEntity.notFound().build()); // If not found, return 404 Not Found
    }

    // PUT /api/todos/{id} - Update a to-do item
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todoDetails) {
        return todoRepository.findById(id)
                .map(existingTodo -> {
                    existingTodo.setTitle(todoDetails.getTitle());
                    existingTodo.setCompleted(todoDetails.isCompleted());
                    Todo updatedTodo = todoRepository.save(existingTodo);
                    return ResponseEntity.ok(updatedTodo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/todos/{id} - Delete a to-do item
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTodo(@PathVariable Long id) {
        return todoRepository.findById(id)
                .map(todo -> {
                    todoRepository.delete(todo);
                    // Return 204 No Content, a standard practice for successful deletions.
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

