package com.cg.service;

import com.cg.model.User;
import com.cg.model.dto.UserDTO;

import java.util.List;

public interface UserService extends IGeneralService<User> {


    List<UserDTO> findAllUserDTO();
    UserDTO findDTOById(Long id);
}
