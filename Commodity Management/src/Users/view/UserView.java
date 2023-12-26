package Users.view;

import java.util.List;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import Commodity.dao.CommodityDAO;
import Commodity.dao.CommodityDAOJdbcImpl;
import Commodity.entity.Commodity;
import Login.view.LoginView;
import Users.dao.UsersDAO;
import Users.dao.UsersDAOJdbcImpl;
import Users.entity.Users;
import Users.util.ShowUtils;

public class UserView {

	private static CommodityDAO dd = new CommodityDAOJdbcImpl();
	private static UsersDAO ud = new UsersDAOJdbcImpl();

	public static void menu(Users users) {
		System.out.println("1���޸���Ϣ����/����ֵ");
		System.out.println("2��ͨ����Ʒ��������Ʒ");
		System.out.println("3������������Ʒ");
		System.out.println("4��������Ʒ");
		System.out.println("5����ѯ������Ϣ");
		System.out.println("6���˳���¼");
		System.out.println("7����������");
		System.out.println("0���˳�ϵͳ");
		int select = new Scanner(System.in).nextInt();
		switch (select) {
		case 1:
			UpdateView(users);
			break;
		case 2:
			FindOneView();
			break;
		case 3:
			FindAllView();
			break;
		case 4:
			BuyView(users);
			break;
		case 5:
			findone(users);
			break;
		case 6:
			LoginView.menu();
		case 7:
			System.out.println("��лʹ�ã�����ҵ���Ʒ�ܹ�������������������͡�����֧�ֽ������Ҽ�������");
			ShowUtils.main(null);
			break;
		case 0:
			System.exit(0);
			break;

		default:
			break;
		}
		menu(users);
	}

	private static void printHead() {
		System.out.println("��Ʒ���\t��Ʒ����\t��Ʒ����\t��Ʒ�۸�");
	}

	private static void printHeads() {
		System.out.println("�û�id\t�û��ǳ�\t�û�����\t�û����");
	}

	private static void printCommodity(Commodity commodity, int index) {
		System.out.println(commodity.getId() + "\t" + commodity.getName() + "\t" + commodity.getNumber() + "\t"
				+ commodity.getPrice());
	}

	private static void printUsersss(Users users, int index) {
		Users one = ud.findOne(users.getUid());
		System.out.println(one.getUid() + "\t" + one.getUname() + "\t" + one.getPassword() + "\t" + one.getBalance());
	}

	private static void findone(Users users) { // ʵ���û���ʾ�Լ�����Ϣ
		printHeads();
		printUsersss(users, 1);
	}

	private static void BuyView(Users users) { // �û���������=�Լ����-��Ʒ���
		// TODO Auto-generated method stub
		try {
		Commodity comm = null;
		Users us= null;
			System.out.println("��������Ҫ�������Ʒ���");
			int id = new Scanner(System.in).nextInt();
			comm = dd.findOne(id);
			us=ud.findOne(users.getUid());
			if(comm==null) {
				System.out.println("���������Ʒid������");
				return ;
			}
			if(us==null) {
				System.out.println("�����µ�¼");
				return;
			}
			if (comm!= null) { // �ж���Ʒid�Ƿ����
				printHead();
				printCommodity(comm, 1);
			} 
			boolean buy = false; // ͬ�����룬��֤�������۳��Ľ�����Ʒ���ͬʱ����ȥ
			boolean num = false;
			System.out.println("��Ҫ�����Ϊ" + comm.getName());
			System.out.println("�Ƿ�ȷ�Ϲ������Ʒ��y/n��");
			String s = new Scanner(System.in).next();
			if (s.equalsIgnoreCase("y")) {
				if (us.getBalance()>=comm.getPrice()) {
					
					System.out.println(us.getBalance());
					buy = ud.buy(us, comm); // �ж�����Ƿ���ڵ�ǰ��Ʒ���
				} else {
					System.out.println("���㣬����Ǯ���������");
					ShowUtils.main(null);
				}
				if (comm.getNumber() > 1) { // ���-1
					num = dd.num(comm);

				} else {
					System.out.println("��治��");
				}
				if (buy && num) { // ͬ��������ʾ�����Ƿ�ɹ�����֤�������۳��Ľ�����Ʒ���ͬʱ����ȥ
					System.out.println("����ɹ�");
					ud.unum(us);
					System.out.println("��������" + ud.unumber(us) + "����Ʒ");
				} else {
					System.out.println("����ʧ��");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	private static void FindAllView() { // �û�����ȫ����Ʒ
		// TODO Auto-generated method stub
		List<Commodity> list = dd.findAll();
		printHead();
		for (int i = 0; i < list.size(); i++) {
			printCommodity(list.get(i), i + 1);
		}
	}

	private static void FindOneView() { // �û�ͨ��id����һ����Ʒ
		// TODO Auto-generated method stub
		System.out.println("��Ʒ����");
		String name = new Scanner(System.in).next();
		List<Commodity> findname = dd.findname(name);
		if (findname.size() != 0) {
			printHead();
			for (Commodity commodity : findname) {
				System.out.println(commodity.getId() + "\t" + commodity.getName() + "\t" + commodity.getNumber() + "\t"
						+ commodity.getPrice());
			}
		} else {
			System.out.println("���޷��ϵ���Ʒ");
		}

	}

	private static void UpdateView(Users users) { // �ѵ�¼�û���Ҫ�޸��ǳƺͳ�ֵ���ķ�������
		// TODO Auto-generated method stub
		try {
			System.out.println("�Ƿ��޸��ǳ�");
			String s = new Scanner(System.in).next();
			if (s.equalsIgnoreCase("y")) {
				System.out.println("�ǳƣ�");
				String uname = new Scanner(System.in).next();
				users.setUname(uname);
			}
			System.out.println("�Ƿ��޸�����");
			String ss = new Scanner(System.in).next();
			if (ss.equalsIgnoreCase("y")) {
				System.out.println("���룺");
				String password = new Scanner(System.in).next();
				users.setPassword(password);
			}
			System.out.println("�Ƿ��ֵ���");
			s = new Scanner(System.in).next();
			if (s.equalsIgnoreCase("y")) {
				System.out.println("��");
				Double balance = new Scanner(System.in).nextDouble();
				ShowUtils.main(null);
				Users oldusers=ud.findOne(users.getUid());
				users.setBalance(oldusers.getBalance()+balance);
			}
			boolean b = ud.update(users);
			if (b) {
				System.out.println("��ֵ�޸ĳɹ�");
			} else {
				System.out.println("��ֵ�޸�ʧ��");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
