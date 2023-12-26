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
		System.out.println("**********这里是商品前台*********");
		System.out.println("1、修改信息密码/余额充值");
		System.out.println("2、通过商品名查找商品");
		System.out.println("3、查找所有商品");
		System.out.println("4、购买商品");
		System.out.println("5、查询个人信息");
		System.out.println("6、退出登录");
		System.out.println("7、关于我们");
		System.out.println("0、退出系统");
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
			System.out.println("感谢使用，如果我的作品能够帮助到您，请随意打赏。您的支持将鼓励我继续创作");
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
		System.out.println("商品编号\t商品名称\t商品数量\t商品价格");
	}

	private static void printHeads() {
		System.out.println("用户id\t用户昵称\t用户密码\t用户余额");
	}

	private static void printCommodity(Commodity commodity, int index) {
		System.out.println(commodity.getId() + "\t" + commodity.getName() + "\t" + commodity.getNumber() + "\t"
				+ commodity.getPrice());
	}

	private static void printUsersss(Users users, int index) {
		Users one = ud.findOne(users.getUid());
		System.out.println(one.getUid() + "\t" + one.getUname() + "\t" + one.getPassword() + "\t" + one.getBalance());
	}

	private static void findone(Users users) { // 实现用户显示自己的信息
		printHeads();
		printUsersss(users, 1);
	}

	private static void BuyView(Users users) { // 用户购买流程=自己余额-商品余额
		// TODO Auto-generated method stub
		try {
		Commodity comm = null;
		Users us= null;
			System.out.println("请输入需要购买的商品编号");
			int id = new Scanner(System.in).nextInt();
			comm = dd.findOne(id);
			us=ud.findOne(users.getUid());
			if(comm==null) {
				System.out.println("您输入的商品id不存在");
				return ;
			}
			if(us==null) {
				System.out.println("请重新登录");
				return;
			}
			if (comm!= null) { // 判断商品id是否存在
				printHead();
				printCommodity(comm, 1);
			} 
			boolean buy = false; // 同步输入，保证购买所扣除的金额和商品库存同时被减去
			boolean num = false;
			System.out.println("您要购买的为" + comm.getName());
			System.out.println("是否确认购买此商品（y/n）");
			String s = new Scanner(System.in).next();
			if (s.equalsIgnoreCase("y")) {
				if (us.getBalance()>=comm.getPrice()) {
					
					System.out.println(us.getBalance());
					buy = ud.buy(us, comm); // 判断余额是否大于当前商品金额
				} else {
					System.out.println("余额不足，不充钱是想白嫖吗");
					ShowUtils.main(null);
				}
				if (comm.getNumber() > 1) { // 库存-1
					num = dd.num(comm);

				} else {
					System.out.println("库存不足");
				}
				if (buy && num) { // 同步输入显示购买是否成功，保证购买所扣除的金额和商品库存同时被减去
					System.out.println("购买成功");
					ud.unum(us);
					System.out.println("您购买了" + ud.unumber(us) + "次商品");
				} else {
					System.out.println("购买失败");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	private static void FindAllView() { // 用户查找全部商品
		// TODO Auto-generated method stub
		List<Commodity> list = dd.findAll();
		printHead();
		for (int i = 0; i < list.size(); i++) {
			printCommodity(list.get(i), i + 1);
		}
	}

	private static void FindOneView() { // 用户通过id查找一个商品
		// TODO Auto-generated method stub
		System.out.println("商品名：");
		String name = new Scanner(System.in).next();
		List<Commodity> findname = dd.findname(name);
		if (findname.size() != 0) {
			printHead();
			for (Commodity commodity : findname) {
				System.out.println(commodity.getId() + "\t" + commodity.getName() + "\t" + commodity.getNumber() + "\t"
						+ commodity.getPrice());
			}
		} else {
			System.out.println("暂无符合的商品");
		}

	}

	private static void UpdateView(Users users) { // 已登录用户需要修改昵称和充值金额的方法调用
		// TODO Auto-generated method stub
		try {
			System.out.println("是否修改昵称");
			String s = new Scanner(System.in).next();
			if (s.equalsIgnoreCase("y")) {
				System.out.println("昵称：");
				String uname = new Scanner(System.in).next();
				users.setUname(uname);
			}
			System.out.println("是否修改密码");
			String ss = new Scanner(System.in).next();
			if (ss.equalsIgnoreCase("y")) {
				System.out.println("密码：");
				String password = new Scanner(System.in).next();
				users.setPassword(password);
			}
			System.out.println("是否充值余额");
			s = new Scanner(System.in).next();
			if (s.equalsIgnoreCase("y")) {
				System.out.println("金额：");
				Double balance = new Scanner(System.in).nextDouble();
				ShowUtils.main(null);
				Users oldusers=ud.findOne(users.getUid());
				users.setBalance(oldusers.getBalance()+balance);
			}
			boolean b = ud.update(users);
			if (b) {
				System.out.println("充值修改成功");
			} else {
				System.out.println("充值修改失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
