package web.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.dto.Member;
import web.service.face.MemberService;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/member/main")
	public void main() {
		logger.info("/member/main [Connection]");
	}
	
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public void login() {
		logger.info("/member/login [GET]");
	}
	
	@RequestMapping(value = "/member/loginProc", method = RequestMethod.POST)
	public String loginProc(Member member, HttpSession session) {
		
		logger.info("/member/loginProc [POST]");
		
		//Member Command Object 테스트
		logger.info("Member - {}", member);
		
		//로그인 여부를 저장하기 - 로그인 인증
		boolean isLogin = memberService.login(member);
		
		//로그인 성공 여부 TEST
		logger.info("isLoign - {}", isLogin);
		
		//로그인 정보를 세션 객체에 저장
		if (isLogin) {
			//로그인 성공 했을 때
			session.setAttribute("isLoign", isLogin);
			session.setAttribute("memberId", member.getId());
		} else {
			//로그인 인증 실패
			session.invalidate();
		}
		
		return "redirect:/member/main";
	}
	
	@RequestMapping(value = "/member/logout")
	public String logout(HttpSession session) {
		logger.info("/member/logout [Connection]");
		
		//세션 정보 초기화
		session.invalidate();
		
		return "redirect:/member/main";
	}
	
	@RequestMapping(value = "/member/join", method = RequestMethod.GET)
	public void join() {
		logger.info("/member/join [GET]");
	}
	
	@RequestMapping(value = "/member/joinProc", method = RequestMethod.POST)
	public String joinProc(Member member) {
		logger.info("/member/joinProc [POST]");
		
		//Member Command Object Test
		logger.info("Member - {}", member);
		
		memberService.join(member);
		
		return "redirect:/member/main";
	}
	
}
