package web.dao.face;

import web.dto.Member;

public interface MemberDao {

	/**
	 * member DTO 객체에 저장되어 있는 데이터로
	 * member테이블에 일치하는 값의 조회된 행의 수를 구한다.
	 * 
	 * @param member - 로그인 정보가 있는 DTO 객체
	 * @return - 조회된 행의 수
	 */
	public int selectCnt(Member member);

	/**
	 * member DTO 객체에 저장되어 있는 데이터를 삽입하는 쿼리문을 수행한다.
	 * 
	 * @param member - 회원가입 정보가 있는 DTO 객체
	 */
	public void insert(Member member);
	

}
