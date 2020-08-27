package DatabaseOperate;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class ConnectionDB {
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "cxh123456";
	public static final String URL = "jdbc:mysql://localhost:3306/db_studentmangement?characterEncoding=utf8";

	public static DataSource dataSource = null;
	
	//׼����������Դ C3P0
	static {
		try {
			ComboPooledDataSource pool = new ComboPooledDataSource();
			pool.setDriverClass(DRIVER);
			pool.setUser(USERNAME);
			pool.setPassword(PASSWORD);
			pool.setJdbcUrl(URL);
			
			pool.setMaxPoolSize(30);
			pool.setMinPoolSize(5);
			dataSource = pool;
		} catch (PropertyVetoException e) {
			e.printStackTrace();
			System.out.println("���ݿ����ʧ�ܣ�");
		}
	}
	/**��ȡ���ݿ����Ӷ���*/
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
