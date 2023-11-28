package com.aboutcat.admin.goods.service;

import java.util.List;
import java.util.Map;

import com.aboutcat.goods.vo.GoodsVO;

public interface AdminGoodsService {
	public int  addNewGoods(Map newGoodsMap) throws Exception;
	public List<GoodsVO> listNewGoods(Map condMap) throws Exception;

}
