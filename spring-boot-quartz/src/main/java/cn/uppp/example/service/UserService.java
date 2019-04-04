package cn.uppp.example.service;

import cn.uppp.example.common.Result;
import cn.uppp.example.entity.User;

import java.util.List;

public interface UserService {

    List<User> list();

    User getById(Integer id);

    Result save(User user);

    Result remove(Integer id);

    Result update(User user);
}
