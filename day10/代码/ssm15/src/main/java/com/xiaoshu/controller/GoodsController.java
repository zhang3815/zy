package com.xiaoshu.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.One;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.xiaoshu.config.util.ConfigUtil;
import com.xiaoshu.dao.GoodstypeMapper;
import com.xiaoshu.entity.Goods;
import com.xiaoshu.entity.GoodsVo;
import com.xiaoshu.entity.Goodstype;
import com.xiaoshu.entity.Operation;
import com.xiaoshu.entity.Role;
import com.xiaoshu.entity.User;
import com.xiaoshu.service.GoodsService;
import com.xiaoshu.service.OperationService;
import com.xiaoshu.service.RoleService;
import com.xiaoshu.service.UserService;
import com.xiaoshu.util.StringUtil;
import com.xiaoshu.util.WriterUtil;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("goods")
public class GoodsController extends LogController{
	static Logger logger = Logger.getLogger(GoodsController.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService ;
	
	@Autowired
	private OperationService operationService;
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping("goodsIndex")
	public String index(HttpServletRequest request,Integer menuid) throws Exception{
		List<Role> roleList = roleService.findRole(new Role());
		List<Operation> operationList = operationService.findOperationIdsByMenuid(menuid);
		List<Goodstype>glist=goodsService.findAll();
		request.setAttribute("glist", glist);
		
		request.setAttribute("operationList", operationList);
		request.setAttribute("roleList", roleList);
		return "goods";
	}
	
	
	@RequestMapping(value="goodsList",method=RequestMethod.POST)
	public void userList(GoodsVo goodsVo,HttpServletRequest request,HttpServletResponse response,String offset,String limit) throws Exception{
		try {
			
			
			Integer pageSize = StringUtil.isEmpty(limit)?ConfigUtil.getPageSize():Integer.parseInt(limit);
			Integer pageNum =  (Integer.parseInt(offset)/pageSize)+1;
			PageInfo<GoodsVo> userList= goodsService.findUserPage(goodsVo,pageNum,pageSize);
			
			
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
	public void reserveUser(HttpServletRequest request,Goods goods,HttpServletResponse response){
		Integer id = goods.getId();
		JSONObject result=new JSONObject();
		try {
			if (id != null) {   // userId不为空 说明是修改
				Goods userName = goodsService.existUserWithUserName(goods.getName());
				if(userName != null && userName.getId().compareTo(id)==0){
					goods.setId(id);
					goodsService.updateUser(goods);
					result.put("success", true);
				}else{
					result.put("success", true);
					result.put("errorMsg", "该用户名被使用");
				}
				
			}else {   // 添加
				if(goodsService.existUserWithUserName(goods.getName())==null){  // 没有重复可以添加
					goodsService.addUser(goods);
					result.put("success", true);
				} else {
					result.put("success", true);
					result.put("errorMsg", "该用户名被使用");
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
				goodsService.deleteUser(Integer.parseInt(id));
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
	
	@RequestMapping("importGoods")
	public void importGoods(MultipartFile goodsExel,HttpServletRequest request,HttpServletResponse response){
		JSONObject result=new JSONObject();
		try {
			HSSFWorkbook workbook = new HSSFWorkbook(goodsExel.getInputStream());
			HSSFSheet sheetAt = workbook.getSheetAt(0);
			int rowNum = sheetAt.getLastRowNum();
			for (int i = 1; i <= rowNum; i++) {
				HSSFRow row = sheetAt.getRow(i);
				String code = row.getCell(0).getNumericCellValue()+"";
				String name = row.getCell(1).getStringCellValue();
				String price = row.getCell(2).getNumericCellValue()+"";
				String status = row.getCell(3).getStringCellValue();
				Date createtime = row.getCell(4).getDateCellValue();
				String typename = row.getCell(5).getStringCellValue();
				Integer id = findByGoods(typename);
				Goods goods = new Goods();
				goods.setCode(code);
				goods.setName(name);
				goods.setPrice(price);
				goods.setStatus(status);
				goods.setCreatetime(createtime);
				goods.setName(typename);
				goods.setTypeid(id);
			goodsService.addUser(goods);
			
			
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
	private GoodstypeMapper goodstypeMapper;
	public Integer findByGoods(String typename){
		Goodstype goodstype = new Goodstype();
		goodstype.setTypename(typename);
		Goodstype one = goodstypeMapper.selectOne(goodstype);
		return one.getId();
	}
	
	
	@RequestMapping("echartsGoods")
	public void echartsGoods(HttpServletRequest request,HttpServletResponse response){
		JSONObject result=new JSONObject();
		try {
			List<GoodsVo>elist=goodsService.getEcharts();
			result.put("elist", elist);
			result.put("success", true);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("删除用户信息错误",e);
			result.put("errorMsg", "对不起，删除失败");
		}
		WriterUtil.write(response, result.toString());
	}


}
