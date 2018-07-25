package org.myapp.mapper;

import org.myapp.bean.Order;

import java.util.List;
import java.util.Map;

public interface OrderMapper {
    public List<Order> queryOrderByCont(Map<String,Object> map);

    public List<Order> queryOrderByChoose(Map<String,Object> map);
}
