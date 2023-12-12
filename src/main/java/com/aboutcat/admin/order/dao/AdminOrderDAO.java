package com.aboutcat.admin.order.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.aboutcat.order.vo.OrderVO;

public interface AdminOrderDAO {
	public ArrayList<OrderVO> selectOrderList(Map<String,Object> condMap);

	void changeDeleveryState(Map orderMap);

	public void searchOrder(HashMap<String, String> searchMap);
}
