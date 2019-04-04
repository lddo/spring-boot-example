package cn.uppp.example.service.impl;

import cn.uppp.example.common.Result;
import cn.uppp.example.dao.UserDao;
import cn.uppp.example.entity.User;
import cn.uppp.example.service.UserService;
import cn.uppp.example.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 获取用户列表
     *
     * @return
     */
    @Override
    public List<User> list() {
        return userDao.list();
    }

    /**
     * 按ID获取用户
     *
     * @param id
     * @return
     */
    @Override
    public User getById(Integer id) {
        return userDao.getById(id);
    }

    /**
     * 保存用户
     *
     * @param user
     * @return
     */
    @Override
    public Result save(User user) {
        return ResultUtils.matchFailure(userDao.save(user));
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public Result remove(Integer id) {
        return ResultUtils.matchFailure(userDao.remove(id));
    }

    /**
     * 更新
     *
     * @param user
     * @return
     */
    @Override
    public Result update(User user) {
        return ResultUtils.matchFailure(userDao.update(user));
    }

}
