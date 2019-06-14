package com.cqut.yyc;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cqut.yyc.utils.MD5Encryption;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CqutcrmApplicationTests {

	@Test
	public void contextLoads() {
	    String username = "admin";
		String salt = UUID.randomUUID().toString().trim().replaceAll("-", "");
		String CredentialsSalt = username + salt;
		String password = "a123456";
		// 将密码加密
		String encryptionPassword = MD5Encryption.Encryption(CredentialsSalt,password);
		System.out.println("Junit测试输出用户名为："+username+"\n"
				+"Junit测试输出盐值为："+salt+"\n"
				+"Junit测试输出密码为："+encryptionPassword);
	}

}
