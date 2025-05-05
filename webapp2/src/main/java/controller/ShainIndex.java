package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ShainBean;
import model.ShainLogic;

/**
 * Servlet implementation class ShainIndex
 */
@WebServlet("/ShainIndex")
public class ShainIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShainIndex() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//社員ロジックの作成
		ShainLogic shainLogic = new ShainLogic();
		
		try {
			//社員リスト取得
			ArrayList<ShainBean> shainList = shainLogic.getAllShain();
			
			//社員リストをセットする
			//リクエストオブジェクトにデータを格納し、次の画面（JSPなど）に渡す
			request.setAttribute("shainList", shainList);
			
			//index.jspに転送
			//現在のリクエストとレスポンスをそのままindex.jspに引き継ぐ
			request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
			
			
		} catch (SQLException | NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
