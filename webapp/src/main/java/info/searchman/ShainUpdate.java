package info.searchman;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShainUpdate
 */
@WebServlet("/ShainUpdate")
public class ShainUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShainUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//文字コード指定
		request.setCharacterEncoding("UTF-8");

		//リクエストからパラメータ取得して表示
		System.out.println(request.getParameter("id"));
		
		//社員Beanを作成
		ShainBean shainBean = new ShainBean();
		shainBean.setId(101);
		shainBean.setName("鈴木義信");
		shainBean.setSei("男");
		shainBean.setNen(2003);
		shainBean.setAddress("宮城県仙台市");

		// 更新社員をセットする
		request.setAttribute("shainBean", shainBean);
		
		

		//update.jspへ転送
		request.getRequestDispatcher("/WEB-INF/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
