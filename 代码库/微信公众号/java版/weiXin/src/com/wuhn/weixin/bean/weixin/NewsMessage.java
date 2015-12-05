package com.wuhn.weixin.bean.weixin;

import java.util.List;

/**
 * @author wuhn
 * @创建时间 2015-12-04
 * @功能 回复图文消息 MsgType=news
 * **/
public class NewsMessage {
	private String ArticleCount;//图文消息个数，限制为10条以内
	private List<News> Articles;//多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应
	public String getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(String articleCount) {
		ArticleCount = articleCount;
	}
	public List<News> getArticles() {
		return Articles;
	}
	public void setArticles(List<News> articles) {
		Articles = articles;
	}
	
}
