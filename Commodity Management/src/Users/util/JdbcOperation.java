package Users.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcOperation<T> {
	private Connection conn;
	private PreparedStatement stat;
	private ResultSet rs;

	public boolean UpdateSql(String sql, Object[] objs) {
		try {
			conn = JdbcUtils.geCon();
			stat = conn.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				stat.setObject(i + 1, objs[i]);
			}
			int row = stat.executeUpdate();
			if (row > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConn(null, stat, conn);
		}

		return false;
	}

	public List<T> seleList(String sql, Object[] objs, Class c) {
		List<T> list = new ArrayList<T>();
		try {
			conn = JdbcUtils.geCon();
			stat = conn.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				stat.setObject(i + 1, objs[i]);
			}
			rs = stat.executeQuery();
			Field[] fields = c.getDeclaredFields();
			while (rs.next()) {
				Object object = c.newInstance();
				for (int i = 0; i < fields.length; i++) {
					Field f = fields[i];
					if ("serialVersionUID".equals(f.getName())) {
						continue;
					}
					f.setAccessible(true);
					f.set(object, rs.getObject(f.getName()));
				}
				list.add((T) object);
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConn(rs, stat, conn);
		}

		return list;
	}
}
