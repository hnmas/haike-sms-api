package com.haike.sms.api.beans;

import java.util.ArrayList;
import java.util.List;

import com.haike.sms.api.beans.base.SmResponse;
import com.haike.sms.api.beans.vo.MoItemBean;



/**
 * 结构类：短信接收应答消息结构(对应返回xml)
 * @author:sym
 * @date:20150914
 */
public class SmsRecvRespBean  extends SmResponse
{
	/**
	 * 接口请求时传过来的手机号个数
	 */
	private int					RecvCount;
	/**
	 * 接收短信的列表
	 */
	private List<MoItemBean>	RevList = new ArrayList<MoItemBean>();
	
	public int getRecvCount()
	{
		return RecvCount;
	}
	public void setRecvCount(int recvCount)
	{
		RecvCount = recvCount;
	}
	
	public List<MoItemBean> getRevList()
	{
		return RevList;
	}
	public void setRevList(List<MoItemBean> revList)
	{
		RevList = revList;
	}
}
