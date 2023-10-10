package belajarjava.todolist.repository;

import belajarjava.todolist.entity.Todolist;
import belajarjava.todolist.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class TodolistRepositoryImpl implements TodolistRepository{

    private EntityManagerFactory entityManagerFactory;

    public TodolistRepositoryImpl() {
        entityManagerFactory = JpaUtil.getEntityManagerFactory();
    }

    @Override
    public void addTodo(String todo) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Todolist todolist = new Todolist();
        todolist.setTodo(todo);
        entityManager.persist(todolist);

        entityTransaction.commit();
        entityManager.close();
    }

    @Override
    public List<Todolist> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        List<Todolist> todolist = entityManager.createQuery("from Todolist ").getResultList();

        entityTransaction.commit();
        entityManager.close();

        return todolist;
    }



    @Override
    public void removeTodo(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Todolist todolist = entityManager.find(Todolist.class, id);

        if (todolist != null) {
            // Remove the entity
            entityManager.remove(todolist);
            System.out.println("Entity removed: ID=" + todolist.getId() + ", Name=" + todolist.getTodo());
        } else {
            System.out.println("Entity not found with ID: " + todolist.getId());
        }

        entityTransaction.commit();
        entityManager.close();
    }

    @Override
    public void updateTodo(Integer id, String todo) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Todolist todolist = entityManager.find(Todolist.class, id);

        if (todolist != null) {
            // Update the entity
            todolist.setTodo(todo);
            entityManager.merge(todolist);
            System.out.println("Entity removed: ID=" + todolist.getId() + ", Name=" + todolist.getTodo());
        } else {
            System.out.println("Entity not found with ID: " + todolist.getId());
        }

        entityTransaction.commit();
        entityManager.close();
    }
}
