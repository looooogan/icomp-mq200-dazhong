package com.amistrong.express.beans.request;

import java.io.Serializable;
/**
 * 提交竞猜答案Bean
 * @author 王冉
 * @version 2015-5-16
 */
public class UserGuessAnswer extends User implements Serializable{

	private static final long serialVersionUID = -5441693344168119653L;
	
	private Integer userId;		//用户ID
	private String guessNo;	//竞猜编号
	private Integer gsNo;//题目编号
	private Integer guessAnswer;//答案编号
//	private Map<String, String> answerMap = new HashMap<String, String>();// 竞猜答案Map
	private String[] answers;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getGuessNo() {
		return guessNo;
	}
	public void setGuessNo(String guessNo) {
		this.guessNo = guessNo;
	}
	public Integer getGsNo() {
		return gsNo;
	}
	public void setGsNo(Integer gsNo) {
		this.gsNo = gsNo;
	}
	public Integer getGuessAnswer() {
		return guessAnswer;
	}
	public void setGuessAnswer(Integer guessAnswer) {
		this.guessAnswer = guessAnswer;
	}
	public String[] getAnswers() {
		return answers;
	}
	public void setAnswers(String[] answers) {
		this.answers = answers;
	}
	
	
	
	
}
