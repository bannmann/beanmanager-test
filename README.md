Prerequisites
-------------

Use VM option `-Dopenejb.jaxrs.providers.auto=true`.

Test
----

Issue a POST request to `localhost/beanmanager-test/`. This works fine in TomEE 1.5.2, but fails in TomEE 1.6.0-SNAPSHOT with the following exception:

```
Aug 23, 2013 11:23:50 AM org.apache.cxf.jaxrs.impl.WebApplicationExceptionMapper toResponse
WARNING: javax.ws.rs.WebApplicationException: java.lang.IllegalStateException: Could not retrieve bean manager
	at org.apache.cxf.jaxrs.utils.JAXRSUtils.readFromMessageBody(JAXRSUtils.java:1047)
	at org.apache.cxf.jaxrs.utils.JAXRSUtils.processParameter(JAXRSUtils.java:617)
	at org.apache.cxf.jaxrs.utils.JAXRSUtils.processParameters(JAXRSUtils.java:581)
	at org.apache.cxf.jaxrs.interceptor.JAXRSInInterceptor.processRequest(JAXRSInInterceptor.java:242)
	at org.apache.cxf.jaxrs.interceptor.JAXRSInInterceptor.handleMessage(JAXRSInInterceptor.java:91)
	at org.apache.cxf.phase.PhaseInterceptorChain.doIntercept(PhaseInterceptorChain.java:262)
	at org.apache.cxf.transport.ChainInitiationObserver.onMessage(ChainInitiationObserver.java:121)
	at org.apache.cxf.transport.http.AbstractHTTPDestination.invoke(AbstractHTTPDestination.java:237)
	at org.apache.openejb.server.cxf.rs.CxfRsHttpListener.onMessage(CxfRsHttpListener.java:137)
	at org.apache.openejb.server.rest.RsServlet.service(RsServlet.java:53)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:728)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:305)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:210)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:222)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:123)
	at org.apache.tomee.catalina.OpenEJBValve.invoke(OpenEJBValve.java:45)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:502)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:171)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:99)
	at org.apache.catalina.valves.AccessLogValve.invoke(AccessLogValve.java:953)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:118)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:408)
	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1023)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:589)
	at org.apache.tomcat.util.net.JIoEndpoint$SocketProcessor.run(JIoEndpoint.java:312)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at java.lang.Thread.run(Thread.java:722)
Caused by: java.lang.IllegalStateException: Could not retrieve bean manager
	at org.example.BeanManagerTools.getBeanManager(BeanManagerTools.java:20)
	at org.example.BeanManagerTools.getBeanByType(BeanManagerTools.java:31)
	at org.example.DataObjectReader.readFrom(DataObjectReader.java:24)
	at org.example.DataObjectReader.readFrom(DataObjectReader.java:15)
	at org.apache.cxf.jaxrs.utils.JAXRSUtils.readFromMessageBody(JAXRSUtils.java:1039)
	... 27 more
Caused by: javax.naming.NameNotFoundException: Name [comp/BeanManager] is not bound in this Context. Unable to find [comp].
	at org.apache.naming.NamingContext.lookup(NamingContext.java:820)
	at org.apache.naming.NamingContext.lookup(NamingContext.java:168)
	at org.apache.naming.SelectorContext.lookup(SelectorContext.java:158)
	at javax.naming.InitialContext.lookup(InitialContext.java:411)
	at org.example.BeanManagerTools.getBeanManager(BeanManagerTools.java:16)
	... 31 more
```
