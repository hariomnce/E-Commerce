package com.ecommerce.ECommerce.model.dao;

import com.ecommerce.ECommerce.model.LocalUser;
import com.ecommerce.ECommerce.model.WebOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WebOrderDao extends JpaRepository<WebOrder, Long> {

    List<WebOrder> findByUser(LocalUser user);

}
