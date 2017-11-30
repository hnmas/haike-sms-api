package com.haike.sms.api.beans;

import java.util.ArrayList;
import java.util.List;

import com.haike.sms.api.beans.base.SmRequest;
import com.haike.sms.api.beans.vo.MobileBean;
import com.haike.sms.api.beans.vo.MtItemBean;
import com.haike.sms.api.util.ApiConstant;
import com.haike.sms.api.util.StringUtils;

/**
 * 结构类：短信发送接口消息结构(同时包含单发和多发) 
 * @author:sym
 * @date:20150906
 */
public class SmsSendBean extends SmRequest
{
	// 以下参数在单发短信时有效
	/**
	 * 多个手机号码字符串
	 */
	private String				Mobiles;
	/**
	 * 短信内容
	 */
	private String				Content;
	//
	// ------------------------------------------------------------------
	// 以下参数在多发短信时需要
	/**
	 * 短信节点的数量
	 */
	private int						smCount	= 0;

	

	/**
	 * 最终解析为短信内容的列表
	 */
	private List<MtItemBean>		smsList		= new ArrayList<MtItemBean>();
	//
	//------------------------------------------------------------------
	//发送短信时的公共参数
	/**
	 * 接口短信发送的优先级(默认为：2中级优先级)
	 */
	private int					Priority	= ApiConstant.Priority_Middle;
	/**
	 * 接口短信发送是否请求回执(默认为：请求回执)
	 */
	private int					RegDeliver	= 1;
	/**
	 * 接口短信发送是否附加用户姓名(默认为：不附加)
	 */
	private boolean				AppendName	= false;
	/**
	 * 接口短信发送是附加要求回复(默认为：不附加)
	 */
	private boolean				NeedReply	= false;

	/**
	 * 是否使用端口的基础端口下发短信(默认为：不使用)
	 */
	private boolean				UseOriginalAddr	= false;

	/**
	 * 接口短信发送是否定时发送(默认为：立即发送)
	 */
	private boolean				SendAtTime	= false;
	/**
	 * 接口短信发送是否定时发送(默认为空，如果要求为定时发送，则要求时间字符串必须正确)
	 */
	private String				SendTime = "";
	/**
	 *  消息发送通道，(为空或不传本参数时默认为SMS)
	 * 	WX:通过微信发送
	 * 	ALL:同时发短信和微信
	 */
	private String				SendChannel	= ApiConstant.SendChannel_SMS;

	//
	public String getMobiles()
	{
		return Mobiles;
	}

	public void setMobiles(String mobiles)
	{
		if (StringUtils.isNotEmpty(mobiles))
		{
			mobiles = mobiles.trim();
			//
			Mobiles = mobiles;
		}
		else
		{
			Mobiles = "";
		}
	}

	

	public String getContent()
	{
		return Content;
	}

	public void setContent(String content)
	{
		if (StringUtils.isNotEmpty(content))
		{
			Content = content;
		}
		else
		{
			Content = "";
		}
	}


	/**
	 * 给短信列表中每条短信都附加短信内容
	 */
	public List<MtItemBean> getSmsList(String appendContent)
	{
		if (StringUtils.isNotEmpty(appendContent))
		{
			if (smsList != null)
			{
				if (smsList.size() > 0)
				{
					for (int i = 0; i < smsList.size(); i++)
					{
						String content = smsList.get(i).getContent() + appendContent;
						smsList.get(i).setContent(content);
					}
				}
			}
		}
		//
		return smsList;
	}

	public List<MtItemBean> getSmsList()
	{
		return smsList;
	}

	public void setSmsList(List<MtItemBean> smsList)
	{
		this.smsList = smsList;
	}
	
	public int getSmCount()
	{
		return this.smsList.size();
	}
	// --------------------------------------------------------------------
	public int getPriority()
	{
		return Priority;
	}

	public void setPriority(String pri)
	{
		int priority = StringUtils.toInt(pri, 3);
		//
		if (priority < 0)
		{
			Priority = 3;
		}
		else if (priority > 3)
		{
			Priority = 3;
		}
		else
		{
			Priority = priority;
		}
	}

	public int getRegDeliver()
	{
		return RegDeliver;
	}

	public void setRegDeliver(String regDeliver)
	{
		RegDeliver = StringUtils.toInt(regDeliver, 1);
		//
		if (RegDeliver > 1)
		{
			RegDeliver = 1;
		}
		else if (RegDeliver < 0)
		{
			RegDeliver = 0;
		}
	}

	public boolean isAppendName()
	{
		return AppendName;
	}

	public void setAppendName(String appendName)
	{
		AppendName = StringUtils.toBoolean(appendName, false);
	}

	public boolean isNeedReply()
	{
		return NeedReply;
	}

	public void setNeedReply(String needReply)
	{
		NeedReply = StringUtils.toBoolean(needReply, false);
	}

	public boolean isUseOriginalAddr()
	{
		return UseOriginalAddr;
	}

	public void setUseOriginalAddr(String originalAddr)
	{
		UseOriginalAddr = StringUtils.toBoolean(originalAddr, false);
	}

	public boolean isSendAtTime()
	{
		return SendAtTime;
	}

	public void setSendAtTime(String sendAtTime)
	{
		SendAtTime = StringUtils.toBoolean(sendAtTime, false);
	}

	public String getSendTime()
	{
		return SendTime;
	}

	public void setSendTime(String sendTime)
	{
		SendTime = sendTime;
	}
	
	public String getSendChannel()
	{
		return SendChannel;
	}

	public void setSendChannel(String sendChannel)
	{
		SendChannel = sendChannel;
	}
}