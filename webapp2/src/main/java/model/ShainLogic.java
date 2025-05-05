package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import beans.ShainBean;

public class ShainLogic {
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
