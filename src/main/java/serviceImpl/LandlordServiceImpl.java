package serviceImpl;

import dao.ApplyDao;
import dao.HotelDao;
import dao.RoomDao;
import entity.Apply;
import entity.Hotel;
import entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.LandlordService;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by marioquer on 2017/3/17.
 */
@Service
public class LandlordServiceImpl implements LandlordService{
    @Autowired
    ApplyDao applyDao;
    @Autowired
    HotelDao hotelDao;
    @Autowired
    RoomDao roomDao;

    @Override
    public boolean createHotel(Integer owner_id, String phone, String name, Integer small_num, Integer big_num, String address, String introduction, Double big_price, Double small_price) {
        byte bit = 0;
        Timestamp time = new Timestamp(System.currentTimeMillis());
        Apply apply = new Apply();
        System.out.println(owner_id);
        apply.setOwnerId(owner_id);
        apply.setPhone(phone);
        apply.setName(name);
        apply.setSmallNum(small_num);
        apply.setBigNum(big_num);
        apply.setAddress(address);
        apply.setIntroduction(introduction);
        apply.setBigPrice(big_price);
        apply.setSmallPrice(small_price);
        apply.setType(bit);
        apply.setStatus(bit);
        apply.setApplyTime(time);
        System.out.println(apply.getName());
        return applyDao.addApply(apply);
    }

    @Override
    public Map<String, Object> getMyHotel(Integer id) {
        Map<String,Object> map = new HashMap<String,Object>();
        Hotel hotel = hotelDao.getHotelByOwner(id);
        Apply apply = applyDao.getApplyByOwner(id);
        if (hotel!=null){
            List<Room> rooms = roomDao.getRoomsByHotel(hotel.getId());
            map.put("state","approved");
            map.put("hotel",hotel);
            if (rooms!=null){
                if (rooms.get(0).getRoomStyle()==0) {
                    map.put("small_room", rooms.get(0));
                    map.put("big_room", rooms.get(1));
                }else {
                    map.put("big_room", rooms.get(0));
                    map.put("small_room", rooms.get(1));
                }
            }
        }else{
            if (apply!=null&&apply.getStatus()==0){
                map.put("state","suspend");
                map.put("apply",apply);
            }else {
                map.put("state","none");
            }
        }
        return map;
    }

    public static void main(String[] args){
        String time= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Timestamp a = new Timestamp(System.currentTimeMillis());
        System.out.println(a);
        System.out.println("aaaa");
    }
}
