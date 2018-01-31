/**************************************************************************************** 
 Copyright © 2003-2012 hbasesoft Corporation. All rights reserved. Reproduction or       <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.hbasesoft.framework.test.rule.plugin.transaction;

import com.hbasesoft.framework.rule.core.FlowBean;

/**
 * <Description> <br>
 * 
 * @author 王伟<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2017年9月5日 <br>
 * @since V1.0<br>
 * @see com.hbasesoft.framework.test.rule.plugin.transaction <br>
 */
public class TestFlowBean implements FlowBean {

    /**
     * serialVersionUID <br>
     */
    private static final long serialVersionUID = 4710973826238213054L;

    private String transId;

    private String name;

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Description: <br>
     * 
     * @author 王伟<br>
     * @taskId <br>
     * @return <br>
     */
    @Override
    public String getTransId() {
        return transId;
    }

    /**
     * Description: <br>
     * 
     * @author 王伟<br>
     * @taskId <br>
     * @param transId <br>
     */
    @Override
    public void setTransId(String transId) {
        this.transId = transId;
    }

}