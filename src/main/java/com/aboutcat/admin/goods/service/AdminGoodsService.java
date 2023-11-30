package com.aboutcat.admin.goods.service;

import java.util.List;
import java.util.Map;

import com.aboutcat.goods.vo.GoodsVO;

public interface AdminGoodsService {
	public int addNewGoods(Map newGoodsMap) throws Exception;

	public List<GoodsVO> listNewGoods(Map condMap) throws Exception;
	
	
	// 희영이한테 추가본
	public void addNewGoodsImage(List imageFileList) throws Exception;

	public Map goodsDetail(int goods_id) throws Exception;

	public void modifyGoodsInfo(Map goodsMap) throws Exception;

}
