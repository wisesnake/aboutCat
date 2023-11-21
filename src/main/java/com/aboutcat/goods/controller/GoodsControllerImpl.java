package com.aboutcat.goods.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aboutcat.goods.service.GoodsService;
import com.aboutcat.goods.vo.GoodsVO;

@Controller
@RequestMapping(value="/goods")
public class GoodsControllerImpl implements GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	@Override
	@RequestMapping(value="/goodsDetail.do" ,method = RequestMethod.GET)
	public ModelAndView goodsDetail(@RequestParam("goods_id") String goods_id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		String viewName= (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		Map goodsMap = goodsService.goodsDetail(goods_id);
		mav.addObject("goodsMap", goodsMap);
		return mav;
	}


	@RequestMapping(value="/searchGoods.do" ,method = RequestMethod.GET)
	public ModelAndView searchGoods(@RequestParam("searchWord") String searchWord,
			                       HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName=(String)request.getAttribute("viewName");
		List<GoodsVO> goodsList=goodsService.searchGoods(searchWord);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("goodsList", goodsList);
		return mav;
		
	}
	
	
	@RequestMapping(value = "/keywordSearch.do" ,method = RequestMethod.GET)
	public void keywordSearch(@RequestParam("keywordSearch") String keywordSearch, HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		String viewName = (String) request.getAttribute("viewName");
		
		List<String> keywordList= goodsService.keywordSearch(keywordSearch);
		//그뒤에 JSON쓰는 이유 몰라서 아직 안씀
	}
	
	
	

	

}
