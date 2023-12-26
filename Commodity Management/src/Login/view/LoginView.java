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
		System.out.println("欢迎来到我的商城");
	System.out.println("1、用户注册");
	System.out.println("2、用户登录");
	System.out.println("3、用户注销");
	System.out.println("0、退出系统");
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
		System.out.println("商品编号\t商品名称\t商品数量\t商品价格");
	}
	private static void printHeads() {
		System.out.println("用户名称\t用户余额");
	}
	
	private static void printCommodity(Commodity commodity,int index) {
		System.out.println(commodity.getId()+"\t"+commodity.getName()+"\t"+commodity.getNumber()+"\t"+commodity.getPrice());
	}

	
	private static void printUsersss(Users users,int index) {
		Users one = ud.findOne(users.getUid());
		System.out.println(one.getUname()+"\t"+one.getBalance());
	}
	
	private static void AddView() {			//注册用户
		// TODO Auto-generated method stub
		try {
			System.out.println("请输入用户昵称：");
			String name=new Scanner(System.in).next();
			System.out.println("请输入用户密码：");
			String password=new Scanner(System.in).next();
			System.out.println("请输入充值金额：");
			Double price=new Scanner(System.in).nextDouble();
			Users users=new Users(name,password,0, price);
			boolean b = ud.add(users);
			
			if(b) {
				System.out.println("注册成功");
				System.out.println("您的用户id为"+ud.findid(users));
			}else {
				System.out.println("注册失败");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	private static void LoginView() {			//用户登录
		// TODO Auto-generated method stub
		Users users = new Users();
		System.out.println("请输入用户id：");
		int uid = new Scanner(System.in).nextInt();
		System.out.println("请输入用户密码：");
		String password = new Scanner(System.in).next();
		users.setUid(uid);
		users.setPassword(password);
		boolean b = ud.login(users);
		if(b) {
			Users one = ud.findOne(uid);
			String uname = one.getUname();
			System.out.println("登录成功"+uname+"，以下为您的信息");
			printHeads();
			printUsersss(users,2);
			UserView.menu(users);
		}else {
			System.out.println("账号密码错误");
			menu();
		}
		
//		Users users=ud.findOne(uid);
//		if(users!=null) {
//			System.out.println("登录成功，"+users.getUname()+"欢迎您"+"以下为您的信息");
//			printHeads();
//			printUsers(users,1);
//			UserView uv=new UserView();
//			uv.menu(users);
//		}else {
//			System.out.println("您输入的用户id不存在");
//		}
	}
	
	private static void DeleteView() {			//用户注销
		// TODO Auto-generated method stub
		System.out.println("编号：");
		int uid=new Scanner(System.in).nextInt();
		boolean b = ud.delete(uid);
		if(b) {
			System.out.println("注销成功");
		}else {
			System.out.println("注销失败");
		}
	}
}