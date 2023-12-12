package com.aboutcat.admin.order.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aboutcat.admin.order.dao.AdminOrderDAO;
import com.aboutcat.order.vo.OrderVO;

@Service("adminOrderService")
public class AdminOrderServiceImpl implements AdminOrderService{

	@Autowired
	private AdminOrderDAO adminOrderDAO;

	@Override
	public ArrayList<OrderVO> selectOrderList(Map<String, Object> condMap) {
		ArrayList<OrderVO> orderList = adminOrderDAO.selectOrderList(condMap);
		return orderList;
	}
	
	@Override
	public void changeDeliveryState(Map orderMap) {
		adminOrderDAO.changeDeleveryState(orderMap);
	}
}
