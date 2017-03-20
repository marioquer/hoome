package daoImpl;

import dao.BookRecordDao;
import entity.BookRecord;
import helper.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by marioquer on 2017/3/17.
 */
@Repository
public class BookRecordDaoImpl implements BookRecordDao {
    private Session session;
    private Criteria criteria;

    @Override
    public boolean addRecord(BookRecord bookRecord) {
        return HibernateUtil.addObject(bookRecord);
    }

    @Override
    public boolean updateRecord(BookRecord bookRecord) {
        return HibernateUtil.updateObject(bookRecord);
    }

    @Override
    public List<BookRecord> getRecordByUser(Integer id) {
        try {
            session = HibernateUtil.currentSession();
            criteria = session.createCriteria(entity.BookRecord.class);
            criteria.add(Restrictions.eq("bookerId", id));
            List<BookRecord> list = criteria.list();

            if (list.size() == 0) {
                HibernateUtil.closeSession();
                return null;
            } else {
                HibernateUtil.closeSession();
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.closeSession();
            return null;
        }
    }
}
