package info.searchman;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBase {

	//DBへの接続を開く
	public static Connection getConnection() throws SQLException {
		//データベース接続へのURL
		String url = "jdbc:mysql://localhost:3306/company?characterEncoding=UTF-8";
		//DBのユーザー
		String user = "suser";
		//DBのパスワード
		String password = "spass";
		//接続オブジェクトの確立
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}
}
