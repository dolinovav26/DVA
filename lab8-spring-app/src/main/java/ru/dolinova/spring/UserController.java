package ru.dolinova.spring;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.dolinova.spring.User;
import ru.dolinova.spring.db.UserDao;
@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserDao userDao;
    @RequestMapping(value = "/browse.html")
    public ModelAndView browse() throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("browse");
        List<User> users = new ArrayList<User>();
        users.addAll(userDao.findAll());
        mav.addObject(users);
        return mav;
    }
    @RequestMapping(value = "/add.html", method = RequestMethod.GET)
    public String add(Model model) throws Exception {
        model.addAttribute(new User());
        return "add";
    }
    @RequestMapping(value = "/add.html", method = RequestMethod.POST)
    public String save(User user) throws Exception {
        userDao.create(user);
        return "redirect:browse.html";
    }
}
