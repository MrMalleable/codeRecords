package com.ilovewl.javaeeblog.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.Tag;

import com.ilovewl.javaeeblog.dao.ArticleDao;
import com.ilovewl.javaeeblog.dao.UserDao;
import com.ilovewl.javaeeblog.daoImpl.UserDaoImpl;
import com.ilovewl.javaeeblog.db.VisitorDB;
import com.ilovewl.javaeeblog.model.Article;
import com.ilovewl.javaeeblog.model.User;
import com.ilovewl.javaeeblog.service.ArticleService;
import com.ilovewl.javaeeblog.service.TagService;
import com.ilovewl.javaeeblog.utils.LoginUtils;

/**
 * Login->index.jsp->init data
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		LoginUtils.login(request);
		
		//初始化分类
		ArticleService as =  ArticleService.getInstance();		
		request.setAttribute("sort_count_map", as.getSortAndCount());
		//初始化文章列表
		request.setAttribute("article_list", as.getArticle());
		//初始化获取标签
		TagService ts = TagService.getInstance();			
		request.setAttribute("tag_list", ts.getAllTag());	
		
		//初始化侧边栏 日志、分类、标签的个数
		request.setAttribute("article_number", as.getCount(ArticleDao.SEARCH_ARTICLE));		
		request.setAttribute("sort_number", as.getCount(ArticleDao.SEARCH_SORT));		
		request.setAttribute("tags_number", ts.getTagCount());
		
		//阅读排行
		request.setAttribute("visit_rank", as.getVisitRank());
		
		//传网站的统计数据
		request.setAttribute("visited", VisitorDB.totalVisit());
		request.setAttribute("member", VisitorDB.totalMember());
		
		//转发到 博客主页 界面
		request.getRequestDispatcher("/page/main.jsp").forward(request, response);	
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
