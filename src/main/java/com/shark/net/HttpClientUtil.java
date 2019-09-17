package com.shark.net;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * net 请求工具类
 */
public class HttpClientUtil {

	public static final PoolingClientConnectionManager PCC = new PoolingClientConnectionManager();
	public static final HttpClient HTTP_CLIENT = new DefaultHttpClient(PCC);

	/**
	 * 初始化连接池
	 */
	static {
		// 连接池最大并发连接数
		PCC.setMaxTotal(200);
		// 单路由最大并发数
		PCC.setDefaultMaxPerRoute(40);
		HTTP_CLIENT.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 30000);
		HTTP_CLIENT.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,180000);
	}

	/**
	 * @描述：处理get请求
	 * */
	public String processGet(String URL, Map<String, String> parameterMap,
			Map<String, String> headerMap) throws Exception {
		ArrayList<NameValuePair> pairList = new ArrayList<NameValuePair>();
		Iterator it = parameterMap.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next().toString();
			pairList.add(new BasicNameValuePair(key, parameterMap.get(key)));
		}
		String str = EntityUtils.toString(new UrlEncodedFormEntity(pairList,
				"UTF-8"));
		// 打印内容
		System.out.println(new URI(URL + "?" + str));
		HttpGet httpGet = new HttpGet();
		httpGet.setURI(new URI(URL + "?" + str));
		httpGet.setHeader("Content-type", "text/xml; charset=UTF-8");
		HttpResponse httpresponse = HTTP_CLIENT.execute(httpGet);
		HttpEntity Resentity = httpresponse.getEntity();
		return EntityUtils.toString(Resentity);
	}

	/**
	 * @描述：处理Post请求
	 * */
	public String processPost(String URL, String params,
			Map<String, String> headerMap) throws Exception {
		HttpPost httpPost = new HttpPost();
		httpPost.setURI(new URI(URL));
		httpPost.setHeader("Content-type", "application/json; charset=UTF-8");
		if (headerMap != null) {
			Iterator iterator = headerMap.keySet().iterator();
			while (iterator.hasNext()) {
				String key = (String) iterator.next();
				httpPost.setHeader(key, headerMap.get(key));
			}
		}
		StringEntity strEntity = new StringEntity(params, "UTF-8");
//		System.out.println("post请求"+new URI(URL + "?" + strEntity.toString()));
		httpPost.setEntity(strEntity);
		HttpResponse httpresponse = HTTP_CLIENT.execute(httpPost);
		HttpEntity Resentity = httpresponse.getEntity();
		return EntityUtils.toString(Resentity);
	}
	
	public String processPostJson(String URL, String params,
			Map<String, String> headerMap) throws Exception {
		HttpPost httpPost = new HttpPost();
		httpPost.setURI(new URI(URL));
		httpPost.setHeader("Content-type", "application/json; charset=UTF-8");
		if (headerMap != null) {
			Iterator iterator = headerMap.keySet().iterator();
			while (iterator.hasNext()) {
				String key = (String) iterator.next();
				httpPost.setHeader(key, headerMap.get(key));
			}
		}
		StringEntity strEntity = new StringEntity(params, "UTF-8");
		httpPost.setEntity(strEntity);
		HttpResponse httpresponse = HTTP_CLIENT.execute(httpPost);
		HttpEntity Resentity = httpresponse.getEntity();
		return EntityUtils.toString(Resentity);
	}
	
	/**
	 * @描述：处理get请求
	 * */
	public String processGet(String URL) throws Exception {
		HttpGet httpGet = new HttpGet();
		httpGet.setURI(new URI(URL));
		httpGet.setHeader("Content-type", "text/xml; charset=UTF-8");
		HttpResponse httpresponse = HTTP_CLIENT.execute(httpGet);
		HttpEntity Resentity = httpresponse.getEntity();
		return EntityUtils.toString(Resentity);
	}
}
