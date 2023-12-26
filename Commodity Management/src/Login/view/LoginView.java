package Login.view;

import java.util.Scanner;

import Commodity.dao.CommodityDAO;
import Commodity.dao.CommodityDAOJdbcImpl;
import Commodity.entity.Commodity;
import Users.dao.UsersDAO;
import Users.dao.UsersDAOJdbcImpl;
import Users.entity.Users;
import Users.view.UserView;


public class LoginView {
	private static CommodityDAO dd=new CommodityDAOJdbcImpl();
	private static UsersDAO ud=new UsersDAOJdbcImpl();
	public static void menu() {
		System.out.println("��ӭ�����ҵ��̳�");
	System.out.println("1���û�ע��");
	System.out.println("2���û���¼");
	System.out.println("3���û�ע��");
	System.out.println("0���˳�ϵͳ");
	int select = new Scanner(System.in).nextInt();
	switch (select) {
	case 1:
		AddView();
		break;
	case 2:
		LoginView();
		break;
	case 3:
		DeleteView();
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
	private static void printHeads() {
		System.out.println("�û�����\t�û����");
	}
	
	private static void printCommodity(Commodity commodity,int index) {
		System.out.println(commodity.getId()+"\t"+commodity.getName()+"\t"+commodity.getNumber()+"\t"+commodity.getPrice());
	}

	
	private static void printUsersss(Users users,int index) {
		Users one = ud.findOne(users.getUid());
		System.out.println(one.getUname()+"\t"+one.getBalance());
	}
	
	private static void AddView() {			//ע���û�
		// TODO Auto-generated method stub
		try {
			System.out.println("�������û��ǳƣ�");
			String name=new Scanner(System.in).next();
			System.out.println("�������û����룺");
			String password=new Scanner(System.in).next();
			System.out.println("�������ֵ��");
			Double price=new Scanner(System.in).nextDouble();
			Users users=new Users(name,password,0, price);
			boolean b = ud.add(users);
			
			if(b) {
				System.out.println("ע��ɹ�");
				System.out.println("�����û�idΪ"+ud.findid(users));
			}else {
				System.out.println("ע��ʧ��");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	private static void LoginView() {			//�û���¼
		// TODO Auto-generated method stub
		Users users = new Users();
		System.out.println("�������û�id��");
		int uid = new Scanner(System.in).nextInt();
		System.out.println("�������û����룺");
		String password = new Scanner(System.in).next();
		users.setUid(uid);
		users.setPassword(password);
		boolean b = ud.login(users);
		if(b) {
			Users one = ud.findOne(uid);
			String uname = one.getUname();
			System.out.println("��¼�ɹ�"+uname+"������Ϊ������Ϣ");
			printHeads();
			printUsersss(users,2);
			UserView.menu(users);
		}else {
			System.out.println("�˺��������");
			menu();
		}
		
//		Users users=ud.findOne(uid);
//		if(users!=null) {
//			System.out.println("��¼�ɹ���"+users.getUname()+"��ӭ��"+"����Ϊ������Ϣ");
//			printHeads();
//			printUsers(users,1);
//			UserView uv=new UserView();
//			uv.menu(users);
//		}else {
//			System.out.println("��������û�id������");
//		}
	}
	
	private static void DeleteView() {			//�û�ע��
		// TODO Auto-generated method stub
		System.out.println("��ţ�");
		int uid=new Scanner(System.in).nextInt();
		boolean b = ud.delete(uid);
		if(b) {
			System.out.println("ע���ɹ�");
		}else {
			System.out.println("ע��ʧ��");
		}
	}
}