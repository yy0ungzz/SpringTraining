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
	public int selectCntMember(Member member);

	/**
	 * 
	 * id를 이용하여 nick을 조회한다.
	 * 
	 * @param member - 조회하려는 회원의 id를 가진 객체
	 * @return 조회된 nick
	 */
	public String selectNickByMember(Member member);
	
	/**
	 * 회원의 id가 이미 존재하는 값인지 확인한다.
	 * 중복된 id인지 확인
	 * 
	 * @param member - 조회하려는 회원의 id를 가진 객체
	 * @return 존재 여부 (0 - 없음, 1 - 있음)
	 */
	public int selectCntById(Member member);
	
	/**
	 * member DTO 객체에 저장되어 있는 데이터를 삽입하는 쿼리문을 수행한다.
	 * 신규 회원 정보를 새롭게 삽입한다.
	 * 
	 * @param member - 회원가입 정보가 있는 DTO 객체
	 */
	public void insert(Member member);
}
