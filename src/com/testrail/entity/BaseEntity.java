package com.testrail.entity;

import java.io.Serializable;

import com.testrail.service.TestRailService;

/**
 * @author mmerrell
 */
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = -3770248751816746138L;

    private TestRailService testRailService;
    protected TestRailService getTestRailService() { return testRailService; }
    public void setTestRailService(TestRailService testRailService) { this.testRailService = testRailService; }
}
