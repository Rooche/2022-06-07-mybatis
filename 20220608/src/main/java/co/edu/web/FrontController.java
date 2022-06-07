package co.edu.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 모든 요청을 받아서 처리하는 처리하는 곳
 */
@WebServlet("*.do") // 앞에 /* 가 들어가면 모든 요청은 얘가 다 받음 근데 관례적으로 /*.do 라고 함
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

	/**
	 * 
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 요청과 처리 명령어를 연결하는 부분
	 */
	public void init(ServletConfig config) throws ServletException {
		map.put("/test.do", new TestCommand()); // /test.do를 실행시키면 TestCommand값이 리턴됨
		map.put("/memberList.do", new MemberListCommand());
	}

	
	/**
	 * 요기서 들어온 요청을 분석하고 명령을 실행해서 결과를 돌려보내주는 곳
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 한글깨짐 방지
		String uri = request.getRequestURI(); // 요청 URI 구함
		String contextPath = request.getContextPath(); // 루트 디렉토리 정보
		String page = uri.substring(contextPath.length()); // contextPath.length()(<-이걸빼면) 이 다음부터는 들어가는게 페이지다. ,, 실제 요청
															// 명령을 받음

		Command command = map.get(page); // 실행할 명령객체를 찾음 여기부분이 인터페이스다 co.deu.web에 인터페이스로 만들어뒀음
		String viewPage = command.exec(request, response); // 명령을 실행하고 결과를 돌려받음
		//위에 있는 viewPage를 Dis

		
		//viewResolve 라고 한다 and연산자는 둘다 참일때 참이기에 하나라도 거짓이면 연산하지 않는다
		if (!viewPage.endsWith(".do") && !viewPage.equals(null)) { // 돌려받을 페이지에서 결과가 null이 아니고 .do가 포함되어있지 않다면
			viewPage = "/WEB-INF/jsp/" + viewPage + ".jsp"; 	//널도 아니고 .do도 아니니 여기 문장을 실행한다
									//jsp/test1.jsp
		}
		
		//이 두문장은 결과 페이지를 돌려준다.
														// /WEB-INF/jsp/test1.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response); // 보여줄 페이지를 던져주는 forward
	}
}
