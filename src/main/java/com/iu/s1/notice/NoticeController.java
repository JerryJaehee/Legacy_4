package com.iu.s1.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="add", method = RequestMethod.GET)
	public void add() throws Exception{
		
	}
	
	@RequestMapping(value="add", method= RequestMethod.POST)
	public String add(NoticeDTO noticeDTO) throws Exception{
		int result = noticeService.add(noticeDTO);
		
		return "redirect:./list";
	}
	
	@RequestMapping(value = "list",method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mv) throws Exception {
		//ModelAndView
		//매개변수 선언
		//메서드내에서 객체 생성
		//ModelAndView modelAndView = new ModelAndView();
		List<NoticeDTO> ar = noticeService.list();
		mv.addObject("list",ar);
		mv.setViewName("notice/list");
		
		return mv;
	}
	
	@RequestMapping(value="detail",method=RequestMethod.GET)
	public void detail(Model model, NoticeDTO noticeDTO) throws Exception {
		noticeDTO = noticeService.detail(noticeDTO);
		model.addAttribute("dto",noticeDTO);
	}
}