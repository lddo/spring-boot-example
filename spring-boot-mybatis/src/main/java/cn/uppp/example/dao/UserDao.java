package cn.uppp.example.dao;

import cn.uppp.example.entity.User;

import java.util.List;

public interface UserDao {

    List<User> list();

    User getById(Integer id);

    int save(User user);

    int remove(Integer id);

    int update(User user);
}
