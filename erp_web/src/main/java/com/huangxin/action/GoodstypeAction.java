package com.huangxin .action;

import com.huangxin .biz.IGoodstypeBiz;
import com.huangxin .entity.Goodstype;

/**
 * 部门action
 * 
 * @author Kay
 *
 */
public class GoodstypeAction extends BaseAction<Goodstype>{
	private IGoodstypeBiz goodstypeBiz;

	public void setGoodstypeBiz(IGoodstypeBiz goodstypeBiz) {
		this.goodstypeBiz = goodstypeBiz;
		super.setBaseBiz(goodstypeBiz);
	}
	
	
	
	public void delete()  {
		Goodstype goodstype = goodstypeBiz.get(super.getId());
		if (goodstype.getGoodss()==null) {
			try {
				goodstypeBiz.delete(super.getId());
				ajaxReturn(true, "删除成功");
			} catch (Exception e) {
				ajaxReturn(false, "删除失败");
				e.printStackTrace();
			}
		}else{
			ajaxReturn(false, "此商品类型还有关联的商品未删除");
		}
		
	}
}
