package ru.zotov.springmvc.WebUserSpringBoot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.zotov.springmvc.WebUserSpringBoot.models.User;

import java.util.List;

@Repository
public class UsersDaoImpl implements UsersDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void add(User user) {
        System.out.println("create new " + user);
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public void update(int id, User updatedUser) {
        entityManager.merge(updatedUser);
        entityManager.flush();
    }

    @Override
    public User readUser(int id) {
        System.out.println("user id - " + id);
        return entityManager.find(User.class, id);
    }

    @Override
    public void delete(int id) {
        User user = readUser(id);
        System.out.println("delete user- " + user);
        entityManager.remove(user);
        entityManager.flush();
    }
}
