package com.haike.sms.api.beans;

import com.haike.sms.api.beans.base.SmRequest;
import com.haike.sms.api.util.StringUtils;


/**
 * 结构类：短信接收请求的消息结构
 * @author:sym
 * @date:20150914
 */
public class SmsRecvBean extends SmRequest
{
	/**
	 * 每次请求最多返回多少条上行短信(允许为空(或节点不存在),必须大于0，最大不允许超过500),为空时表示20
	 */
	private int	amount;

	//
	public int getAmount()
	{
		return amount;
	}

	public void setAmount(int amount)
	{
		this.amount = amount;
	}
}
