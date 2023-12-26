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

	boolean login(Users users); // ��¼����

	boolean unum(Users users);

	Integer unumber(Users users); // ������Ʒ����

	boolean buy(Users users, Commodity comm); // ������Ʒ����û������ȥ������Ʒ�Ľ��

	Integer findid(Users users); // �����û�id

}
