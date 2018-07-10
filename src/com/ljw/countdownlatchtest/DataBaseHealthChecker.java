package com.ljw.countdownlatchtest;

import java.util.concurrent.CountDownLatch;

public class DataBaseHealthChecker extends BaseHealthChecker
{
    public DataBaseHealthChecker (CountDownLatch latch)  {
        super("DataSource Service", latch);
    }
 
    @Override
    public void verifyService()
    {
        System.out.println("Checking " + this.getServiceName());
        try
        {
            Thread.sleep(7000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + " is UP");
    }
}