package cn.uppp.example.controller;

import cn.uppp.example.common.Result;
import cn.uppp.example.entity.User;
import cn.uppp.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> list() {
        return userService.list();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @PostMapping
    public Result save(User user) {
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public Result remove(@PathVariable Integer id) {
        return userService.remove(id);
    }

    @PutMapping
    public Result update(User user) {
        return userService.update(user);
    }
}
