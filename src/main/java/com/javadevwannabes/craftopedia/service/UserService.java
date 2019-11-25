package com.javadevwannabes.craftopedia.service;

import com.javadevwannabes.craftopedia.dto.UserDto;
import com.javadevwannabes.craftopedia.persistence.model.User;
import com.javadevwannabes.craftopedia.persistence.dao.RoleRepository;
import com.javadevwannabes.craftopedia.persistence.dao.UserRepository;
import com.javadevwannabes.craftopedia.validation.EmailExistsException;
import java.util.Arrays;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class UserService implements IUserService{

  @Autowired
  private UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Override
  public User registerNewUserAccount(UserDto accountDto) throws EmailExistsException {
    if(emailExists(accountDto.getEmail())){
      throw new EmailExistsException("There is already an account with that email address: " + accountDto.getEmail());
    }

    User user = new User();
    user.setFirstName(accountDto.getFirstName());
    user.setLastName(accountDto.getLastName());
    user.setPassword(accountDto.getPassword());
    user.setEmail(accountDto.getEmail());
    user.setUsing2FA(accountDto.isUsing2FA());
    user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
    return userRepository.save(user);
  }

  private boolean emailExists(final String email){
    return userRepository.findByEmail(email) != null;
  }
}
