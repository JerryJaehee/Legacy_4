package com.iu.s1.notice;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {
	@Autowired
	private NoticeDAO noticeDAO;
	//메서드는 DAO의 메서드와 거의 동일
	
	//list
	public List<NoticeDTO> list() throws Exception {
		
		//DAO 메서드 호출 전 전처리 작업
		//호출 후 후처리 작업
		List<NoticeDTO> ar = noticeDAO.list();
		
		return ar;
	}
	
	//insert
	public int add(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.add(noticeDTO);
	}
	
	//detail
	public NoticeDTO detail(NoticeDTO noticeDTO) throws Exception {
		
		return noticeDAO.detail(noticeDTO);
	}
}
