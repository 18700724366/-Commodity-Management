package Login;

import Login.view.LoginView;

/*
 * 
 * 这个是用户所能看到的界面。
 * 里面有用户登录注册和注销的功能
 * 通过登录功能可以跳转到二级页面购买商品充值余额功能的实现。
 */
public class AppLogin {
	public static void main(String[] args) {
		LoginView du = new LoginView();
		du.menu();
	}
}
