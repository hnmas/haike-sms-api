package com.haike.sms.api.beans.base;

import com.haike.sms.api.util.ApiConstant;
import com.haike.sms.api.util.StringUtils;

/**
 * 结构基类：短信接口请求消息的基础类(只包含公共参数)
 * 
 * @author:sym
 * @date:20150906
 */
public abstract class SmRequest
{
	/**
	 * xml接口文件的命名空间
	 */
	private String 	xmlns;
	/**
	 * 文档标准的版本号
	 */
	private String 	DocVersion;
	
	/**
	 * 请求来源的IP
	 */
	private String	IpAddr;
	
	/**
	 * 接口调用时使用的系统用户名
	 */
	private String	Account;
	
	/**
	 * 接口调用时使用的系统用户对应的密码
	 */
	private String	Password;
	/**
	 * 接口调用时使用的接口编码
	 */
	private String	ApiCode;
	/**
	 * 接口调用时的操作类型(表示当前消息要做什么)
	 */
	private String	OperType;
	/**
	 * 接口调用时的动作模式(请求还是应答)
	 */
	private int		ActionCode =  ApiConstant.ActionCode_Request;
	/**
	 * 接口调用时的时间快照
	 */
	private String	SnapTime;
	/**
	 * 接口调用时的会话token
	 */
	private String	Token;
	/**
	 * 当前短信接口业务逻辑的版本号
	 */
	private String	Version  = ApiConstant.ApiVersion;
	//
	
	//
	//
	public String getXmlns()
	{
		return xmlns;
	}
	public void setXmlns(String xmlns)
	{
		this.xmlns = xmlns;
	}
	//
	public String getDocVersion()
	{
		return DocVersion;
	}
	public void setDocVersion(String docVersion)
	{
		DocVersion = docVersion;
	}
	//
	public String getIpAddr()
	{
		return IpAddr;
	}
	public void setIpAddr(String ip)
	{
		this.IpAddr = ip;
	}
	//
	public String getAccount()
	{
		return Account;
	}
	public void setAccount(String account)
	{
		Account = account;
	}
	public String getPassword()
	{
		return Password;
	}
	public void setPassword(String password)
	{
		Password = password;
	}
	
	public String getApiCode()
	{
		return ApiCode;
	}
	public void setApiCode(String apiCode)
	{
		ApiCode = apiCode;
	}
	
	public String getOperType()
	{
		return OperType;
	}
	public void setOperType(String operType)
	{
		if(StringUtils.isNotEmpty(operType))
		{
			OperType = operType;
		}
		else
		{
			OperType = "";
		}
	}
	
	public int getActionCode()
	{
		return ActionCode;
	}
	
	public String getSnapTime()
	{
		return SnapTime;
	}
	public void setSnapTime(String snapTime)
	{
		SnapTime = snapTime;
	}
	
	public String getToken()
	{
		return Token;
	}
	public void setToken(String token)
	{
		Token = token;
	}
	
	public String getVersion()
	{
		return Version;
	}
}