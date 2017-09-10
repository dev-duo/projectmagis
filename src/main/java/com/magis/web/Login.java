package com.magis.web;

import com.exacttarget.fuelsdk.ETClient;
import com.exacttarget.fuelsdk.ETConfiguration;
import com.exacttarget.fuelsdk.ETSdkException;

public class Login {



    public Login() {
        try{
            int stack = 4;
            String soapEndpoint = "";
            ETConfiguration configuration = new ETConfiguration("/fuelsdk.properties");

            //set username
            configuration.set("username","");
            //set password
            configuration.set("password","");
            //set client id
            configuration.set("clientId","29y2z4p6u51s160uk3z9b4cp");
            //set client secret
            configuration.set("clientSecret","Q8AVYav7ICQdl22YyCth3vRj");
            //set soapEndpoint

            switch (stack) {
                case 1:  soapEndpoint = configuration.get("s1_soapEndpoint");
                    break;
                case 4:  soapEndpoint = configuration.get("s4_soapEndpoint");
                    break;
                case 6:  soapEndpoint = configuration.get("s6_soapEndpoint");
                    break;
                case 7:  soapEndpoint = configuration.get("s7_soapEndpoint");
                    break;
                default: soapEndpoint = "Invalid stack";
                    break;
            }

            configuration.set("soapEndpoint",soapEndpoint);
            ETClient client = new ETClient(configuration);

            System.out.println("Client to String");
            System.out.println(client.toString());
        } catch (ETSdkException e){
            System.out.println(e);
        }

    }
}
