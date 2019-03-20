//提交的方法
var method = '';
var listParam='';
var saveParam = '';
$(function(){
		$('#grid').datagrid({
			url : name+'_getList'+listParam,
			striped : true,//各行换色
			pagination : true,//分页工具栏
			pagePosition : 'bottom',
			singleSelect:true,
			pageSize : 10,
			pageNumber : 1,
			pageList : [ 10,20 ],
			columns : columns,
			toolbar : [ {
				iconCls : 'icon-add',
				text : '添加'+text,
				handler : function() {
					//点击新增按钮时修改方法名称
					method = 'add';
					$('#editDlg').dialog('open');
					//清空表单
					$('#editForm').form('clear');
//					启用员工管理登录名编辑
					$("#username").textbox({editable:true});
				}
			}, '-' ]
		});
		$('#btnSearch').bind('click',function(){
			var formData = $('#searchForm').serializeJSON();
			//alert(JSON.stringify(formData));
			/* $.ajax({
				url:"dep_getList",
				data:formData,
				dataType:'json',
				type:'post',
				success:function(rtn){
					//加载数据
					$('#grid').datagrid('loadData',rtn);
				}
				
			}); */
			$('#grid').datagrid('load',formData);
		});
		/* 编辑窗口 */
		$('#editDlg').dialog({
		    title: '编辑窗口',
		    width: 300,
		    closed: true,
		    modal: true
		});
		
	});
	/**
	 * 提交表单
	 * @returns
	 */
	function submitForm(){
		var isValid = $("#editForm").form('validate');
		if (isValid) {
			/* 窗口提交 */
			var formData = $('#editForm').serializeJSON();
			$.ajax({
				url:name+'_'+method+saveParam,
				data:formData,
				dataType:'json',
				type:'post',
				success:function(rtn){
					//返回的数据
					$.messager.alert('提示',rtn.message,'info',function(){
						//成功则关闭对话框
						$('#editDlg').dialog('close');
						$('#grid').datagrid('reload');
						
					});
					
				}
			});
		}else{
			$.messager.alert('提示','请输入正确的信息！','info'); 
			return ;
		}
		
	}
	/* 删除方法 */
	function del(uuid){
		$.messager.confirm('确认对话框', '您确定要删除吗?', function(r){
			if (r){
				$.ajax({
					url:name+'_delete',
					data:{'id':uuid},
					dataType:'json',
					type:'post',
					success:function(rtn){
						//返回的数据
						$.messager.alert('提示',rtn.message,'info',function(){
							//成功则关闭对话框
							$('#grid').datagrid('reload');
						});
						
					}
				});
			}
		});
	}
	//修改部门
	function edit(uuid){
		
		//清空表单
		$('#editForm').form('clear');
		method = 'update';
		$('#editDlg').dialog('open');
		$('#editForm').form('load',name+'_get?id='+uuid);
//		禁用员工管理登录名编辑
		$("#username").textbox({editable:false});
	}