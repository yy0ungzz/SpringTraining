package web.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
//	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	//@GetMapping("~~")은 @RequestMapping(value = "~~", method = RequestMethod.GET) 같은 역할을 한다.
	@GetMapping("/member/login")
	public void login() {
		logger.info("/member/login [GET]");
	}
	
//	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	//@PostMapping("~~")은 @RequestMapping(value = "~~", method = RequestMethod.POST) 같은 역할을 한다.
	@PostMapping("/member/login")
	public String loginProcess(Member member, HttpSession session) {
		
		logger.info("/member/login [POST]");
		
		//Member Command Object 테스트
		logger.info("Member - {}", member);
		
		//로그인 여부를 저장하기 - 로그인 인증
		boolean loginResult = memberService.login(member);
		
		//로그인 성공 여부 TEST
		logger.info("loginResult - {}", loginResult);
		
		//로그인 정보를 세션 객체에 저장
		if (loginResult) {
			//로그인 성공 했을 때
			logger.info("로그인 성공");
			
			session.setAttribute("login", loginResult);
			session.setAttribute("id", member.getId());
			session.setAttribute("nick", memberService.getNick(member));
			
			return "redirect:/";
			
		} else {
			//로그인 인증 실패
			logger.info("로그인 실패");
			
			session.invalidate();
			return "redirect:/member/login";
		}
		
	}
	
	@RequestMapping(value = "/member/logout")
	public String logout(HttpSession session) {
		logger.info("/member/logout [Connection]");
		
		//세션 정보 초기화
		session.invalidate();
		
		return "redirect:/";
	}
	
//	@RequestMapping(value = "/member/join", method = RequestMethod.GET)
	@GetMapping("/member/join")
	public void join() {
		logger.info("/member/join [GET]");
	}
	
//	@RequestMapping(value = "/member/join", method = RequestMethod.POST)
	@PostMapping("/member/join")
	public String joinProcess(Member member) {
		logger.info("/member/join [POST]");
		
		//Member Command Object Test
		logger.info("Member - {}", member);
		
		boolean joinResult = memberService.join(member);
		
		if (joinResult) {
			logger.info("회원가입 성공");
			return "redirect:/";
		} else {
			logger.info("회원가입 실패");
			return "redirect:/member/join";
		}
		
	}
	
}
