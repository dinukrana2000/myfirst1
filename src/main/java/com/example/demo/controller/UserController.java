package com.example.demo.controller;

import com.example.demo.dto.Userdto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//The @RestController annotation in Spring Boot is a specialized version of the @Controller annotation. It's used to create RESTful web services by combining @Controller and @ResponseBody annotations, making it convenient for building APIs that return data in various formats like JSON or XML.
@RequestMapping(value = "api/v1/user")//map the http request
@CrossOrigin//use of two origins
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/getUser")
    public List<Userdto>  getUser(){

        return userService.getAllUsers();
    }
    @PostMapping("/postUser")
    public Userdto postUser(@RequestBody Userdto userdto){

        return userService.saveUser(userdto);
    }
    @PutMapping("/putUser")
    public Userdto putUser(@RequestBody Userdto userdto){

        return userService.updateUser(userdto);
    }
    @DeleteMapping("/deleteUser")
    public boolean deleteUser(@RequestBody Userdto userdto){

        return userService.deleteUser(userdto);
    }
    @GetMapping("/getUserById/{UserId}")
    public Userdto getUserid(@PathVariable String UserId){

        return userService.getUsersById(UserId);

    }

    @GetMapping("/getUsersByIdAndAddress/{UserId}/{address}")
    public Userdto getUsersByIdAndAddress(@PathVariable String UserId ,@PathVariable String address){
        return userService.getUsersByIdAndAddress(UserId,address);
    }

    @PutMapping("/updateUserById/{ID}/{Name}")
    public Userdto updateUserById(@PathVariable String ID,@PathVariable String Name){
        System.out.println("successfully updated");
        return userService.updateUserById(ID,Name);
    }
    @DeleteMapping("/deleteUserByAddress/{Address}")
    public boolean deleteUserByAddress(@PathVariable String Address){
        return userService.deleteUserByAddress(Address);

    }

}
