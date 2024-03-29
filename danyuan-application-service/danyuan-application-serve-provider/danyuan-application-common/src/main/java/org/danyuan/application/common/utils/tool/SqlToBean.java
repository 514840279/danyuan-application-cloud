package org.danyuan.application.common.utils.tool;

/*
 * 给出数据库JAR包，数据库链接路径，数据库表空间名，数据库名，数据库密码，表名 可以提取出来创建表属性的javaBean文件，并且提供标准的get,set方法。 此程序将所有字段和数据提取出来定义为String类型，如有别的需要可以提取表中字段的类型和别的表信息，自动生成 java文件 \t 表示 空格 \r 表示换行 等价于 \n ResultSetMetaData 关键
 */
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 * 文件名 ： SqlToBean.java
 * 包 名 ： org.danyuan.utils.tool.sqltobean
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 作 者 ： Tenghui.Wang
 * 时 间 ： 2016年3月24日 下午9:19:50
 * 版 本 ： V1.0
 */
public class SqlToBean {
	private Connection			conn		= null;					// 保存链接路径
	private Statement			stmt		= null;					// 建立连接
	private ResultSetMetaData	meta		= null;					// 保存表属性信息
	private ResultSet			rs			= null;					// 查询结果集
	private OutputStreamWriter	osw			= null;
	private BufferedWriter		bw			= null;
	private FileOutputStream	fos			= null;
	private static StringBuffer	coding		= new StringBuffer();	// 字符串缓冲区
	private String				driver		= null;					// 数据库包名
	private String				url			= null;					// 路径名
	private String				table		= null;					// 表空间名
	private String				password	= null;					// 密码
	private String				tableName	= null;					// 表名

	public SqlToBean(String driver, String url, String table, String password, String tableName) {
		this.driver = driver;
		this.url = url;
		this.table = table;
		this.password = password;
		this.tableName = tableName;
	}

	public StringBuffer createClassName(String className) {
		coding.append("public class " + className + "{\n");
		return coding;
	}
	
	//	public static void main(String[] args) {
	//		String className = "Hellow";
	//		// SqlToBean sqlToBean = new SqlToBean("oracle.jdbc.driver.OracleDriver","jdbc:oracle:thin:@192.168.3.11:1521:orcl","mamibon","mamibon","my_standard_data2");
	//		SqlToBean sqlToBean = new SqlToBean("org.gjt.mm.mysql.Driver", "jdbc:mysql://117.79.84.144:3306/wordpress", "wangjun", "wangjun", "wp_users");
	//		// 连接数据库
	//		sqlToBean.connect();
	//		sqlToBean.createClassName(className);
	//		// 获取表的字段
	//		String[] str;
	//		str = sqlToBean.getColumenName();
	//		for (int i = 0; i < str.length; i++) {
	//			sqlToBean.createGenerate(str[i]);
	//		}
	//		coding.append("\n");
	//		sqlToBean.createMethod(str);
	//		coding.append("\n}");
	//		// 写入文件
	//		sqlToBean.writeData(sqlToBean.getCoding(coding), className);
	//		sqlToBean.destroy();
	//		
	//		System.out.println("如果觉得这工具类不错,请关注我们的网站:http://www.itbuluoge.com,期待你的入住，程序员俱乐部,为您提供更多的帮助!");
	//		System.out.println("如果觉得这工具类不错,请关注我们的网站:http://www.itbuluoge.com,期待你的入住，程序员俱乐部,为您提供更多的帮助!");
	//	}

}
