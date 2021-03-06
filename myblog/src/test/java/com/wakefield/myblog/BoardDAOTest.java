package com.wakefield.myblog;

import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wakefield.myblog.dao.BoardDAO;
import com.wakefield.myblog.model.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:spring/root-context.xml",
		"classpath:spring/dataSource-context.xml"
})
public class BoardDAOTest {
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Inject
	private BoardDAO boardDAO;
	
	@Test@Ignore
	public void testGetBoardList()throws Exception{
		List<BoardVO> boardList = boardDAO.getPostList("tester");
		logger.info("\n Board list\n");
		if(boardList.size()>0) {
			for(BoardVO list: boardList) {
				logger.info(list.getTitle());
			}
		}else logger.info("no data");
	}
	@Test @Ignore
	public void testGetPost() throws Exception{
		BoardVO paramVO = new BoardVO();
		paramVO.setIdx(1);
		paramVO.setWriter("tester");
		BoardVO boardVO = boardDAO.getPost(paramVO);
		logger.info("\nPost\n");
		if(boardVO != null) {

			logger.info("글번호 : " + boardVO.getIdx() );
			logger.info("글제목 : " + boardVO.getTitle() );
			logger.info("글내용 : " + boardVO.getContent() );
			logger.info("조회수 : " + boardVO.getHit() );
			logger.info("작성자 : " + boardVO.getWriter() );
			logger.info("작성일 : " + boardVO.getDate() );
			logger.info("비공개 : " + boardVO.isLock() );

		}else logger.info("no data");

	}
	@Test 
	public void testInsertBoard() throws Exception {
		BoardVO paramVO = new BoardVO();
		paramVO.setWriter("new-tester");
		//paramVO.setTitle("첫번째 게시물 입니다.");
		//paramVO.setContent("첫번째 게시물입니다.");
		paramVO.setLock(false);
		
		for(int i = 1; i < 1300; i++) {
			paramVO.setTitle(i+" 게시물");
			paramVO.setContent(i+ " 게시물 입니다.");
		int result = boardDAO.insertPost(paramVO);

		logger.info("\n Insert Post Result " +result);

		if(result == 1) {

			logger.info("\n 게시물 등록 성공 ");

		} else {

			logger.info("\n 게시물 등록 실패");

		}
		}

	}

	

	@Test  @Ignore
	public void testUpdateBoard() throws Exception {
		BoardVO paramVO = new BoardVO();
		paramVO.setIdx(1);
		paramVO.setWriter("tester");
		paramVO.setTitle("첫번째 게시물 입니다-수정");
		paramVO.setContent("첫번째 게시물입니다-수정");
		paramVO.setLock(true);

		int result = boardDAO.updatePost(paramVO);

		logger.info("\n Update Post Result \n ");

		if(result > 0) {
			logger.info("\n 게시물 수정 성공 ");
		} else {
			logger.info("\n 게시물 수정 실패");
		}

	}

	

	@Test  @Ignore
	public void testDeleteBoard() throws Exception {
		BoardVO paramVO = new BoardVO();
		paramVO.setIdx(1);
		paramVO.setWriter("tester");
		int result = boardDAO.deletePost(paramVO);

		logger.info("\n Delete Post Result \n ");

		if(result > 0) logger.info("\n 게시물 삭제 성공 ");
		else logger.info("\n 게시물 삭제 실패");


	}



	@Test @Ignore
	public void testUpdateHit() throws Exception {
		BoardVO paramVO = new BoardVO();
		paramVO.setWriter("tester");
		paramVO.setIdx(1);
		paramVO = boardDAO.getPost(paramVO);

		boardDAO.updateHit(paramVO);

		logger.info("\n==========Update Hit Test==========\n");
		testGetPost();

	}


	
}
