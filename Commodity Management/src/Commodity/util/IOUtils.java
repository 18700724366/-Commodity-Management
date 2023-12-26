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

	public static void write(List list, File file) { // д��
		ObjectOutputStream oos = null; // ����һ��ObjectOutputStream�������ڽ�����д�뵽�ļ���
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file)); // ����һ���µ�ObjectOutputStream������ָ����FileOutputStreamΪ�������������Խ�����д�뵽ָ�����ļ���
			oos.writeObject(list); // ��List����д�뵽ObjectOutputStream�У��Ա���Խ��䱣�浽�ļ���
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

	public static List read(File file) { // ��ȡ
		ObjectInputStream ois = null; // ����һ��ObjectInputStream�������ڴ��ļ��ж�ȡ����
		List list = new ArrayList(); // ����һ��List�������ڴ洢���ļ��ж�ȡ�Ķ���
		try {
			ois = new ObjectInputStream(new FileInputStream(file)); // ����һ���µ�ObjectInputStream������ָ����FileInputStreamΪ�������������Դ�ָ�����ļ��ж�ȡ����
			list = (List) ois.readObject(); // ��ObjectInputStream�ж�ȡһ�����󣬲�ǿ��ת��ΪList���ͣ�Ȼ��洢��list������
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
