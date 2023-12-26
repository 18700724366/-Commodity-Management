package Commodity;

/*
 * 找个是后台管理员上架添加商品的app
 * 里面有商品增删改查功能
 */

import Commodity.view.CommodityView;

public class Appbackstage {
	public static void main(String[] args) {
		CommodityView dv = new CommodityView();
		dv.menu();
	}
}
