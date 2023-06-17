package com.bushrdd.bushrddwebserver.controller;

import com.bushrdd.bushrddwebserver.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.bushrdd.bushrddwebserver.utils.Result.OK;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.println(username);
        System.out.println(password);
        // userService.addUser(username, password);
        userService.findUserByName(username);
        return OK();
    }
}
