package com.haike.sms.api.beans.vo;

/**
 * 实体类：主键ID和天的实体
 * @author:sym
 * @date:20150812
 */
public class IdDayBean
{
	/**
	 * 主键 
	 */
	private String	id;
	/**
	 * 日期(天)
	 */
	private String	day;
	//
	public IdDayBean(String id, String day)
	{
		this.id 	= id;
		this.day 	= day;
	}
	//
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getDay()
	{
		return day;
	}
	public void setDay(String day)
	{
		this.day = day;
	}
}
