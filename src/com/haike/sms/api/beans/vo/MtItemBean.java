package com.haike.sms.api.beans.vo;

import com.haike.sms.api.util.StringUtils;

/**
 * 实体类：短信发送内容的实体
 * @author:sym
 * @date:20150812
 */
public class MtItemBean
{
	/**
	 * 短信的业务归属ID主键
	 */
	private String	id;
	/**
	 * 短信的手机号码
	 */
	private String	mobile;
	/**
	 * 短信的短信内容
	 */
	private String	content;
	//
	public MtItemBean(String id, String mobile, String content)
	{
		this.id 		= id;
		this.mobile 	= mobile;
		//传入的短信内容要过滤下
		this.content 	= StringUtils.replaceYh(content);
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
	public String getMobile()
	{
		return mobile;
	}
	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		if(StringUtils.isNotEmpty(content))
		{
			this.content = StringUtils.replaceYh(content);
		}
		else
		{
			this.content = "";
		}
	}
}