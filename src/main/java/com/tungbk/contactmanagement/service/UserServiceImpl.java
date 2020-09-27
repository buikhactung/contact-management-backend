package com.tungbk.contactmanagement.service;

import com.tungbk.contactmanagement.DAO.UserDAO;
import com.tungbk.contactmanagement.DTO.ResponseRestAPI;
import com.tungbk.contactmanagement.DTO.SearchUserDTO;
import com.tungbk.contactmanagement.DTO.UserDTO;
import com.tungbk.contactmanagement.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDAO userDAO;

    @Override
    public ResponseRestAPI add(UserDTO userDTO) {

        List objResponse = new ArrayList();
        logger.info("Add user: {}", userDTO);
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        userDAO.save(user);
        objResponse.add(user);
        return new ResponseRestAPI("add success", "201", objResponse);
    }

    @Override
    public ResponseRestAPI update(UserDTO userDTO) {
        List objResponse = new ArrayList();
        logger.info("Update user: {}", userDTO);
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        userDAO.save(user);
        objResponse.add(user);
        return new ResponseRestAPI("update success", "200", objResponse);
    }



    @Override
    public ResponseRestAPI delete(Long id) {
        userDAO.deleteById(id);
        return new ResponseRestAPI("delete success", "200", null);
    }

    @Override
    public ResponseRestAPI search(SearchUserDTO searchUserDTO) {
        List objResponse = new ArrayList();
        if (searchUserDTO.getName() == null || "".equals(searchUserDTO.getName())){
             objResponse = userDAO.findAll();
            Collections.sort(objResponse);
            return new ResponseRestAPI("Get All List success", "200", objResponse);
        }

        objResponse = userDAO.findAllByFirstNameContaining(searchUserDTO.getName());
        objResponse.addAll(userDAO.findAllByLastNameContaining(searchUserDTO.getName()));

        Collections.sort(objResponse);

        return new ResponseRestAPI("Find by name: " + searchUserDTO.getName(), "200", objResponse);
    }

    @Override
    public ResponseRestAPI getById(Long id) {
        User user = userDAO.findById(id).orElse(null);
        if (user == null) {
            return new ResponseRestAPI("Find by id: " + id, "404", null);
        }
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        List objResponse = new ArrayList();
        objResponse.add(userDTO);
        return new ResponseRestAPI("Find by id: " + id, "200", objResponse);
    }

}
