package service;

import entity.User;

/**
 * Created by marioquer on 2017/3/13.
 */
public interface UserService {
    User getUser(Integer id);

    boolean login(String phone,String password);
}
