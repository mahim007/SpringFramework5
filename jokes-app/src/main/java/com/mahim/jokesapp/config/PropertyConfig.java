package com.mahim.jokesapp.config;

import com.mahim.jokesapp.FakeDataSource;
import com.mahim.jokesapp.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySources({
        @PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath:jms.properties")
})
public class PropertyConfig {

    Environment env;

    public PropertyConfig(Environment env) {
        this.env = env;
    }

    @Value("${jokesapp.user}") String user;
    @Value("${jokesapp.password}") String password;
    @Value("${jokesapp.dbUrl}") String dbUrl;

    @Value("${jms.user}") String jmsUser;
    @Value("${jms.password}") String jmsPassword;
    @Value("${jms.dbUrl}") String jmsDbUrl;

    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource(env.getProperty("MAHIM_USERNAME"), password, dbUrl);
        System.out.println("FakeDataSource:  " +  fakeDataSource);
        return fakeDataSource;
    }

    @Bean
    public FakeJmsBroker fakeJmsBroker() {
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker(jmsUser, jmsPassword, jmsDbUrl);
        System.out.println("fakeJsmBroker: " + fakeJmsBroker);
        return fakeJmsBroker;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
