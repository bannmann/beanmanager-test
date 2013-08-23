package org.example;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/")
@Stateless
public class RestfulTest
{
    Logger log = LoggerFactory.getLogger(getClass());

    @GET
    public String testGet()
    {
        ExampleBean exampleBean = BeanManagerTools.getBeanByType(ExampleBean.class);
        String message;
        if (exampleBean != null)
        {
            message = "Found bean " + exampleBean;
            log.info(message);
        }
        else
        {
            message = "Could not find example bean";
            log.error(message);
        }
        return message;
    }

    @POST
    public void testPost(DataObject dataObject)
    {
        log.info("POST parameter: {}", dataObject);
    }
}