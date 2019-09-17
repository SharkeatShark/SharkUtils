package com.shark.net;


import com.shark.encrypt.DES3;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public final class JDBCUtilSingle {
	
	static String url = "";

	static String name = "";

	static String password = "";
	
	static String file = "jdbc.properties";

	static Connection conn = null;

	private static JDBCUtilSingle jdbcUtilSingle = null;

	public static JDBCUtilSingle getInitJDBCUtil() {

		if (jdbcUtilSingle == null) {

			// 给类加锁 防止线程并发

			synchronized (JDBCUtilSingle.class) {

				if (jdbcUtilSingle == null) {

					jdbcUtilSingle = new JDBCUtilSingle();

				}

			}

		}

		return jdbcUtilSingle;

	}

	private JDBCUtilSingle() {

	}

	// 通过静态代码块注册数据库驱动，保证注册只执行一次

	static {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

	}

	// 获得连接

	public Connection getConnection() {

		try {
			 Properties properties = new Properties();
	         InputStream inputStream = new BufferedInputStream(this.getClass().getClassLoader().getResourceAsStream(file));
			try {
			    properties.load(inputStream);
			   
			    url =  properties.getProperty("jdbc.url");
			    name =  properties.getProperty("jdbc.username");
			    password = DES3.decrypt(properties.getProperty("jdbc.pwd"));
			    if(inputStream!=null)
			    inputStream.close();
		    } catch (IOException e) {
			    e.printStackTrace();
				return null;
		    } catch (Exception e) {
				e.printStackTrace();
			}
		   

			conn = DriverManager.getConnection(url, name, password);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;

	}
	
	// 获得新的数据库连接

	public Connection getConnectionNew() {

		try {
			 Properties properties = new Properties();
	         InputStream inputStream = new BufferedInputStream(this.getClass().getClassLoader().getResourceAsStream(file));
			try {
			    properties.load(inputStream);
			   
			    url =  properties.getProperty("jdbc.url2");
			    name = properties.getProperty("jdbc.username2");
			    password = DES3.decrypt(properties.getProperty("jdbc.pwd2"));
			    if(inputStream!=null)
			    inputStream.close();
		    } catch (IOException e) {
			    e.printStackTrace();
			    return null;
		    } catch (Exception e) {
				e.printStackTrace();
			}
		   

			conn = DriverManager.getConnection(url, name, password);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return conn;

	}
	// 获得第三个数据库连接

	public Connection getConnectionThree() {

		try {
			 Properties properties = new Properties();
	         InputStream inputStream = new BufferedInputStream(this.getClass().getClassLoader().getResourceAsStream(file));
			try {
			    properties.load(inputStream);
			   
			    url =   properties.getProperty("jdbc.url3");
			    name =  properties.getProperty("jdbc.username3");
			    password =  DES3.decrypt(properties.getProperty("jdbc.pwd3"));
			    if(inputStream!=null)
			    inputStream.close();
		    } catch (IOException e) {
				e.printStackTrace();
				return null;
			}catch (Exception e) {
				e.printStackTrace();
			}
		   

			conn = DriverManager.getConnection(url, name, password);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;

	}
	// 关闭连接

	public void closeConnection(ResultSet rs, Statement statement,
			Connection con) {

		try {

			if (rs != null) {

				rs.close();

			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			try {

				if (statement != null) {

					statement.close();

				}

			} catch (Exception e) {

				e.printStackTrace();

			} finally {

				try {

					if (con != null) {

						con.close();

					}

				} catch (SQLException e) {

					e.printStackTrace();

				}

			}

		}

	}


}
