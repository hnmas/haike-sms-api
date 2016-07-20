package com.haike.sms.api.beans.vo;

/**
 * 结构类：短信状态报告消息结构
 * 
 * @author:sym
 * @date:20150914
 */
public class RptItemBean
{
	/**
	 * 原短信在业务系统中的主键ID
	 */
	private String id;
	

	/**
	 * 原短信任务时的任务名称
	 */
	private String	taskName;
	/**
	 * 短信源地址，这里指运营商端口的扩展码,不含基础码
	 */
	private String	orgAddr;
	/**
	 * 原任务是否要求接收回执
	 */
	private String	regDeliver;
	/**
	 * 手机号
	 */
	private String 	mobile;
	/**
	 * 短信的发送状态
	 */
	private String	sendStatus;
	/**
	 * 短信的接收状态,变化过后的，各运营商统一表示
	 */
	private String	recvStatus;
	/**
	 * 只在请求回执时有意义，收到回执的时间
	 */
	private String	rptTime;
	/**
	 * 短信的协议状态，以运营商的实际值为准
	 */
	private String	proStatus;
	/**
	 * 当前短信所归属的运营商协议标识
	 */
	private String	proType;

	//
	//
	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}
	public String getTaskName()
	{
		return taskName;
	}

	public void setTaskName(String taskName)
	{
		this.taskName = taskName;
	}

	public String getOrgAddr()
	{
		return orgAddr;
	}

	public void setOrgAddr(String orgAddr)
	{
		this.orgAddr = orgAddr;
	}
	
	public String getMobile()
	{
		return mobile;
	}

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}

	public String getRegDeliver()
	{
		return regDeliver;
	}

	public void setRegDeliver(String regDeliver)
	{
		this.regDeliver = regDeliver;
	}

	public String getSendStatus()
	{
		return sendStatus;
	}

	public void setSendStatus(String sendStatus)
	{
		this.sendStatus = sendStatus;
	}

	public String getRecvStatus()
	{
		return recvStatus;
	}

	public void setRecvStatus(String recvStatus)
	{
		this.recvStatus = recvStatus;
	}

	

	public String getRptTime()
	{
		return rptTime;
	}

	public void setRptTime(String rptTime)
	{
		this.rptTime = rptTime;
	}

	public String getProStatus()
	{
		return proStatus;
	}

	public void setProStatus(String proStatus)
	{
		this.proStatus = proStatus;
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
