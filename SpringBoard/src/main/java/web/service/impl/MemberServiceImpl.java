package web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.face.MemberDao;
import web.dto.Member;
import web.service.face.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao memberDao;
	
	@Override
	public boolean login(Member member) {
		
		int loginChk = memberDao.selectCntMember(member);
		
		//selectCntMember method릍 통하여 조회된 행의 수가 
		//저장된 loginChk가 1이상 이라면true 반환
		if (loginChk > 0) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public String getNick(Member member) {
		
		return memberDao.selectNickByMember(member);
	}
	
	@Override
	public boolean join(Member member) {
		
		//중복된 아이디 인지 체크 !
		if (memberDao.selectCntById(member) > 0) {
			return false;
		}
		
		//회원가입 (삽입)
		memberDao.insert(member);
		
		//회원가입 결과 확인
		if (memberDao.selectCntById(member) > 0) {
			return true;
		}
		
		return false;
	}

}
