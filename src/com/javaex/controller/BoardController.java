package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.BoardDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.BoardVo;


@WebServlet("/BoardController")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		System.out.println(action);
		
		if("list".equals(action)) {
			System.out.println("listaaa");
			
			BoardDao boardDao = new BoardDao();
			List<BoardVo> boardList = boardDao.select();
			System.out.println(boardList);
			
			request.setAttribute("boardList", boardList);
			
			WebUtil.forword(request, response, "/WEB-INF/views/board/list.jsp");
		
		}else if("read".equals(action)) {
			System.out.println("read");
			
			
		}
		
		
		
		
		
	}


	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
