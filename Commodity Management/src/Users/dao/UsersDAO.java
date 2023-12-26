package Users.dao;

import java.util.List;

import Commodity.entity.Commodity;
import Users.entity.Users;

public interface UsersDAO {
	boolean add(Users obj);

	boolean delete(Integer id);

	boolean update(Users obj);

	Users findOne(Integer id);

	List<Users> findAll();

	boolean login(Users users); // 登录方法

	boolean unum(Users users);

	Integer unumber(Users users); // 查找商品数量

	boolean buy(Users users, Commodity comm); // 购买商品后的用户金额会减去单个商品的金额

	Integer findid(Users users); // 查找用户id

}
