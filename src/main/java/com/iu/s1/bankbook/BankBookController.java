package com.iu.s1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.util.Pager;

@Controller
@RequestMapping("/bankbook/*")
public class BankBookController {

	@Autowired
	private BankBookService bankBookService;

	@RequestMapping(value="update",method = RequestMethod.POST)
	public String update(BankBookDTO bankBookDTO) throws Exception {
		int result = bankBookService.update(bankBookDTO);
		
		return "redirect:./list";
	}
	
	//update form으로 이동
	@RequestMapping(value="update", method = RequestMethod.GET)
	public void update(BankBookDTO bankBookDTO,Model model) throws Exception {
		System.out.println(bankBookDTO.getBookNumber());
		bankBookDTO = bankBookService.detail(bankBookDTO);
		model.addAttribute("dto",bankBookDTO);
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(BankBookDTO bankBookDTO) throws Exception {
		int result = bankBookService.delete(bankBookDTO);

		return "redirect:./list";
	}

	// insert form 이동
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() throws Exception {

	}

	// DB에 insert
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(BankBookDTO bankBookDTO) throws Exception {
		int result = bankBookService.add(bankBookDTO);

		return "redirect:./list";
	}

	// list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mv, Pager pager) throws Exception {
		// ModelAndView
		// 매개변수 선언
		// 메서드내에서 객체 생성
		// ModelAndView modelAndView = new ModelAndView();
		List<BankBookDTO> ar = bankBookService.list(pager);
		mv.addObject("list", ar);
		mv.addObject("pager",pager);
		mv.setViewName("bankbook/list");

		return mv;
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(Model model, BankBookDTO bankBookDTO) throws Exception {
		bankBookDTO = bankBookService.detail(bankBookDTO);
		
		//조회가 성공하면 출력
		//조회가 실패하면 alert으로 없는 번호입니다. 이후 다시 list로 이동
		//common/result.jsp 활용 
		
		String view = "common/result";
		
		if(bankBookDTO != null) {
			view = "bankbook/detail";
			model.addAttribute("dto", bankBookDTO);
		}
		else {
			model.addAttribute("message", "없는 번호입니다.");
			model.addAttribute("path", "./list");
		}
		return view;
	}

}
