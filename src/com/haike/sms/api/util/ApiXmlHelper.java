package com.haike.sms.api.util;


import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;

import com.haike.sms.api.beans.SmsSendBean;
import com.haike.sms.api.beans.SmsSendRespBean;
import com.haike.sms.api.beans.SmsRptBean;
import com.haike.sms.api.beans.SmsRptRespBean;
import com.haike.sms.api.beans.SmsRecvBean;
import com.haike.sms.api.beans.SmsRecvRespBean;
import com.haike.sms.api.beans.SmsActiveBean;
import com.haike.sms.api.beans.SmsActiveRespBean;
import com.haike.sms.api.beans.vo.IdDayBean;
import com.haike.sms.api.beans.vo.MoItemBean;
import com.haike.sms.api.beans.vo.MtItemBean;
import com.haike.sms.api.beans.vo.RptItemBean;

/**
 * 接口工具类：短信接口的常用xml方法工具类
 * @author:sym
 * @date:20150906
 */
public class ApiXmlHelper
{
	private static final String	xmlHead	= "<?xml version=\"1.0\" encoding=\""+ ApiConstant.charset +"\"?>";
	//这里的Version表示文档标准的版本(xml中的版本表示业务逻辑的版本)
	private static final String xmlHaikeMiscStart = "<haikemisc namespace=\"http://www.haikemobile.cn/misc/sms/design\" version=\""+ ApiConstant.DocVersion +"\">";
	private static final String xmlHaikeMiscEnd	  = "</haikemisc>";
	private static final String xmlHeadStart = "<head>";
	private static final String xmlHeadEnd	 = "</head>";
	private static final String xmlBodyStart = "<body>";
	private static final String xmlBodyEnd   = "</body>";
	//
	private static final String sep 	=  System.getProperty("line.separator", "/n");
	//
	//-----------------------------------------------------------------------------------------------
	//以下为将实体类转为xml字符串的方法
	/**
	 * 将短信发送实体转为xml字符串
	 */
	public static String toXml(SmsSendBean bean)
	{
		StringBuffer si = new StringBuffer();
		//
		si.append(xmlHead);
		si.append(xmlHaikeMiscStart);
		si.append(xmlHeadStart);
		si.append("<authinfo>");
		si.append("<account>"+ bean.getAccount() +"</account>");
		si.append("<password>"+ bean.getPassword() +"</password>");
		si.append("<apicode>"+ bean.getApiCode() +"</apicode>");
		si.append("</authinfo>");
		si.append("<opertype>" + bean.getOperType() + "</opertype>");
		si.append("<actioncode>" + bean.getActionCode() + "</actioncode>");
		si.append("<snaptime>" + bean.getSnapTime() + "</snaptime>");
		si.append("<token>" + bean.getToken() + "</token>");
		si.append("<version>" + bean.getVersion() + "</version>");
		si.append(xmlHeadEnd);
		si.append(xmlBodyStart);
		si.append("<svcsms>");
		if(bean.getOperType().equalsIgnoreCase(ApiConstant.OperType_SmsSend))
		{
			//单发短信
			si.append("<mobiles>"+ bean.getMobiles() +"</mobiles>");
			si.append("<content><![CDATA["+ bean.getContent() +"]]></content>");
		}
		else if(bean.getOperType().equalsIgnoreCase(ApiConstant.OperType_SmsSendMuli))
		{
			//多发短信
			for(int i = 0; i < bean.getSmCount(); i++)
			{
				MtItemBean mt = bean.getSmsList().get(i);
				//
				si.append("<message>");
				si.append("<id>"+ mt.getId() +"</id>");
				si.append("<mobile>"+ mt.getMobile() +"</mobile>");
				si.append("<content><![CDATA["+ mt.getContent() +"]]></content>");
				si.append("</message>");
			}
		}
		si.append("</svcsms>");
		si.append("<svccmd>");
		si.append("<priority>"+ bean.getPriority() +"</priority>");
		si.append("<regdeliver>"+ bean.getRegDeliver() +"</regdeliver>");
		si.append("<appendname>"+ bean.isAppendName() +"</appendname>");
		si.append("<needreply>"+ bean.isNeedReply() +"</needreply>");
		si.append("<useoriginaladdr>"+ bean.isUseOriginalAddr() +"</useoriginaladdr>");
		si.append("<sendattime>"+ bean.isSendAtTime() +"</sendattime>");
		si.append("<sendtime>"+ bean.getSendTime() +"</sendtime>");
		si.append("</svccmd>");
		si.append(xmlBodyEnd);
		si.append(xmlHaikeMiscEnd);
		//
		return si.toString();
	}
	
	/**
	 * 将短信回执实体转为xml字符串
	 */
	public static String toXml(SmsRptBean bean)
	{
		StringBuffer si = new StringBuffer();
		//
		si.append(xmlHead);
		si.append(xmlHaikeMiscStart);
		si.append(xmlHeadStart);
		si.append("<authinfo>");
		si.append("<account>"+ bean.getAccount() +"</account>");
		si.append("<password>"+ bean.getPassword() +"</password>");
		si.append("<apicode>"+ bean.getApiCode() +"</apicode>");
		si.append("</authinfo>");
		si.append("<opertype>" + bean.getOperType() + "</opertype>");
		si.append("<actioncode>" + bean.getActionCode() + "</actioncode>");
		si.append("<snaptime>" + bean.getSnapTime() + "</snaptime>");
		si.append("<token>" + bean.getToken() + "</token>");
		si.append("<version>" + bean.getVersion() + "</version>");
		si.append(xmlHeadEnd);
		si.append(xmlBodyStart);
		si.append("<svcsms>");
		//要查询的回执的短信业务主键和日期
		for(int i = 0; i < bean.getIdCount(); i++)
		{
			IdDayBean vo = bean.getIdList().get(i);
			//
			si.append("<message>");
			si.append("<id>"+ vo.getId() +"</id>");
			si.append("<sendday>"+ vo.getDay() +"</sendday>");
			si.append("</message>");
		}
		si.append("</svcsms>");
		si.append(xmlBodyEnd);
		si.append(xmlHaikeMiscEnd);
		//
		return si.toString();
	}
	//
	/**
	 * 将接收短信实体转为xml字符串
	 */
	public static String toXml(SmsRecvBean bean)
	{
		StringBuffer si = new StringBuffer();
		//
		si.append(xmlHead);
		si.append(xmlHaikeMiscStart);
		si.append(xmlHeadStart);
		si.append("<authinfo>");
		si.append("<account>"+ bean.getAccount() +"</account>");
		si.append("<password>"+ bean.getPassword() +"</password>");
		si.append("<apicode>"+ bean.getApiCode() +"</apicode>");
		si.append("</authinfo>");
		si.append("<opertype>" + bean.getOperType() + "</opertype>");
		si.append("<actioncode>" + bean.getActionCode() + "</actioncode>");
		si.append("<snaptime>" + bean.getSnapTime() + "</snaptime>");
		si.append("<token>" + bean.getToken() + "</token>");
		si.append("<version>" + bean.getVersion() + "</version>");
		si.append(xmlHeadEnd);
		si.append(xmlBodyStart);
		si.append("<svcsms>");
		//
		si.append("<amount>"+ bean.getAmount() +"</amount>");
		//
		si.append("</svcsms>");
		si.append(xmlBodyEnd);
		si.append(xmlHaikeMiscEnd);
		//
		return si.toString();
	}
	
	/**
	 * 将心跳实体转为xml字符串
	 */
	public static String toXml(SmsActiveBean bean)
	{
		StringBuffer si = new StringBuffer();
		//
		si.append(xmlHead);
		si.append(xmlHaikeMiscStart);
		si.append(xmlHeadStart);
		si.append("<opertype>" + bean.getOperType() + "</opertype>");
		si.append("<actioncode>" + bean.getActionCode() + "</actioncode>");
		si.append("<snaptime>" + bean.getSnapTime() + "</snaptime>");
		si.append("<token>" + bean.getToken() + "</token>");
		si.append("<version>" + bean.getVersion() + "</version>");
		si.append(xmlHeadEnd);
		si.append(xmlBodyStart);
		si.append("<svcsms>");
		si.append("</svcsms>");
		si.append(xmlBodyEnd);
		si.append(xmlHaikeMiscEnd);
		//
		return si.toString();
	}
	
	//-------------------------------------------------------------------------------------------
	//以下是将xml转为实体类的方法
	/**
	 * 将短信发送应答xml字符串转为实体类
	 */
	public static SmsSendRespBean xmlToSmsSendRespBean(String xml)
	{
		SmsSendRespBean bean = null;
		//
		if(StringUtils.isNotEmpty(xml))
		{
			//用指定的编码(默认为utf-8)编码xml的字符串
			Document doc = XmlUtils.ConvertStringToXml(xml, ApiConstant.charset);
			//
			if(doc != null)
			{
				bean = new SmsSendRespBean();
				//
				String xmlns			= XmlUtils.getElementValue(doc, "/haikemisc", "namespace");
				String docVersion		= XmlUtils.getElementValue(doc, "/haikemisc", "version");
				//应答头信息
				String xpathHead 		= "/haikemisc/head/";
				String operType 		= XmlUtils.getElementValue(doc, xpathHead + "opertype");
				String actionCode 		= XmlUtils.getElementValue(doc, xpathHead + "actioncode");
				String snapTime 		= XmlUtils.getElementValue(doc, xpathHead + "snaptime");
				String token 			= XmlUtils.getElementValue(doc, xpathHead + "token");
				String version 			= XmlUtils.getElementValue(doc, xpathHead + "version");
				//应答内容信息
				String xpathBody 	= "/haikemisc/body/";
				//
				String resultCode 		= XmlUtils.getElementValue(doc, xpathBody + "resultcode");
				String resultMsg 		= XmlUtils.getElementValue(doc, xpathBody + "resultmsg");
				String accessCount 		= XmlUtils.getElementValue(doc, xpathBody + "accesscount");
				String acceptCount 		= XmlUtils.getElementValue(doc, xpathBody + "acceptcount");
				String reqIpAddr 		= XmlUtils.getElementValue(doc, xpathBody + "reqipaddr");
				String sendDay 			= XmlUtils.getElementValue(doc, xpathBody + "sendday");
				//-----------------------------------------------------------------------------------
				//解析结束后设置实类参数
				bean.setXmlns(xmlns);
				bean.setDocVersion(docVersion);
				//设置信息头
				bean.setOperType(operType);
				bean.setActionCode(StringUtils.toInt(actionCode));
				bean.setSnapTime(snapTime);
				bean.setToken(token);
				bean.setVersion(version);
				//设置信息内容
				bean.setResultCode(StringUtils.toInt(resultCode));
				bean.setResultMsg(resultMsg);
				bean.setAccessCount(StringUtils.toInt(accessCount));
				bean.setAcceptCount(StringUtils.toInt(acceptCount));
				bean.setSendDay(sendDay);
				bean.setReqIpAddr(reqIpAddr);
			}
		}
		//
		return bean;
	}
	
	/**
	 * 将短信回执应答xml字符串转为实体类
	 */
	public static SmsRptRespBean xmlToSmsRptRespBean(String xml)
	{
		SmsRptRespBean bean = null;
		//
		if(StringUtils.isNotEmpty(xml))
		{
			//用指定的编码(默认为utf-8)编码xml的字符串
			Document doc = XmlUtils.ConvertStringToXml(xml, ApiConstant.charset);
			//
			if(doc != null)
			{
				bean = new SmsRptRespBean();
				//
				String xmlns			= XmlUtils.getElementValue(doc, "/haikemisc", "namespace");
				String docVersion		= XmlUtils.getElementValue(doc, "/haikemisc", "version");
				//应答头信息
				String xpathHead 		= "/haikemisc/head/";
				String operType 		= XmlUtils.getElementValue(doc, xpathHead + "opertype");
				String actionCode 		= XmlUtils.getElementValue(doc, xpathHead + "actioncode");
				String snapTime 		= XmlUtils.getElementValue(doc, xpathHead + "snaptime");
				String token 			= XmlUtils.getElementValue(doc, xpathHead + "token");
				String version 			= XmlUtils.getElementValue(doc, xpathHead + "version");
				//应答内容信息
				String xpathBody 	= "/haikemisc/body/";
				//
				String resultCode 		= XmlUtils.getElementValue(doc, xpathBody + "resultcode");
				String resultMsg 		= XmlUtils.getElementValue(doc, xpathBody + "resultmsg");
				String reqIpAddr 		= XmlUtils.getElementValue(doc, xpathBody + "reqipaddr");
				//
				String nodeCount 		= XmlUtils.getElementValue(doc, xpathBody + "nodecount");
				String idCount 			= XmlUtils.getElementValue(doc, xpathBody + "idcount");
				String rptCount 		= XmlUtils.getElementValue(doc, xpathBody + "rptcount");
				//
				List<Element> nodeList	= XmlUtils.getElementList(doc, xpathBody + "svcsms/message");
				//-----------------------------------------------------------------------------------
				//解析结束后设置实类参数
				bean.setXmlns(xmlns);
				bean.setDocVersion(docVersion);
				//设置信息头
				bean.setOperType(operType);
				bean.setActionCode(StringUtils.toInt(actionCode));
				bean.setSnapTime(snapTime);
				bean.setToken(token);
				bean.setVersion(version);
				//设置信息内容
				bean.setResultCode(StringUtils.toInt(resultCode));
				bean.setResultMsg(resultMsg);
				bean.setReqIpAddr(reqIpAddr);
				//
				bean.setNodeCount(StringUtils.toInt(nodeCount));
				bean.setIdCount(StringUtils.toInt(idCount));
				bean.setRptCount(StringUtils.toInt(rptCount));
				bean.setRptList(noteListToRptItemBean(nodeList));
			}
		}
		//
		return bean;
	}
	//
	/**
	 * 将接收短信应答xml字符串转为实体类
	 */
	public static SmsRecvRespBean xmlToSmsRecvRespBean(String xml)
	{
		SmsRecvRespBean bean = null;
		//
		if(StringUtils.isNotEmpty(xml))
		{
			//用指定的编码(默认为utf-8)编码xml的字符串
			Document doc = XmlUtils.ConvertStringToXml(xml, ApiConstant.charset);
			//
			if(doc != null)
			{
				bean = new SmsRecvRespBean();
				//
				String xmlns			= XmlUtils.getElementValue(doc, "/haikemisc", "namespace");
				String docVersion		= XmlUtils.getElementValue(doc, "/haikemisc", "version");
				//应答头信息
				String xpathHead 		= "/haikemisc/head/";
				String operType 		= XmlUtils.getElementValue(doc, xpathHead + "opertype");
				String actionCode 		= XmlUtils.getElementValue(doc, xpathHead + "actioncode");
				String snapTime 		= XmlUtils.getElementValue(doc, xpathHead + "snaptime");
				String token 			= XmlUtils.getElementValue(doc, xpathHead + "token");
				String version 			= XmlUtils.getElementValue(doc, xpathHead + "version");
				//应答内容信息
				String xpathBody 	= "/haikemisc/body/";
				//
				String resultCode 		= XmlUtils.getElementValue(doc, xpathBody + "resultcode");
				String resultMsg 		= XmlUtils.getElementValue(doc, xpathBody + "resultmsg");
				String reqIpAddr 		= XmlUtils.getElementValue(doc, xpathBody + "reqipaddr");
				//
				String recvCount 		= XmlUtils.getElementValue(doc, xpathBody + "recvcount");
				//
				List<Element> nodeList	= XmlUtils.getElementList(doc, xpathBody + "svcsms/message");
				//-----------------------------------------------------------------------------------
				//解析结束后设置实类参数
				bean.setXmlns(xmlns);
				bean.setDocVersion(docVersion);
				//设置信息头
				bean.setOperType(operType);
				bean.setActionCode(StringUtils.toInt(actionCode));
				bean.setSnapTime(snapTime);
				bean.setToken(token);
				bean.setVersion(version);
				//设置信息内容
				bean.setResultCode(StringUtils.toInt(resultCode));
				bean.setResultMsg(resultMsg);
				bean.setReqIpAddr(reqIpAddr);
				//
				bean.setRecvCount(StringUtils.toInt(recvCount));
				bean.setRevList(noteListToMoItemBean(nodeList));
			}
		}
		//
		return bean;
	}
	
	/**
	 * 将心跳实体应答xml字符串转为实体类
	 */
	public static SmsActiveRespBean xmlToSmsActiveRespBean(String xml)
	{
		SmsActiveRespBean bean = null;
		//
		if(StringUtils.isNotEmpty(xml))
		{
			//用指定的编码(默认为utf-8)编码xml的字符串
			Document doc = XmlUtils.ConvertStringToXml(xml, ApiConstant.charset);
			//
			if(doc != null)
			{
				bean = new SmsActiveRespBean();
				//
				String xmlns			= XmlUtils.getElementValue(doc, "/haikemisc", "namespace");
				String docVersion		= XmlUtils.getElementValue(doc, "/haikemisc", "version");
				//应答头信息
				String xpathHead 		= "/haikemisc/head/";
				String operType 		= XmlUtils.getElementValue(doc, xpathHead + "opertype");
				String actionCode 		= XmlUtils.getElementValue(doc, xpathHead + "actioncode");
				String snapTime 		= XmlUtils.getElementValue(doc, xpathHead + "snaptime");
				String token 			= XmlUtils.getElementValue(doc, xpathHead + "token");
				String version 			= XmlUtils.getElementValue(doc, xpathHead + "version");
				//应答内容信息
				String xpathBody 	= "/haikemisc/body/";
				//
				String resultCode 		= XmlUtils.getElementValue(doc, xpathBody + "resultcode");
				String resultMsg 		= XmlUtils.getElementValue(doc, xpathBody + "resultmsg");
				String reqIpAddr 		= XmlUtils.getElementValue(doc, xpathBody + "reqipaddr");
				//-----------------------------------------------------------------------------------
				//解析结束后设置实类参数
				bean.setXmlns(xmlns);
				bean.setDocVersion(docVersion);
				//设置信息头
				bean.setOperType(operType);
				bean.setActionCode(StringUtils.toInt(actionCode));
				bean.setSnapTime(snapTime);
				bean.setToken(token);
				bean.setVersion(version);
				//设置信息内容
				bean.setResultCode(StringUtils.toInt(resultCode));
				bean.setResultMsg(resultMsg);
				bean.setReqIpAddr(reqIpAddr);
			}
		}
		//
		return bean;
	}
	
	//----------------------------------------------------------------------------------------------------
	//将节点列表转为不同的实体列表
	public static List<RptItemBean> noteListToRptItemBean(List<Element> nodeList)
	{
		List<RptItemBean> rptList = new ArrayList<RptItemBean>();
		//
		if(nodeList != null)
		{
			if(nodeList.size() > 0)
			{
				for (int i = 0; i < nodeList.size(); ++i)
				{
					//遍历每一个message的xml子节点
					Element smsNode = (Element) nodeList.get(i);
					if(smsNode != null)
					{
						RptItemBean rpt 	= new RptItemBean();
						//
						String id 			= XmlUtils.getElementValue(smsNode, "id");
						String orgAddr 		= XmlUtils.getElementValue(smsNode, "orgaddr");
						String regDeliver 	= XmlUtils.getElementValue(smsNode, "regdeliver");
						String mobile 		= XmlUtils.getElementValue(smsNode, "mobile");
						String sendStatus 	= XmlUtils.getElementValue(smsNode, "sendstatus");
						String recvStatus 	= XmlUtils.getElementValue(smsNode, "recvstatus");
						String proStatus 	= XmlUtils.getElementValue(smsNode, "prostatus");
						String rptTime 		= XmlUtils.getElementValue(smsNode, "protype");
						String proType 		= XmlUtils.getElementValue(smsNode, "protype");
						//
						rpt.setId(id);
						rpt.setOrgAddr(orgAddr);
						rpt.setRegDeliver(regDeliver);
						rpt.setMobile(mobile);
						rpt.setSendStatus(sendStatus);
						rpt.setRecvStatus(recvStatus);
						rpt.setProStatus(proStatus);
						rpt.setRptTime(rptTime);
						rpt.setProType(proType);
						//
						rptList.add(rpt);
					}
				}
			}
		}
		//
		return rptList;
	}
	
	public static List<MoItemBean> noteListToMoItemBean(List<Element> nodeList)
	{
		List<MoItemBean> recvList = new ArrayList<MoItemBean>();
		//
		if(nodeList != null)
		{
			if(nodeList.size() > 0)
			{
				for (int i = 0; i < nodeList.size(); ++i)
				{
					//遍历每一个message的xml子节点
					Element node = (Element) nodeList.get(i);
					if(node != null)
					{
						MoItemBean mo 		= new MoItemBean();
						//
						String destAddr 	= XmlUtils.getElementValue(node, "destaddr");
						String mobile 		= XmlUtils.getElementValue(node, "mobile");
						String content 		= XmlUtils.getElementValue(node, "content");
						String recvTime 	= XmlUtils.getElementValue(node, "recvtime");
						String proType 		= XmlUtils.getElementValue(node, "protype");
						//
						mo.setDestAddr(destAddr);
						mo.setMobile(mobile);
						mo.setContent(content);
						mo.setRecvTime(recvTime);
						mo.setProType(proType);
						//
						recvList.add(mo);
					}
				}
			}
		}
		//
		return recvList;
	}
}