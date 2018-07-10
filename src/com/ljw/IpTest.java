package com.ljw;

public class IpTest {
	 public static void main(String[] args) {  
	        System.out.println(isInRange("221.177.63.255", "221.177.64.0/19"));  
	        System.out.println(isInRange("221.177.64.1", "221.177.64.0/19"));  
	        System.out.println(isInRange("221.177.95.254", "221.177.64.0/19"));  
	        System.out.println(isInRange("221.177.96.0", "221.177.64.0/19"));  
	    } 
	 
	    public static boolean isInRange(String ip, String cidr) {  
	        
	    	//待检测ip：二进制位移后求和处理
	    	String[] ips = ip.split("\\.");  
	        int ipAddr = (Integer.parseInt(ips[0]) << 24)  
	                | (Integer.parseInt(ips[1]) << 16)  
	                | (Integer.parseInt(ips[2]) << 8) 
	                | Integer.parseInt(ips[3]);  
	       
	         
	        //待检测ip：二进制位移后求和处理
	        String cidrIp = cidr.replaceAll("/.*", "");  
	        String[] cidrIps = cidrIp.split("\\.");
	        int cidrIpAddr = (Integer.parseInt(cidrIps[0]) << 24)  
	                | (Integer.parseInt(cidrIps[1]) << 16)  
	                | (Integer.parseInt(cidrIps[2]) << 8)  
	                | Integer.parseInt(cidrIps[3]);  
	  
	        
	        int type = Integer.parseInt(cidr.replaceAll(".*/", ""));  
	        int mask = 0xFFFFFFFF << (32 - type); 
	        
	        return (ipAddr & mask) == (cidrIpAddr & mask);  
	    }  
}
