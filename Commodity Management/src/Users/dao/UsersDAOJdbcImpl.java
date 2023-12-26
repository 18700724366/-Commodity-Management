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
	public boolean add(Users users) { // �û�ע��
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
	public boolean unum(Users users) { // �û�����ɹ���ͳ������+1
		String sql = "UPDATE users set unumber=(" + users.getUnumber() + "+1) where uid=" + users.getUid();
		Object[] objs = {};
		return jo.UpdateSql(sql, objs);
	}

	@Override
	public Integer unumber(Users users) { // �û�������ͳ�����ݸ���
		String sql = "select * from users where uid=" + users.getUid();
		Object[] objs = {};
		List<Users> seleList = jo.seleList(sql, objs, Users.class);
		return seleList.get(0).getUnumber();
	}

	@Override
	public boolean buy(Users users, Commodity comm) { // ������Ʒ����û������ȥ������Ʒ�Ľ��
		String sql = "UPDATE users set balance=(" + users.getBalance() + "-" + comm.getPrice() + ") where uid="
				+ users.getUid();
		Object[] objs = {};
		return jo.UpdateSql(sql, objs);
	}

	@Override
	public boolean delete(Integer id) { // �û�ע��
		// TODO Auto-generated method stub
		String sql = "delete from users where uid=?";
		Object[] objs = { id };
		return jo.UpdateSql(sql, objs);
	}

	@Override
	public boolean update(Users obj) { // �û��޸ĵ�ǰ�û���¼�����Ϣ����ֵ�������
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
	public Users findOne(Integer uid) { // ����һ���û���ֻ�ܹ���Ա����
		String sql = "select * from users where uid=?";
		Object[] objs = { uid };
		List<Users> list = jo.seleList(sql, objs, Users.class);
		return list.size() == 0 ? null : list.get(0);
	}

	@Override
	public List<Users> findAll() { // ����ȫ���û���ֻ�ܹ���Ա����
		// TODO Auto-generated method stub
		String sql = "select * from users";
		Object[] objs = {};
		return jo.seleList(sql, objs, Users.class);
	}

	@Override
	public Integer findid(Users users) { // ͨ���û��������û�id
		String sql = "select * from users where uname=?";
		Object[] objs = { users.getUname() };
		List<Users> list = jo.seleList(sql, objs, Users.class);
		return list.size() == 0 ? -1 : list.get(0).getUid();
	}

}
