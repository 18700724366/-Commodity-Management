package Commodity.dao;

import java.util.List;

import Commodity.entity.Commodity;
import Commodity.util.JdbcOperation;

public class CommodityDAOJdbcImpl implements CommodityDAO {
	JdbcOperation<Commodity> jo = new JdbcOperation<Commodity>();

	@Override
	public boolean add(Commodity commodity) { // �����Ʒ����
		if (commodity.getNumber() < 0 || commodity.getPrice() < 0) {
		} else {
			String sql = "insert into commodity values(null,?,?,?)";
			Object[] objs = { commodity.getName(), commodity.getNumber(), commodity.getPrice() };
			return jo.UpdateSql(sql, objs);
		}
		return false;
	}

	@Override
	public boolean delete(Integer id) { // ��Ʒɾ��
		String sql = "delete from commodity where id=?";
		Object[] objs = { id };
		return jo.UpdateSql(sql, objs);
	}

	@Override
	public boolean update(Commodity obj) { // �޸���Ʒ
		// TODO Auto-generated method stub
		Commodity commodity = this.findOne(obj.getId());
		if (obj.getName() != null) { // �п�
			commodity.setName(obj.getName());
		}
		if (obj.getNumber() != null) {
			commodity.setNumber(obj.getNumber());
		}
		if (obj.getPrice() != null) {
			commodity.setPrice(obj.getPrice());
		}
		String sql = "update commodity set Name=?,Number=?,Price=? where id=?"; // sql�����ʾ��Ʒ����Ϣ
		Object[] objs = { commodity.getName(), commodity.getNumber(), commodity.getPrice(), commodity.getId() };
		return jo.UpdateSql(sql, objs);

	}

	@Override
	public Commodity findOne(Integer id) { // ��ѯһ����Ʒ
		// TODO Auto-generated method stub
		String sql = "select * from commodity where id=?";
		Object[] objs = { id };
		List<Commodity> list = jo.seleList(sql, objs, Commodity.class);
		return list.size() == 0 ? null : list.get(0);
	}

	@Override
	public List<Commodity> findAll() { // �������е���Ʒ
		// TODO Auto-generated method stub
		String sql = "select * from commodity";
		Object[] objs = {};
		return jo.seleList(sql, objs, Commodity.class);
	}

	@Override
	public boolean num(Commodity comm) { // �û�����������һ���ķ���
		String sql = "UPDATE commodity set number=(" + comm.getNumber() + "-1) where id=" + comm.getId();
		Object[] objs = {};
		return jo.UpdateSql(sql, objs);
	}

	@Override
	public List findname(String str) { // ʹ������ģ����ѯ
		String sql = "select * from commodity where name like ?";
		Object[] objs = { "%" + str + "%" };
		return jo.seleList(sql, objs, Commodity.class);
	}

}
