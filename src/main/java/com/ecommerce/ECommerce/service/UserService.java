package com.ecommerce.ECommerce.service;

import com.ecommerce.ECommerce.api.model.LoginBody;
import com.ecommerce.ECommerce.api.model.RegistrationBody;
import com.ecommerce.ECommerce.exception.UserAlreadyExistsException;
import com.ecommerce.ECommerce.model.LocalUser;
import com.ecommerce.ECommerce.model.dao.LocalUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private LocalUserDao localUserDao;

    @Autowired
    private EncryptionService encryptionService;

    @Autowired
    private JWTService jwtService;

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
        user.setPassword(encryptionService.encryptPassword(registrationBody.getPassword()));
        return localUserDao.saveAndFlush(user);
    }

    public String loginUser(LoginBody loginBody) {
        Optional<LocalUser> opUser = localUserDao.findByUserNameIgnoreCase(loginBody.getUserName());
        if (opUser.isPresent()) {
            LocalUser user = opUser.get();
            if (encryptionService.verifyPassword(loginBody.getPassword(), user.getPassword())) {
                return jwtService.generateJWT(user);
            }
        }
        return null;
    }
}
