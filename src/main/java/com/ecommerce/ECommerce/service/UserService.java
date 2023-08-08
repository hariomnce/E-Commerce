package com.ecommerce.ECommerce.service;

import com.ecommerce.ECommerce.api.model.RegistrationBody;
import com.ecommerce.ECommerce.exception.UserAlreadyExistsException;
import com.ecommerce.ECommerce.model.LocalUser;
import com.ecommerce.ECommerce.model.dao.LocalUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private LocalUserDao localUserDao;

    public UserService(LocalUserDao localUserDao) {
        this.localUserDao = localUserDao;
    }

    public LocalUser registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException {
        if (localUserDao.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent() ||
                localUserDao.findByUserNameIgnoreCase(registrationBody.getUserName()).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        LocalUser user = new LocalUser();
        user.setEmail(registrationBody.getEmail());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        user.setUserName(registrationBody.getUserName());

//      Encrypt password
        user.setPassword(registrationBody.getPassword());
        return localUserDao.saveAndFlush(user);
    }
}
