
package org.mule.modules.varnish.connectivity;

import javax.annotation.Generated;
import org.mule.api.ConnectionManager;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.process.ProcessCallback;
import org.mule.api.process.ProcessInterceptor;
import org.mule.api.process.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.varnish.adapters.VarnishModuleConnectionIdentifierAdapter;
import org.mule.modules.varnish.process.ManagedConnectionProcessInterceptor;
import org.mule.modules.varnish.process.ProcessCallbackProcessInterceptor;
import org.mule.modules.varnish.process.RetryProcessInterceptor;

@Generated(value = "Mule DevKit Version 3.3.2", date = "2012-12-07T01:33:30-03:00", comments = "Build UNNAMED.1372.db235f3")
public class ManagedConnectionProcessTemplate<P >implements ProcessTemplate<P, VarnishModuleConnectionIdentifierAdapter>
{

    private final ProcessInterceptor<P, VarnishModuleConnectionIdentifierAdapter> processInterceptor;

    public ManagedConnectionProcessTemplate(ConnectionManager<VarnishModuleConnectionKey, VarnishModuleConnectionIdentifierAdapter> connectionManager, MuleContext muleContext) {
        ProcessInterceptor<P, VarnishModuleConnectionIdentifierAdapter> processCallbackProcessInterceptor = new ProcessCallbackProcessInterceptor<P, VarnishModuleConnectionIdentifierAdapter>();
        ProcessInterceptor<P, VarnishModuleConnectionIdentifierAdapter> managedConnectionProcessInterceptor = new ManagedConnectionProcessInterceptor<P>(processCallbackProcessInterceptor, connectionManager, muleContext);
        ProcessInterceptor<P, VarnishModuleConnectionIdentifierAdapter> retryProcessInterceptor = new RetryProcessInterceptor<P, VarnishModuleConnectionIdentifierAdapter>(managedConnectionProcessInterceptor, muleContext, connectionManager.getRetryPolicyTemplate());
        processInterceptor = retryProcessInterceptor;
    }

    public P execute(ProcessCallback<P, VarnishModuleConnectionIdentifierAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
        throws Exception
    {
        return processInterceptor.execute(processCallback, null, messageProcessor, event);
    }

    public P execute(ProcessCallback<P, VarnishModuleConnectionIdentifierAdapter> processCallback, Filter filter, MuleMessage message)
        throws Exception
    {
        return processInterceptor.execute(processCallback, null, filter, message);
    }

}
