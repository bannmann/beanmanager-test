package org.example;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Startup
@Singleton
public class SingletonEjbTest
{
    Logger log = LoggerFactory.getLogger(getClass());

    @PostConstruct
    public void test()
    {
        ExampleBean exampleBean = BeanManagerTools.getBeanByType(ExampleBean.class);
        if (exampleBean != null)
        {
            log.info("Found bean {}", exampleBean);
        }
        else
        {
            log.error("Could not find example bean");
        }
    }
}