package co.edu.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 요청이 test.do로 들어왔을떄 처리하는 곳
		
		return "test1";
	}

}
