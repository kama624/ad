package com.ad.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = {"com.ad.mapper.**"})
public class MyBatisConfig {

    @Autowired
    private ApplicationContext applicationContext;
    
	//javax.sql.DataSource     
	// DataSource =>    SqlSessionFactory 
	//   => SqlSessionTemplate => SqlSession    
    @Bean //자바코드로 bean을 등록
    //Legacy 프로젝트에서는 xml로 작성된 태그 내용을 읽어서 
    //자바코드로 바꿔 객체를 메모리에 올리는 작업이 이루어짐
    //Boot에서는 주로 @Bean어노테이션을 사용하여 자바코드로 설정
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception { 
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource); //데이터소스 설정
        sqlSessionFactoryBean.setVfs(SpringBootVFS.class);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.ad.dto");//com/ad/dt       
        sqlSessionFactoryBean.setMapperLocations( new PathMatchingResourcePatternResolver().getResources("classpath:mappers/**/*.xml"));
        sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        
        return sqlSessionFactoryBean.getObject();
    }
    
    @Bean
    public SqlSessionTemplate sqlSession(SqlSessionFactory factory) {
        return new SqlSessionTemplate(factory);
    }
}
