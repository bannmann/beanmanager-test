package org.example;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.naming.InitialContext;
import javax.naming.NamingException;

class BeanManagerTools
{
    public static BeanManager getBeanManager()
    {
        BeanManager beanManager;
        try
        {
            beanManager = (BeanManager) new InitialContext().lookup("java:comp/BeanManager");
        }
        catch (NamingException e)
        {
            throw new IllegalStateException("Could not retrieve bean manager", e);
        }
        catch (Exception e)
        {
            throw new IllegalStateException("Could not retrieve bean manager", e);
        }
        return beanManager;
    }

    public static <T> T getBeanByType(Class<T> beanClass)
    {
        return getBeanByType(beanClass, getBeanManager());
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBeanByType(Class<T> beanClass, BeanManager beanManager)
    {
        Bean<T> bean = (Bean<T>) beanManager.getBeans(beanClass).iterator().next();
        CreationalContext<T> ctx = beanManager.createCreationalContext(bean);
        T result = (T) beanManager.getReference(bean, beanClass, ctx);
        return result;
    }

}
