/**
 * Mule Rest Module
 *
 * Copyright 2011-2012 (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * This software is protected under international copyright law. All use of this software is
 * subject to MuleSoft's Master Subscription Agreement (or other master license agreement)
 * separately entered into in writing between you and MuleSoft. If such an agreement is not
 * in place, you may not use the software.
 */

package org.mule.modules.varnish;

import com.jayway.restassured.RestAssured;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.mule.api.MuleEvent;
import org.mule.construct.Flow;
import org.mule.tck.junit4.FunctionalTestCase;
import org.mule.tck.junit4.rule.DynamicPort;

public class VarnishModuleTest extends FunctionalTestCase {
    @Rule
    public DynamicPort serverPort = new DynamicPort("serverPort");

    @Override
    protected void doSetUp() throws Exception {
        RestAssured.port = serverPort.getNumber();

        super.doSetUp();
    }

    @Override
    protected String getConfigResources() {
        return "varnish.xml";
    }

    @Test
    @Ignore
    public void testBanUrl() throws Throwable {
        runFlow("banUrl");
    }

    protected Flow lookupFlowConstruct(String name) {
        return (Flow) muleContext.getRegistry().lookupFlowConstruct(name);
    }

    protected MuleEvent runFlow(String flowName) throws Throwable {
        String payload = "";
        Flow flow = lookupFlowConstruct(flowName);
        MuleEvent event = getTestEvent(payload);
        MuleEvent responseEvent = flow.process(event);
        if (responseEvent != null && responseEvent.getMessage() != null && responseEvent.getMessage().getExceptionPayload() != null) {
            throw responseEvent.getMessage().getExceptionPayload().getRootException();
        }
        return responseEvent;
    }
}
