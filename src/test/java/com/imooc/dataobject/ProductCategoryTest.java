package com.imooc.dataobject;

import com.imooc.repository.ProductCategoryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: xyx
 * @Date: 2018-11-29 09:03
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        ProductCategory productCategory = repository.findOne(1);
        System.out.println(productCategory);
    }

    @Test
    @Transactional //回滚
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("东京日", 10);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
        Assert.assertNotEquals(null, result);
    }

    @Test
    public void updateTest() {
        ProductCategory productCategory = repository.findOne(1);
        productCategory.setCategoryType(9);
        repository.save(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(2,3,4);
        //需要无参的单元测试
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size());
    }


}