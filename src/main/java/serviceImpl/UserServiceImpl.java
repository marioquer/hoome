package serviceImpl;

import dao.PointDao;
import dao.UserDao;
import dao.VipCardDao;
import dao.VipRecordDao;
import entity.User;
import entity.VipCard;
import entity.VipRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by marioquer on 2017/3/13.
 */
@Service
public class UserServiceImpl implements UserService {
    public static Long ONE_YEAR_MILLI = 31536000000L;

    @Autowired
    UserDao userDao;
    @Autowired
    VipCardDao vipCardDao;
    @Autowired
    VipRecordDao vipRecordDao;
    @Autowired
    PointDao pointDao;

    @Override
    public Map<String, Object> login(String phone, String password) {
        User user = userDao.getUser(phone);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("state", false);
        result.put("user", null);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                result.replace("state", false, true);
                result.replace("user", null, user);
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
        return userDao.addUser(phone, name, password, role);
    }

    @Override
    public boolean newVip(Integer id) {
        byte zero = 0, one = 1;
        Timestamp time = new Timestamp(System.currentTimeMillis());
        Timestamp expire_time = new Timestamp(System.currentTimeMillis() + ONE_YEAR_MILLI);
        VipCard vipCard = new VipCard();
        vipCard.setUserId(id);
        vipCard.setBalance(0);
        vipCard.setLevel(zero);
        vipCard.setPoint(0);
        vipCard.setCreatedAt(time);
        vipCard.setUpdatedAt(time);
        vipCard.setExpiredAt(expire_time);
        vipCard.setStatus(zero);
        User user = userDao.getUser(id);
        user.setIsVip(one);
        return vipCardDao.addVip(vipCard) && userDao.updateUser(user);
    }

    @Override
    public boolean activateVip(Integer id, Double balance, String bank_card) {
        Timestamp update_time = new Timestamp(System.currentTimeMillis());
        Timestamp expire_time = new Timestamp(System.currentTimeMillis() + ONE_YEAR_MILLI);
        VipCard vipCard = vipCardDao.getVipCardByUserId(id);
        vipCard.setUpdatedAt(update_time);
        vipCard.setExpiredAt(expire_time);
        vipCard.setBalance(balance);
        vipCard.setStatus((byte) 1);
        User user = userDao.getUser(id);
        user.setIsVip((byte) 2);
        VipRecord vipRecord = new VipRecord();
        vipRecord.setVipId(vipCard.getId());
        vipRecord.setInOut(balance);
        vipRecord.setBalance(balance);
        vipRecord.setCreatedAt(update_time);
        vipRecord.setType((byte) 0);//正常
        return vipCardDao.updateVip(vipCard) && userDao.updateUser(user) && vipRecordDao.addRecord(vipRecord);
    }

    @Override
    public boolean topUp(Integer user_id, Double money) {
        Timestamp update_time = new Timestamp(System.currentTimeMillis());
        Timestamp expire_time = new Timestamp(System.currentTimeMillis() + ONE_YEAR_MILLI);
        VipCard vipCard = vipCardDao.getVipCardByUserId(user_id);
        vipCard.setBalance(vipCard.getBalance() + money);
        vipCard.setUpdatedAt(update_time);
        vipCard.setExpiredAt(expire_time);
        VipRecord vipRecord = new VipRecord();
        vipRecord.setVipId(vipCard.getId());
        vipRecord.setInOut(money);
        vipRecord.setBalance(vipCard.getBalance());
        vipRecord.setType((byte) 0);
        vipRecord.setCreatedAt(update_time);
        return vipCardDao.updateVip(vipCard) && vipRecordDao.addRecord(vipRecord);
    }

    @Override
    public Map<String, Object> getMyVip(Integer id) {
        Map<String ,Object> result = new HashMap<String, Object>();
        VipCard vipCard = vipCardDao.getVipCard(id);
        result.put("vipCard",vipCard);
        result.put("vipRecords",vipRecordDao.getRecords(vipCard.getId()));
        result.put("point",pointDao.getPointRecords(vipCard.getId()));
        return result;
    }
}
