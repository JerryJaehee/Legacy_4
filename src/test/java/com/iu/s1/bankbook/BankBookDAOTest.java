package com.iu.s1.bankbook;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;

import com.iu.s1.MyJunitTest;
import com.iu.s1.util.Pager;

public class BankBookDAOTest extends MyJunitTest{
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	//@Test
	public void check() {
		assertNotNull(bankBookDAO);
	}
	
	@Test
	public void listTest() throws Exception {
		Pager pager = new Pager();
		pager.setPerPage(5L);
		pager.makeRow();
		List<BankBookDTO> ar = bankBookDAO.list(pager);
		System.out.println(ar.get(0).getBookNumber());
		System.out.println(ar.get(4).getBookNumber());
		assertEquals(5, ar.size());
	}
	
	//insert Test
	//@Test
	public void addTest() throws Exception {
		
		
		for(int i=0;i<200;i++) {
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookName("bookName"+i);
			bankBookDTO.setBookContents("Contents"+i);
			
			double rate = Math.random(); //0.0 ~ 1.0 미만 0.12345678
			rate = rate * 1000;
			int r = (int)rate;
			rate = r/100.0;
			
			bankBookDTO.setBookRate(rate);
			bankBookDTO.setBookSale(1);
			int result = bankBookDAO.add(bankBookDTO);
			
			if(i%10 == 0)
				Thread.sleep(1000); //1초동안 멈추기
		}
		System.out.println("Insert Finish");
		//assertEquals(1, result);
	}
	
	//Detail
	//@Test
	public void detailTest() throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();
		//bankBookDTO.setBookNumber(2L);
		bankBookDTO = bankBookDAO.detail(bankBookDTO);
		assertNotNull(bankBookDTO);
	}
	
	//delete Test
	//@Test
	public void deleteTest() throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(2L);
		int result = bankBookDAO.delete(bankBookDTO);
		assertEquals(1, result);
	}

}
