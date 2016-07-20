package com.haike.sms.api.util;

/**
 * 接口工具类：token工具类
 * @author:sym
 * @date:20150906
 */
public class TokenUtils
{
	//全局公共用的toke
	private  String token = "";
	

	//单例实例
	private static TokenUtils instance;
	//
	public static final TokenUtils getInstance()
	{
		if (instance == null)
		{
			instance = new TokenUtils();
		}
		return instance;
	}
	
	public String getToken()
	{
		return token;
	}
	
	/**
	 * 设置或更新公共token
	 */
	public void updateToken(String token)
	{
		if(StringUtils.isNotEmpty(token))
		{
			synchronized (this.token)
			{
				this.token = token;
			}
		}
	}
	
	/**
	 * 清除公共token
	 */
	public void clearToken()
	{
		synchronized (this.token)
		{
			this.token = "";
		}
	}
}
