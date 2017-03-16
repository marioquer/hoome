package serviceImpl;

import dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

/**
 * Created by marioquer on 2017/3/13.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public boolean login(String phone, String password) {
        User user = userDao.getUser(phone);
        if (user == null) {
            return false;
        } else {
            if (user.getPassword().equals(password)) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public User getUser(Integer id) {
        return userDao.getUser(id);
    }
}
