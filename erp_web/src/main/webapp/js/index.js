$(function() {
		showName();
		initMenu();
		
	});
	function showName() {
		$.ajax({
			url : 'login_showName',
			dataType : 'json',
			type : 'post',
			success : function(rtn) {
				if (rtn.success) {
					//访问json的两种方式
					//对象.key
					//对象[' key']
					$('#username').html(rtn.message);
				} else {
					$.messager.alert("提示", "请先登陆", "info", function() {
						location.href = 'login.html';
					})
				}
			}
		});
	}
	function loginOut() {
		$.ajax({
			url : 'login_loginOut',
			type : 'post',
			success : function(rtn) {
				location.href = "login.html";
			}
		});
	}
	
	//创建选项卡
	function createTabs(textContent,url){
		//判断选项卡是否存在
		var flag = $("#tt").tabs("exists",textContent);
		if (!flag) {
			//如果不存在
			$("#tt").tabs('add',{
			    title:textContent,
			    content:createUrl(url),
			    closable:true
			    
			});
		}else{
			$("#tt").tabs("select",textContent)
		}
	}
	
	function createUrl(url){
		return "<iframe  src='"+url+"' style='border:0px;width:100%;height:95%;'></iframe>";
	}
	
	function initMenu(){
		
		var _menus='';
		$.ajax({
			url : 'menu_getMeneTrees',
			dataType : 'json',
			type : 'post',
			success : function(rtn) {
				var content='';
				_menus = rtn;
				$.each(_menus.menus,function(i,n){
					content='';
					$.each(n.menus,function(j,v){
						
						content+="<a href='"+v.url+"' class='easyui-linkbutton menuA' data-options=\"plain:true,width:'170px',iconCls:'"+v.icon+"'\" style='padding: 0px,5px;text-align: left;'>"+v.menuname+"</a>";
						
					});
					
					$('#mainMenu').accordion('add', {
						title: n.menuname,
						content: content,
						selected: false,
						iconCls:'icon-ok',
						bodyCls:'menuPanel'
					});
				});
				$(".menuA").click(function(){
					// 获得超链接选项卡
					var textContent = $(this).html();
					//获得路径
					var url = this.href;
					
					createTabs(textContent,url);
					//让超链接不跳转
					return false;
				});
			}
		});
		
		
	}
	