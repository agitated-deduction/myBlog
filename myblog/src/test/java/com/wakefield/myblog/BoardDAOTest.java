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
	@Test 
	public void testGetPost() throws Exception{
		BoardVO paramVO = new BoardVO();
		paramVO.setIdx(1);
		paramVO.setWriter("tester");
		BoardVO boardVO = boardDAO.getPost(paramVO);
		logger.info("\nPost\n");
		if(boardVO != null) {

			logger.info("�۹�ȣ : " + boardVO.getIdx() );
			logger.info("������ : " + boardVO.getTitle() );
			logger.info("�۳��� : " + boardVO.getContent() );
			logger.info("��ȸ�� : " + boardVO.getHit() );
			logger.info("�ۼ��� : " + boardVO.getWriter() );
			logger.info("�ۼ��� : " + boardVO.getDate() );
			logger.info("����� : " + boardVO.isLock() );

		}else logger.info("no data");

	}
	@Test @Ignore
	public void testInsertBoard() throws Exception {
		BoardVO paramVO = new BoardVO();
		paramVO.setWriter("tester");
		paramVO.setTitle("ù��° �Խù� �Դϴ�.");
		paramVO.setContent("ù��° �Խù��Դϴ�.");

		int result = boardDAO.insertPost(paramVO);

		logger.info("\n Insert Post Result " +result);

		if(result == 1) {

			logger.info("\n �Խù� ��� ���� ");

		} else {

			logger.info("\n �Խù� ��� ����");

		}

	}

	

	@Test  @Ignore
	public void testUpdateBoard() throws Exception {
		BoardVO paramVO = new BoardVO();
		paramVO.setIdx(1);
		paramVO.setWriter("tester");
		paramVO.setTitle("ù��° �Խù� �Դϴ�-����");
		paramVO.setContent("ù��° �Խù��Դϴ�-����");
		paramVO.setLock(true);

		int result = boardDAO.updatePost(paramVO);

		logger.info("\n Update Post Result \n ");

		if(result > 0) {
			logger.info("\n �Խù� ���� ���� ");
		} else {
			logger.info("\n �Խù� ���� ����");
		}

	}

	

	@Test  @Ignore
	public void testDeleteBoard() throws Exception {
		BoardVO paramVO = new BoardVO();
		paramVO.setIdx(1);
		paramVO.setWriter("tester");
		int result = boardDAO.deletePost(paramVO);

		logger.info("\n Delete Post Result \n ");

		if(result > 0) logger.info("\n �Խù� ���� ���� ");
		else logger.info("\n �Խù� ���� ����");


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