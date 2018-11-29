package com.imooc.service.impl;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: xyx
 * @Date: 2018-11-29 12:27
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() {
        ProductCategory productCategory = categoryService.findOne(1);
        Assert.assertEquals(productCategory.getCategoryId(), Integer.valueOf(1));
    }

    @Test
    public void findAll() {
        List<ProductCategory> categoryList = categoryService.findAll();
        Assert.assertNotEquals(0, categoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<ProductCategory> productCategories = categoryService.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, productCategories.size());
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory("男生专享", 5);
        ProductCategory result = categoryService.save(productCategory);
        System.out.println(result);
        Assert.assertNotNull(result);
    }
}