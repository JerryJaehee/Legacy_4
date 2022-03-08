package com.iu.s1.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.board.BoardDTO;
import com.iu.s1.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String board() {
		return "notice";
	}
	
	@RequestMapping(value="add", method = RequestMethod.GET)
	public ModelAndView add(ModelAndView mv) throws Exception{
		mv.setViewName("board/add");
		
		return mv;
	}
	
	@RequestMapping(value="add", method= RequestMethod.POST)
	public String add(NoticeDTO noticeDTO) throws Exception{
		int result = noticeService.add(noticeDTO);
		
		return "redirect:./list";
	}
	
	@RequestMapping(value = "list",method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mv, Pager pager) throws Exception {
		//ModelAndView
		//매개변수 선언
		//메서드내에서 객체 생성
		//ModelAndView modelAndView = new ModelAndView();
		List<BoardDTO> ar = noticeService.list(pager);
		mv.addObject("list",ar);
		mv.setViewName("board/list");
		
		return mv;
	}
	
	@RequestMapping(value="detail",method=RequestMethod.GET)
	public ModelAndView detail(Model model, NoticeDTO noticeDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		BoardDTO boardDTO = noticeService.detail(noticeDTO);
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/detail");

		return mv;
	}
	
	//update form 으로 이동
	@RequestMapping(value="update", method=RequestMethod.GET)
	public ModelAndView update(ModelAndView mv, NoticeDTO noticeDTO) throws Exception {
		BoardDTO boardDTO = noticeService.detail(noticeDTO);
		mv.addObject("dto",boardDTO);
		mv.setViewName("board/update");
		return mv;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.update(noticeDTO);
		
		return "redirect:./list";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public ModelAndView delete(NoticeDTO noticeDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = noticeService.delete(noticeDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}
}
