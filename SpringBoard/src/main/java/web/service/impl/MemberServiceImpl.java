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
		
		if (memberDao.selectCnt(member) >= 1) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public void join(Member member) {
		
		memberDao.insert(member);
		
	}
}
