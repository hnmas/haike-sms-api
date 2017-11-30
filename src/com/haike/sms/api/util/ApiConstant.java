package com.haike.sms.api.util;


/**
 * 短信接口常量类
 * @author:sym
 * @date:20150906
 */
public class ApiConstant
{
	/**
	 * 系统目录分隔符
	 */
	private static String	sep						= System.getProperty("file.separator");
	/**
	 * mo表类型
	 */
	public static String 	TableType_Mo			= "mo";
	/**
	 * mt表类型
	 */
	public static String 	TableType_Mt			= "mt";
	/**
	 * 短信类型固定为API
	 */
	public static String 	SmOperType_API			= "API";
	//
	/**
	 * xml文档的编码要求必须为utf-8(不允许为其它值)
	 */
	public static String 	charset					= "utf-8";
	//---------------------------------------------------------------------
	/**
	 * 接口文档标准的版本
	 */
	public static String	DocVersion				= "1.0";
	/**
	 * 当前短信接口业务逻辑的版本号(1.50纯短信，1.60支撑微信)
	 */
	public static String	ApiVersion				= "1.60";
	//---------------------------------------------------------------------
	public static String	SmsLogPath				= "logs" + sep + "sms" + sep;
	public static String 	SmsLogFileTxt			= ".txt";
	public static String 	SmsLogFileXml			= ".xml";
	public static String 	SmsLogAction_Request  	= "req";
	public static String 	SmsLogAction_Xml  		= "xml";
	public static String 	SmsLogAction_Response  	= "resp";
	//---------------------------------------------------------------------
	/**
	 * 接口操作类型:普通单发短信(多个号码对应同一个短信内容)
	 */
	public static String	OperType_SmsSend		= "SmsSend";
	/**
	 * 接口操作类型:群发短信(一个号码对应一个短信内容)
	 */
	public static String	OperType_SmsSendMuli	= "SmsSendMuli";
	/**
	 * 接口操作类型:读取接收短信
	 */
	public static String	OperType_SmsReceive		= "SmsReceive";
	/**
	 * 接口操作类型:读取状态报告
	 */
	public static String	OperType_SmsReport		= "SmsReport";
	/**
	 * 接口操作类型:心跳操作
	 */
	public static String	OperType_SmsActive		= "SmsActive";
	//---------------------------------------------------------------------
	/**
	 * 接口动作方式：发送请求
	 */
	public static int		ActionCode_Request		= 1;
	/**
	 * 接口动作方式：返回应答
	 */
	public static int		ActionCode_Response		= 2;
	//---------------------------------------------------------------------
	/**
	 * 实时优先级
	 */
	public static int		Priority_RealTime		= 0;
	/**
	 * 高级优先级
	 */
	public static int		Priority_High			= 1;
	/**
	 * 中级优先级
	 */
	public static int		Priority_Middle			= 2;
	/**
	 * 低级优先级
	 */
	public static int		Priority_Low			= 3;
	//---------------------------------------------------------------------
	/**
	 * 接口信息发送渠道:短信
	 */
	public static String	SendChannel_SMS			= "SMS";
	/**
	 * 接口信息发送渠道:微信
	 */
	public static String	SendChannel_WX			= "WX";
	/**
	 * 接口信息发送渠道:全部
	 */
	public static String	SendChannel_ALL			= "ALL";
}
