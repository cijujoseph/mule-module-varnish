
package org.mule.modules.varnish.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.process.ProcessAdapter;
import org.mule.api.process.ProcessCallback;
import org.mule.api.process.ProcessTemplate;
import org.mule.api.process.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.varnish.VarnishModule;


/**
 * A <code>VarnishModuleProcessAdapter</code> is a wrapper around {@link VarnishModule } that enables custom processing strategies.
 * 
 */
@Generated(value = "Mule DevKit Version 3.3.2", date = "2012-12-07T01:33:30-03:00", comments = "Build UNNAMED.1372.db235f3")
public class VarnishModuleProcessAdapter
    extends VarnishModuleLifecycleAdapter
    implements ProcessAdapter<VarnishModuleCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, VarnishModuleCapabilitiesAdapter> getProcessTemplate() {
        final VarnishModuleCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,VarnishModuleCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, VarnishModuleCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, VarnishModuleCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
