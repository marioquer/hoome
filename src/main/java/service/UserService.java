package service;

import entity.User;

import java.util.Map;

/**
 * Created by marioquer on 2017/3/13.
 */
public interface UserService {
    User getUser(Integer id);

    Map<String, Object> login(String phone, String password);

    boolean logup(String phone,String name, String password,byte role);
}
