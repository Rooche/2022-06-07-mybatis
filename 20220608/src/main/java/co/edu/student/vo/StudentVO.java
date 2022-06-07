package co.edu.student.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentVO { // 명령규칙은 자바식대로 하되 디벨로퍼 테이블안에 있는거와 똑같이 이름을 쓴다.
	private String studentId;
	private String name;
	private Date birthday;
	private String major;
	private String address;
	private String tel;
}
