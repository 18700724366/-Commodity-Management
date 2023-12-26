package Commodity.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class IOUtils {

	public static void write(List list, File file) { // 写入
		ObjectOutputStream oos = null; // 定义一个ObjectOutputStream对象，用于将对象写入到文件中
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file)); // 创建一个新的ObjectOutputStream对象，以指定的FileOutputStream为参数，这样可以将对象写入到指定的文件中
			oos.writeObject(list); // 将List对象写入到ObjectOutputStream中，以便可以将其保存到文件中
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static List read(File file) { // 读取
		ObjectInputStream ois = null; // 定义一个ObjectInputStream对象，用于从文件中读取对象
		List list = new ArrayList(); // 定义一个List对象，用于存储从文件中读取的对象
		try {
			ois = new ObjectInputStream(new FileInputStream(file)); // 创建一个新的ObjectInputStream对象，以指定的FileInputStream为参数，这样可以从指定的文件中读取对象
			list = (List) ois.readObject(); // 从ObjectInputStream中读取一个对象，并强制转换为List类型，然后存储到list变量中
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
}
