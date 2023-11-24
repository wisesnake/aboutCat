package com.aboutcat.admin.goods.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aboutcat.common.base.BaseController;


@Controller("adminGoodsController")
@RequestMapping(value="/admin/goods")
public class AdminGoodsControllerImpl extends BaseController implements AdminGoodsController {
	private static final String CURR_IMAGE_REPO_PATH = "C:\\image\\file_repo";


}
