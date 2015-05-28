package com.ofs.sms.twilio;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;


public class SendNotifications {
    /* Twilio REST API version */
	 public static final String ACCOUNTSID = "ACa8e076418ff7b89a666df46db5c91b95"; 
	 public static final String AUTHTOKEN = "6cc07d048d6f1aaf2bb973f7113eec0b"; 
    
    public static void main(String args[]){
    	 
    
    	TwilioRestClient client = new TwilioRestClient(ACCOUNTSID, AUTHTOKEN); 

    	// Build the parameters 
    	List<NameValuePair> params = new ArrayList<NameValuePair>();  
    	params.add(new BasicNameValuePair("From", "+15095633018"));    
    	params.add(new BasicNameValuePair("To", "+918870862303"));   
    	params.add(new BasicNameValuePair("Body", "Welcome to twilio from eclipse")); 

    	MessageFactory messageFactory = client.getAccount().getMessageFactory(); 
    	Message message;
		try {
			message = messageFactory.create(params);
			System.out.println(message.getSid()); 
		} catch (TwilioRestException e) {
			e.printStackTrace();
		} 

//        /* Instantiate a new Twilio Rest Client */
//        TwilioRestClient client = new TwilioRestClient(ACCOUNTSID, AUTHTOKEN);
//
//        // Get the account and call factory class
//        Account acct = client.getAccount();
//        SmsFactory smsFactory = acct.getSmsFactory();
//
//        //build map of server admins
//        Map<String,String> admins = new HashMap<String,String>();
//        admins.put("+919884423313", "9443-6535Johnny");
//       
//        String fromNumber = "+15095633018";
//
//    	// Iterate over all our server admins
//        for (String toNumber : admins.keySet()) {
//            
//            //build map of post parameters 
//            Map<String,String> params = new HashMap<String,String>();
//            params.put("From", fromNumber);
//            params.put("To", toNumber);
//            params.put("Body", "Bad news " + admins.get(toNumber) + ", the server is down and it needs your help");
//
//            try {
//                // send an sms a call  
//                // ( This makes a POST request to the SMS/Messages resource)
//                Sms sms = smsFactory.create(params);
//                System.out.println("Success sending SMS: " + sms.getSid());
//            }
//            catch (TwilioRestException e) {
//                e.printStackTrace();
//            }
//        }
    }       
}
