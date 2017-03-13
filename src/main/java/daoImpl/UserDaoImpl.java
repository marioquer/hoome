package daoImpl;

import dao.UserDao;
import entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by marioquer on 2017/3/13.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public User getUser(int id) {
        User user = new User();
        user.setId(1);
        user.setName("阙阙");
        return user;
    }
}
