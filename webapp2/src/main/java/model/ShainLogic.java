package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import beans.ShainBean;

public class ShainLogic {

	//社員を削除
	public void deleteShain(int id) throws SQLException, NamingException {

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

	//社員情報を更新
	public void updateShain(ShainBean shainBean) throws SQLException, NamingException {

		//社員を更新するSQL
		String sql = "update shain set name=?, sei=?, nen=?,  address=? where id=?";
		try (Connection con = ConnectionBase.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			//パラメータをSQLにセット
			pstmt.setString(1, shainBean.getName());
			pstmt.setString(2, shainBean.getSei());
			pstmt.setInt(3, shainBean.getNen());
			pstmt.setString(4, shainBean.getAddress());
			pstmt.setInt(5, shainBean.getId());
			//SQL文を表示
			System.out.println(pstmt.toString());
			//SQL実行
			pstmt.executeUpdate();
		}
	}

	//社員idから社員情報を取得
	public ShainBean getShainBean(int id) throws SQLException, NamingException {

		ShainBean shainBean = new ShainBean();

		//社員idから社員情報を取得
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
				shainBean.setId(id);
				shainBean.setName(rs.getString("name"));
				shainBean.setSei(rs.getString("sei"));
				shainBean.setNen(rs.getInt("nen"));
				shainBean.setAddress(rs.getString("address"));
			}
		}

		return shainBean;
	}

	//リクエストからshainBeanの作成(insert.jspで入力される情報を取得)
	public ShainBean getShainBean(HttpServletRequest request) {

		//shainBeanの初期化
		ShainBean shainBean = new ShainBean();

		//リクエストから実際のshainBeanの中身のデータを揃えていく
		//文字列をIntに変換
		//各input要素のname属性を指定
		shainBean.setId(Integer.parseInt(request.getParameter("id")));
		shainBean.setName(request.getParameter("name"));
		shainBean.setSei(request.getParameter("sei"));
		shainBean.setNen(Integer.parseInt(request.getParameter("nen")));
		shainBean.setAddress(request.getParameter("address"));

		//作成したshainBeanを戻す
		return shainBean;

	}

	//作ったshainBeanのデータをDBに登録
	public void insertShain(ShainBean shainBean) throws SQLException, NamingException {
		//社員を登録するsql
		String sql = "insert into shain(id, name, sei, nen, address) values(?,?,?,?,?);";
		try (Connection con = ConnectionBase.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			//パラメータをSQLにセット
			pstmt.setInt(1, shainBean.getId());
			pstmt.setString(2, shainBean.getName());
			pstmt.setString(3, shainBean.getSei());
			pstmt.setInt(4, shainBean.getNen());
			pstmt.setString(5, shainBean.getAddress());
			//SQl文を表示
			System.out.println(pstmt.toString());
			//SQL実行
			pstmt.executeUpdate();
		}
	}

	//全社員を取得                   //エラーがあった場合にオブジェクト形式でエラーを投げる - このメソッドを使用している元でそのエラーを受け取り処理
	public ArrayList<ShainBean> getAllShain() throws SQLException, NamingException {

		ArrayList<ShainBean> shainList = new ArrayList<ShainBean>();

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
				//社員Beanの初期化
				ShainBean shainBean = new ShainBean();

				//取得した値を社員Beanにセット
				shainBean.setId(rs.getInt("id"));
				shainBean.setName(rs.getString("name"));
				shainBean.setSei(rs.getString("sei"));
				shainBean.setNen(rs.getInt("nen"));
				shainBean.setAddress(rs.getString("address"));

				//社員リストに各社員のデータを追加していく
				shainList.add(shainBean);
			}
		}

		return shainList;
	}
}
