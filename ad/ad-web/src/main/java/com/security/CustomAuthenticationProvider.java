package com.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.ad.dto.MamberDto;
import com.ad.web.service.MemberService;

import lombok.extern.slf4j.Slf4j;


@Configuration
@Slf4j
@Component
@EnableWebSecurity
public class CustomAuthenticationProvider implements AuthenticationProvider{
	
	// 여기서 하는 일은 인증을 어떻게 할지에 대한 프로파이더를 정의한다. 
	private PasswordEncoder encoder;
	private MemberService memberService;
	
	public CustomAuthenticationProvider(PasswordEncoder encoder) {
		this.encoder = encoder;
//		this.userdetailService = userdetailService;
	}

	///인증객체 폼에서 입력한 사용자 아이디와 패스와드 (authentication) 들어있음
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken)authentication;
		
		String userId = token.getName();
		//User user = null;
		
		
		List<GrantedAuthority> list =  new ArrayList<GrantedAuthority>();
			
		list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		User user = new User("admin","1234", list);
		if(StringUtils.isEmpty(userId)) {
			
		}
		String password = user.getPassword();
		MamberDto dto = new MamberDto();
//		dto.setUserId(userId);
//		dto.setPassword(password);
		
		
		UsernamePasswordAuthenticationToken aaa = new UsernamePasswordAuthenticationToken(user, password, list);
		return aaa;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		   //return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
		return true;
	}

}
