//package com.ad.config;
//
//import javax.sql.DataSource;
//
//import org.apache.ibatis.session.ExecutorType;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@MapperScan(value="com.ad.mapper.batch", sqlSessionFactoryRef="db2SqlSessionFactory")
//@EnableTransactionManagement
//public class MyBatisConfig2 {
//
//	@Bean(name ="db2DataSource")
//    @ConfigurationProperties(prefix ="spring.db2.datasource")
// 
//    public DataSource db2DataSource() {
//        return DataSourceBuilder.create().build();
//    }
// 
//    @Bean(name ="db2SqlSessionFactory")
//    public SqlSessionFactory db2SqlSessionFactory(@Qualifier("db2DataSource") DataSource db2DataSource, ApplicationContext applicationContext) throws Exception {
//    	SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//    	sqlSessionFactoryBean.setDataSource(db2DataSource); //데이터소스 설정
//    	sqlSessionFactoryBean.setVfs(SpringBootVFS.class);
//        sqlSessionFactoryBean.setTypeAliasesPackage("com.ad.dto");//com/ad/dt       
//        sqlSessionFactoryBean.setMapperLocations( applicationContext.getResources("classpath:mappers/batch/*.xml"));
//        sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
//        return sqlSessionFactoryBean.getObject();
//    }
// 
//    @Bean(name ="db2SqlSessionTemplate")
//    public SqlSessionTemplate db2SqlSessionTemplate(@Autowired @Qualifier("db2SqlSessionFactory") SqlSessionFactory db2SqlSessionFactory)throws Exception {
//        return new SqlSessionTemplate(db2SqlSessionFactory, ExecutorType.BATCH);
//    }
//    
////    @Bean(name="sqlSessionBatch")
////    public SqlSession sqlSessionBatch(@Autowired @Qualifier("db2SqlSessionFactory") SqlSessionFactory db2SqlSessionFactory) {
////        return new SqlSessionTemplate(db2SqlSessionFactory);
////    }
//     
////    @Bean(name="secondaryTransactionManager")
////    public DataSourceTransactionManager secondaryTransactionManager(@Autowired @Qualifier("db2DataSource") DataSource db2DataSource) {
////        return new DataSourceTransactionManager(db2DataSource);
////    }
//}
