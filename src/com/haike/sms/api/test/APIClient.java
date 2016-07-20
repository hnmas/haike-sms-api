package com.haike.sms.api.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.haike.sms.api.beans.SmsActiveBean;
import com.haike.sms.api.beans.SmsActiveRespBean;
import com.haike.sms.api.beans.SmsRecvBean;
import com.haike.sms.api.beans.SmsRecvRespBean;
import com.haike.sms.api.beans.SmsRptBean;
import com.haike.sms.api.beans.SmsRptRespBean;
import com.haike.sms.api.beans.SmsSendBean;
import com.haike.sms.api.beans.SmsSendRespBean;
import com.haike.sms.api.util.ApiConstant;
import com.haike.sms.api.util.ApiXmlHelper;

/**
 * 短信发送客户端工具类(本文件仅为参考实现，实际中请根据需要自行修改)
 * @author:sym
 * @date:20150906
 */
public class APIClient
{
	
	/**
	 * 服务器的目标地址(注意必须以/结束)
	 */
	private String targetEndpoint 	= "";
	//
	private String mt				= "sms/api/misc.do?mt";
	private String mo				= "sms/api/misc.do?mo";
	private String rpt				= "sms/api/misc.do?rpt";
	private String active			= "sms/api/misc.do?active";
	//
	private boolean debug			= false;
	//
	/**
	 * 发送短信(单发或多发)
	 */
	public SmsSendRespBean sendSms(SmsSendBean bean)
	{
		String actionUrl = targetEndpoint + mt;
		//将请求实体转为请求的xml
		String xml = ApiXmlHelper.toXml(bean);
		if(this.isDebug())
		{
			System.out.println("Request  Xml:" + xml);
		}
		//发送请求
		String respXml = sendPostXml(actionUrl, xml);
		if(this.isDebug())
		{
			System.out.println("Response Xml:" + respXml);
		}
		//将结果转为实体
		SmsSendRespBean respBean = ApiXmlHelper.xmlToSmsSendRespBean(respXml);
		//返回实体
		return respBean;
	}
	
	/**
	 * 接收短信回执
	 */
	public SmsRptRespBean recvRpt(SmsRptBean bean)
	{
		String actionUrl = targetEndpoint + rpt;
		//将请求实体转为请求的xml
		String xml = ApiXmlHelper.toXml(bean);
		if(this.isDebug())
		{
			System.out.println("Request  Xml:" + xml);
		}
		//发送请求
		String respXml = sendPostXml(actionUrl, xml);
		if(this.isDebug())
		{
			System.out.println("Response Xml:" + respXml);
		}
		//将结果转为实体
		SmsRptRespBean respBean = ApiXmlHelper.xmlToSmsRptRespBean(respXml);
		//返回实体
		return respBean;
	}
	
	/**
	 * 接收上行短信
	 */
	public SmsRecvRespBean recvSms(SmsRecvBean bean)
	{
		String actionUrl = targetEndpoint + mo;
		//将请求实体转为请求的xml
		String xml = ApiXmlHelper.toXml(bean);
		if(this.isDebug())
		{
			System.out.println("Request  Xml:" + xml);
		}
		//发送请求
		String respXml = sendPostXml(actionUrl, xml);
		if(this.isDebug())
		{
			System.out.println("Response Xml:" + respXml);
		}
		//将结果转为实体
		SmsRecvRespBean respBean = ApiXmlHelper.xmlToSmsRecvRespBean(respXml);
		//返回实体
		return respBean;
	}
	
	/**
	 * 发送心跳
	 */
	public SmsActiveRespBean sendActive(SmsActiveBean bean)
	{
		String actionUrl = targetEndpoint + active;
		//将请求实体转为请求的xml
		String xml = ApiXmlHelper.toXml(bean);
		if(this.isDebug())
		{
			System.out.println("Request  Xml:" + xml);
		}
		//发送请求
		String respXml = sendPostXml(actionUrl, xml);
		if(this.isDebug())
		{
			System.out.println("Response Xml:" + respXml);
		}
		//将结果转为实体
		SmsActiveRespBean respBean = ApiXmlHelper.xmlToSmsActiveRespBean(respXml);
		//返回实体
		return respBean;
	}
	
	/**
	 * 向目标url发送xml请求,本方法建议通过httpClient重写
	 */
	private String sendPostXml(String urlStr, String params) 
	{
		OutputStream out = null;
		BufferedReader in = null;
		StringBuffer result = new StringBuffer();
		try 
		{
			URL realUrl = new URL(urlStr);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			//设置通用的请求属性(请求超时和应答后读取超时)
			conn.setConnectTimeout(3000);
			conn.setReadTimeout(5000);
			//
			conn.setRequestProperty("Accept", "*/*");
			conn.setRequestProperty("Content-Type", "text/xml"); 
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("User-Agent","HaikeSoft/API MISC/V"+ ApiConstant.ApiVersion +" (KHTML, like Gecko)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = conn.getOutputStream();
			// 发送请求参数
			out.write(params.getBytes("UTF-8"));
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line = "";
			while ((line = in.readLine()) != null) 
			{
				result.append(line);
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		finally 
		{
			try 
			{
				if (out != null) 
				{
					out.close();
					out = null;
				}
				if (in != null) 
				{
					in.close();
					in = null;
				}
			}
			catch (Exception ex) 
			{
				System.out.println(ex);
			}
		}
		//
		return result.toString();
	} 
	
	public boolean isDebug()
	{
		return debug;
	}

	public void setDebug(boolean debug)
	{
		this.debug = debug;
	}
	
	public String getTargetEndpoint()
	{
		return targetEndpoint;
	}

	public void setTargetEndpoint(String targetEndpoint)
	{
		this.targetEndpoint = targetEndpoint;
	}
}
