package com.tungbk.contactmanagement.controller;

import com.tungbk.contactmanagement.DTO.ResponseRestAPI;
import com.tungbk.contactmanagement.DTO.SearchUserDTO;
import com.tungbk.contactmanagement.DTO.UserDTO;
import com.tungbk.contactmanagement.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<ResponseRestAPI> createUser(@RequestBody UserDTO userDTO) {
        logger.info("REST Request to create user: {}", userDTO);
        ResponseRestAPI responseRestAPI = userService.add(userDTO);
        return new ResponseEntity<>(responseRestAPI, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ResponseRestAPI> updateUser(@RequestBody UserDTO userDTO) {
        logger.info("REST Request to update user: {}", userDTO);
        ResponseRestAPI responseRestAPI = userService.update(userDTO);
        return new ResponseEntity<>(responseRestAPI,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResponseRestAPI> deleteUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.delete(id), HttpStatus.OK);
    }

    @PostMapping("search")
    public ResponseEntity<ResponseRestAPI> getListUser(@RequestBody SearchUserDTO searchUserDTO){
        return new ResponseEntity<>(userService.search(searchUserDTO), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseRestAPI> findUserById(@PathVariable Long id){
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }
}
