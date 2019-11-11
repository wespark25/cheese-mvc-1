package org.launchcode.controllers;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("index")
    public String index(Model model){
        return "user/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String newUser(Model model) {
        model.addAttribute("checked", false);
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute User user, @RequestParam String verify){
        model.addAttribute("username", user.getUsername());
        if(verify.equals(user.getPassword())) {
            model.addAttribute("checked", true);
            index(model);
            return "user/index";}
        model.addAttribute("email", user.getEmail());
        model.addAttribute("checked", true);
        return "user/add";
    }

}
