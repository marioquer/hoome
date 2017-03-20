package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.LandlordService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by marioquer on 2017/3/17.
 */
@Controller
@RequestMapping(value = "/landlord")
public class LandlordController {
    @Autowired
    LandlordService landlordService;

    @RequestMapping(value = "/myHotel", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> myHotel(Integer id) {
        Map<String, Object> json = landlordService.getMyHotel(id);
        //json.put("state", "success");
        return json;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String createHotel(Integer owner_id,
                              String phone,
                              String name,
                              Integer small_num,
                              Integer big_num,
                              String address,
                              String introduction,
                              Double big_price,
                              Double small_price) {
        System.out.println(owner_id);
        boolean result = landlordService.createHotel(owner_id, phone, name, small_num, big_num, address, introduction, big_price, small_price);
        if (result) {
            return "success";
        } else {
            return "fail";
        }
    }

    @RequestMapping(value = "/updateHotel", method = RequestMethod.POST)
    @ResponseBody
    public String createHotel(Integer owner_id,
                              String phone,
                              String name,
                              Integer small_num,
                              Integer big_num,
                              String address,
                              String introduction) {
        System.out.println(owner_id);
        boolean result = landlordService.updateHotel(owner_id, phone, name, small_num, big_num, address, introduction);
        if (result) {
            return "success";
        } else {
            return "fail";
        }
    }

    @RequestMapping(value = "/publishSpecial", method = RequestMethod.POST)
    @ResponseBody
    public String publishSpecial(Integer user_id, String time,Double smallprice,Double bigprice) {
        System.out.println(smallprice);
        System.out.println(bigprice);
        if(landlordService.publishSpecial(user_id,time,smallprice,bigprice)){
            return "success";
        }else{
            return "fail";
        }
    }


}
