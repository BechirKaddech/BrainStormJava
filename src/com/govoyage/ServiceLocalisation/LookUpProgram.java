/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.ServiceLocalisation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class LookUpProgram {
    
    	private static String getCurrentIPAddress() throws MalformedURLException, IOException {
		HttpURLConnection conn = (HttpURLConnection)new URL("http://ifconfig.me/ip").openConnection();
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String response = reader.readLine();
		if (conn.getResponseCode() == 200) {
                   // System.out.println("hedi");
			return response.trim();
                        
		} else {
			return null;
		}
	}
    
    
    

    public static void main(String... args) throws UnknownHostException, IOException {
        
        String ipadress = getCurrentIPAddress();

        long ipAddress = new BigInteger(InetAddress.getByName(ipadress).getAddress()).longValue();

        System.out.println("By String IP address: \n" +GeoIPv4.getLocation(ipadress));
        
        System.out.println(GeoIPv4.getLocation(ipadress).getLatitude());
        
       // System.out.println("itis me"+GeoIPv4.getLocation(ipAddress).getLatitude());

       // System.out.println("By long IP address: \n" +GeoIPv4.getLocation(ipAddress));

       // System.out.println("By InetAddress IP address: \n" +GeoIPv4.getLocation(InetAddress.getByName("197.0.138.12")));

    }
    
    
    
}