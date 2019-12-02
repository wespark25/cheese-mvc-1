package org.launchcode.controllers;

import org.launchcode.models.User;
import org.launchcode.models.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("")
    public String index(Model model){
        model.addAttribute("users", UserData.getAll());
        return "user/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String newUser(Model model) {
        model.addAttribute(new User());
        model.addAttribute("checked", false);
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User user,
                      Errors errors){



        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("checked", true);

        if(errors.hasErrors()){
            user.setPassword("");
        return "user/add";}

        UserData.add(user);
        return "redirect:";
    }

}








//Three Steps of Model validation
//1. Add validation validation to fields in your model on the variables/properties you want checked
//(e.g. add @NotNull || @Size() to properties of the model you want to validate)
//
// 2. Validate the models within the controller where they are being created
//(e.g. add @Valid to where your binding the model to a handler parameter)
//
// 3. We check to make sure it valid (create a if statement that within the method handler that sends a error message)
// (This is easily done by adding a Errors object in the handler method parameter)
//
//4. Have tags within the appropriate template ready to display error messages.
// (here we used th:error which is provided by thymeleaf)

