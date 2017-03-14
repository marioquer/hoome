package daoImpl;

import dao.UserDao;
import entity.User;
import helper.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by marioquer on 2017/3/13.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public User getUser(Integer id) {
        Session session = HibernateUtil.currentSession();
        Criteria criteria = session.createCriteria(entity.User.class);
        criteria.add(Expression.eq("id",id));
        List list = criteria.list();
        User user = (User)list.get(0);
        return user;
    }
}
