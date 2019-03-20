var existEditIndex = -1;
$(function(){
	$('#grid').datagrid({
		striped : true,//各行换色
		singleSelect:true,
		rownumbers:true,//行号
		showFooter:true,//行脚
		columns : [ [
			﻿{field : 'goodsuuid',title : '商品编号',width : 100,align : 'center',editor:{type:'numberbox',options:{readonly:true}}},//禁用编辑框
			﻿{field : 'goodsname',title : '商品名称',width : 100,align : 'center',editor:{type:'combobox',options:{
				 url:'goods_list',
				 valueField:'name',
				 textField:'name',
				 editable: false,
				 onSelect: function(goods){
					 bindGridEditor();
					 var goodsuuidEditor = getEditor('goodsuuid');
					 goodsuuidEditor.target.textbox('setValue',goods.uuid);
					 //设置为进货价格   target 为真正的element
					 var priceEditor = getEditor('price');
					 priceEditor.target.textbox('setValue',goods.inprice);
//					 设置表格的值
					 $("#grid").datagrid('getRows')[existEditIndex].price= goods.inprice;
					 
					 var numEditor = getEditor('num');
					 if (numEditor) {
						$(numEditor.target).textbox('textbox').focus();
					 }
//					 bindGridEditor();
				 }
			}}},
			﻿{field : 'price',title : '价格',width : 100,align : 'center',editor:{type:'numberbox',options:{precision:2}}},
			﻿{field : 'num',title : '数量',width : 100,align : 'center',editor:'numberbox'},
			﻿{field : 'money',title : '金额',width : 100,align : 'center',editor:{type:'numberbox',options:{precision:2,readonly:true}}},
			{
				field : 'xxxx',
				title : '操作',
				width : 100,
				align : 'center',
				formatter : function(value, row, index) {
					if (row.num == '总计') {
						return '';
					}
					return "<a href='javascript:void(0)' onclick='deleteRow("+index+")'>删除</a>"
				}
			} ] ],
		toolbar : [ {
			iconCls : 'icon-add',
			text : '新增',
			handler : function() {
				//如果存在编辑的行，则关闭
				if (existEditIndex > -1) {
//					关闭编辑的行
					$('#grid').datagrid('endEdit',existEditIndex);
				}
//				添加一行
				$('#grid').datagrid('appendRow',{num:0,money:0});
				var rows = $('#grid').datagrid('getRows');
				existEditIndex = rows.length-1;9
//				需要先设置编辑器
				$('#grid').datagrid('beginEdit',existEditIndex);
				//绑定事件
				
			}
		}, '-' ,{
			iconCls : 'icon-save',
				text : '提交',
				handler : function() {
					//判断是否添加了商品
					if (existEditIndex > -1) {
//						关闭编辑的行
						$('#grid').datagrid('endEdit',existEditIndex);
					}
					//获取订单明细
					var rows = $('#grid').datagrid('getRows');
					if (rows.length==0) {
						return;
					}
					var formData = $("#orderForm").serializeJSON();
					if (formData['t.supplieruuid']=='') {
						$.messager.alert('提示','请选择供应商','info')
						return;
					}
					//转换成json字符串
					//给json对象加了给json的key值，再赋值
					formData.json = JSON.stringify(rows);
//					formData['json']= JSON.stringify(rows);
					$.ajax({
						url:'orders_add',
						data:formData,
						dataType:'json',
						type:'post',
						success:function(rtn){
							$.messager.alert('提示',rtn.message,'info',function(){
								if (rtn.success) {
									//清空供应商
									$('#supplier').combogrid('clear');
									//清空表格
									$('#grid').datagrid('loadData',{total:0,rows:[],footer:[{num:'总计',money:0}]});

								}
							});
						}
					});
				}
			}
		],
//		单击行事件
		onClickCell:function(rowIndex, field, value){
//			rowIndex索引
//			field：列的字段名
//			value：列的对象
			$('#grid').datagrid('endEdit',existEditIndex);
			existEditIndex = rowIndex;
			$('#grid').datagrid('beginEdit',existEditIndex);
		}
	});
	/*$('#grid').datagrid('reloadFooter',[
		{num: '总计', money:0 }
	]);*/
	$('#supplier').combogrid({
	    delay: 500,
	    mode: 'remote',
	    panelWidth:'604px',
	    url: 'supplier_list?t1.type=1',
	    idField: 'uuid',
	    textField: 'name',
	    columns: [[
	    	﻿{field : 'uuid',title : '编号',width : 100,align : 'center'},
			﻿{field : 'name',title : '名称',width : 100,align : 'center'},
			﻿{field : 'address',title : '联系地址',width : 100,align : 'center'},
			﻿{field : 'contact',title : '联系人',width : 100,align : 'center'},
			﻿{field : 'tele',title : '联系电话',width : 100,align : 'center'},
			﻿{field : 'email',title : '邮件地址',width : 100,align : 'center',sortable:true},
	    ]]
	});
})
/**
 * 获取当前行指定的编辑器
 * @param _field 编辑器字段名
 * @returns
 */
function getEditor(_field){
	return $('#grid').datagrid('getEditor',{index:existEditIndex,field:_field});
}
/**
 * 计算价格
 * @returns
 */
function cal(){
	 var price = $(getEditor('price').target).val();
	 var num = $(getEditor('num').target).val();
	 var total = num*price;
	 total = total.toFixed(2);
	 var moneyEditor = getEditor('money');
	 moneyEditor.target.textbox('setValue',total);
	 //更新表格中的数据
	 $("#grid").datagrid('getRows')[existEditIndex].money= total
	 sum();
}
/**
 * 绑定键盘的输入事件
 */
function bindGridEditor(){
	var numEditor = getEditor('num');
	numEditor.target.numberbox({
		onChange:function(newValue,oldValue){
			cal();
		}
	})
	
	
	var priceEditor = getEditor('price');
	priceEditor.target.numberbox({
		onChange:function(newValue,oldValue){
			 $("#grid").datagrid('getRows')[existEditIndex].price= newValue
			cal();
		}
	})
}
/**
 * 计算总金额
 */
function sum(){
	var rows = $('#grid').datagrid('getRows');
	var total = 0;
	$.each(rows,function(i,row){
		total+=parseFloat(row.money);
	})
	 total = total.toFixed(2);
	$('#grid').datagrid('reloadFooter',[
		{num: '总计', money:total }
	]);
}
/**
 * 删除行
 * @param rowIndex 索引
 * @returns
 */
function deleteRow(rowIndex){
	//如果其他行在编辑，需先结束编辑
	$('#grid').datagrid('endEdit',existEditIndex);
	/*existEditIndex = rowIndex;
	$('#grid').datagrid('beginEdit',existEditIndex);*/
	
	//删除行
	var rows = $('#grid').datagrid('deleteRow',rowIndex);
	//结束编辑
	$('#grid').datagrid('endEdit',existEditIndex);
	//获取数据
	var data = $('#grid').datagrid('getData');
	//重新加载数据
	$('#grid').datagrid('loadData',data);
	sum();
}