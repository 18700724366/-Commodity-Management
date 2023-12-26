package Commodity.view;



import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import Commodity.dao.CommodityDAO;
import Commodity.dao.CommodityDAOJdbcImpl;
import Commodity.entity.Commodity;
import Users.dao.UsersDAO;
import Users.dao.UsersDAOJdbcImpl;
import Users.entity.Users;





public class CommodityView {
	
	private static CommodityDAO dd=new CommodityDAOJdbcImpl();
	private static UsersDAO ud=new UsersDAOJdbcImpl();

	public static void menu() {
		System.out.println("----��ӭ������̨����----");
		System.out.println("1�������Ʒ");
		System.out.println("2����Ʒ�޸�");
		System.out.println("3����Ʒɾ��");
		System.out.println("4������һ����Ʒ");
		System.out.println("5������������Ʒ");
		System.out.println("6������һ���û���Ϣ");
		System.out.println("7�����������û���Ϣ");
		System.out.println("8�������û���Ϣ");
		System.out.println("0���˳�ϵͳ");
		int select = new Scanner(System.in).nextInt();
		switch (select) {
		case 1:
			AddView();
			break;
		case 2:
			UpdateView();
			break;
		case 3:
			DeleteView();
			break;
		case 4:
			FindOneView();
			break;
		case 5:
			FindAllView();
			break;
		case 6:
			FindoneUserView();
			break;
		case 7:
			FindAllUserView();
			break;
		case 8:
			ManageusersView();
			break;
		case 0:
			System.exit(0);
			break;

		default:
			break;
		}
		menu();
	}

	private static void printHead() {
		System.out.println("��Ʒ���\t��Ʒ����\t��Ʒ����\t��Ʒ�۸�");
	}
	private static void printHeadss() {
		System.out.println("�û����\t�û��ǳ�\t�û�����\t�û��������\t�û����");
	}
	
	private static void printCommodity(Commodity commodity,int index) {
		System.out.println(commodity.getId()+"\t"+commodity.getName()+"\t"+commodity.getNumber()+"\t"+commodity.getPrice());
	}
	private static void printUsers(Users users,int index) {
		System.out.println(users.getUid()+"\t"+users.getUname()+"\t"+users.getPassword()+"\t"+users.getUnumber()+"\t\t"+users.getBalance());
	}
	
	private static void ManageusersView() {
		// TODO Auto-generated method stub
		try {
			Users users=new Users();
			System.out.println("��������Ҫ������û�ID");
			int uid = new Scanner(System.in).nextInt();
			users.setUid(uid); 
			System.out.println("�Ƿ�����ǳ�");
			String  ss = new Scanner(System.in).next();
			if(ss.equalsIgnoreCase("y")) {
				System.out.println("�ǳƣ�");
				String uname = new Scanner(System.in).next();
				users.setUname(uname);
			}
			System.out.println("�Ƿ�������");
			ss = new Scanner(System.in).next();
			if(ss.equalsIgnoreCase("y")) {
				System.out.println("��");
				Double balance  = new Scanner(System.in).nextDouble();
				users.setBalance(balance);
			}
			boolean b = ud.update(users);
			if(b) {
				System.out.println("�޸ĳɹ�");
			}else {
			System.out.println("�޸�ʧ��");
			}
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
	
	private static void FindoneUserView() {
		// TODO Auto-generated method stub
		System.out.println("�û���ţ�");
		int uid=new Scanner(System.in).nextInt();
		Users users=ud.findOne(uid);
		if(users!=null) {
			printHeadss();
			printUsers(users,1);
		}else {
			System.out.println("�������uid������");
		}
		
	}
	private static void FindAllUserView() {
		// TODO Auto-generated method stub
		List<Users> list = ud.findAll();
		printHeadss();
		for (int i = 0; i < list.size(); i++) {
			printUsers(list.get(i),i+1);
		}
	}
	
	
	private static void FindAllView() {
		// TODO Auto-generated method stub
		List<Commodity> list = dd.findAll();
		printHead();
		for (int i = 0; i < list.size(); i++) {
			printCommodity(list.get(i),i+1);
		}
	}

	private static void FindOneView() {
		// TODO Auto-generated method stub
		System.out.println("��ţ�");
		int id=new Scanner(System.in).nextInt();
		Commodity commodity=dd.findOne(id);
		if(commodity!=null) {
			printHead();
			printCommodity(commodity,1);
		}else {
			System.out.println("�������id������");
		}
		
	}


	private static void DeleteView() {
		// TODO Auto-generated method stub
		System.out.println("��ţ�");
		int id=new Scanner(System.in).nextInt();
		boolean b = dd.delete(id);
		if(b) {
			System.out.println("ɾ���ɹ�");
		}else {
			System.out.println("ɾ��ʧ��");
		}
	}
	private static void UpdateView() {
		// TODO Auto-generated method stub
		try {
			Commodity commodity=new Commodity();
			System.out.println("��ţ�");
			int id=new Scanner(System.in).nextInt();
			commodity.setId(id);
			System.out.println("�Ƿ��޸�����");
			String s = new Scanner(System.in).next();
			if(s.equalsIgnoreCase("y")) {
				System.out.println("���ƣ�");
				String name = new Scanner(System.in).next();
				commodity.setName(name);
			}
			System.out.println("�Ƿ��޸Ŀ��");
			 s = new Scanner(System.in).next();
			if(s.equalsIgnoreCase("y")) {
				System.out.println("��棺");
				int number  = new Scanner(System.in).nextInt();
				commodity.setNumber(number);
			}
			System.out.println("�Ƿ��޸ļ۸�");
			 s = new Scanner(System.in).next();
			if(s.equalsIgnoreCase("y")) {
				System.out.println("�۸�");
				Double price  = new Scanner(System.in).nextDouble();
				commodity.setPrice(price);
			}
			boolean b = dd.update(commodity);
			if(b) {
				System.out.println("�޸ĳɹ�");
			}else {
			System.out.println("�޸�ʧ��");
			}
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}

	private static void AddView() {
		// TODO Auto-generated method stub
		try {
			System.out.println("��������Ʒ���ƣ�");
			String name=new Scanner(System.in).next();
			System.out.println("��������Ʒ������");
			int number=new Scanner(System.in).nextInt();
			System.out.println("��������Ʒ�۸�");
			Double price=new Scanner(System.in).nextDouble();
			boolean b = dd.add(new Commodity(name, number, price));
			if(b) {
				System.out.println("��ӳɹ�");
			}else {
				System.out.println("���ʧ��");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}




}

