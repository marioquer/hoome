package service;

import entity.Room;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by marioquer on 2017/3/17.
 */
public interface LandlordService {
    Map<String, Object> getMyHotel(Integer id);

    boolean createHotel(Integer owner_id,
                        String phone,
                        String name,
                        Integer small_num,
                        Integer big_num,
                        String address,
                        String introduction,
                        Double big_price,
                        Double small_price);

    boolean updateHotel(Integer owner_id,
                        String phone,
                        String name,
                        Integer small_num,
                        Integer big_num,
                        String address,
                        String introduction);

    List<Room> getTargetRooms(Timestamp beginTime, Timestamp endTime, byte roomType);

    boolean publishSpecial(Integer user_id, String time, Double smallPrice, Double bigPrice);

}
