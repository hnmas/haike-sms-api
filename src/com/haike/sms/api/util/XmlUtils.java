package com.haike.sms.api.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


public class XmlUtils
{

	
	/**
	 * 将指定的xml文档输出到指定的文件中
	 * @param doc:xml文档
	 * @param outFile:保存的目标文件
	 */
	public static void writeXml(Document doc, File outFile)
	{
		XMLWriter writer = null;
		try
		{
			if (doc == null)
			{
				return;
			}
			//
			OutputFormat format = new OutputFormat("  ");
			format.setNewlines(true);
			format.setSuppressDeclaration(true);
			//
			writer = new XMLWriter(new FileOutputStream(outFile), format);
			writer.write(doc);
			writer.flush();
			//
			writer.close();
		}
		catch (IOException e)
		{
			System.out.println("将xml文档保存到指定的文件出错 ：" + e.getLocalizedMessage());
		}
		finally
		{
			writer = null;
		}
	}

	/**
	 * 用指定的编码转换字符串为xml文档
	 * @param xml
	 * @param charset
	 * @return
	 */
	public static Document ConvertStringToXml(String xml, String charset)
	{
		SAXReader saxReader = new SAXReader();
		//
		Document doc = null;
		try
		{
			doc = saxReader.read(new ByteArrayInputStream(xml.getBytes(charset)));
			return doc;
		}
		catch (DocumentException e)
		{
			System.out.println("将xml字符串解为xml文档出错:" + e.getLocalizedMessage());
		}
		catch (UnsupportedEncodingException e)
		{
			System.out.println("将xml字符串解为xml文档编码出错:" + e.getLocalizedMessage());
		}
		//
		return null;
	}


	/**
	 * 转换字符串为xml文档(使用默认字符集)
	 * @param xml
	 * @return
	 */
	public static Document ConvertStringToXml(String xml)
	{
		Document doc = null;
		try
		{
			doc = DocumentHelper.parseText(xml);
			//
			return doc;
		}
		catch (DocumentException e)
		{
			System.out.println("字符串换为xml失败：" + e.getLocalizedMessage());
		}
		finally
		{
			doc = null;
		}
		//
		return null;
	}

	

	/**
	 * 从指定的路径和文件名创建xml文档
	 */
	public static Document openXmlDocument(String pPath, String Filename)
	{
		Document doc = null;
		SAXReader reader = null;
		try
		{
			reader = new SAXReader();
			//
			File xmlConfigFile = null;
			if (StringUtils.isNotEmpty(pPath))
			{
				xmlConfigFile = new File(pPath, Filename);
				
			}
			else
			{
				xmlConfigFile = new File(Filename);
			}
			//
			doc = reader.read(xmlConfigFile);
			reader = null;
			//
			return doc;
		}
		catch (DocumentException ex)
		{
			System.out.println("从指定文件创建xml文档出错:" + ex.getLocalizedMessage());
		}
		finally
		{
			reader = null;
		}
		return null;
	}

	/**
	 * 从指定的输入流创建xml文档
	 */
	public static Document openXmlDocument(InputStream in)
	{
		SAXReader reader = new SAXReader();
		//
		try
		{
			return reader.read(in);
		}
		catch (DocumentException e)
		{
			System.out.println("从InputStream读取xml文档出错 ：" + e.getLocalizedMessage());
		}
		//
		return null;
	}
	//
	/**
	 * 根据xpath读取xml文档指定节点的内容(适用直接读取指定节点的内容的情况)
	 * @param doc:xml文档
	 * @param xpath:文档的xpath搜索路径
	 */
	public static String getElementValue(Document doc, String xpath)
	{
		String nodeValue = "";
		//
		if(doc != null)
		{
			Element ele = (Element) doc.selectSingleNode(xpath);
			//
			if (ele != null)
			{
				nodeValue = ele.getText();
			}
		}
		//
		return nodeValue;
	}
	/**
	 * 根据xml的节点Element继续读取指定节点的内容(适用直接读取指定节点的内容的情况)
	 */
	public static String getElementValue(Element node, String xpath)
	{
		String nodeValue = "";
		//
		if(node != null)
		{
			Element ele = (Element) node.selectSingleNode(xpath);
			//
			if (ele != null)
			{
				nodeValue = ele.getText();
			}
		}
		//
		return nodeValue;
	}
	/**
	 * 根据xpath读取xml文档指定节点的指定属性(适用读取指定节点属性标签的内容的情况)
	 * @param doc:xml文档
	 * @param xpath:文档的xpath搜索路径
	 * @param attribute:文档节点的属性
	 */
	public static String getElementValue(Document doc, String xpath, String attribute)
	{
		String nodeValue = "";
		//
		if(doc != null)
		{
			Element ele = (Element) doc.selectSingleNode(xpath);
			//
			if (ele != null)
			{
				if(ele.attributeValue(attribute) != null)
				{
					nodeValue = ele.attributeValue(attribute);
				}
			}
		}
		//
		return nodeValue;
	}
	
	/**
	 * 根据xpath返回匹配的节点列表
	 */
	public static List<Element> getElementList(Document doc, String xpath)
	{
		List<Element> nodeList = new ArrayList<Element>();
		//
		if(doc != null)
		{
			nodeList = (List<Element>)doc.selectNodes(xpath);
		}
		//
		return nodeList;
	}
}
