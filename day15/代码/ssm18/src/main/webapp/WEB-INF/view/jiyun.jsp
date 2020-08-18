<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>用户主页</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ include file="/WEB-INF/common.jsp"%>

<link
	href="${path }/resources/css/plugins/bootstrap-table/bootstrap-table.min.css"
	rel="stylesheet">
<link href="${path }/resources/css/animate.css" rel="stylesheet">
<link href="${path }/resources/css/style.css?v=4.1.0" rel="stylesheet">

</head>
<body class="gray-bg">
	<div class="panel-body">
		<div id="toolbar" class="btn-group">
			<c:forEach items="${operationList}" var="oper">
				<privilege:operation operationId="${oper.operationid }" id="${oper.operationcode }" name="${oper.operationname }" clazz="${oper.iconcls }"  color="#093F4D"></privilege:operation>
			</c:forEach>
        </div>
        <div class="row">
			  <div class="col-lg-2">
				<div class="input-group">
			      <span class="input-group-addon">人员姓名 </span>
			      <input type="text" name="pName" class="form-control" id="txt_search_username" >
				</div>
			  </div>
			  <div class="col-lg-2">
				<div class="input-group">
					<span class="input-group-addon">存款公司</span>
					<select class="form-control" name="bId" id = "txt_search_roleid">
						<option value="0">---请选择---</option>
						<c:forEach items="${blist }" var="b">
						 	<option value="${b.bId }">${b.bName }</option>
						</c:forEach>
                	</select>
				</div>
			 </div>
			  <div class="col-lg-2">
				<div class="input-group">
			      <span class="input-group-addon">存款时间 </span>
			      <input type="date" name="start" class="form-control" id="txt_search_start" >
			       <input type="date" name="end" class="form-control" id="txt_search_end" >
				</div>
			  </div>
            <button id="btn_search" type="button" class="btn btn-default">
            	<span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
            </button>
	  	</div>
        
        <table id="table_user"></table>
		
	</div>
	
	<!-- 新增和修改对话框 -->
	<div class="modal fade" id="modal_user_edit" role="dialog" aria-labelledby="modal_user_edit" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<form id="form_user" method="post" action="reserveUser.htm">
						<input type="hidden" name="pId" id="hidden_txt_userid" value=""/>
						<table style="border-collapse:separate; border-spacing:0px 10px;">
							<tr>
								<td>人员姓名：</td>
								<td><input type="text" id="pName" name="pName"
									class="form-control" aria-required="true" required/></td>
								<td>&nbsp;&nbsp;</td>
								<td>人员性别：</td>
								<td><input type="radio" id="pSex" name="pSex" value="男"
									class="form-control" aria-required="true" required/>男
									<input type="radio" id="pSex" name="pSex" value="女"
									class="form-control" aria-required="true" required/>女</td>
							</tr>
							<tr>
								<td>人员爱好：</td>
								<td><input type="checkbox" id="pLike1" name="pLike" value="篮球"
									class="form-control" aria-required="true" required/>篮球
									<input type="checkbox" id="pLike2" name="pLike" value="足球"
									class="form-control" aria-required="true" required/>足球
									<input type="checkbox" id="pLike3" name="pLike" value="排球"
									class="form-control" aria-required="true" required/>排球</td>
								<td>&nbsp;&nbsp;</td>
								<td>存款金额：</td>
								<td><input type="text" id="pCount" name="pCount"
									class="form-control" aria-required="true" required/></td>
							</tr>
							<tr>
								<td>人员年龄：</td>
								<td><input type="text" id="pAge" name="pAge"
									class="form-control" aria-required="true" required/></td>
								<td>&nbsp;&nbsp;</td>
								<td>存款日期：</td>
								<td><input type="date" id="createtime" name="createtime"
									class="form-control" aria-required="true" required/></td>
							</tr>
							<tr>
								<td>存款银行：</td>
								<td >
									<select class="form-control" name="bId" id = "bId" aria-required="true" required>
										<option value="">---请选择---</option>
										<c:forEach items="${blist}" var="b">
										 	<option value="${b.bId }">${b.bName }</option>
										</c:forEach>
				                	</select>
								</td>
							</tr>
							
						</table>
						
						<div class="modal-footer">
							<button type="button" class="btn btn-primary"  id="submit_form_user_btn">保存</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						</div>
					</form>

				</div>
				
			</div>

		</div>

	</div>
	
	
	<!--删除对话框 -->
	<div class="modal fade" id="modal_user_del" role="dialog" aria-labelledby="modal_user_del" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					 <h4 class="modal-title" id="modal_user_del_head"> 刪除  </h4>
				</div>
				<div class="modal-body">
							删除所选记录？
				</div>
				<div class="modal-footer">
				<button type="button" class="btn btn-danger"  id="del_user_btn">刪除</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
			</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="modal_user_st" role="dialog" aria-labelledby="modal_user_st" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					 <h4 class="modal-title" id="modal_user_del_head"> 刪除  </h4>
				</div>
				<div class="modal-body">
							<form action="bankSt.htm" method="post" id="form_st">
							专业：<input type="text" id="bName" name="bName"
									class="form-control" aria-required="true" required/>
							</form>
				</div>
				<div class="modal-footer">
				<button type="button" class="btn btn-danger"  id="st_user_btn">刪除</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
			</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="modal_user_echarts" role="dialog" aria-labelledby="modal_user_echarts" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					 <h4 class="modal-title" id="modal_user_del_head"> 报表  </h4>
				</div>
				<div class="modal-body">
						<div id="main" style="width: 500px;height: 500px"></div>
				</div>
				<div class="modal-footer">
				
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
			</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="modal_user_export" role="dialog" aria-labelledby="modal_user_export" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					 <h4 class="modal-title" id="modal_user_del_head"> 导出  </h4>
				</div>
				<div class="modal-body">
							导出所选记录？
				</div>
				<div class="modal-footer">
				<button type="button" class="btn btn-danger"  id="export_user_btn">导出</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
			</div>
			</div>
		</div>
	</div>
	
	<div class="ui-jqdialog modal-content" id="alertmod_table_user_mod"
		dir="ltr" role="dialog"
		aria-labelledby="alerthd_table_user" aria-hidden="true"
		style="width: 200px; height: auto; z-index: 2222; overflow: hidden;top: 274px; left: 534px; display: none;position: absolute;">
		<div class="ui-jqdialog-titlebar modal-header" id="alerthd_table_user"
			style="cursor: move;">
			<span class="ui-jqdialog-title" style="float: left;">注意</span> <a id ="alertmod_table_user_mod_a"
				class="ui-jqdialog-titlebar-close" style="right: 0.3em;"> <span
				class="glyphicon glyphicon-remove-circle"></span></a>
		</div>
		<div class="ui-jqdialog-content modal-body" id="alertcnt_table_user">
			<div id="select_message"></div>
			<span tabindex="0"> <span tabindex="-1" id="jqg_alrt"></span></span>
		</div>
		<div
			class="jqResize ui-resizable-handle ui-resizable-se glyphicon glyphicon-import"></div>
	</div>
	
	<!-- Peity-->
	<script src="${path }/resources/js/plugins/peity/jquery.peity.min.js"></script>
	
	<!-- Bootstrap table-->
	<script src="${path }/resources/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
	<script src="${path }/resources/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>

	<!-- 自定义js-->
	<script src="${path }/resources/js/content.js?v=1.0.0"></script>
	
	 <!-- jQuery Validation plugin javascript-->
    <script src="${path }/resources/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="${path }/resources/js/plugins/validate/messages_zh.min.js"></script>
   
   	<!-- jQuery form  -->
    <script src="${path }/resources/js/jquery.form.min.js"></script>
    
	<script type="text/javascript">
	Date.prototype.Format = function (fmt) {
	    var o = {  
	        "M+": this.getMonth() + 1, //月份   
	        "d+": this.getDate(), //日   
	        "H+": this.getHours(), //小时   
	        "m+": this.getMinutes(), //分   
	        "s+": this.getSeconds(), //秒   
	        "S": this.getMilliseconds() //毫秒   
	    };  
	    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));  
	    for (var k in o)  
	    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));  
	    return fmt;  
	};
	$(function () {
	    init();
	    $("#btn_search").bind("click",function(){
	    	//先销毁表格  
	        $('#table_user').bootstrapTable('destroy');
	    	init();
	    }); 
	    var validator = $("#form_user").validate({
    		submitHandler: function(form){
   		      $(form).ajaxSubmit({
   		    	dataType:"json",
   		    	success: function (data) {
   		    		
   		    		if(data.success && !data.errorMsg ){
   		    			validator.resetForm();
   		    			$('#modal_user_edit').modal('hide');
   		    			$("#btn_search").click();
   		    		}else{
   		    			$("#select_message").text(data.errorMsg);
   		    			$("#alertmod_table_user_mod").show();
   		    		}
                }
   		      });     
   		   }  
	    });
	    $("#submit_form_user_btn").click(function(){
	    	$("#form_user").submit();
	    });
	    
	    var validator = $("#form_st").validate({
    		submitHandler: function(form){
   		      $(form).ajaxSubmit({
   		    	dataType:"json",
   		    	success: function (data) {
   		    		
   		    		if(data.success && !data.errorMsg ){
   		    			validator.resetForm();
   		    			$('#modal_user_st').modal('hide');
   		    			$("#btn_search").click();
   		    		}else{
   		    			$("#select_message").text(data.errorMsg);
   		    			$("#alertmod_table_user_mod").show();
   		    		}
                }
   		      });     
   		   }  
	    });
	    $("#st_user_btn").click(function(){
	    	$("#form_st").submit();
	    });
	    
	});
	
	var init = function () {
		//1.初始化Table
	    var oTable = new TableInit();
	    oTable.Init();
	    //2.初始化Button的点击事件
	    var oButtonInit = new ButtonInit();
	    oButtonInit.Init();
	};
	
	var TableInit = function () {
	    var oTableInit = new Object();
	    //初始化Table
	    oTableInit.Init = function () {
	        $('#table_user').bootstrapTable({
	            url: 'jiyunList.htm',         //请求后台的URL（*）
	            method: 'post',                      //请求方式（*）
	            contentType : "application/x-www-form-urlencoded",
	            toolbar: '#toolbar',                //工具按钮用哪个容器
	            striped: true,                      //是否显示行间隔色
	            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
	            pagination: true,                   //是否显示分页（*）
	            sortable: true,                     //是否启用排序
	            sortName: "userid",
	            sortOrder: "desc",                   //排序方式
	            queryParams: oTableInit.queryParams,//传递参数（*）
	            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
	            pageNumber:1,                       //初始化加载第一页，默认第一页
	            pageSize: 10,                       //每页的记录行数（*）
	            pageList: [10, 25, 50, 75, 100],    //可供选择的每页的行数（*）
	            search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
	            strictSearch: true,
	            showColumns: true,                  //是否显示所有的列
	            showRefresh: false,                  //是否显示刷新按钮
	            minimumCountColumns: 2,             //最少允许的列数
	            clickToSelect: true,                //是否启用点击选中行
	           // height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
	            uniqueId: "userid",                     //每一行的唯一标识，一般为主键列
	            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
	            cardView: false,                    //是否显示详细视图
	            detailView: false,                   //是否显示父子表
	            columns: [{
	                checkbox: true
	            },
	            {
	                field: 'pId',
	                title: '人员编号',
	                sortable:true
	            },
	            {
	                field: 'pName',
	                title: '人员姓名',
	                sortable:true
	            },
	            {
	                field: 'pSex',
	                title: '人员性别',
	                sortable:true
	            },
	            {
	                field: 'pLike',
	                title: '人员爱好',
	                sortable:true
	            },
	            {
	                field: 'pCount',
	                title: '存款金额',
	                sortable:true
	            },{
	                field: 'pAge',
	                title: '人员年龄',
	                sortable:true
	            },
	            {
	                field: 'createtime',
	                title: '存款时间',
	                sortable:true,
	                formatter:function(value,row,index){
	                	return new Date(value).Format("yyyy-MM-dd");
	                }
	            }, {
	                field: 'cname',
	                title: '存款银行',
	            }],
	            onClickRow: function (row) {
	            	$("#alertmod_table_user_mod").hide();
	            }
	        });
	    };

	    //得到查询的参数
	    oTableInit.queryParams = function (params) {
	        var temp = {//这里的键的名字和控制器的变量名必须一致，这边改动，控制器也需要改成一样的
	            limit: params.limit,   //页面大小
	            offset: params.offset,  //页码
	            pName: $("#txt_search_username").val(),
	            bId: $("#txt_search_roleid").val(),
	            start: $("#txt_search_start").val(),
	            end: $("#txt_search_end").val(),
	            search:params.search,
	            order: params.order,
	            ordername: params.sort
	        };
	        return temp;
	    };
	    return oTableInit;
	};
	
	var ButtonInit = function () {
	    var oInit = new Object();
	    var postdata = {};

	    oInit.Init = function () {
	        //初始化页面上面的按钮事件
	    	$("#btn_add").click(function(){
	    		$('#password').attr("readOnly",false).val(getSelection.password);
	    		$("#form_user").resetForm();
	    		document.getElementById("hidden_txt_userid").value='';
	    		$('#modal_user_edit').modal({backdrop: 'static', keyboard: false});
				$('#modal_user_edit').modal('show');
	        });
	        
	    	$("#btn_edit").click(function(){
	    		var getSelections = $('#table_user').bootstrapTable('getSelections');
	    		if(getSelections && getSelections.length==1){
	    			initEditUser(getSelections[0]);
	    			$('#modal_user_edit').modal({backdrop: 'static', keyboard: false});
					$('#modal_user_edit').modal('show');
	    		}else{
	    			$("#select_message").text("请选择其中一条数据");
	    			$("#alertmod_table_user_mod").show();
	    		}
	    		
	        });
	    	
	    	$("#btn_delete").click(function(){
	    		var getSelections = $('#table_user').bootstrapTable('getSelections');
	    		if(getSelections && getSelections.length>0){
	    			$('#modal_user_del').modal({backdrop: 'static', keyboard: false});
	    			$("#modal_user_del").show();
	    		}else{
	    			$("#select_message").text("请选择数据");
	    			$("#alertmod_table_user_mod").show();
	    		}
	        });
	    	$("#btn_st").click(function(){
	    		
	    			$('#modal_user_st').modal({backdrop: 'static', keyboard: false});
	    			$("#modal_user_st").show();
	    		
	        });
	        
	    	$("#btn_export").click(function(){
	    	
	    			$('#modal_user_export').modal({backdrop: 'static', keyboard: false});
	    			$("#modal_user_export").show();
	    		
	        });
	    	
	    	$("#export_user_btn").click(function(){
	    		
	    		
	    		$.ajax({
	    		    url:"exportJiyun.htm",
	    		    dataType:"json",
	    		   
	    		    type:"post",
	    		    success:function(res){
	    		    	if(res.success){
	    	    			$('#modal_user_export').modal('hide');
	    	    			$("#btn_search").click();
	    	    		}else{
	    	    			$("#select_message").text(res.errorMsg);
	    	    			$("#alertmod_table_user_mod").show();
	    	    		}
	    		    }
	    		});
	    	});
	    	
	    	$("#btn_echarts").click(function(){
	    		var myEcharts=echarts.init(document.getElementById("main"));
	    			$('#modal_user_echarts').modal({backdrop: 'static', keyboard: false});
	    			$("#modal_user_echarts").show();
	    			$.ajax({
	    			    url:"echartsJiyun.htm",
	    			    dataType:"json",
	    			    
	    			    type:"post",
	    			    success:function(res){
	    			    	var xdata = new Array();
	    			    	var ydata = new Array();
	    			    	if(res.success){
	    			    		res.elist.forEach(function(emp){
		    			    		xdata.push(emp.cname);
		    			    		ydata.push({value:emp.num,name:emp.cname});
		    			    	})
		    			    	option = {
	    			    		    title: {
	    			    		        text: '某站点用户访问来源',
	    			    		        subtext: '纯属虚构',
	    			    		        left: 'center'
	    			    		    },
	    			    		    tooltip: {
	    			    		        trigger: 'item',
	    			    		        formatter: '{a} <br/>{b} : {c} ({d}%)'
	    			    		    },
	    			    		    legend: {
	    			    		        orient: 'vertical',
	    			    		        left: 'left',
	    			    		        data: xdata
	    			    		    },
	    			    		    series: [
	    			    		        {
	    			    		            name: '访问来源',
	    			    		            type: 'pie',
	    			    		            radius: '55%',
	    			    		            center: ['50%', '60%'],
	    			    		            data: ydata,
	    			    		            emphasis: {
	    			    		                itemStyle: {
	    			    		                    shadowBlur: 10,
	    			    		                    shadowOffsetX: 0,
	    			    		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	    			    		                }
	    			    		            }
	    			    		        }
	    			    		    ]
	    			    		};
	    		    		}
	    			    	 myEcharts.setOption(option);
	    			    }
	    			});
	        });
	    };

	    return oInit;
	};
	
	$("#alertmod_table_user_mod_a").click(function(){
		$("#alertmod_table_user_mod").hide();
	});
	
	function initEditUser(getSelection){
		$('#hidden_txt_userid').val(getSelection.pId);
		$('#bId').val(getSelection.bId);
		$('#pName').val(getSelection.pName);
		$("input[value='"+getSelection.pSex+"']").prop("checked",true)
		$('#pLike1').attr("checked",getSelection.pLike.indexOf("篮球")!=-1);
		$('#pLike2').attr("checked",getSelection.pLike.indexOf("足球")!=-1);
		$('#pLike3').attr("checked",getSelection.pLike.indexOf("排球")!=-1);
		$('#pCount').val(getSelection.pCount);
		$('#pAge').val(getSelection.pAge);
		$('#createtime').val(new Date(getSelection.createtime).Format("yyyy-MM-dd"));
		$('#password').attr("readOnly",true).val(getSelection.password);
	}
	
	$("#del_user_btn").click(function(){
		var getSelections = $('#table_user').bootstrapTable('getSelections');
		var idArr = new Array();
		var ids;
		getSelections.forEach(function(item){
			idArr.push(item.pId);
		});
		ids = idArr.join(",");
		$.ajax({
		    url:"deleteUser.htm",
		    dataType:"json",
		    data:{"ids":ids},
		    type:"post",
		    success:function(res){
		    	if(res.success){
	    			$('#modal_user_del').modal('hide');
	    			$("#btn_search").click();
	    		}else{
	    			$("#select_message").text(res.errorMsg);
	    			$("#alertmod_table_user_mod").show();
	    		}
		    }
		});
	});
	</script>

</body>
</html>