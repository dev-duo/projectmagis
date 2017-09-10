package com.magis.web;

import com.exacttarget.fuelsdk.*;

public class Login {
    private static final String DEFAULT_clientId ="29y2z4p6u51s160uk3z9b4cp";
    private static final String DEFAULT_clientSecret ="Q8AVYav7ICQdl22YyCth3vRj";
    private static final String DEFAULT_soapEndPoint ="https://webservice.s4.exacttarget.com/Service.asmx";
    public Login() {
        
        try{
            int stack = 4;
            String soapEndpoint = "";
            ETConfiguration configuration = new ETConfiguration("/fuelsdk.properties");

            //set username
            configuration.set("username","la-mcebrian");
            //set password
            configuration.set("password","James1:1");
            //set client id
            configuration.set("clientId",DEFAULT_clientId);
            //set client secret
            configuration.set("clientSecret",DEFAULT_clientSecret);
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
                default: soapEndpoint = DEFAULT_soapEndPoint;
                    break;
            }

            configuration.set("soapEndpoint",soapEndpoint);
            ETClient client = new ETClient(configuration);
            ETSoapConnection soap = new ETSoapConnection(client, configuration.get("s4_soapEndpoint"),
                            configuration.get("username"),
                            configuration.get("password"));

            System.out.println("soap to String");
            System.out.println(soap.getSoap().toString());
        } catch (ETSdkException e){
            System.out.println("ETSdkException to String");
            System.out.println(e.toString());
        }

    }    
}
