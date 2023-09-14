package ru.zotov.springmvc.WebUserSpringBoot.dao;


import ru.zotov.springmvc.WebUserSpringBoot.models.User;

import java.util.List;

public interface UsersDao {

    List<User> listUsers();

    void add(User user);

    void update(int id, User updatedUser);

    User readUser(int id);

    void delete(int id);
}
