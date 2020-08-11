package com.xiaoshu.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.xiaoshu.config.util.ConfigUtil;
import com.xiaoshu.dao.CourseMapper;
import com.xiaoshu.entity.Attachment;
import com.xiaoshu.entity.Course;
import com.xiaoshu.entity.Log;
import com.xiaoshu.entity.Operation;
import com.xiaoshu.entity.Role;
import com.xiaoshu.entity.Student;
import com.xiaoshu.entity.StudentVo;
import com.xiaoshu.entity.User;
import com.xiaoshu.service.OperationService;
import com.xiaoshu.service.RoleService;
import com.xiaoshu.service.StudentService;
import com.xiaoshu.service.UserService;
import com.xiaoshu.util.StringUtil;
import com.xiaoshu.util.TimeUtil;
import com.xiaoshu.util.WriterUtil;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.mchange.v2.async.StrandedTaskReporting;

@Controller
@RequestMapping("student")
public class StudentController extends LogController{
	static Logger logger = Logger.getLogger(StudentController.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService ;
	
	@Autowired
	private OperationService operationService;
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("studentIndex")
	public String index(HttpServletRequest request,Integer menuid) throws Exception{
		List<Role> roleList = roleService.findRole(new Role());
		List<Operation> operationList = operationService.findOperationIdsByMenuid(menuid);
		List<Course>clist=studentService.findAll();
		request.setAttribute("clist", clist);
		
		request.setAttribute("operationList", operationList);
		request.setAttribute("roleList", roleList);
		return "student";
	}
	
	
	@RequestMapping(value="studentList",method=RequestMethod.POST)
	public void userList(StudentVo studentVo,HttpServletRequest request,HttpServletResponse response,String offset,String limit) throws Exception{
		try {
			
			Integer pageSize = StringUtil.isEmpty(limit)?ConfigUtil.getPageSize():Integer.parseInt(limit);
			Integer pageNum =  (Integer.parseInt(offset)/pageSize)+1;
			PageInfo<StudentVo> userList= studentService.findUserPage(studentVo,pageNum,pageSize);
			
			
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
	public void reserveUser(HttpServletRequest request,Student student,HttpServletResponse response){
		Integer code = student.getCode();
		JSONObject result=new JSONObject();
		try {
			if (code != null) {   // userId不为空 说明是修改
				
					student.setCode(code);
					studentService.updateUser(student);
					result.put("success", true);
				
				
			}else {   // 添加
				
					studentService.addUser(student);
					result.put("success", true);
				
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
				studentService.deleteUser(Integer.parseInt(id));
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
	@RequestMapping("importStudent")
	public void importStudent(MultipartFile studentExel,HttpServletRequest request,HttpServletResponse response){
		JSONObject result=new JSONObject();
		try {
		//获取上传文件
			HSSFWorkbook workbook = new HSSFWorkbook(studentExel.getInputStream());
			//获取sheet页
			HSSFSheet sheetAt = workbook.getSheetAt(0);
			//获取最后一行的行数
			int rowNum = sheetAt.getLastRowNum();
			//循环行数获取单元格
			for (int i = 1; i <=rowNum; i++) {
				//获取单元格中的数据
				HSSFRow row = sheetAt.getRow(i);
				  String name = row.getCell(1).getStringCellValue();
				  String age = row.getCell(2).getStringCellValue();
				  String grade = row.getCell(3).getStringCellValue();
				  String cname = row.getCell(4).getStringCellValue();
				  Date entrytime = row.getCell(5).getDateCellValue();
				  Date createtime = row.getCell(6).getDateCellValue();
				  //根据部门名称查询部门id
				  Integer code = findByStudent(name);
				  //创建对象，封装参数
				  Student student = new Student();
				  student.setName(name);
				  student.setAge(age);
				 student.setGrade(grade);
				 student.setEntrytime(entrytime);
				 student.setCreatetime(createtime);
				 student.setName(cname);
				 student.setCourseid(code);
				  studentService.addUser(student);
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
	private CourseMapper courseMapper;
	public Integer findByStudent(String name){
		Course course=new Course();
		course.setName(name);
		Course one = courseMapper.selectOne(course);
		return one.getCode();
		
	}
	
	
	
	
	@RequestMapping("exportStudent")
	public void exportStudent(HttpServletRequest request,HttpServletResponse response){
		JSONObject result = new JSONObject();
		try {
			String time = TimeUtil.formatTime(new Date(), "yyyyMMddHHmmss");
		    String excelName = "手动备份"+time;
			Log log = new Log();
			List<StudentVo> list = studentService.findpage(new StudentVo());
			String[] handers = {"学生编号","所选课程","学生姓名","学生年龄","学生年级","入学时间","创建时间"};
			// 1导入硬盘
			ExportExcelToDisk(request,handers,list, excelName);
			// 2导出的位置放入attachment表
			
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("", "对不起，备份失败");
		}
		WriterUtil.write(response, result.toString());
	}
	
	
	
	// 导出到硬盘
	@SuppressWarnings("resource")
	private void ExportExcelToDisk(HttpServletRequest request,
			String[] handers, List<StudentVo> list, String excleName) throws Exception {
		
		try {
			HSSFWorkbook wb = new HSSFWorkbook();//创建工作簿
			HSSFSheet sheet = wb.createSheet("操作记录备份");//第一个sheet
			HSSFRow rowFirst = sheet.createRow(0);//第一个sheet第一行为标题
			rowFirst.setHeight((short) 500);
			for (int i = 0; i < handers.length; i++) {
				sheet.setColumnWidth((short) i, (short) 4000);// 设置列宽
			}
			//写标题了
			for (int i = 0; i < handers.length; i++) {
			    //获取第一行的每一个单元格
			    HSSFCell cell = rowFirst.createCell(i);
			    //往单元格里面写入值
			    cell.setCellValue(handers[i]);
			}
			for (int i = 0;i < list.size(); i++) {
			    //获取list里面存在是数据集对象
			    StudentVo studentVo = list.get(i);
			    //创建数据行
			    HSSFRow row = sheet.createRow(i+1);
			    //设置对应单元格的值
			    row.setHeight((short)400);   // 设置每行的高度
			    //"序号","操作人","IP地址","操作时间","操作模块","操作类型","详情"
			    row.createCell(0).setCellValue(studentVo.getCode());
			    row.createCell(1).setCellValue(studentVo.getCname());
			    row.createCell(2).setCellValue(studentVo.getName());
			    row.createCell(3).setCellValue(studentVo.getAge());
			    row.createCell(4).setCellValue(studentVo.getGrade());
			    row.createCell(5).setCellValue(TimeUtil.formatTime(studentVo.getEntrytime(), "yyyy-MM-dd"));
			    row.createCell(6).setCellValue(TimeUtil.formatTime(studentVo.getCreatetime(), "yyyy-MM-dd"));
			}
			//写出文件（path为文件路径含文件名）
				OutputStream os;
				File file = new File("d:/photo/"+excleName+".xls");
				
				if (!file.exists()){//若此目录不存在，则创建之  
					file.createNewFile();  
					logger.debug("创建文件夹路径为："+ file.getPath());  
	            } 
				os = new FileOutputStream(file);
				wb.write(os);
				os.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
	}

	@RequestMapping("echartsStudent")
	public void echartsStudent(HttpServletRequest request,HttpServletResponse response){
		JSONObject result=new JSONObject();
		try {
			List<StudentVo>elist=studentService.getEcharts();
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
