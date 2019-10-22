package com.abc.springboot2.mybatisplus;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.abc.springboot2.mybatisplus.client.HttpClient;
import com.abc.springboot2.mybatisplus.client.HttpClient.HttpResponse;
import com.abc.springboot2.mybatisplus.util.Base64Utils;
import com.github.javafaker.Faker;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class HttpClientTest {

	@Autowired
	private HttpClient httpClient;
	
	@Test
	public void doGet() throws Exception{
		String url = "https://dev.badiyun.com/services/account/api/v1/accounts";
		String responseHTML = httpClient.doGet(url);
		log.info(responseHTML);
	}
	
	@Test
	public void queryAccount() throws Exception{
		String id = "951";
		
		String url = "https://dev.badiyun.com/services/account/api/v1/accounts";
		url = url+"?id="+id;
		
		String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnRfaWQiOjgsInVzZXJfaWQiOjEsInVzZXJfbmFtZSI6ImFkbWluIiwic2NvcGUiOlsib3BlbmlkIl0sImV4cCI6MTU3MTkxNTc0NiwiaWF0IjoxNTcxMzEwOTQ2LCJhdXRob3JpdGllcyI6WyJST0xFX1NZU1RFTV9BRE1JTiJdLCJqdGkiOiJlM2UzYjAyOC1hZmI4LTRmZDMtYmJhOC0yMDBlNDgyMmU0OGMiLCJjbGllbnRfaWQiOiJ3ZWJfYXBwIn0.UlzrZPqfEYfQ6iaBqSgaDxmb0b0KlEjtKIsEEoqKU62RurA1s_JibruAa6D1edhbKcYRnSBgXHGV66QC43KH5RrixT5NilRYNIKmEO26hXLgid4iDdqbKd8FqVfhdSMEzcLNl17SmwIoWv1JSn98rHVtqlScJVVkBoOCpILNd4SSAblHevoKmknI7TNYiEP3U0dnG53qf_4J40vHoawvrrxUz1k7llzSq4ftJCShiFFHUypOrHn4B-sDltfE_0nLvReP5-UldyIgF6Qa_-I8pdH2f3PvF7Tkt7RiwVZE1AkdVLkv1Ysms-58DblRsd_uTeqhctj7BY7edtopqY9VWw";
		
		//authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnRfaWQiOjgsInVzZXJfaWQiOjEsInVzZXJfbmFtZSI6ImFkbWluIiwic2NvcGUiOlsib3BlbmlkIl0sImV4cCI6MTU3MTkxNTc0NiwiaWF0IjoxNTcxMzEwOTQ2LCJhdXRob3JpdGllcyI6WyJST0xFX1NZU1RFTV9BRE1JTiJdLCJqdGkiOiJlM2UzYjAyOC1hZmI4LTRmZDMtYmJhOC0yMDBlNDgyMmU0OGMiLCJjbGllbnRfaWQiOiJ3ZWJfYXBwIn0.UlzrZPqfEYfQ6iaBqSgaDxmb0b0KlEjtKIsEEoqKU62RurA1s_JibruAa6D1edhbKcYRnSBgXHGV66QC43KH5RrixT5NilRYNIKmEO26hXLgid4iDdqbKd8FqVfhdSMEzcLNl17SmwIoWv1JSn98rHVtqlScJVVkBoOCpILNd4SSAblHevoKmknI7TNYiEP3U0dnG53qf_4J40vHoawvrrxUz1k7llzSq4ftJCShiFFHUypOrHn4B-sDltfE_0nLvReP5-UldyIgF6Qa_-I8pdH2f3PvF7Tkt7RiwVZE1AkdVLkv1Ysms-58DblRsd_uTeqhctj7BY7edtopqY9VWw
		
		Map<String, Object> requestParameter = new HashMap<>();
		Map<String, Object> headerParameter = new HashMap<>();
		
		headerParameter.put("authorization", "Bearer "+token);
		
		log.info("url=[{}]",url);
		log.info("request=[{}]",requestParameter);
		log.info("header=[{}]",headerParameter);
		
		String httpResponse = httpClient.doGet(url,requestParameter,headerParameter);
		log.info("response=[{}]",httpResponse);
	}
	
	@Test
	public void doPost() throws Exception{
		String url = "https://dev.badiyun.com/services/account/api/v1/accounts";
		
		String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnRfaWQiOjgsInVzZXJfaWQiOjEsInVzZXJfbmFtZSI6ImFkbWluIiwic2NvcGUiOlsib3BlbmlkIl0sImV4cCI6MTU3MTkxNTc0NiwiaWF0IjoxNTcxMzEwOTQ2LCJhdXRob3JpdGllcyI6WyJST0xFX1NZU1RFTV9BRE1JTiJdLCJqdGkiOiJlM2UzYjAyOC1hZmI4LTRmZDMtYmJhOC0yMDBlNDgyMmU0OGMiLCJjbGllbnRfaWQiOiJ3ZWJfYXBwIn0.UlzrZPqfEYfQ6iaBqSgaDxmb0b0KlEjtKIsEEoqKU62RurA1s_JibruAa6D1edhbKcYRnSBgXHGV66QC43KH5RrixT5NilRYNIKmEO26hXLgid4iDdqbKd8FqVfhdSMEzcLNl17SmwIoWv1JSn98rHVtqlScJVVkBoOCpILNd4SSAblHevoKmknI7TNYiEP3U0dnG53qf_4J40vHoawvrrxUz1k7llzSq4ftJCShiFFHUypOrHn4B-sDltfE_0nLvReP5-UldyIgF6Qa_-I8pdH2f3PvF7Tkt7RiwVZE1AkdVLkv1Ysms-58DblRsd_uTeqhctj7BY7edtopqY9VWw";
		
		//authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnRfaWQiOjgsInVzZXJfaWQiOjEsInVzZXJfbmFtZSI6ImFkbWluIiwic2NvcGUiOlsib3BlbmlkIl0sImV4cCI6MTU3MTkxNTc0NiwiaWF0IjoxNTcxMzEwOTQ2LCJhdXRob3JpdGllcyI6WyJST0xFX1NZU1RFTV9BRE1JTiJdLCJqdGkiOiJlM2UzYjAyOC1hZmI4LTRmZDMtYmJhOC0yMDBlNDgyMmU0OGMiLCJjbGllbnRfaWQiOiJ3ZWJfYXBwIn0.UlzrZPqfEYfQ6iaBqSgaDxmb0b0KlEjtKIsEEoqKU62RurA1s_JibruAa6D1edhbKcYRnSBgXHGV66QC43KH5RrixT5NilRYNIKmEO26hXLgid4iDdqbKd8FqVfhdSMEzcLNl17SmwIoWv1JSn98rHVtqlScJVVkBoOCpILNd4SSAblHevoKmknI7TNYiEP3U0dnG53qf_4J40vHoawvrrxUz1k7llzSq4ftJCShiFFHUypOrHn4B-sDltfE_0nLvReP5-UldyIgF6Qa_-I8pdH2f3PvF7Tkt7RiwVZE1AkdVLkv1Ysms-58DblRsd_uTeqhctj7BY7edtopqY9VWw
		
		Map<String, Object> requestParameter = new HashMap<>();
		Map<String, Object> headerParameter = new HashMap<>();
		
		headerParameter.put("authorization", "Bearer "+token);
		
		Long id = IdUtil.createSnowflake(1L, 1L).nextId();
		//Long id = 951L;
		String name = new Faker(Locale.CHINA).name().fullName();
		String mobile = "1"+RandomUtil.randomChar("3456789")+RandomUtil.randomString(RandomUtil.BASE_NUMBER, 9);///^1[3456789]\d{9}$/;
		
		
		Map<String,Object> identity_info =new HashMap<>();
		String identity_info_type ="01"; //证件类型。01：身份证、02：企业营业执照、03：护照、04：港澳通行证、05：台湾往来通行证、06：临时身份证（目前仅支持 01、02 两种类型）
		//String identity_info_id = ""+	RandomUtil.randomInt(10, 100)+RandomUtil.randomInt(10, 100)+RandomUtil.randomInt(10, 100)+DateUtil.format(DateUtil.offsetDay(DateUtil.date(), -RandomUtil.randomInt(1000, 10000)), "yyyyMMdd")+RandomUtil.randomString(RandomUtil.BASE_NUMBER, 4);
		String identity_info_id = idcard();
		String valid_from =DateUtil.format(DateUtil.offsetDay(DateUtil.date(), -RandomUtil.randomInt(100, 1000)), "yyyy-MM-dd");
		String valid_until =DateUtil.format(DateUtil.offsetDay(DateUtil.date(), +RandomUtil.randomInt(100, 1000)), "yyyy-MM-dd");
		
		identity_info.put("type", identity_info_type);
		identity_info.put("id", identity_info_id);
		identity_info.put("valid_from", valid_from);//yyyy-mm-dd
		identity_info.put("valid_until", valid_until);//yyyy-mm-dd
		
		
		List<Map<String,Object>> upload_pic = new ArrayList<Map<String,Object>>();
		
		String idcardImageFace = "D:/image/1185095136758075392.jpg";
		String idcardImageBack = "D:/image/1185095136917458944.jpg";
		
		Map<String,Object> upload_pic_idcard_face = new HashMap<>();
		upload_pic_idcard_face.put("type", "customer");
		upload_pic_idcard_face.put("pic", Base64Utils.GetImageStr(idcardImageFace));
		upload_pic_idcard_face.put("pic_fmt", "jpg");
		upload_pic_idcard_face.put("pic_type", "101");
		
		Map<String,Object> upload_pic_idcard_back = new HashMap<>();
		upload_pic_idcard_back.put("type", "customer");
		upload_pic_idcard_back.put("pic", Base64Utils.GetImageStr(idcardImageBack));
		upload_pic_idcard_back.put("pic_fmt", "jpg");
		upload_pic_idcard_back.put("pic_type", "102");
		
		upload_pic.add(upload_pic_idcard_face);
		upload_pic.add(upload_pic_idcard_back);
		
		requestParameter.put("id", id);
		requestParameter.put("name", name);
		requestParameter.put("mobile", mobile);
		requestParameter.put("identity_info", identity_info);
		requestParameter.put("upload_pic", upload_pic);
		
		log.info("url=[{}]",url);
		log.info("request=[{}]",requestParameter);
		log.info("header=[{}]",headerParameter);
		
		HttpResponse httpResponse = httpClient.doPost(url,requestParameter,headerParameter);
		log.info("response=[{}]",ToStringBuilder.reflectionToString(httpResponse, ToStringStyle.MULTI_LINE_STYLE));
	}
	
	@Test
	public void doPut() throws Exception{
		//String url = "https://dev.badiyun.com/services/account/api/v1/accounts";
		
		String id = "951";
		
		String url = "https://dev.badiyun.com/services/account/api/v1/accounts";
		url = url+"?id="+id;
		
		
		String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnRfaWQiOjgsInVzZXJfaWQiOjEsInVzZXJfbmFtZSI6ImFkbWluIiwic2NvcGUiOlsib3BlbmlkIl0sImV4cCI6MTU3MTkxNTc0NiwiaWF0IjoxNTcxMzEwOTQ2LCJhdXRob3JpdGllcyI6WyJST0xFX1NZU1RFTV9BRE1JTiJdLCJqdGkiOiJlM2UzYjAyOC1hZmI4LTRmZDMtYmJhOC0yMDBlNDgyMmU0OGMiLCJjbGllbnRfaWQiOiJ3ZWJfYXBwIn0.UlzrZPqfEYfQ6iaBqSgaDxmb0b0KlEjtKIsEEoqKU62RurA1s_JibruAa6D1edhbKcYRnSBgXHGV66QC43KH5RrixT5NilRYNIKmEO26hXLgid4iDdqbKd8FqVfhdSMEzcLNl17SmwIoWv1JSn98rHVtqlScJVVkBoOCpILNd4SSAblHevoKmknI7TNYiEP3U0dnG53qf_4J40vHoawvrrxUz1k7llzSq4ftJCShiFFHUypOrHn4B-sDltfE_0nLvReP5-UldyIgF6Qa_-I8pdH2f3PvF7Tkt7RiwVZE1AkdVLkv1Ysms-58DblRsd_uTeqhctj7BY7edtopqY9VWw";
		
		//authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnRfaWQiOjgsInVzZXJfaWQiOjEsInVzZXJfbmFtZSI6ImFkbWluIiwic2NvcGUiOlsib3BlbmlkIl0sImV4cCI6MTU3MTkxNTc0NiwiaWF0IjoxNTcxMzEwOTQ2LCJhdXRob3JpdGllcyI6WyJST0xFX1NZU1RFTV9BRE1JTiJdLCJqdGkiOiJlM2UzYjAyOC1hZmI4LTRmZDMtYmJhOC0yMDBlNDgyMmU0OGMiLCJjbGllbnRfaWQiOiJ3ZWJfYXBwIn0.UlzrZPqfEYfQ6iaBqSgaDxmb0b0KlEjtKIsEEoqKU62RurA1s_JibruAa6D1edhbKcYRnSBgXHGV66QC43KH5RrixT5NilRYNIKmEO26hXLgid4iDdqbKd8FqVfhdSMEzcLNl17SmwIoWv1JSn98rHVtqlScJVVkBoOCpILNd4SSAblHevoKmknI7TNYiEP3U0dnG53qf_4J40vHoawvrrxUz1k7llzSq4ftJCShiFFHUypOrHn4B-sDltfE_0nLvReP5-UldyIgF6Qa_-I8pdH2f3PvF7Tkt7RiwVZE1AkdVLkv1Ysms-58DblRsd_uTeqhctj7BY7edtopqY9VWw
		
		Map<String, Object> requestParameter = new HashMap<>();
		Map<String, Object> headerParameter = new HashMap<>();
		
		headerParameter.put("authorization", "Bearer "+token);
		
//		Long id = IdUtil.createSnowflake(1L, 1L).nextId();
//		//Long id = 951L;
		String name = new Faker(Locale.CHINA).name().fullName();
		String mobile = "1"+RandomUtil.randomChar("3456789")+RandomUtil.randomString(RandomUtil.BASE_NUMBER, 9);///^1[3456789]\d{9}$/;
		
		
		Map<String,Object> identity_info =new HashMap<>();
		String identity_info_type ="01"; //证件类型。01：身份证、02：企业营业执照、03：护照、04：港澳通行证、05：台湾往来通行证、06：临时身份证（目前仅支持 01、02 两种类型）
		//String identity_info_id = ""+	RandomUtil.randomInt(10, 100)+RandomUtil.randomInt(10, 100)+RandomUtil.randomInt(10, 100)+DateUtil.format(DateUtil.offsetDay(DateUtil.date(), -RandomUtil.randomInt(1000, 10000)), "yyyyMMdd")+RandomUtil.randomString(RandomUtil.BASE_NUMBER, 4);
		String identity_info_id = idcard();
		String valid_from =DateUtil.format(DateUtil.offsetDay(DateUtil.date(), -RandomUtil.randomInt(100, 1000)), "yyyy-MM-dd");
		String valid_until =DateUtil.format(DateUtil.offsetDay(DateUtil.date(), +RandomUtil.randomInt(100, 1000)), "yyyy-MM-dd");
		
		identity_info.put("type", identity_info_type);
		identity_info.put("id", identity_info_id);
		identity_info.put("valid_from", valid_from);//yyyy-mm-dd
		identity_info.put("valid_until", valid_until);//yyyy-mm-dd
//		
//		
//		List<Map<String,Object>> upload_pic = new ArrayList<Map<String,Object>>();
//		
//		String idcardImageFace = "D:/image/1185095136758075392.jpg";
//		String idcardImageBack = "D:/image/1185095136917458944.jpg";
//		
//		Map<String,Object> upload_pic_idcard_face = new HashMap<>();
//		upload_pic_idcard_face.put("type", "customer");
//		upload_pic_idcard_face.put("pic", Base64Utils.GetImageStr(idcardImageFace));
//		upload_pic_idcard_face.put("pic_fmt", "jpg");
//		upload_pic_idcard_face.put("pic_type", "101");
//		
//		Map<String,Object> upload_pic_idcard_back = new HashMap<>();
//		upload_pic_idcard_back.put("type", "customer");
//		upload_pic_idcard_back.put("pic", Base64Utils.GetImageStr(idcardImageBack));
//		upload_pic_idcard_back.put("pic_fmt", "jpg");
//		upload_pic_idcard_back.put("pic_type", "102");
//		
//		upload_pic.add(upload_pic_idcard_face);
//		upload_pic.add(upload_pic_idcard_back);
		
//		requestParameter.put("id", id);
		requestParameter.put("name", name);
		requestParameter.put("mobile", mobile);
		requestParameter.put("identity_info", identity_info);
//		requestParameter.put("upload_pic", upload_pic);
		
		log.info("url=[{}]",url);
		log.info("request=[{}]",requestParameter);
		log.info("header=[{}]",headerParameter);
		
		HttpResponse httpResponse = httpClient.httpPutRaw(url,requestParameter,headerParameter);
		log.info("response=[{}]",ToStringBuilder.reflectionToString(httpResponse, ToStringStyle.MULTI_LINE_STYLE));
	}
	
	
	@Test
	public void doPostSettleAccount() throws Exception{
		String url = "https://dev.badiyun.com/services/account/api/v1/settle_accounts";
		
		String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnRfaWQiOjgsInVzZXJfaWQiOjEsInVzZXJfbmFtZSI6ImFkbWluIiwic2NvcGUiOlsib3BlbmlkIl0sImV4cCI6MTU3MTkxNTc0NiwiaWF0IjoxNTcxMzEwOTQ2LCJhdXRob3JpdGllcyI6WyJST0xFX1NZU1RFTV9BRE1JTiJdLCJqdGkiOiJlM2UzYjAyOC1hZmI4LTRmZDMtYmJhOC0yMDBlNDgyMmU0OGMiLCJjbGllbnRfaWQiOiJ3ZWJfYXBwIn0.UlzrZPqfEYfQ6iaBqSgaDxmb0b0KlEjtKIsEEoqKU62RurA1s_JibruAa6D1edhbKcYRnSBgXHGV66QC43KH5RrixT5NilRYNIKmEO26hXLgid4iDdqbKd8FqVfhdSMEzcLNl17SmwIoWv1JSn98rHVtqlScJVVkBoOCpILNd4SSAblHevoKmknI7TNYiEP3U0dnG53qf_4J40vHoawvrrxUz1k7llzSq4ftJCShiFFHUypOrHn4B-sDltfE_0nLvReP5-UldyIgF6Qa_-I8pdH2f3PvF7Tkt7RiwVZE1AkdVLkv1Ysms-58DblRsd_uTeqhctj7BY7edtopqY9VWw";
		
		//authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnRfaWQiOjgsInVzZXJfaWQiOjEsInVzZXJfbmFtZSI6ImFkbWluIiwic2NvcGUiOlsib3BlbmlkIl0sImV4cCI6MTU3MTkxNTc0NiwiaWF0IjoxNTcxMzEwOTQ2LCJhdXRob3JpdGllcyI6WyJST0xFX1NZU1RFTV9BRE1JTiJdLCJqdGkiOiJlM2UzYjAyOC1hZmI4LTRmZDMtYmJhOC0yMDBlNDgyMmU0OGMiLCJjbGllbnRfaWQiOiJ3ZWJfYXBwIn0.UlzrZPqfEYfQ6iaBqSgaDxmb0b0KlEjtKIsEEoqKU62RurA1s_JibruAa6D1edhbKcYRnSBgXHGV66QC43KH5RrixT5NilRYNIKmEO26hXLgid4iDdqbKd8FqVfhdSMEzcLNl17SmwIoWv1JSn98rHVtqlScJVVkBoOCpILNd4SSAblHevoKmknI7TNYiEP3U0dnG53qf_4J40vHoawvrrxUz1k7llzSq4ftJCShiFFHUypOrHn4B-sDltfE_0nLvReP5-UldyIgF6Qa_-I8pdH2f3PvF7Tkt7RiwVZE1AkdVLkv1Ysms-58DblRsd_uTeqhctj7BY7edtopqY9VWw
		
		Map<String, Object> requestParameter = new HashMap<>();
		Map<String, Object> headerParameter = new HashMap<>();
		
		headerParameter.put("authorization", "Bearer "+token);
		
		Long account_id = 951L;
		String channel = "bank_account";
		
		Map<String,Object> recipient =new HashMap<>();
		String account  ="622575"+RandomUtil.randomString(RandomUtil.BASE_NUMBER, 10); //
		String name = new Faker(Locale.CHINA).name().fullName();
		String type = "b2c";
		String mobile = "1"+RandomUtil.randomChar("3456789")+RandomUtil.randomString(RandomUtil.BASE_NUMBER, 9);
		String open_bank = "招商银行";
		String open_bank_code= null;
		String card_type="0";//银行卡号类型，0：银行卡借记卡；2：信用卡；3：准贷记卡；5：虚拟卡；6：基本户；7：一般户。其中 type 为 b2c 时，只能为 0、2、3、5中的一个；type 为 b2b 时只能为 6、7 中的一个
		
		name = "邵擎苍";
		mobile ="18341667057";
		
		recipient.put("account", account);
		recipient.put("name", name);
		recipient.put("type", type);//
		recipient.put("mobile", mobile);//
		recipient.put("open_bank", open_bank);
		recipient.put("open_bank_code", open_bank_code);
		recipient.put("card_type", card_type);//
		
		requestParameter.put("account_id", account_id);
		requestParameter.put("channel", channel);
		requestParameter.put("recipient", recipient);
		
		log.info("url=[{}]",url);
		log.info("request=[{}]",requestParameter);
		log.info("header=[{}]",headerParameter);
		
		HttpResponse httpResponse = httpClient.doPost(url,requestParameter,headerParameter);
		log.info("response=[{}]",ToStringBuilder.reflectionToString(httpResponse, ToStringStyle.MULTI_LINE_STYLE));
	}
	
	@Test
	public void doGetSettleAccountList() throws Exception{
		String url = "https://dev.badiyun.com/services/account/api/v1/settle_accounts/list";
		
		String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnRfaWQiOjgsInVzZXJfaWQiOjEsInVzZXJfbmFtZSI6ImFkbWluIiwic2NvcGUiOlsib3BlbmlkIl0sImV4cCI6MTU3MTkxNTc0NiwiaWF0IjoxNTcxMzEwOTQ2LCJhdXRob3JpdGllcyI6WyJST0xFX1NZU1RFTV9BRE1JTiJdLCJqdGkiOiJlM2UzYjAyOC1hZmI4LTRmZDMtYmJhOC0yMDBlNDgyMmU0OGMiLCJjbGllbnRfaWQiOiJ3ZWJfYXBwIn0.UlzrZPqfEYfQ6iaBqSgaDxmb0b0KlEjtKIsEEoqKU62RurA1s_JibruAa6D1edhbKcYRnSBgXHGV66QC43KH5RrixT5NilRYNIKmEO26hXLgid4iDdqbKd8FqVfhdSMEzcLNl17SmwIoWv1JSn98rHVtqlScJVVkBoOCpILNd4SSAblHevoKmknI7TNYiEP3U0dnG53qf_4J40vHoawvrrxUz1k7llzSq4ftJCShiFFHUypOrHn4B-sDltfE_0nLvReP5-UldyIgF6Qa_-I8pdH2f3PvF7Tkt7RiwVZE1AkdVLkv1Ysms-58DblRsd_uTeqhctj7BY7edtopqY9VWw";
		
		//authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnRfaWQiOjgsInVzZXJfaWQiOjEsInVzZXJfbmFtZSI6ImFkbWluIiwic2NvcGUiOlsib3BlbmlkIl0sImV4cCI6MTU3MTkxNTc0NiwiaWF0IjoxNTcxMzEwOTQ2LCJhdXRob3JpdGllcyI6WyJST0xFX1NZU1RFTV9BRE1JTiJdLCJqdGkiOiJlM2UzYjAyOC1hZmI4LTRmZDMtYmJhOC0yMDBlNDgyMmU0OGMiLCJjbGllbnRfaWQiOiJ3ZWJfYXBwIn0.UlzrZPqfEYfQ6iaBqSgaDxmb0b0KlEjtKIsEEoqKU62RurA1s_JibruAa6D1edhbKcYRnSBgXHGV66QC43KH5RrixT5NilRYNIKmEO26hXLgid4iDdqbKd8FqVfhdSMEzcLNl17SmwIoWv1JSn98rHVtqlScJVVkBoOCpILNd4SSAblHevoKmknI7TNYiEP3U0dnG53qf_4J40vHoawvrrxUz1k7llzSq4ftJCShiFFHUypOrHn4B-sDltfE_0nLvReP5-UldyIgF6Qa_-I8pdH2f3PvF7Tkt7RiwVZE1AkdVLkv1Ysms-58DblRsd_uTeqhctj7BY7edtopqY9VWw
		
		Map<String, Object> requestParameter = new HashMap<>();
		Map<String, Object> headerParameter = new HashMap<>();
		
		headerParameter.put("authorization", "Bearer "+token);
		
		Long account_id = 951L;
	
		
		requestParameter.put("account_id", account_id);
		requestParameter.put("page[offset]", 1);
		requestParameter.put("page[limit]", 10);
		
		log.info("url=[{}]",url);
		log.info("request=[{}]",requestParameter);
		log.info("header=[{}]",headerParameter);
		
		String httpResponse = httpClient.doGet(url,requestParameter,headerParameter);
		log.info("response=[{}]",httpResponse);
	}
	
	@Test
	public void doGetSettleAccount() throws Exception{
		String url = "https://dev.badiyun.com/services/account/api/v1/settle_accounts";
		
		String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnRfaWQiOjgsInVzZXJfaWQiOjEsInVzZXJfbmFtZSI6ImFkbWluIiwic2NvcGUiOlsib3BlbmlkIl0sImV4cCI6MTU3MTkxNTc0NiwiaWF0IjoxNTcxMzEwOTQ2LCJhdXRob3JpdGllcyI6WyJST0xFX1NZU1RFTV9BRE1JTiJdLCJqdGkiOiJlM2UzYjAyOC1hZmI4LTRmZDMtYmJhOC0yMDBlNDgyMmU0OGMiLCJjbGllbnRfaWQiOiJ3ZWJfYXBwIn0.UlzrZPqfEYfQ6iaBqSgaDxmb0b0KlEjtKIsEEoqKU62RurA1s_JibruAa6D1edhbKcYRnSBgXHGV66QC43KH5RrixT5NilRYNIKmEO26hXLgid4iDdqbKd8FqVfhdSMEzcLNl17SmwIoWv1JSn98rHVtqlScJVVkBoOCpILNd4SSAblHevoKmknI7TNYiEP3U0dnG53qf_4J40vHoawvrrxUz1k7llzSq4ftJCShiFFHUypOrHn4B-sDltfE_0nLvReP5-UldyIgF6Qa_-I8pdH2f3PvF7Tkt7RiwVZE1AkdVLkv1Ysms-58DblRsd_uTeqhctj7BY7edtopqY9VWw";
		
		//authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnRfaWQiOjgsInVzZXJfaWQiOjEsInVzZXJfbmFtZSI6ImFkbWluIiwic2NvcGUiOlsib3BlbmlkIl0sImV4cCI6MTU3MTkxNTc0NiwiaWF0IjoxNTcxMzEwOTQ2LCJhdXRob3JpdGllcyI6WyJST0xFX1NZU1RFTV9BRE1JTiJdLCJqdGkiOiJlM2UzYjAyOC1hZmI4LTRmZDMtYmJhOC0yMDBlNDgyMmU0OGMiLCJjbGllbnRfaWQiOiJ3ZWJfYXBwIn0.UlzrZPqfEYfQ6iaBqSgaDxmb0b0KlEjtKIsEEoqKU62RurA1s_JibruAa6D1edhbKcYRnSBgXHGV66QC43KH5RrixT5NilRYNIKmEO26hXLgid4iDdqbKd8FqVfhdSMEzcLNl17SmwIoWv1JSn98rHVtqlScJVVkBoOCpILNd4SSAblHevoKmknI7TNYiEP3U0dnG53qf_4J40vHoawvrrxUz1k7llzSq4ftJCShiFFHUypOrHn4B-sDltfE_0nLvReP5-UldyIgF6Qa_-I8pdH2f3PvF7Tkt7RiwVZE1AkdVLkv1Ysms-58DblRsd_uTeqhctj7BY7edtopqY9VWw
		
		Map<String, Object> requestParameter = new HashMap<>();
		Map<String, Object> headerParameter = new HashMap<>();
		
		headerParameter.put("authorization", "Bearer "+token);
		
		Long account_id = 951L;
		String id = "320119101913583500002701";
	
		
		requestParameter.put("account_id", account_id);
		requestParameter.put("id", id);
		
		log.info("url=[{}]",url);
		log.info("request=[{}]",requestParameter);
		log.info("header=[{}]",headerParameter);
		
		String httpResponse = httpClient.doGet(url,requestParameter,headerParameter);
		log.info("response=[{}]",httpResponse);
	}
	
	@Test
	public void doDeleteSettleAccount() throws Exception{
		String url = "https://dev.badiyun.com/services/account/api/v1/settle_accounts";
		
		String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnRfaWQiOjgsInVzZXJfaWQiOjEsInVzZXJfbmFtZSI6ImFkbWluIiwic2NvcGUiOlsib3BlbmlkIl0sImV4cCI6MTU3MTkxNTc0NiwiaWF0IjoxNTcxMzEwOTQ2LCJhdXRob3JpdGllcyI6WyJST0xFX1NZU1RFTV9BRE1JTiJdLCJqdGkiOiJlM2UzYjAyOC1hZmI4LTRmZDMtYmJhOC0yMDBlNDgyMmU0OGMiLCJjbGllbnRfaWQiOiJ3ZWJfYXBwIn0.UlzrZPqfEYfQ6iaBqSgaDxmb0b0KlEjtKIsEEoqKU62RurA1s_JibruAa6D1edhbKcYRnSBgXHGV66QC43KH5RrixT5NilRYNIKmEO26hXLgid4iDdqbKd8FqVfhdSMEzcLNl17SmwIoWv1JSn98rHVtqlScJVVkBoOCpILNd4SSAblHevoKmknI7TNYiEP3U0dnG53qf_4J40vHoawvrrxUz1k7llzSq4ftJCShiFFHUypOrHn4B-sDltfE_0nLvReP5-UldyIgF6Qa_-I8pdH2f3PvF7Tkt7RiwVZE1AkdVLkv1Ysms-58DblRsd_uTeqhctj7BY7edtopqY9VWw";
		
		//authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnRfaWQiOjgsInVzZXJfaWQiOjEsInVzZXJfbmFtZSI6ImFkbWluIiwic2NvcGUiOlsib3BlbmlkIl0sImV4cCI6MTU3MTkxNTc0NiwiaWF0IjoxNTcxMzEwOTQ2LCJhdXRob3JpdGllcyI6WyJST0xFX1NZU1RFTV9BRE1JTiJdLCJqdGkiOiJlM2UzYjAyOC1hZmI4LTRmZDMtYmJhOC0yMDBlNDgyMmU0OGMiLCJjbGllbnRfaWQiOiJ3ZWJfYXBwIn0.UlzrZPqfEYfQ6iaBqSgaDxmb0b0KlEjtKIsEEoqKU62RurA1s_JibruAa6D1edhbKcYRnSBgXHGV66QC43KH5RrixT5NilRYNIKmEO26hXLgid4iDdqbKd8FqVfhdSMEzcLNl17SmwIoWv1JSn98rHVtqlScJVVkBoOCpILNd4SSAblHevoKmknI7TNYiEP3U0dnG53qf_4J40vHoawvrrxUz1k7llzSq4ftJCShiFFHUypOrHn4B-sDltfE_0nLvReP5-UldyIgF6Qa_-I8pdH2f3PvF7Tkt7RiwVZE1AkdVLkv1Ysms-58DblRsd_uTeqhctj7BY7edtopqY9VWw
		
		Map<String, Object> requestParameter = new HashMap<>();
		Map<String, Object> headerParameter = new HashMap<>();
		
		headerParameter.put("authorization", "Bearer "+token);
		
		Long account_id = 951L;
		String id = "320119101913583500002701";
	
		
		requestParameter.put("account_id", account_id);
		requestParameter.put("id", id);
		
		log.info("url=[{}]",url);
		log.info("request=[{}]",requestParameter);
		log.info("header=[{}]",headerParameter);
		
		String httpResponse = httpClient.httpDelete(url,requestParameter,headerParameter);
		log.info("response=[{}]",httpResponse);
	}
	
	public static Map<String,String> AREA = new HashMap<>();
	
	//企业营业执照
	public static String licence() {
		return  RandomUtil.randomString(RandomUtil.BASE_NUMBER, 15);
	}
	
	public static String idcard() {
		int random = RandomUtil.randomInt(AREA.size());
		String area = AREA.keySet().toArray()[random].toString()+"01"+"01";
		String birthday = DateUtil.format(DateUtil.offsetDay(DateUtil.date(), -RandomUtil.randomInt(1000, 10000)), "yyyyMMdd");
		String seq = RandomUtil.randomString(RandomUtil.BASE_NUMBER, 3);
		//String valid = RandomUtil.randomString(RandomUtil.BASE_NUMBER+"X", 1);
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(area);
		stringBuilder.append(birthday);
		stringBuilder.append(seq);
		stringBuilder.append(valid(stringBuilder.toString()));
		
		return stringBuilder.toString();
	}
	
	
	
	public static String  valid(String front) {
		String v;
		
		int[] IDnums = new int[17];
		int[] coe = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};	//1-17位对应的系数
		
		String inputID = front;
		
		for(int i=0;i<inputID.length();i++){
			IDnums[i] = inputID.charAt(i)-'0';
			//System.out.print(IDnums[i]);
		}
		
		int sum = getSum(IDnums, coe);
		int last = getLastNum(sum);
		if(last == 10){
			v ="X";
		}else{
			//System.out.println(last);
			v = Integer.toString(last);
		}
		
		return v;
	}
	
	public static int getSum(int IDnums[],int coe[]){
		int sum = 0;
		for(int i=0;i<17;i++)
		{
			sum += IDnums[i]*coe[i];
		}
		return sum;
	}
	
	public static int getLastNum(int num){
		num = num%11;
		switch(num)
		{
			case 0:
				num = 1;
				break;
	        case 1:
	            num = 0;
	            break;
			case 2:
				num = 10;
				break;
			case 3:
				num = 9;
				break;
			case 4:
				num = 8;
				break;
			case 5:
				num = 7;
				break;
			case 6:
				num = 6;
				break;
			case 7:
				num = 5;
				break;
			case 8:
				num = 4;
				break;
			case 9:
				num = 3;
				break;
			case 10:
				num = 2;
				break;
		}
		return num;
	}
	
	@Test
	public void idcardTest() {
		log.info(idcard());
	} 
	
	@Test
	public void drawImageTest() throws Exception{
		String idcard = idcard();
		drawImage(idcard,"FACE");
		drawImage(idcard,"BACK");
	} 
	
	@Test
	public void drawLicenceTest() throws Exception{
		String licence = licence();
		drawImage(licence,"LICENCE");
	} 
	
	public static String  drawImage(String idcardNo,String desc) throws FileNotFoundException, IOException {
		// 获取图片的缓冲区，也就是所谓的画布
		BufferedImage bufferedImage = new BufferedImage(200, 160, BufferedImage.TYPE_INT_RGB);
		// 获取画笔，画笔用于在画布上进行绘制
		Graphics paint = bufferedImage.getGraphics();
		// 设置画笔的颜色
		paint.setColor(Color.WHITE);
		// 绘制画布的背景色
		paint.fillRect(0, 0, 200, 160);
		// 设置画笔的颜色
		paint.setColor(Color.blue);
		// 绘制显示的具体内容
		paint.drawString(idcardNo, 60, 40);
		
		// 设置画笔的颜色
		paint.setColor(Color.RED);
		// 绘制显示的具体内容
		paint.drawString(desc, 120, 80);
		
		// 绘制完成保存文件
		String id = IdUtil.createSnowflake(1L, 1L).nextIdStr();
		String filePath = "/image/"+id+".jpg";
		new File(filePath).getParentFile().mkdirs();
		ImageIO.write(bufferedImage, "jpeg", new FileOutputStream(filePath));
		
		return filePath;
	}
	
	
	@Test
	public void base64Test() throws Exception{
		String imgPath = "D:/image/1185091323510788096.jpg";
		String base64String = Base64Utils.GetImageStr(imgPath);
		log.info(base64String);
		
		String imgPathBase64 = "D:/image/1185091323510788096_base64.jpg";
		Base64Utils.GenerateImage(base64String, imgPathBase64);
	}
	
	
	@Test
	public void companyNameTest() {
		
		
		
		String state = new Faker(Locale.CHINA).address().state();
		
		String city = new Faker(Locale.CHINA).address().city();
		String name = new Faker(Locale.CHINA).name().firstName();
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(state);
		stringBuilder.append(city);
		stringBuilder.append(name);
		stringBuilder.append("有限公司");
		
		log.info(stringBuilder.toString());
		
	}
	
	
	//================================================================================================================================================
	@Test
	public void companyUserAdd() throws Exception{
		String url = "https://dev.badiyun.com/services/account/api/v1/accounts";
		
		String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnRfaWQiOjgsInVzZXJfaWQiOjEsInVzZXJfbmFtZSI6ImFkbWluIiwic2NvcGUiOlsib3BlbmlkIl0sImV4cCI6MTU3MTkxNTc0NiwiaWF0IjoxNTcxMzEwOTQ2LCJhdXRob3JpdGllcyI6WyJST0xFX1NZU1RFTV9BRE1JTiJdLCJqdGkiOiJlM2UzYjAyOC1hZmI4LTRmZDMtYmJhOC0yMDBlNDgyMmU0OGMiLCJjbGllbnRfaWQiOiJ3ZWJfYXBwIn0.UlzrZPqfEYfQ6iaBqSgaDxmb0b0KlEjtKIsEEoqKU62RurA1s_JibruAa6D1edhbKcYRnSBgXHGV66QC43KH5RrixT5NilRYNIKmEO26hXLgid4iDdqbKd8FqVfhdSMEzcLNl17SmwIoWv1JSn98rHVtqlScJVVkBoOCpILNd4SSAblHevoKmknI7TNYiEP3U0dnG53qf_4J40vHoawvrrxUz1k7llzSq4ftJCShiFFHUypOrHn4B-sDltfE_0nLvReP5-UldyIgF6Qa_-I8pdH2f3PvF7Tkt7RiwVZE1AkdVLkv1Ysms-58DblRsd_uTeqhctj7BY7edtopqY9VWw";
		
		//authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnRfaWQiOjgsInVzZXJfaWQiOjEsInVzZXJfbmFtZSI6ImFkbWluIiwic2NvcGUiOlsib3BlbmlkIl0sImV4cCI6MTU3MTkxNTc0NiwiaWF0IjoxNTcxMzEwOTQ2LCJhdXRob3JpdGllcyI6WyJST0xFX1NZU1RFTV9BRE1JTiJdLCJqdGkiOiJlM2UzYjAyOC1hZmI4LTRmZDMtYmJhOC0yMDBlNDgyMmU0OGMiLCJjbGllbnRfaWQiOiJ3ZWJfYXBwIn0.UlzrZPqfEYfQ6iaBqSgaDxmb0b0KlEjtKIsEEoqKU62RurA1s_JibruAa6D1edhbKcYRnSBgXHGV66QC43KH5RrixT5NilRYNIKmEO26hXLgid4iDdqbKd8FqVfhdSMEzcLNl17SmwIoWv1JSn98rHVtqlScJVVkBoOCpILNd4SSAblHevoKmknI7TNYiEP3U0dnG53qf_4J40vHoawvrrxUz1k7llzSq4ftJCShiFFHUypOrHn4B-sDltfE_0nLvReP5-UldyIgF6Qa_-I8pdH2f3PvF7Tkt7RiwVZE1AkdVLkv1Ysms-58DblRsd_uTeqhctj7BY7edtopqY9VWw
		
		Map<String, Object> requestParameter = new HashMap<>();
		Map<String, Object> headerParameter = new HashMap<>();
		
		headerParameter.put("authorization", "Bearer "+token);
		
		String state = new Faker(Locale.CHINA).address().state();
		
		String city = new Faker(Locale.CHINA).address().city();
		String companyName = new Faker(Locale.CHINA).name().firstName();
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(state);
		stringBuilder.append(city);
		stringBuilder.append(companyName);
		stringBuilder.append("有限公司");
		
		String company = stringBuilder.toString();
		
		Long id = IdUtil.createSnowflake(1L, 1L).nextId();
		String name = company;
		String mobile = "1"+RandomUtil.randomChar("3456789")+RandomUtil.randomString(RandomUtil.BASE_NUMBER, 9);///^1[3456789]\d{9}$/;
		
		
		Map<String,Object> identity_info =new HashMap<>();
		String identity_info_type ="02"; //证件类型。01：身份证、02：企业营业执照、03：护照、04：港澳通行证、05：台湾往来通行证、06：临时身份证（目前仅支持 01、02 两种类型）
		//String identity_info_id = ""+	RandomUtil.randomInt(10, 100)+RandomUtil.randomInt(10, 100)+RandomUtil.randomInt(10, 100)+DateUtil.format(DateUtil.offsetDay(DateUtil.date(), -RandomUtil.randomInt(1000, 10000)), "yyyyMMdd")+RandomUtil.randomString(RandomUtil.BASE_NUMBER, 4);
		String identity_info_id = licence();
		String valid_from =DateUtil.format(DateUtil.offsetDay(DateUtil.date(), -RandomUtil.randomInt(100, 1000)), "yyyy-MM-dd");
		String valid_until =DateUtil.format(DateUtil.offsetDay(DateUtil.date(), +RandomUtil.randomInt(100, 1000)), "yyyy-MM-dd");
		
		identity_info.put("type", identity_info_type);
		identity_info.put("id", identity_info_id);
		identity_info.put("valid_from", valid_from);//yyyy-mm-dd
		identity_info.put("valid_until", valid_until);//yyyy-mm-dd
		
		
		List<Map<String,Object>> upload_pic = new ArrayList<Map<String,Object>>();
		
		//201：企业证件照片，202：法人身份证正面（个人信息面），203：法人身份证反面（国徽面）
		String licenceImage = "D:/image/1185492852281577472.jpg";
		String idcardImageFace = "D:/image/1185095136758075392.jpg";
		String idcardImageBack = "D:/image/1185095136917458944.jpg";
		
		Map<String,Object> upload_pic_licence = new HashMap<>();
		upload_pic_licence.put("type", "business");
		upload_pic_licence.put("pic", Base64Utils.GetImageStr(licenceImage));
		upload_pic_licence.put("pic_fmt", "jpg");
		upload_pic_licence.put("pic_type", "201");
		
		Map<String,Object> upload_pic_idcard_face = new HashMap<>();
		upload_pic_idcard_face.put("type", "business");
		upload_pic_idcard_face.put("pic", Base64Utils.GetImageStr(idcardImageFace));
		upload_pic_idcard_face.put("pic_fmt", "jpg");
		upload_pic_idcard_face.put("pic_type", "202");
		
		Map<String,Object> upload_pic_idcard_back = new HashMap<>();
		upload_pic_idcard_back.put("type", "business");
		upload_pic_idcard_back.put("pic", Base64Utils.GetImageStr(idcardImageBack));
		upload_pic_idcard_back.put("pic_fmt", "jpg");
		upload_pic_idcard_back.put("pic_type", "203");
		
		upload_pic.add(upload_pic_licence);
		upload_pic.add(upload_pic_idcard_face);
		upload_pic.add(upload_pic_idcard_back);
		
		requestParameter.put("id", id);
		requestParameter.put("name", name);
		requestParameter.put("mobile", mobile);
		requestParameter.put("identity_info", identity_info);
		requestParameter.put("upload_pic", upload_pic);
		
		log.info("url=[{}]",url);
		log.info("request=[{}]",requestParameter);
		log.info("header=[{}]",headerParameter);
		
		HttpResponse httpResponse = httpClient.doPost(url,requestParameter,headerParameter);
		log.info("response=[{}]",ToStringBuilder.reflectionToString(httpResponse, ToStringStyle.MULTI_LINE_STYLE));
	}
	//================================================================================================================================================
	
	
	
	
	public static List<String> imageList = new ArrayList<>();
	
	
	
	
	
	
	
	
	
	
	static {
		AREA.put("11","北京市");
		AREA.put("12","天津市");
		AREA.put("13","河北省");
		AREA.put("14","山西省");
		AREA.put("15","内蒙古自治区");
		AREA.put("21","辽宁省");
		AREA.put("22","吉林省");
		AREA.put("23","黑龙江省");
		AREA.put("31","上海市");
		AREA.put("32","江苏省");
		AREA.put("33","浙江省");
		AREA.put("34","安徽省");
		AREA.put("35","福建省");
		AREA.put("36","江西省");
		AREA.put("37","山东省");
		AREA.put("41","河南省");
		AREA.put("42","湖北省");
		AREA.put("43","湖南省");
		AREA.put("44","广东省");
		AREA.put("45","广西壮族自治区");
		AREA.put("46","海南省");
		AREA.put("50","重庆市");
		AREA.put("51","四川省");
		AREA.put("52","贵州省");
		AREA.put("53","云南省");
		AREA.put("54","西藏自治区");
		AREA.put("61","陕西省");
		AREA.put("62","甘肃省");
		AREA.put("63","青海省");
		AREA.put("64","宁夏回族自治区");
		AREA.put("65","新疆维吾尔自治区");
		
		
		imageList.add("1185094713338892288");
		imageList.add("1185094714018369536");
		imageList.add("1185094875494879232");
		imageList.add("1185094878175039488");
		imageList.add("1185094904951476224");
		imageList.add("1185094910387294208");
		imageList.add("1185094947460747264");
		imageList.add("1185094950929436672");
		imageList.add("1185094976749572096");
		imageList.add("1185094984148324352");
		imageList.add("1185094996454412288");
		imageList.add("1185095002032836608");
		imageList.add("1185095004062879744");
		imageList.add("1185095011717484544");
		imageList.add("1185095034421252096");
		imageList.add("1185095035331416064");
		imageList.add("1185095054205784064");
		imageList.add("1185095055556349952");
		imageList.add("1185095060425936896");
		imageList.add("1185095061948469248");
		imageList.add("1185095065345855488");
		imageList.add("1185095065580736512");
		imageList.add("1185095099432964096");
		imageList.add("1185095106965934080");
		imageList.add("1185095116247928832");
		imageList.add("1185095118923894784");
		imageList.add("1185095120861663232");
		imageList.add("1185095123541823488");
		imageList.add("1185095124510707712");
		imageList.add("1185095125496369152");
		imageList.add("1185095126876295168");
		imageList.add("1185095127232811008");
		imageList.add("1185095127681601536");
		imageList.add("1185095128310747136");
		imageList.add("1185095128415604736");
		imageList.add("1185095129212522496");
		imageList.add("1185095131133513728");
		imageList.add("1185095131276120064");
		imageList.add("1185095132752515072");
		imageList.add("1185095132920287232");
		imageList.add("1185095136758075392");
		imageList.add("1185095136917458944");
	}

}
