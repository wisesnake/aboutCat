package com.aboutcat.admin.order.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.aboutcat.order.vo.OrderVO;

public interface AdminOrderService {
	
	public ArrayList<OrderVO> selectOrderList(Map<String, Object> condMap);

	void changeDeliveryState(Map orderMap);

	public void searchOrder(HashMap<String, String> searchMap);

}
