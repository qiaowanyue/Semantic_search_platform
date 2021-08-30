package com.example.utils;

import com.example.RPC.RPC;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.ResourceBundle;

public final class EnvUtil {
    private static String NAMEKO_USERNAME;
    private static String NAMEKO_PASSWORD;
    private static String RABBITMQ_HOST;
//    private static  Map<String, String> env;
    public static Logger logger = Logger.getLogger(EnvUtil.class);
//    public static Map<String, String> getEnv() {
//        return System.getenv();
//    }

    public EnvUtil(){
        ResourceBundle util = ResourceBundle.getBundle("util");
        this.NAMEKO_USERNAME = util.getString("util.username");
        this.NAMEKO_PASSWORD = util.getString("util.password");
        this.RABBITMQ_HOST = util.getString("util.rabhost");

//        env =  getEnv();
    }

    public static void initMQFromEnv(Map<String, String> env){
        try{
//            if(env.containsKey(NAMEKO_USERNAME) && !env.get(NAMEKO_USERNAME).isEmpty()){
//                RPC.username = env.get(NAMEKO_USERNAME);
//            }
//            if(env.containsKey(NAMEKO_PASSWORD) && !env.get(NAMEKO_PASSWORD).isEmpty()){
//                RPC.password = env.get(NAMEKO_PASSWORD);
//            }
//
//            if(env.containsKey(RABBITMQ_HOST) && !env.get(RABBITMQ_HOST).isEmpty()){
//                RPC.host = env.get(RABBITMQ_HOST);
//            }
            if(env.containsKey("nameko_username") && !env.get("nameko_username").isEmpty()){
                RPC.username = env.get("nameko_username");
            }

            if(env.containsKey("nameko_password") && !env.get("nameko_password").isEmpty()){
                RPC.password = env.get("nameko_password");
            }

            if(env.containsKey("rabbitmq_host") && !env.get("rabbitmq_host").isEmpty()){
                RPC.host = env.get("rabbitmq_host");
            }
        }
        catch (Exception e){
            logger.debug("The service function cannot be empty");
        }
    }

    public static String getNamekoUsername() {
        return NAMEKO_USERNAME;
    }

    public static String getNamekoPassword() {
        return NAMEKO_PASSWORD;
    }

    public static String getRabbitmqHost() {
        return RABBITMQ_HOST;
    }
}
