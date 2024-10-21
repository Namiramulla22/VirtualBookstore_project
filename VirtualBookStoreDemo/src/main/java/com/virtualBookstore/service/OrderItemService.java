package com.virtualBookstore.service;

import java.util.List;
import com.virtualBookstore.entities.OrderItem;

public interface OrderItemService {
	public List<OrderItem> getOrderItem();
    public OrderItem getOrderItem(String OrderItem_id);
    public OrderItem addOrderItem(OrderItem orderitem);
    public OrderItem updateOrderItem(OrderItem orderitem);
    public void deleteOrderItem(String OrderItem_id);
}
