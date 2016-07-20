package com.haike.sms.api.beans;

import java.util.ArrayList;
import java.util.List;

import com.haike.sms.api.beans.base.SmResponse;
import com.haike.sms.api.beans.vo.RptItemBean;


/**
 * 结构类：短信回执应答消息结构(对应xml)
 * @author:sym
 * @date:20150914
 */
public class SmsRptRespBean extends SmResponse
{
	/**
	 * 请求message的xml节点的数量
	 */
	private int				NodeCount	= 0;

	/**
	 * message节点有效节点的数量
	 */
	private int				IdCount		= 0;
	/**
	 * 送报报告的消息个数
	 */
	private int				RptCount	= 0;

	
	/**
	 * 状态报告的列表(查询数据库之后的)
	 */
	private List<RptItemBean>	RptList = new ArrayList<RptItemBean>();
	//

	public int getRptCount()
	{
		return  RptCount;
	}
	public void setRptCount(int rptCount)
	{
		RptCount = rptCount;
	}

	public List<RptItemBean> getRptList()
	{
		return RptList;
	}
	public void setRptList(List<RptItemBean> rptList)
	{
		RptList = rptList;
	}
	public int getNodeCount()
	{
		return NodeCount;
	}
	public void setNodeCount(int nodeCount)
	{
		NodeCount = nodeCount;
	}
	public int getIdCount()
	{
		return IdCount;
	}
	public void setIdCount(int idCount)
	{
		IdCount = idCount;
	}
}
