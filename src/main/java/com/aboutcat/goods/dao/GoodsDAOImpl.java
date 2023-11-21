package com.aboutcat.goods.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.aboutcat.goods.vo.GoodsVO;

@Repository("goodsDAO")
public class GoodsDAOImpl implements GoodsDAO {

	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public GoodsVO selectGoodsDetail(String goods_id) {
		
		GoodsVO goodsvo = (GoodsVO) sqlSession.selectList("mapper.goods.selectGoodsDetail", goods_id);
				
		return goodsvo;
	}
	
	
	
	
	@Override
	public List<GoodsVO> selectGoodsList(String goodsStatus){
		List<GoodsVO> goodsList = sqlSession.selectList("mapper.goods.selectGoodsList", goodsStatus);
		
		return goodsList;
		
	}
	

	@Override
	public ArrayList selectGoodsBySearchWord(String searchWord) throws DataAccessException{
		ArrayList list=(ArrayList)sqlSession.selectList("mapper.goods.selectGoodsBySearchWord",searchWord);
		 return list;
	}


	
}
