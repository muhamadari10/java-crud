package belajarjava.todolist;

import belajarjava.todolist.repository.TodolistRepository;
import belajarjava.todolist.repository.TodolistRepositoryImpl;
import belajarjava.todolist.service.TodolistServiceImpl;
import org.junit.jupiter.api.Test;


public class TodolistRepositoryTest {

    @Test
    void addTodo() {
        TodolistRepositoryImpl repository = new TodolistRepositoryImpl();
        repository.addTodo("Makan makan todo");
    }

    @Test
    void removeTodo() {
        TodolistRepositoryImpl repository = new TodolistRepositoryImpl();
        TodolistServiceImpl service = new TodolistServiceImpl(repository);
        service.showTodolist();

        repository.removeTodo(1);

        service.showTodolist();
    }

    @Test
    void updateTodo() {
        TodolistRepositoryImpl todoRepo = new TodolistRepositoryImpl();
        TodolistServiceImpl todoService = new TodolistServiceImpl(todoRepo);
        todoService.showTodolist();
        todoRepo.updateTodo(4, "makan makan kucing");

        todoService.showTodolist();
    }
}
