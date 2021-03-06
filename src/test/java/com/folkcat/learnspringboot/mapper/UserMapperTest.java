package com.folkcat.learnspringboot.mapper;

import com.folkcat.learnspringboot.Application;
import com.folkcat.learnspringboot.bean.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Tamas on 2017/6/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    @Rollback
    public void findByName() throws Exception {
        userMapper.insert("AAA", 20);
        User u = userMapper.findByName("AAA");
        Assert.assertEquals(20, u.getAge().intValue());
    }

    @Test
    public void update(){
        User user=new User("shabi",21);
        user.setId(5L);
        int i=userMapper.update(user);
        System.out.println("i:"+i);
    }

    @Test
    public void updateByMap(){
        Map<String ,String> map=new HashMap<>();
        map.put("name","mapName");
        map.put("age","16");
        map.put("id","5");
        int i=userMapper.updateByMap(map);
        System.out.println("i:"+i);
    }

    @Test
    public void delete(){
        int i=userMapper.deleteByName("d");
        System.out.println("i:"+i);
    }

    @Test
    public void getAll(){
        List<User> userList=userMapper.getAll();
        System.out.println("user list size : "+userList.size());
    }

    @Test
    public void insertWithoutColumn(){
        User user=new User("haha",2);
        user.setId(110L);
        userMapper.insertWithoutColumn(user);
    }
}