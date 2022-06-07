package co.edu.student.service;

import java.util.List;

import co.edu.student.vo.StudentVO;

//인터페이스가 2개인데 기본 만들었던 service에서 복사 붙여넣기 하지만 조금씩 틀려서 2개로 만들어야한다
//mybatis에서 사용하는게 Mapper 인터페이스
//mybatis로 만든 student-map 안에 보면 알것
public interface StudentMapper { 
	List<StudentVO> studentSelectList(); //전체리스트
	StudentVO studentSelect(StudentVO vo); // 한명조회
	int studentInsert(StudentVO vo); // 추가
	int studentUpdate(StudentVO vo); // 변경
	int studentDelete(StudentVO vo); // 정보삭제
}
