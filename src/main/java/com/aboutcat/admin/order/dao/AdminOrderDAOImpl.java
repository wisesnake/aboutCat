package com.aboutcat.admin.order.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aboutcat.order.vo.OrderVO;

@Repository("adminOrderDAO")
public class AdminOrderDAOImpl implements AdminOrderDAO{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ArrayList<OrderVO> selectOrderList(Map<String,Object> condMap) {
	List<OrderVO> orderList = new ArrayList<OrderVO>();
		orderList = sqlSession.selectList("mapper.admin.order.selectNewOrderList",condMap);
		return (ArrayList<OrderVO>)orderList;
	}
	
	@Override
	public void changeDeleveryState(Map orderMap) {
		sqlSession.selectList("mapper.admin.order.changeDeliveryState", orderMap);
	}

}
