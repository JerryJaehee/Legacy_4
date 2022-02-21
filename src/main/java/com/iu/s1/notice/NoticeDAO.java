package com.iu.s1.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMASPACE = "com.iu.s1.notice.NoticeDAO.";
	
	public List<NoticeDTO> list() throws Exception{
		return sqlSession.selectList(NAMASPACE+"list");
	}
	
	public NoticeDTO detail(NoticeDTO noticeDTO) throws Exception{
		
		return sqlSession.selectOne(NAMASPACE+"detail", noticeDTO);
	}
	
	public int add(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.insert(NAMASPACE+"add", noticeDTO);
	}
	
	public int delete(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.delete(NAMASPACE+"delete",noticeDTO);
	}
}
