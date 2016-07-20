package com.haike.sms.api.test;

import java.util.ArrayList;
import java.util.List;

import com.haike.sms.api.beans.SmsActiveBean;
import com.haike.sms.api.beans.SmsActiveRespBean;
import com.haike.sms.api.beans.SmsRecvBean;
import com.haike.sms.api.beans.SmsRecvRespBean;
import com.haike.sms.api.beans.SmsRptBean;
import com.haike.sms.api.beans.SmsRptRespBean;
import com.haike.sms.api.beans.SmsSendBean;
import com.haike.sms.api.beans.SmsSendRespBean;
import com.haike.sms.api.beans.vo.IdDayBean;
import com.haike.sms.api.beans.vo.MtItemBean;

import com.haike.sms.api.util.ApiConstant;
import com.haike.sms.api.util.StringUtils;
import com.haike.sms.api.util.TokenUtils;

public class Main
{
	/**
	 * 接口调用时使用的系统用户名(实际项目中从配置中获取)
	 */
	private static String	account = "zztest";
	
	/**
	 * 接口调用时使用的系统用户对应的密码(实际项目中从配置中获取)
	 */
	private static String	password = "111111";
	/**
	 * 接口调用时使用的接口编码(实际项目中从配置中获取)
	 */
	private static String	apiCode  = "hkapi";
	/**
	 * 接口服务器的目标地址(实际项目中从配置中获取)
	 */
	private static String  endpoint = "http://127.0.0.1:8080/";
	/**
	 * 接口是否在调试状态(实际项目中从配置中获取)
	 */
	private static boolean debug	 = true;
	//
	
	public static void main(String[] args)
	{
		//------------------------------------------------------------------
		//必须先获得token管理的单例
		TokenUtils.getInstance();
		//准备接口调用
		//以下为api调用的示例代码
		APIClient api = new APIClient();
		//设置接口服务器的目标地址
		api.setTargetEndpoint(endpoint);
		//设置调试(为了输出调用过程中的xml)
		api.setDebug(debug);
		//
		//发送短信必须调用接口(下面二个二选一或根据实际情况都使用)
		//单发短信接口测试(请改写getSmsSendBean方法以生成不同的发送请求bean)
		//SmsSendBean 	bean 		= getSmsSendBean(ApiConstant.OperType_SmsSend);
		//多发测试(请改写getSmsSendBean方法以生成不同的发送请求bean)
		/*
		SmsSendBean 	bean 		= getSmsSendBean(ApiConstant.OperType_SmsSendMuli);
		SmsSendRespBean respBean 	= api.sendSms(bean);
		//返回有token时一定应答成功或部分成功
		if(StringUtils.isNotEmpty(respBean.getToken()))
		{
			TokenUtils.getInstance().updateToken(respBean.getToken());
		}*/
		
		//---------------------------------------------------------------------
		//以下三个接口都不是必须的
		//短信发送回执测试
		//SmsRptBean rptBean 			= getSmsRptBean();
		//SmsRptRespBean	respRptBean = api.recvRpt(rptBean);
		
		//接收短信
		TokenUtils.getInstance().updateToken("48405adf18ac1310e36e3c0539650aeb");
		SmsRecvBean recvBean			= getSmsRecvBean();
		SmsRecvRespBean respRecvBean	= api.recvSms(recvBean);
		
		//心跳操作
		SmsActiveBean activeBean 		= getSmsActiveBean();
		SmsActiveRespBean respActiveBean= api.sendActive(activeBean);
	}
	
	/**
	 * 发送短信示例
	 */
	private static SmsSendBean getSmsSendBean(String OperType)
	{
		SmsSendBean bean = new SmsSendBean();
		//
		//从token的单例类中获取全局token
		bean.setToken(TokenUtils.getInstance().getToken());
		//设置接口认证参数
		bean.setAccount(account);
		bean.setPassword(password);
		bean.setApiCode(apiCode);
		bean.setSnapTime(StringUtils.getSnapTime());
		//
		if(OperType.equalsIgnoreCase(ApiConstant.OperType_SmsSend))
		{
			//设置为单发消息
			bean.setOperType(ApiConstant.OperType_SmsSend);
			//
			//设置目标手机号，大于0个，不超过500个
			bean.setMobiles("13598825428,13503715693");
			bean.setContent("测试短信");
		}
		else if(OperType.equalsIgnoreCase(ApiConstant.OperType_SmsSendMuli))
		{
			//设置为多发消息
			bean.setOperType(ApiConstant.OperType_SmsSendMuli);
			//
			//多个消息，实际项目中应该从数据库中遍历到，大小0个，小于500个
			MtItemBean mt1 = new MtItemBean("2345690", "13598825428", "测试短信111");
			MtItemBean mt2 = new MtItemBean("2345691", "13503715693", "测试短信222");
			//
			List<MtItemBean> smsList		= new ArrayList<MtItemBean>();
			smsList.add(mt1);
			smsList.add(mt2);
			//
			bean.setSmsList(smsList);
		}
		//
		return bean;
	}
	
	/**
	 * 接收短信回执
	 */
	private static SmsRptBean getSmsRptBean()
	{
		SmsRptBean bean = new SmsRptBean();
		//
		//从token的单例类中获取全局token
		bean.setToken(TokenUtils.getInstance().getToken());
		//设置接口认证参数
		bean.setAccount(account);
		bean.setPassword(password);
		bean.setApiCode(apiCode);
		bean.setSnapTime(StringUtils.getSnapTime());
		//设置信息类型为状态报告
		bean.setOperType(ApiConstant.OperType_SmsReport);
		//
		IdDayBean id1 = new IdDayBean("2345690", "20150928");
		IdDayBean id2 = new IdDayBean("2345691", "20150928");
		//
		List<IdDayBean>	idList = new ArrayList<IdDayBean>();
		idList.add(id1);
		idList.add(id2);
		//
		bean.setIdList(idList);
		//
		return bean;
	}
	
	/**
	 * 接收短信示例
	 */
	private static SmsRecvBean getSmsRecvBean()
	{
		SmsRecvBean bean = new SmsRecvBean();
		//
		//从token的单例类中获取token
		bean.setToken(TokenUtils.getInstance().getToken());
		//设置接口认证参数
		bean.setAccount(account);
		bean.setPassword(password);
		bean.setApiCode(apiCode);
		bean.setSnapTime(StringUtils.getSnapTime());
		//设置信息类型为接收信息
		bean.setOperType(ApiConstant.OperType_SmsReceive);
		//
		bean.setAmount(20);
		//
		return bean;
	}
	
	/**
	 * 发送心跳示例
	 */
	private static SmsActiveBean getSmsActiveBean()
	{
		SmsActiveBean  bean = new SmsActiveBean();
		//
		//从token的单例类中获取token
		bean.setToken(TokenUtils.getInstance().getToken());
		bean.setSnapTime(StringUtils.getSnapTime());
		//设置信息类型为心跳信息
		bean.setOperType(ApiConstant.OperType_SmsActive);
		//
		return bean;
	}
}
