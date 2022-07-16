package com.ssafy.hw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.hw.interceptor.SessionInterceptor;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//프록시 설정 <aop:aspectj-autoproxy></aop:aspectj-autoproxy>를 대체한다.
@EnableAspectJAutoProxy
//mybatis의 매퍼 스캔: <mybatis:scan base-package="com.ssafy.hw.model.repo"/>를 대체한다.
@MapperScan(basePackages = "com.ssafy.hw.model.repo")
//swagger 사용을 위한 어노테이션
@___________
//인터셉터 설정 추가를 위해 WebMvcConfigurer 인터페이스를 implements 한다.
public class HwFrameworkSpring102Application implements WebMvcConfigurer {
	
	@Autowired
	SessionInterceptor sessionInterceptor;
	
	// 인터셉터 설정 추가
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(sessionInterceptor).addPathPatterns("/regist");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HwFrameworkSpring102Application.class, args);
	}

}
