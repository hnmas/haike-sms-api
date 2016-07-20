package com.haike.sms.api.beans.vo;

/**
 * 实体类：手机号实体(三个成员)
 * @author:sym
 * @date:20150812
 */
public class MobileBean
{
	/**
	 *  ID：可表示人员ID，群组ID
	 */
	private String id;
	/**
	 * 姓名或群组名
	 */
	private String name;
	/**
	 * 手机号
	 */
	private String mobile;
	//
	//
	public MobileBean()
	{
		//
	}
	//只有手机号
	public MobileBean(String mobile)
	{
		this.mobile = mobile;
	}
	//
	//手机号和姓名
	public MobileBean(String name, String mobile)
	{
		this.name 	= name;
		this.mobile = mobile;
	}
	//手机号姓名和主键ID
	public MobileBean(String id, String name,  String mobile)
	{
		this.id 		= id;
		this.name 		= name;
		this.mobile 	= mobile;
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
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getMobile()
	{
		return mobile;
	}
	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}
}
