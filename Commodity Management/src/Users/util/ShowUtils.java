package Users.util;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ShowUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				ImageIcon image = new ImageIcon("bin/Users/util/ma.jpg");
				JLabel imageLabel = new JLabel(image);
				imageLabel.setBounds(500, 200, 500, 1000);
				JFrame j = new JFrame();
				j.setTitle("请付款");
				j.setBounds(800, 100, 1000, 800);
				//添加JLabel组件
				j.add(imageLabel);
				j.setVisible(true);
			}
}
