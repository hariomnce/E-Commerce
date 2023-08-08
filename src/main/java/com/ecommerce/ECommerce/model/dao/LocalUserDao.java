package com.ecommerce.ECommerce.model.dao;

import com.ecommerce.ECommerce.model.LocalUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocalUserDao extends JpaRepository<LocalUser, Long> {
    Optional<LocalUser> findByUserNameIgnoreCase(String userName);

    Optional<LocalUser> findByEmailIgnoreCase(String email);


}
