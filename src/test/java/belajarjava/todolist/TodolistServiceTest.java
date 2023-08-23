package belajarjava.todolist;

import belajarjava.todolist.repository.TodolistRepository;
import belajarjava.todolist.repository.TodolistRepositoryImpl;
import belajarjava.todolist.service.TodolistServiceImpl;
import org.junit.jupiter.api.Test;

public class TodolistServiceTest {

    @Test
    void showTodolist(){
        TodolistRepository todolistRepositoryImpl = new TodolistRepositoryImpl();
        TodolistServiceImpl service = new TodolistServiceImpl(todolistRepositoryImpl);
        service.showTodolist();
    }

    @Test
    void addTodolist(){
        TodolistRepositoryImpl todoRepository = new TodolistRepositoryImpl();
        TodolistServiceImpl todoService = new TodolistServiceImpl(todoRepository);

        todoService.addTodolist("Makan Kucing");
        todoService.showTodolist();
    }

    @Test
    void removeTodolist(){
        TodolistRepositoryImpl repository = new TodolistRepositoryImpl();
        TodolistServiceImpl service = new TodolistServiceImpl(repository);
        service.showTodolist();
        service.removeTodolist(2);
        service.removeTodolist(3);
        service.showTodolist();
    }

    @Test
    void updateTodolist(){
        TodolistRepositoryImpl repository = new TodolistRepositoryImpl();
        TodolistServiceImpl service = new TodolistServiceImpl(repository);
        service.showTodolist();
        service.updateTodo(3, "update makanan kucing");
        service.updateTodo(4, "update makanan kucing");
        service.showTodolist();
    }

}
