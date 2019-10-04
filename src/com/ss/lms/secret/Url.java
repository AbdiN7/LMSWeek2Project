package com.ss.lms.secret;

public class Url {
     public String getUrl()
    {

        ServerCred mySecret = new ServerCred();
        return ("jdbc:mysql://localhost:3306/library?" + "user=" +
                mySecret.getServerUser() + "&password="+
                mySecret.getServerPWord()+"&serverTimezone=EST5EDT");

    }
}
