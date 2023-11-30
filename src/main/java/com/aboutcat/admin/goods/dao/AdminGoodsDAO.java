package com.aboutcat.admin.goods.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.aboutcat.goods.vo.GoodsVO;

public interface AdminGoodsDAO {

	public int insertNewGoods(Map newGoodsMap) throws DataAccessException;

	public List<GoodsVO> selectNewGoodsList(Map condMap) throws DataAccessException;

	public void insertGoodsImageFile(List fileList) throws DataAccessException;

}
