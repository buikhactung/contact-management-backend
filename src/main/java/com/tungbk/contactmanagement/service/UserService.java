package com.tungbk.contactmanagement.service;

import com.tungbk.contactmanagement.DTO.ResponseRestAPI;
import com.tungbk.contactmanagement.DTO.SearchUserDTO;
import com.tungbk.contactmanagement.DTO.UserDTO;
import com.tungbk.contactmanagement.model.User;

public interface UserService {
    ResponseRestAPI add(UserDTO userDTO);
    ResponseRestAPI update(UserDTO userDTO);
    ResponseRestAPI delete(Long id);
    ResponseRestAPI search(SearchUserDTO searchUserDTO);
    ResponseRestAPI getById(Long id);
}
