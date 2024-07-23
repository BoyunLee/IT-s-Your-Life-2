package com.multi.model.dao;

import com.multi.model.bean.BoardDto;
import java.util.List;

public interface BoardDao {
	void registerArticle(BoardDto boardDto);
	List<BoardDto> searchListAll();
	List<BoardDto> searchListBySubject(String subject);
	BoardDto viewArticle(int no);
	void modifyArticle(BoardDto boardDto);
	void deleteArticle(int no);
}
