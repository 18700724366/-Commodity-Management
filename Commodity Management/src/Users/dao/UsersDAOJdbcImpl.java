package Users.dao;

import java.util.List;

import Commodity.entity.Commodity;
import Commodity.util.JdbcOperation;
import Users.entity.Users;

public class UsersDAOJdbcImpl implements UsersDAO {
	JdbcOperation<Users> jo = new JdbcOperation<Users>();

	@Override
	public boolean login(Users users) {
		// TODO Auto-generated method stub
		try {

			Users findOne = findOne(users.getUid());
			if (findOne.getPassword().equals(users.getPassword()) && findOne.getUid() == users.getUid()) {
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean add(Users users) { // 用户注册
		// TODO Auto-generated method stub
		try {

		if (users.getBalance() < 0) {
		} else {
			String sql = "insert into users(uname,password,balance) values(?,?,?)";
			Object[] objs = { users.getUname(), users.getPassword(), users.getBalance() };
			return jo.UpdateSql(sql, objs);
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
		

	}

	@Override
	public boolean unum(Users users) { // 用户购买成功后统计数量+1
		String sql = "UPDATE users set unumber=(" + users.getUnumber() + "+1) where uid=" + users.getUid();
		Object[] objs = {};
		return jo.UpdateSql(sql, objs);
	}

	@Override
	public Integer unumber(Users users) { // 用户购买后的统计数据更新
		String sql = "select * from users where uid=" + users.getUid();
		Object[] objs = {};
		List<Users> seleList = jo.seleList(sql, objs, Users.class);
		return seleList.get(0).getUnumber();
	}

	@Override
	public boolean buy(Users users, Commodity comm) { // 购买商品后的用户金额会减去单个商品的金额
		String sql = "UPDATE users set balance=(" + users.getBalance() + "-" + comm.getPrice() + ") where uid="
				+ users.getUid();
		Object[] objs = {};
		return jo.UpdateSql(sql, objs);
	}

	@Override
	public boolean delete(Integer id) { // 用户注销
		// TODO Auto-generated method stub
		String sql = "delete from users where uid=?";
		Object[] objs = { id };
		return jo.UpdateSql(sql, objs);
	}

	@Override
	public boolean update(Users obj) { // 用户修改当前用户登录后的信息，充值提现余额
		// TODO Auto-generated method stub
		Users users = this.findOne(obj.getUid());
		if (obj.getUname() != null) {
			users.setUname(obj.getUname());
		}
		if (obj.getBalance() != null) {
			users.setBalance(obj.getBalance());
		}
		String sql = "update users set uname=?,password=?,balance=? where uid=?";
		Object[] objs = { users.getUname(), users.getPassword(), users.getBalance(), users.getUid() };
		return jo.UpdateSql(sql, objs);
	}

	@Override
	public Users findOne(Integer uid) { // 查找一个用户，只能管理员调用
		String sql = "select * from users where uid=?";
		Object[] objs = { uid };
		List<Users> list = jo.seleList(sql, objs, Users.class);
		return list.size() == 0 ? null : list.get(0);
	}

	@Override
	public List<Users> findAll() { // 查找全部用户，只能管理员调用
		// TODO Auto-generated method stub
		String sql = "select * from users";
		Object[] objs = {};
		return jo.seleList(sql, objs, Users.class);
	}

	@Override
	public Integer findid(Users users) { // 通过用户名查找用户id
		String sql = "select * from users where uname=?";
		Object[] objs = { users.getUname() };
		List<Users> list = jo.seleList(sql, objs, Users.class);
		return list.size() == 0 ? -1 : list.get(0).getUid();
	}

}
