package com.github.sioncheng.transportation.acq.ejb;

import org.junit.Assert;
import org.junit.Test;

public class AServletTest {

    @Test
    public void testAServletNew() {
        AServlet aServlet = new AServlet();
        Assert.assertNotNull(aServlet);
    }
}
