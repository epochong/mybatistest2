package com.ming.mapper;

import com.ming.po.Orders;
import com.ming.po.OrdersEx;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;

public interface OrdersMapper {

    public List<OrdersEx> queryOrdersToUser() throws Exception;

    public List<Orders> queryOrdersToUserRM() throws Exception;

    public List<Orders> queryOrdersToOrderDetail() throws Exception;

    public List<Orders> queryOrderToItems() throws Exception;


}
