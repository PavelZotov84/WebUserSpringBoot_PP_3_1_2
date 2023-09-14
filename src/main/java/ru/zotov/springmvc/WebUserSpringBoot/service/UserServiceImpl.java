package ru.zotov.springmvc.WebUserSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zotov.springmvc.WebUserSpringBoot.dao.UsersDao;
import ru.zotov.springmvc.WebUserSpringBoot.models.User;


import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersDao userDao;


    @Override
    public List<User> getAllUsers() {
        return userDao.listUsers();
    }

    @Override
    public void createUser(User user) {
        userDao.add(user);
    }

    @Override
    public User readUser(int id) {
        return userDao.readUser(id);
    }


    @Override
    public void update(int id, User updatedUser) {
        userDao.update(id, updatedUser);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}
