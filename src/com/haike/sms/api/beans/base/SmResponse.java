package com.haike.sms.api.beans.base;

import com.haike.sms.api.util.ApiConstant;
import com.haike.sms.api.util.StringUtils;

/**
 * 结构基类：短信接口应答消息的基础类(只包含公共参数)
 * @author:sym
 * @date:20150906
 */
public abstract class SmResponse
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
	 * 接口调用时的操作类型(表示当前消息要做什么)
	 */
	private String	OperType;
	/**
	 * 接口调用时的动作模式(请求还是应答)
	 */
	private int		ActionCode = ApiConstant.ActionCode_Response;
	/**
	 * 接口应答时的时间快照
	 */
	private String	SnapTime;
	/**
	 * 接口调用时的会话token
	 */
	private String	Token;
	/**
	 * 当前短信接口业务逻辑的版本号
	 */
	private String	Version;

	

	/**
	 * 接口应答码
	 */
	private int		ResultCode;
	/**
	 * 接口应答码对应的含义
	 */
	private String	ResultMsg;
	/**
	 * 接口请求时传过来的手机号个数
	 */

	

	/**
	 * 服务端识别到的请求来源IP
	 */
	private String	ReqIpAddr;

	public String getXmlns()
	{
		return xmlns;
	}
	public void setXmlns(String xmlns)
	{
		this.xmlns = xmlns;
	}
	//
	//
	public String getOperType()
	{
		if (StringUtils.isNotEmpty(OperType))
		{
			return OperType;
		}
		else
		{
			return "";
		}
	}

	public void setOperType(String operType)
	{
		OperType = operType;
	}

	public int getActionCode()
	{
		return ActionCode;
	}

	public void setActionCode(int actionCode)
	{
		ActionCode = actionCode;
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
		if (StringUtils.isNotEmpty(Token))
		{
			return Token;
		}
		else
		{
			return "";
		}
	}

	public void setToken(String token)
	{
		Token = token;
	}
	
	public String getDocVersion()
	{
		return DocVersion;
	}
	public void setDocVersion(String docVersion)
	{
		DocVersion = docVersion;
	}
	
	public String getVersion()
	{
		return Version;
	}
	public void setVersion(String version)
	{
		Version = version;
	}

	public int getResultCode()
	{
		return ResultCode;
	}

	public void setResultCode(int resultCode)
	{
		ResultCode = resultCode;
	}

	public String getResultMsg()
	{
		return ResultMsg;
	}
	public void setResultMsg(String resultMsg)
	{
		ResultMsg = resultMsg;
	}

	public String getReqIpAddr()
	{
		return ReqIpAddr;
	}

	public void setReqIpAddr(String reqIpAddr)
	{
		ReqIpAddr = reqIpAddr;
	}
}
