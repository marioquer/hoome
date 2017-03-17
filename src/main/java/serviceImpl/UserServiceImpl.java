package serviceImpl;

import dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by marioquer on 2017/3/13.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public Map<String, Object> login(String phone, String password) {
        User user = userDao.getUser(phone);
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("state",false);
        result.put("user",null);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                result.replace("state",false,true);
                result.replace("user",null,user);
                System.out.println(result.toString());
            }
        }
        return result;
    }

    @Override
    public User getUser(Integer id) {
        return userDao.getUser(id);
    }

    @Override
    public boolean logup(String phone, String name, String password, byte role) {
        return userDao.addUser(phone,name,password,role);
    }
}
