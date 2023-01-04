package com.AndroidApp.PMOB;

import android.content.Context;
import android.content.SharedPreferences;


public class Preferences {

    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context ctx;

    public Preferences(Context ctx){
        this.ctx = ctx;
        prefs = ctx.getSharedPreferences("pmob", Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setLoggedin(boolean logggedin){
        editor.putBoolean("loggedInmode",logggedin);
        editor.commit();
    }

    public boolean loggedin(){
        return prefs.getBoolean("loggedInmode", false);
    }
}