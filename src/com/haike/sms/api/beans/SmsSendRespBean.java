package com.haike.sms.api.beans;

import com.haike.sms.api.beans.base.SmResponse;
import com.haike.sms.api.util.StringUtils;


/**
 * 结构类：短信发送应答消息结构(单发和多发用同一个返回)
 * @author:sym
 * @date:20150906
 */
public class SmsSendRespBean extends SmResponse
{
	/**
	 * 接口请求时传过来的手机号个数
	 */
	private int		AccessCount;
	/**
	 * 接口请求后处理时识别出来的有效手机号个数
	 */
	private int		AcceptCount;
	
	/**
	 * 短信发送的年月日(即时为当天，定时为指定的发送天)
	 */
	private String 	SendDay;
	//
	

	public int getAccessCount()
	{
		return AccessCount;
	}

	public void setAccessCount(int accessCount)
	{
		AccessCount = accessCount;
	}

	public int getAcceptCount()
	{
		return AcceptCount;
	}

	public void setAcceptCount(int acceptCount)
	{
		AcceptCount = acceptCount;
	}
	
	public String getSendDay()
	{
		if(StringUtils.isNotEmpty(SendDay))
		{
			return SendDay;
		}
		else
		{
			return "";
		}
	}

	public void setSendDay(String sendDay)
	{
		if(StringUtils.isNotEmpty(sendDay))
		{
			int index = sendDay.indexOf(" ");
			if(index > -1)
			{
				sendDay = sendDay.substring(0, index);
				sendDay = sendDay.replaceAll("-", "").trim();
			}
		}
		//
		SendDay = sendDay;
	}
}
