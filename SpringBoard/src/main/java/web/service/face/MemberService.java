package web.service.face;

import web.dto.Member;

public interface MemberService {
	
	/**
	 * login페이지에서 입력한 정보를 파라미터로 전달 받아 로그인 인증 처리를 한다.
	 * 
	 * @param member - login 페이지에서 입력한 파라미터가 있는 DTO 객체
	 * @return - 입력한 파라미터가 로그인 정보와 일치 여부를 반환한다.
	 */
	public boolean login(Member member);

	/**
	 * join 페이지에서 입력한 정보를 파라미터로 전달 받아 회원가입 처리를 한다.
	 * 
	 * @param member - join 페이지에서 입력한 파라미터가 있는 DTO 객체
	 */
	public void join(Member member);
	
}
