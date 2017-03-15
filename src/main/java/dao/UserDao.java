package dao;

import entity.User;

/**
 * Created by marioquer on 2017/3/13.
 */
public interface UserDao {
    User getUser(Integer id);
    User getUser(String phone);
}
