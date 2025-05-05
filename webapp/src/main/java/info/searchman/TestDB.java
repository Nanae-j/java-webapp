package info.searchman;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDB {

	public static void main(String[] args) {
		try {
			//insertShain();
			//getAllShain();
			//getShainBean(300);
			//updateShain(300);
			deleteShain(300);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("更新処理が失敗しました");
		}
	}

	//社員を削除
	public static void deleteShain(int id) throws SQLException {

		//社員を削除するSQL
		String sql = "delete from shain where id=?";
		//SQL実行の準備
		try (Connection con = ConnectionBase.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			//パラメータをSQLにセット
			pstmt.setInt(1, id);
			//SQL文を表示
			System.out.println(pstmt.toString());
			//SQL実行
			pstmt.executeUpdate();
		}
	}

	//社員情報をを更新
	public static void updateShain(int id) throws SQLException {

		//社員を更新するSQL
		String sql = "update shain set name=?, sei=?, nen=?,  address=? where id=?";
		try (Connection con = ConnectionBase.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			//パラメータをSQLにセット
			pstmt.setString(1, "高崎太郎");
			pstmt.setString(2, "男");
			pstmt.setInt(3, 2010);
			pstmt.setString(4, "群馬県高崎市");
			pstmt.setInt(5, id);
			//SQL文を表示
			System.out.println(pstmt.toString());
			//SQL実行
			pstmt.executeUpdate();
		}
	}

	//全社員を取得
	public static void getAllShain() throws SQLException {

		//社員を取得するSQL
		String sql = "select id, name, sei, nen, address from shain";

		//SQL実行の準備
		try (Connection con = ConnectionBase.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			//SQL文を表示
			System.out.println(pstmt.toString());
			//SQL実行
			ResultSet rs = pstmt.executeQuery();
			//取得した行数を繰り返す
			while (rs.next()) {
				//値を取得
				System.out.print(rs.getInt("id"));
				System.out.print(rs.getString("name"));
				System.out.print(rs.getString("sei"));
				System.out.print(rs.getInt("nen"));
				System.out.println(rs.getString("address"));
			}
		}
	}

	//1社員を取得
	public static void getShainBean(int id) throws SQLException {

		//社員を取得するSQL
		String sql = "select id, name, sei, nen, address from shain where id=?";

		//SQL実行の準備
		try (Connection con = ConnectionBase.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			//パラメータをSQLにセット
			pstmt.setInt(1, id);
			//SQL文を表示
			System.out.println(pstmt.toString());
			//SQL実行
			ResultSet rs = pstmt.executeQuery();
			//取得した行数を繰り返す
			while (rs.next()) {
				//値を取得
				System.out.print(rs.getInt("id"));
				System.out.print(rs.getString("name"));
				System.out.print(rs.getString("sei"));
				System.out.print(rs.getInt("nen"));
				System.out.println(rs.getString("address"));
			}
		}
	}

	//社員を登録
	public static void insertShain() throws SQLException {

		//社員を登録するSQL
		String sql = "insert into shain(id, name, sei, nen, address) values(?,?,?,?,?);";
		try (Connection con = ConnectionBase.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			//パラメータをSQLにセット
			pstmt.setInt(1, 300);
			pstmt.setString(2, "長野太郎");
			pstmt.setString(3, "男");
			pstmt.setInt(4, 2010);
			pstmt.setString(5, "長野県長野市");
			//SQL文を表示
			System.out.println(pstmt.toString());
			//SQL実行
			pstmt.executeUpdate();
		}
	}

}
