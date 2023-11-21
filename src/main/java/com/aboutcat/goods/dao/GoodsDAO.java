package com.aboutcat.goods.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.aboutcat.goods.vo.GoodsVO;

public interface GoodsDAO {
	
	public GoodsVO selectGoodsDetail(String goods_id);
	
	public List<GoodsVO> selectGoodsList(String goodsStatus ) throws DataAccessException;


	public List<GoodsVO> selectGoodsBySearchWord(String searchWord) throws DataAccessException;

}
