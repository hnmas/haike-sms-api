package com.haike.sms.api.beans.vo;

import com.haike.sms.api.util.StringUtils;

/**
 * 实体类：短信接收内容的实体
 * @author:sym
 * @date:20150812
 */
public class MoItemBean
{
	/**
	 * 端口的扩展码
	 */
	private String	destAddr;
	/**
	 * 短信的手机号码
	 */
	private String	mobile;
	/**
	 * 短信的短信内容
	 */
	private String	content;
	/**
	 * 短信接收时间
	 */
	private String	recvTime;
	/**
	 * 短信的接收协议
	 */
	private String	proType;
	//
	//
	public String getDestAddr()
	{
		return destAddr;
	}
	public void setDestAddr(String destAddr)
	{
		if(StringUtils.isNotEmpty(destAddr))
		{
			this.destAddr = destAddr;
		}
		else
		{
			this.destAddr = "";
		}
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
		this.content = content;
	}
	public String getRecvTime()
	{
		return recvTime;
	}
	public void setRecvTime(String recvTime)
	{
		this.recvTime = recvTime;
	}
	public String getProType()
	{
		return proType;
	}
	public void setProType(String proType)
	{
		this.proType = proType;
	}
}
