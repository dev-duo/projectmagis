package com.magis.web;

public class Login {

    public Login(){}

    public Login()
        throws ETSdkException
    {
        private static String clientId = null;
        private static String clientSecret = null;
        private static String endpoint = null;
        private static String authEndpoint = null;
        private static String soapEndpoint = null;
        public static String stack = "4";
        private static ETConfiguration configuration = new ETConfiguration("application.properties");
        
        //set username
        configuration.set("username","");
        //set password
        configuration.set("password","");
        //set client id
        configuration.set("clientId","");
        //set client secret
        configuration.set("clientSecret","");
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
        }
        
        configuration.set("soapEndpoint",soapEndpoint);
        private static ETClient client = new ETClient(configuration);

    }
}