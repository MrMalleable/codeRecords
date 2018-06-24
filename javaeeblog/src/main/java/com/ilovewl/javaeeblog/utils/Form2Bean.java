package com.ilovewl.javaeeblog.utils;

import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import com.ilovewl.javaeeblog.model.Article;
import com.ilovewl.javaeeblog.model.Comment;

public class Form2Bean {
	
	
	public static  Comment commentForm2Bean(HttpServletRequest request) throws FailException{

		int id = Integer.valueOf(request.getParameter("id"));
		
		String nickname = request.getParameter("w_nickname");
		String content = request.getParameter("w_content");
		
		Comment bean = new Comment();
		bean.setArticle_id(id);
		bean.setNickname(nickname);
		bean.setContent(content);
		if(validate(bean)){
			bean.setDiss(0);
			bean.setStar(0);
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			bean.setTime(format.format(new Date()));
			return bean;
		}
		throw new FailException("Create Fail!");
		
	}
	
	
	private static boolean validate(Comment c){
		boolean result= true;
		
		if(c.getArticle_id()==0 || StringUtils.isEmpty(c.getContent())){
			result = false;			
		}
		return result;
	}
	
	
	public static Article articleForm2Bean(HttpServletRequest request) throws FailException{
		
		Map value = new HashMap();
		
		value.put("title",request.getParameter("title"));
		value.put("time",request.getParameter("time"));
		value.put("author",request.getParameter("author"));
		value.put("sort", request.getParameter("sort"));		
		//String tags = request.getParameter("tags");		
		value.put("content", request.getParameter("content"));		
		value.put("star", 0);
		value.put("comment", 0);
		value.put("visit",0);
		
		Article bean = new Article();
		
		try {
			BeanUtils.populate(bean, value);
		} catch (Exception e) {		
			e.printStackTrace();
		
		}			
		if( validate(bean) ){
			return bean;
		}
		throw new FailException("Create Fail!");
		
	}
	
	private static boolean validate(Article a){
		boolean result= true;
		
		if(a.getSort() ==null || a.getTitle()==null || a.getAuthor()==null || a.getTime()==null){
			result = false;	
		}
		
		return result;
	}
	

}
