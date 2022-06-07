package co.edu.student.service;

import java.util.List;

import co.edu.student.vo.StudentVO;

public interface StudentService {
	List<StudentVO> studentSelectList(); //전체리스트
	StudentVO studentSelect(StudentVO vo); // 한명조회
	int studentInsert(StudentVO vo); // 추가
	int studentUpdate(StudentVO vo); // 변경
	int studentDelete(StudentVO vo); // 정보삭제
}
