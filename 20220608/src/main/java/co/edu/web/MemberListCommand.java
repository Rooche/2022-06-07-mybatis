package co.edu.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberListCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//DB처리하는 부분 작업하고
		//보여줄 페이지에 값을 싣고
		request.setAttribute("name", "홍길동");
		request.setAttribute("id", "micol");
		request.setAttribute("password", "1234");
		return "member/member";
	}

}
