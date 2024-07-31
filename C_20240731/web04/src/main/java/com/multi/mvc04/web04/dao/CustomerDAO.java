package com.multi.mvc04.web04.dao;

import com.multi.mvc04.web04.vo.CustomerVO;
import java.util.HashMap;
import java.util.Map;

public class CustomerDAO {
    private Map<String, CustomerVO> customers = new HashMap<>();

    public void addCustomer(CustomerVO customer) {
        System.out.println("dao insert customer >> " + customer);
        customers.put(customer.getId(), customer);
    }

    public void delectCustomer(String id) {
        System.out.println("dao delete customer >> " + id);
        customers.remove(id);
    }
}
