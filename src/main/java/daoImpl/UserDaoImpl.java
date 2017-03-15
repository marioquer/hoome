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
    private Session session;
    private Criteria criteria;

    @Override
    public User getUser(Integer id) {
        try {
            session = HibernateUtil.currentSession();
            criteria = session.createCriteria(entity.User.class);
            criteria.add(Expression.eq("id",id));
            List list = criteria.list();
            User user = (User)list.get(0);
            return user;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User getUser(String phone) {
        try {
            session = HibernateUtil.currentSession();
            criteria = session.createCriteria(entity.User.class);
            criteria.add(Expression.eq("phone",phone));
            List list = criteria.list();
            User user = (User)list.get(0);
            return user;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
