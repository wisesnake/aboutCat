package com.aboutcat.goods.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aboutcat.goods.dao.GoodsDAO;
import com.aboutcat.goods.vo.GoodsVO;
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	private GoodsDAO goodsDAO;
	
	@Override
	public Map goodsDetail(String goods_id) {
		Map goodsMap = new HashMap();
		
		
		GoodsVO goodsVO = goodsDAO.selectGoodsDetail(goods_id);
		goodsMap.put("goodsVO", goodsVO);
		return goodsMap;
	}

	
	@Override
	public Map<String, List<GoodsVO>> listGoods() throws Exception {
		
		Map goodsMap = new HashMap();
		
		List<GoodsVO> goodsList = goodsDAO.selectGoodsList("bestgoods");
		goodsMap.put("bestgoods", goodsList);
		
		goodsList = goodsDAO.selectGoodsList("newgoods");
		goodsMap.put("newgoods", goodsList);
		
		goodsList = goodsDAO.selectGoodsList("recommendgoods");
		goodsMap.put("recommendgoods", goodsList);
		
		return goodsMap;
	}


	public List<GoodsVO> searchGoods(String searchWord) throws Exception{
		List goodsList=goodsDAO.selectGoodsBySearchWord(searchWord);
		return goodsList;
	}
	
	

}
