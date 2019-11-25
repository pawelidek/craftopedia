package com.javadevwannabes.craftopedia.service;

import com.javadevwannabes.craftopedia.dto.UserDto;
import com.javadevwannabes.craftopedia.persistence.model.User;
import com.javadevwannabes.craftopedia.validation.EmailExistsException;

public interface IUserService {

  User registerNewUserAccount(UserDto accountDto) throws EmailExistsException;
}
