package controller;

import entity.User;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    HttpSession session;

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getUser(Integer id) {
        Map<String, Object> userJson = new HashMap<String, Object>();
        User user = userService.getUser(id);
        userJson.put("state", "success");
        userJson.put("data", user);
        return userJson;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> login(HttpServletRequest request, String phone, String password) {
        Map<String, Object> result = userService.login(phone, password);
        Map<String, Object> json = new HashMap<>();
        User user = (User)result.get("user");
        session = request.getSession();
        System.out.println(result.get("state"));
        if (result.get("state").equals(Boolean.TRUE)) {
            if (session.getAttribute("user") == null)
                session.setAttribute("user", user);
            json.put("state","success");
            json.put("role",user.getRole());
            return json;
        } else {
            json.put("state","fail");
            return json;
        }
    }

    @RequestMapping(value = "/logup", method = RequestMethod.POST)
    @ResponseBody
    public String logup(String phone,String name, String password,byte role) {
        boolean result = userService.logup(phone,name,password,role);
        if (result)
            return "success";
        else
            return "fail";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public String logout(String id, HttpServletRequest request) {
        session = request.getSession();
        if (session.getAttribute("user")!=null){
            session.removeAttribute("user");
            return "success";
        }else{
            return "fail";
        }
    }

    @RequestMapping(value = "/newVip", method = RequestMethod.POST)
    @ResponseBody
    public String newVip(Integer id) {
        if (userService.newVip(id)){
            return "success";
        }else{
            return "fail";
        }
    }

    //test
    @RequestMapping(value = "/showSession", method = RequestMethod.GET)
    @ResponseBody
    public String show(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        return user.getPhone();
    }

}
