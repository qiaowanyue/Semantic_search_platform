package com.example.RPC;


import com.nlp.nameko.rpc.RPC.NamekoRPC;

import java.util.ResourceBundle;


public class RPC extends NamekoRPC {

    public static String EXCHANGENAME;
    public static String host;
    public static String username;
    public static String password;
    public static int PORT;
    public RPC(){ init(); }

    public RPC(String name){
        this.setName(name);
        init();
    }

    private void init(){
        try{
            ResourceBundle rpcdata = ResourceBundle.getBundle("rpcdata");
            this.EXCHANGENAME = rpcdata.getString("rpcdata.exchangeName");
            this.host = rpcdata.getString("rpcdata.host");
            this.username = rpcdata.getString("rpcdata.username");
            this.password = rpcdata.getString("rpcdata.password");
            this.PORT = Integer.parseInt(rpcdata.getString("rpcdata.port"));

            this.setExchangeName(EXCHANGENAME);
            this.setHost(host);
            this.setUsername(username);
            this.setPassword(password);
            this.setPort(PORT);
        }catch(Exception e) {
            throw e;
        }

    }

}




