
package org.mule.modules.varnish.process;

import java.util.List;
import javax.annotation.Generated;
import org.mule.api.ConnectionManager;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.UnableToAcquireConnectionException;
import org.mule.api.UnableToReleaseConnectionException;
import org.mule.api.process.ProcessCallback;
import org.mule.api.process.ProcessInterceptor;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.varnish.adapters.VarnishModuleConnectionIdentifierAdapter;
import org.mule.modules.varnish.connectivity.VarnishModuleConnectionKey;
import org.mule.modules.varnish.processors.AbstractConnectedProcessor;
import org.mule.modules.varnish.processors.AbstractExpressionEvaluator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Generated(value = "Mule DevKit Version 3.3.2", date = "2012-12-07T01:33:30-03:00", comments = "Build UNNAMED.1372.db235f3")
public class ManagedConnectionProcessInterceptor<T >
    extends AbstractExpressionEvaluator
    implements ProcessInterceptor<T, VarnishModuleConnectionIdentifierAdapter>
{

    private static Logger logger = LoggerFactory.getLogger(ManagedConnectionProcessInterceptor.class);
    private final ConnectionManager<VarnishModuleConnectionKey, VarnishModuleConnectionIdentifierAdapter> connectionManager;
    private final MuleContext muleContext;
    private final ProcessInterceptor<T, VarnishModuleConnectionIdentifierAdapter> next;

    public ManagedConnectionProcessInterceptor(ProcessInterceptor<T, VarnishModuleConnectionIdentifierAdapter> next, ConnectionManager<VarnishModuleConnectionKey, VarnishModuleConnectionIdentifierAdapter> connectionManager, MuleContext muleContext) {
        this.next = next;
        this.connectionManager = connectionManager;
        this.muleContext = muleContext;
    }

    public T execute(ProcessCallback<T, VarnishModuleConnectionIdentifierAdapter> processCallback, VarnishModuleConnectionIdentifierAdapter object, MessageProcessor messageProcessor, MuleEvent event)
        throws Exception
    {
        VarnishModuleConnectionIdentifierAdapter connection = null;
        VarnishModuleConnectionKey key = null;
        if ((messageProcessor!= null)&&((messageProcessor instanceof AbstractConnectedProcessor)&&(((AbstractConnectedProcessor) messageProcessor).getHost()!= null))) {
            final String _transformedHost = ((String) evaluateAndTransform(muleContext, event, AbstractConnectedProcessor.class.getDeclaredField("_hostType").getGenericType(), null, ((AbstractConnectedProcessor) messageProcessor).getHost()));
            final Integer _transformedPort = ((Integer) evaluateAndTransform(muleContext, event, AbstractConnectedProcessor.class.getDeclaredField("_portType").getGenericType(), null, ((AbstractConnectedProcessor) messageProcessor).getPort()));
            final String _transformedSecret = ((String) evaluateAndTransform(muleContext, event, AbstractConnectedProcessor.class.getDeclaredField("_secretType").getGenericType(), null, ((AbstractConnectedProcessor) messageProcessor).getSecret()));
            key = new VarnishModuleConnectionKey(_transformedHost, _transformedPort, _transformedSecret);
        } else {
            key = connectionManager.getDefaultConnectionKey();
        }
        try {
            if (logger.isDebugEnabled()) {
                logger.debug(("Attempting to acquire connection using "+ key.toString()));
            }
            connection = connectionManager.acquireConnection(key);
            if (connection == null) {
                throw new UnableToAcquireConnectionException();
            } else {
                if (logger.isDebugEnabled()) {
                    logger.debug((("Connection has been acquired with [id="+ connection.getConnectionIdentifier())+"]"));
                }
            }
            return next.execute(processCallback, connection, messageProcessor, event);
        } catch (Exception e) {
            if (processCallback.getManagedExceptions()!= null) {
                for (Class exceptionClass: ((List<Class> ) processCallback.getManagedExceptions())) {
                    if (exceptionClass.isInstance(e)) {
                        if (logger.isDebugEnabled()) {
                            logger.debug((((("An exception ( "+ exceptionClass.getName())+") has been thrown. Destroying the connection with [id=")+ connection.getConnectionIdentifier())+"]"));
                        }
                        try {
                            connectionManager.destroyConnection(key, connection);
                            connection = null;
                        } catch (Exception innerException) {
                            logger.error(innerException.getMessage(), innerException);
                        }
                    }
                }
            }
            throw e;
        } finally {
            try {
                if (connection!= null) {
                    if (logger.isDebugEnabled()) {
                        logger.debug((("Releasing the connection back into the pool [id="+ connection.getConnectionIdentifier())+"]"));
                    }
                    connectionManager.releaseConnection(key, connection);
                }
            } catch (Exception e) {
                throw new UnableToReleaseConnectionException(e);
            }
        }
    }

    public T execute(ProcessCallback<T, VarnishModuleConnectionIdentifierAdapter> processCallback, VarnishModuleConnectionIdentifierAdapter object, Filter filter, MuleMessage message)
        throws Exception
    {
        throw new UnsupportedOperationException();
    }

}
