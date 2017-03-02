package com.shiyanlou.java8;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

public class Base64OfNewFeatures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

	         // 使用基本的Base64编码
	         String base64encodedString = Base64.getEncoder().encodeToString("Shiyanlou.com".getBytes("utf-8"));
	         System.out.println("Basic base64 encoding:" + base64encodedString);

	         // 解码并输出结果
	         byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);        
	         System.out.println("Original content: " + new String(base64decodedBytes, "utf-8"));

	         // 使用URL类型的Base64编码
	         base64encodedString = Base64.getUrlEncoder().encodeToString("Shiyanlou.com".getBytes("utf-8"));
	         System.out.println("URL base64 encoding:" + base64encodedString);

	         // MIME类型的Base64编码
	         StringBuilder stringBuilder = new StringBuilder();

	         for (int i = 0; i < 10; ++i) {
	            stringBuilder.append(UUID.randomUUID().toString());
	         }

	         byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
	         String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
	         System.out.println("MIME base64 encoding:" + mimeEncodedString);

	      }catch(UnsupportedEncodingException e){
	         // 捕获异常并输出
	         System.out.println("Exception:" + e.getMessage());
	      }
	   }

	

}
