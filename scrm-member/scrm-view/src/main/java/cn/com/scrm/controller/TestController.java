package cn.com.scrm.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import cn.com.scrm.dto.MemberDTO;
import cn.com.scrm.service.IMemberService;
import cn.com.scrm.tool.PageInfos;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/test/")
public class TestController {
	
	  @Resource
	  private IMemberService iMemberService;
	
	  @RequestMapping("listpage")
	  public String querypageListInfo(HttpServletRequest request, PageInfos page) {
		  Page<MemberDTO> info = this.iMemberService.queryAllDatas(page.getPageNum(), page.getPageSize());
		  PageInfo pageInfo = new PageInfo<>(info);
		  String str = JSONObject.fromObject(pageInfo).toString();
		  return str;
	  }

}
