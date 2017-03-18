package serviceImpl;

import dao.UserDao;
import dao.VipCardDao;
import entity.User;
import entity.VipCard;
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

    @Override
    public boolean newVip(Integer id) {
        byte zero = 0;
        Timestamp time = new Timestamp(System.currentTimeMillis());
        Timestamp expire_time = new Timestamp(System.currentTimeMillis()+ONE_YEAR_MILLI);
        VipCard vipCard = new VipCard();
        vipCard.setUserId(id);
        vipCard.setBalance(0);
        vipCard.setLevel(zero);
        vipCard.setPoint(0);
        vipCard.setCreatedAt(time);
        vipCard.setExpiredAt(expire_time);
        vipCard.setStatus(zero);
        return vipCardDao.addVip(vipCard);
    }

}
