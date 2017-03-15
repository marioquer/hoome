package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by marioquer on 2017/3/11.
 */

@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView welcome(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("common/welcome");
        return mv;
    }

    /*
    * user view
    */
    @RequestMapping(value = "/user/account", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView userAccount(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/account");
        return mv;
    }

    @RequestMapping(value = "/user/hotel", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView userHotel(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/hotel");
        return mv;
    }

    @RequestMapping(value = "/user/order", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView userOrder(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/order");
        return mv;
    }

    @RequestMapping(value = "/user/statistics", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView userStatistics(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/statistics");
        return mv;
    }

    /*
       landlord view
    */
    @RequestMapping(value = "/landlord/check-in-out", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView landlordCheckInOut(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("landlord/check-in-out");
        return mv;
    }

    @RequestMapping(value = "/landlord/hotel-info", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView landlordHotelInfo(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("landlord/hotel-info");
        return mv;
    }

    @RequestMapping(value = "/landlord/statistics", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView landlordStatistics(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("landlord/statistics");
        return mv;
    }

    /*
    * manager view
    * */
    @RequestMapping(value = "/manager/apply", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView managerApply(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("manager/apply");
        return mv;
    }

    @RequestMapping(value = "/manager/statistics", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView managerStatistics(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("manager/statistics");
        return mv;
    }

}
