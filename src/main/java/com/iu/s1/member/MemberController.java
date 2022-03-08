package com.iu.s1.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	//회원가입 폼 이동
	@RequestMapping(value="join", method = RequestMethod.GET)
	public void join() throws Exception{
		
	}
	
	//insert
	@RequestMapping(value="join", method = RequestMethod.POST)
	public String join(MemberDTO memberDTO) throws Exception{
		int result = memberService.join(memberDTO);
		return "redirect:../";
	}
	
	@RequestMapping(value="joinCheck", method = RequestMethod.GET)
	public void joinCheck() throws Exception{
		
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public void login(Model model, @CookieValue(value="remember", defaultValue="", required=false) String rememberId) throws Exception{
		//model.addAttribute("rememberId",rememberId);
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(HttpSession session,MemberDTO memberDTO, Model model, String remember, HttpServletResponse res) throws Exception{
		memberDTO = memberService.login(memberDTO);
		
		System.out.println("Remember : "+remember);
		
		if(remember != null && remember.equals("1")) {
			//쿠키 생성
			Cookie cookie = new Cookie("remember", memberDTO.getId());
			//cookie.setPath("/");
			cookie.setMaxAge(-1);
			//응답
			res.addCookie(cookie);
		}
		else {
			Cookie cookie = new Cookie("remember", "");
			cookie.setMaxAge(0);
			res.addCookie(cookie);
		}
		
//		String path="redirect:./login";
//		if(memberDTO != null) {
//			session.setAttribute("member", memberDTO); //session명 : member
//			path = "redirect:../";
//		}
		String message="Login Fail";
		String p = "./login";
		
		if(memberDTO != null) {
			session.setAttribute("member", memberDTO);
			message = "Login success";
			p = "../";
		}
		model.addAttribute("message",message);
		model.addAttribute("path",p);
		String path = "common/result";
			
		return path;
	}
	
	//logout
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:../";
	}
	
	@RequestMapping(value="mypage", method=RequestMethod.GET)
	public ModelAndView mypage(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		memberDTO = memberService.mypage(memberDTO);
		mv.setViewName("member/mypage");
		mv.addObject("dto",memberDTO);
		return mv;
	}
}
