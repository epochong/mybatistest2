package com.ming;


import com.ming.bz.UserBz;
import com.ming.mapper.OrdersMapper;
import com.ming.mapper.UserMapper;
import com.ming.po.Orders;
import com.ming.po.OrdersEx;
import com.ming.po.User;
import com.ming.po.UserEx;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class MybatisTest2 {

    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void testInitialtive(){
        String file = "sqlMapConfig.xml";
        InputStream is = null;
        try{
            is = Resources.getResourceAsStream(file);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    //1:1  使用ResultType完成： 建立Orders的扩展类OrdersEx 包住username,sex,address.
    @Test
    public void testQueryOrderToUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
            List<OrdersEx> ordersExList = ordersMapper.queryOrdersToUser();
            System.out.println(ordersExList);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    //1:1  使用ResultMap完成： 使用association标签完成关联映射
    @Test
    public void testQueryOrderToUser2(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
            List<Orders> ordersList = ordersMapper.queryOrdersToUserRM();
            System.out.println(ordersList);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


    // 1:m 关联查询： 使用collection   ofType List<object>
    @Test
    public void testQueryOrderToOrderDetail(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
            List<Orders> ordersList = ordersMapper.queryOrdersToOrderDetail();
            System.out.println(ordersList);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    // 1:m 关联查询： 使用collection   ofType List<object>
    @Test
    public void testQueryOrderToItems(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
            List<Orders> ordersList = ordersMapper.queryOrderToItems();
            System.out.println(ordersList);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
