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
		System.out.println("----欢迎来到后台管理----");
		System.out.println("1、添加商品");
		System.out.println("2、商品修改");
		System.out.println("3、商品删除");
		System.out.println("4、查找一个商品");
		System.out.println("5、查找所有商品");
		System.out.println("6、查找一个用户信息");
		System.out.println("7、查找所有用户信息");
		System.out.println("8、管理用户信息");
		System.out.println("0、退出系统");
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
		System.out.println("商品编号\t商品名称\t商品数量\t商品价格");
	}
	private static void printHeadss() {
		System.out.println("用户编号\t用户昵称\t用户密码\t用户购买次数\t用户余额");
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
			System.out.println("请输入需要管理的用户ID");
			int uid = new Scanner(System.in).nextInt();
			users.setUid(uid); 
			System.out.println("是否更改昵称");
			String  ss = new Scanner(System.in).next();
			if(ss.equalsIgnoreCase("y")) {
				System.out.println("昵称：");
				String uname = new Scanner(System.in).next();
				users.setUname(uname);
			}
			System.out.println("是否更改余额");
			ss = new Scanner(System.in).next();
			if(ss.equalsIgnoreCase("y")) {
				System.out.println("金额：");
				Double balance  = new Scanner(System.in).nextDouble();
				users.setBalance(balance);
			}
			boolean b = ud.update(users);
			if(b) {
				System.out.println("修改成功");
			}else {
			System.out.println("修改失败");
			}
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
	
	private static void FindoneUserView() {
		// TODO Auto-generated method stub
		System.out.println("用户编号：");
		int uid=new Scanner(System.in).nextInt();
		Users users=ud.findOne(uid);
		if(users!=null) {
			printHeadss();
			printUsers(users,1);
		}else {
			System.out.println("您输入的uid不存在");
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
		System.out.println("编号：");
		int id=new Scanner(System.in).nextInt();
		Commodity commodity=dd.findOne(id);
		if(commodity!=null) {
			printHead();
			printCommodity(commodity,1);
		}else {
			System.out.println("您输入的id不存在");
		}
		
	}


	private static void DeleteView() {
		// TODO Auto-generated method stub
		System.out.println("编号：");
		int id=new Scanner(System.in).nextInt();
		boolean b = dd.delete(id);
		if(b) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
	}
	private static void UpdateView() {
		// TODO Auto-generated method stub
		try {
			Commodity commodity=new Commodity();
			System.out.println("编号：");
			int id=new Scanner(System.in).nextInt();
			commodity.setId(id);
			System.out.println("是否修改名称");
			String s = new Scanner(System.in).next();
			if(s.equalsIgnoreCase("y")) {
				System.out.println("名称：");
				String name = new Scanner(System.in).next();
				commodity.setName(name);
			}
			System.out.println("是否修改库存");
			 s = new Scanner(System.in).next();
			if(s.equalsIgnoreCase("y")) {
				System.out.println("库存：");
				int number  = new Scanner(System.in).nextInt();
				commodity.setNumber(number);
			}
			System.out.println("是否修改价格");
			 s = new Scanner(System.in).next();
			if(s.equalsIgnoreCase("y")) {
				System.out.println("价格：");
				Double price  = new Scanner(System.in).nextDouble();
				commodity.setPrice(price);
			}
			boolean b = dd.update(commodity);
			if(b) {
				System.out.println("修改成功");
			}else {
			System.out.println("修改失败");
			}
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}

	private static void AddView() {
		// TODO Auto-generated method stub
		try {
			System.out.println("请输入商品名称：");
			String name=new Scanner(System.in).next();
			System.out.println("请输入商品数量：");
			int number=new Scanner(System.in).nextInt();
			System.out.println("请输入商品价格：");
			Double price=new Scanner(System.in).nextDouble();
			boolean b = dd.add(new Commodity(name, number, price));
			if(b) {
				System.out.println("添加成功");
			}else {
				System.out.println("添加失败");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}




}

