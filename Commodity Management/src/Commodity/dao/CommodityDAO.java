package Commodity.dao;

import java.util.List;

import Commodity.entity.Commodity;

public interface CommodityDAO {
	boolean add(Commodity obj); // 添加商品的方法

	boolean delete(Integer id); // 删除商品

	boolean update(Commodity obj); // 修改商品信息

	Commodity findOne(Integer id); // 查找一个商品

	List<Commodity> findAll(); // 查找全部商品

	boolean num(Commodity comm); // 用户购买一个后库存-1的方法

	List<Commodity> findname(String str); // 用户模糊查询商品的方法
}
