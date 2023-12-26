package Commodity.dao;

import java.util.List;

import Commodity.entity.Commodity;

public interface CommodityDAO {
	boolean add(Commodity obj); // �����Ʒ�ķ���

	boolean delete(Integer id); // ɾ����Ʒ

	boolean update(Commodity obj); // �޸���Ʒ��Ϣ

	Commodity findOne(Integer id); // ����һ����Ʒ

	List<Commodity> findAll(); // ����ȫ����Ʒ

	boolean num(Commodity comm); // �û�����һ������-1�ķ���

	List<Commodity> findname(String str); // �û�ģ����ѯ��Ʒ�ķ���
}
