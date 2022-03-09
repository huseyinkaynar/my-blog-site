package com.blogsite.blog.controller;

import com.blogsite.blog.domain.constant.ControllerConstrant;
import com.blogsite.blog.domain.data.ServiceResponseData;
import com.blogsite.blog.domain.data.UserDto;
import com.blogsite.blog.domain.enums.ProcessStatus;
import com.blogsite.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hkaynar on 12.12.2021
 */
@RestController
@RequestMapping(ControllerConstrant.VERSION_V1 + ControllerConstrant.USERS)
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping
    public ServiceResponseData getUsers() {
        var users = userService.getUsers();
        var responseData = new ServiceResponseData();
        responseData.setData(users);
        responseData.setStatus(ProcessStatus.SUCCESS);
        return responseData;
    }

    @GetMapping(ControllerConstrant.ID)
    public ServiceResponseData getUser(@PathVariable long id) {
        var user = userService.getUser(id);
        var responseData = new ServiceResponseData();
        responseData.setData(user);
        responseData.setStatus(ProcessStatus.SUCCESS);
        return responseData;
    }

    @PostMapping
    public ServiceResponseData saveUser(@RequestBody UserDto userDto) {
        userService.save(userDto);
        var responseData = new ServiceResponseData();
        responseData.setStatus(ProcessStatus.SUCCESS);
        return responseData;
    }

    @PutMapping(ControllerConstrant.ID)
    public ServiceResponseData updateUser(@RequestBody UserDto userDto, @PathVariable long id) {
        userService.update(userDto, id);
        var responseData = new ServiceResponseData();
        responseData.setStatus(ProcessStatus.SUCCESS);
        return responseData;
    }

    @DeleteMapping(ControllerConstrant.ID)
    public ServiceResponseData deleteUser(@PathVariable long id) {
        userService.delete(id);
        var responseData = new ServiceResponseData();
        responseData.setStatus(ProcessStatus.SUCCESS);
        return responseData;
    }

}
