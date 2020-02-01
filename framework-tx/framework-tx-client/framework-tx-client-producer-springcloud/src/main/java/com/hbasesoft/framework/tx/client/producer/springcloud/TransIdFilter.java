/**************************************************************************************** 
 Copyright © 2003-2012 hbasesoft Corporation. All rights reserved. Reproduction or       <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.hbasesoft.framework.tx.client.producer.springcloud;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.hbasesoft.framework.common.annotation.NoTransLog;
import com.hbasesoft.framework.common.utils.CommonUtil;

/**
 * <Description> <br>
 * 
 * @author 王伟<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate Feb 1, 2020 <br>
 * @since V1.0<br>
 * @see com.hbasesoft.framework.tx.client.producer.springcloud <br>
 */
@NoTransLog
@Component
@WebFilter(urlPatterns = "/**", filterName = "transIdFilter")
public class TransIdFilter implements javax.servlet.Filter {

    public static final String TRACE_ID = "X-B3-TraceId";

    /**
     * Description: <br>
     * 
     * @author 王伟<br>
     * @taskId <br>
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException <br>
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        String traceId = req.getHeader(TRACE_ID);
        if (StringUtils.isEmpty(traceId)) {
            traceId = CommonUtil.getTransactionID();
            MutableHttpServletRequest mutableRequest = new MutableHttpServletRequest(req);
            mutableRequest.putHeader(TRACE_ID, traceId);
            req = mutableRequest;
            WebTransIdGeneratorFactory.setTraceId(traceId);
        }
        chain.doFilter(req, response);
    }
}
