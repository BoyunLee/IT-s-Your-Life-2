package com.multi.mvc04.web04.dao;

import com.multi.mvc04.web04.vo.ProductVO;
import java.util.HashMap;
import java.util.Map;

public class ProductDAO {
    private Map<String, ProductVO> products = new HashMap<>();

    public void addProduct(ProductVO product) {
        System.out.println("dao insert product >> " + product);
        products.put(product.getId(), product);
    }

    public void delectProduct(String id) {
        System.out.println("dao delete product >> " + id);
        products.remove(id);
    }
}
