package belajarjava.todolist;

import belajarjava.todolist.entity.Todolist;
import belajarjava.todolist.repository.TodolistRepositoryImpl;
import belajarjava.todolist.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CrudTest {

    private EntityManagerFactory entityManagerFactory;

    @BeforeEach
    void setup(){
        entityManagerFactory = JpaUtil.getEntityManagerFactory();
    }

    @Test
    void insert() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Todolist todolist = new Todolist();
        todolist.setTodo("todo 1");

        entityManager.persist(todolist);

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void findTodolist(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Todolist todolist = entityManager.find(Todolist.class, 1);
        Assertions.assertEquals("todo 1", todolist.getTodo());


        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void updateTodolist() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Todolist todolist = entityManager.find(Todolist.class, "1");
        todolist.setTodo("todo 1 update");
        entityManager.merge(todolist);

        entityTransaction.commit();
        entityManager.close();
    }


    @Test
    void findAll(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        List<Todolist> todolist = entityManager.createQuery("from Todolist ").getResultList();

        todolist.forEach(System.out::println);

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void showTodolist() {
        TodolistRepositoryImpl service = new TodolistRepositoryImpl();
        List<Todolist> todolist = service.findAll();

        todolist.forEach(t -> System.out.println(t.getTodo()));
    }
}
