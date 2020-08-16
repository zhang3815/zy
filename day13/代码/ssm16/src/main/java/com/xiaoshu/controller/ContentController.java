package com.xiaoshu.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.aspectj.weaver.AjAttribute.PrivilegedAttribute;
import org.springframework.aop.IntroductionAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.xiaoshu.config.util.ConfigUtil;
import com.xiaoshu.dao.ContentcategoryMapper;
import com.xiaoshu.entity.Content;
import com.xiaoshu.entity.ContentVo;
import com.xiaoshu.entity.Contentcategory;
import com.xiaoshu.entity.Operation;
import com.xiaoshu.entity.Role;
import com.xiaoshu.entity.User;
import com.xiaoshu.service.ContentService;
import com.xiaoshu.service.OperationService;
import com.xiaoshu.service.RoleService;
import com.xiaoshu.service.UserService;
import com.xiaoshu.util.StringUtil;
import com.xiaoshu.util.WriterUtil;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("content")
public class ContentController extends LogController{
	static Logger logger = Logger.getLogger(ContentController.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService ;
	
	@Autowired
	private OperationService operationService;
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("contentIndex")
	public String index(HttpServletRequest request,Integer menuid) throws Exception{
		List<Role> roleList = roleService.findRole(new Role());
		List<Operation> operationList = operationService.findOperationIdsByMenuid(menuid);
		List<Contentcategory>clist=contentService.findAll();
		request.setAttribute("clist",clist);
		
		request.setAttribute("operationList", operationList);
		request.setAttribute("roleList", roleList);
		return "content";
	}
	
	
	@RequestMapping(value="contentList",method=RequestMethod.POST)
	public void userList(ContentVo contentVo,HttpServletRequest request,HttpServletResponse response,String offset,String limit) throws Exception{
		try {
			
			
			Integer pageSize = StringUtil.isEmpty(limit)?ConfigUtil.getPageSize():Integer.parseInt(limit);
			Integer pageNum =  (Integer.parseInt(offset)/pageSize)+1;
			PageInfo<ContentVo> userList= contentService.findUserPage(contentVo,pageNum,pageSize);
			
			
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("total",userList.getTotal() );
			jsonObj.put("rows", userList.getList());
	        WriterUtil.write(response,jsonObj.toString());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("用户展示错误",e);
			throw e;
		}
	}
	
	
	// 新增或修改
	@RequestMapping("reserveUser")
	public void reserveUser(HttpServletRequest request,Content content,HttpServletResponse response){
		Integer contentid = content.getContentid();
		JSONObject result=new JSONObject();
		try {
			if (contentid != null) {   // userId不为空 说明是修改
				
				content.setContentid(contentid);
					contentService.updateUser(content);
					result.put("success", true);
				
				
			}else {   // 添加
				if(content.getPrice().length()==3){
					contentService.addUser(content);
					result.put("success", true);
				} else {
					result.put("success", true);
					result.put("errorMsg", "价钱太贵，不干");
				}
				
			
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("保存用户信息错误",e);
			result.put("success", true);
			result.put("errorMsg", "对不起，操作失败");
		}
		WriterUtil.write(response, result.toString());
	}
	
	
	@RequestMapping("deleteUser")
	public void delUser(HttpServletRequest request,HttpServletResponse response){
		JSONObject result=new JSONObject();
		try {
			String[] ids=request.getParameter("ids").split(",");
			for (String id : ids) {
				contentService.deleteUser(Integer.parseInt(id));
			}
			result.put("success", true);
			result.put("delNums", ids.length);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("删除用户信息错误",e);
			result.put("errorMsg", "对不起，删除失败");
		}
		WriterUtil.write(response, result.toString());
	}
	@RequestMapping("importContent")
	public void importContent(MultipartFile conname, HttpServletRequest request,HttpServletResponse response){
		JSONObject result=new JSONObject();
		try {
			
			HSSFWorkbook workbook =new  HSSFWorkbook(conname.getInputStream());
			HSSFSheet sheet = workbook.getSheetAt(0);
			int rowNum = sheet.getLastRowNum();
			for (int i = 1; i <= rowNum; i++) {
			HSSFRow row = sheet.getRow(i);
			//名字
			String contenttitle = row.getCell(0).getStringCellValue();
			//链接
			String contenturl = row.getCell(1).getStringCellValue();
			//图片 
			String picpath = row.getCell(2).getStringCellValue();
			//价格
			Double numericCellValue = row.getCell(3).getNumericCellValue();
			String price = Double.toString(numericCellValue);
			//状态
			String status = row.getCell(4).getStringCellValue();
			//创建时间
			Date createtime = row.getCell(5).getDateCellValue();
			//广告分类
			String categoryname = row.getCell(6).getStringCellValue();
			Integer contentcategoryid = findByContent(categoryname);
			Content content = new Content();
			
			content.setContenttitle(contenttitle);
			content.setContenturl(contenturl);
			content.setPicpath(picpath);
			content.setPrice(price);
			content.setStatus(status);
			content.setCreatetime(createtime);
			
			content.setContentcategoryid(contentcategoryid);
			contentService.addUser(content);
			}
			
			
			result.put("success", true);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("删除用户信息错误",e);
			result.put("errorMsg", "对不起，删除失败");
		}
		WriterUtil.write(response, result.toString());
	}
	
	@Autowired
	private ContentcategoryMapper contentcategoryMapper;
	public Integer findByContent(String categoryname){
		Contentcategory contentcategory = new Contentcategory();
		contentcategory.setCategoryname(categoryname);
		Contentcategory one = contentcategoryMapper.selectOne(contentcategory);
		return one.getContentcategoryid();
		
	}
	
	@RequestMapping("echartsContent")
	public void echartsContent(HttpServletRequest request,HttpServletResponse response){
		JSONObject result=new JSONObject();
		try {
			List<ContentVo>elist=contentService.getEcharts();
			result.put("elist",elist);
			result.put("success", true);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("删除用户信息错误",e);
			result.put("errorMsg", "对不起，删除失败");
		}
		WriterUtil.write(response, result.toString());
	}

}
