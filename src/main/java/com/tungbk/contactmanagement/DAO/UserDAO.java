package com.tungbk.contactmanagement.DAO;

import com.tungbk.contactmanagement.DTO.UserDTO;
import com.tungbk.contactmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;

public interface UserDAO extends JpaRepository<User, Long> {
    List<User> findAllByFirstNameContaining(String firstName);
    List<User> findAllByLastNameContaining(String lastName);
}
