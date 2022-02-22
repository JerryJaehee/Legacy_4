package com.iu.s1.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyJunitTest;

public class MemberDAOTest extends MyJunitTest{
	
	@Autowired
	private MemberDAO memberDAO; //test 할 클래스
	
	@Test
	public void mypageTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id4f");
		memberDTO = memberDAO.mypage(memberDTO);
		assertNotNull(memberDTO);
	}
	
	//@Test
	public void joinTest() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id2");
		memberDTO.setPw("pw2");
		memberDTO.setName("name2");
		memberDTO.setPhone("010-2222-2222");
		memberDTO.setEmail("id2@gmail.com");
	    int result = memberDAO.join(memberDTO);
	    assertEquals(1, result);
	}
	
	//@Test
	public void loginTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("ID1");
		memberDTO.setPw("PW1");
		memberDTO = memberDAO.login(memberDTO);
		assertNotNull(memberDTO);
	}
	

}
