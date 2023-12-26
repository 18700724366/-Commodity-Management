package Users;

import Login.view.LoginView;
import Users.view.UserView;

/*
 * 测试专用用户登录之后的界面
 * 实现用户登录后所能看到的菜单页面
 */

public class appUser {
	public static void main(String[] args) {
		UserView ud = new UserView();
		UserView.menu(null);
	}
}