package com.ss.lms.secret;

public class Url {
     public String getUrl()
    {

        ServerCredential mySecret = new ServerCredential();
        return ("jdbc:mysql://localhost:3306/library?" + "user=" +
                mySecret.getServerUser() + "&password="+
                mySecret.getServerPWord());

    }
}
