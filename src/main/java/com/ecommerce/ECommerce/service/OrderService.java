package com.ecommerce.ECommerce.service;

import com.ecommerce.ECommerce.model.LocalUser;
import com.ecommerce.ECommerce.model.WebOrder;
import com.ecommerce.ECommerce.model.dao.WebOrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private WebOrderDao webOrderDao;

    public List<WebOrder> getOrders(LocalUser user) {
        return webOrderDao.findByUser(user);
    }
}
