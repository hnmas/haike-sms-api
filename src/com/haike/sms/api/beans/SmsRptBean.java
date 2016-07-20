package com.haike.sms.api.beans;

import java.util.ArrayList;
import java.util.List;

import com.haike.sms.api.beans.base.SmRequest;
import com.haike.sms.api.beans.vo.IdDayBean;

/**
 * 结构类：短信回执请求的消息结构
 * 
 * @author:sym
 * @date:20150906
 */
public class SmsRptBean extends SmRequest
{
	/**
	 * message节点有效节点的数量
	 */
	private int				idCount	= 0;

	/**
	 * 最终解析为短信内容的列表
	 */
	private List<IdDayBean>	idList	= new ArrayList<IdDayBean>();

	//
	public int getIdCount()
	{
		return this.idList.size();
	}

	public List<IdDayBean> getIdList()
	{
		return idList;
	}

	public void setIdList(List<IdDayBean> idList)
	{
		this.idList = idList;
	}
}
