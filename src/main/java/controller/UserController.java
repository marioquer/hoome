package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by marioquer on 2017/3/13.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getUser(Integer id){
        Map<String, Object> userJson = new HashMap<String, Object>();
        userJson.put("state","success");
        userJson.put("data",userService.getUser(id));
        return userJson;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(String phone, String password){
        boolean result = userService.login(phone,password);
        if (result)
            return "success";
        else
            return "fail";
    }

}
