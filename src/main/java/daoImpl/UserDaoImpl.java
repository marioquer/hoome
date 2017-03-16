package daoImpl;

import dao.UserDao;
import entity.User;
import helper.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
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
            criteria.add(Restrictions.eq("id",id));
            List<User> list = criteria.list();

            if(list.size()==0){
                System.out.println("aaa");
                return null;
            }else{
                User user = list.get(0);
                HibernateUtil.closeSession();
                return user;
            }
        }catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.closeSession();
            return null;
        }
    }

    @Override
    public User getUser(String phone) {
        try {
            session = HibernateUtil.currentSession();
            criteria = session.createCriteria(entity.User.class);
            criteria.add(Restrictions.eq("phone",phone));
            List<User> list = criteria.list();

            if(list.size()==0){
                System.out.println("aaa");
                return null;
            }else{
                User user = list.get(0);
                HibernateUtil.closeSession();
                return user;
            }
        }catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.closeSession();
            return null;
        }
    }
}
