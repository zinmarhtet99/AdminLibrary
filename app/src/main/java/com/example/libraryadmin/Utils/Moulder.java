package com.example.libraryadmin.Utils;

import android.util.Log;

import me.myatminsoe.mdetect.Rabbit;

public class Moulder {

    private static boolean isUnicode=true;

    public static void init(boolean isUnicode){
        Moulder.isUnicode = isUnicode;
    }

    public static String stringToUni(String text){
        if(!isUnicode){
            return Rabbit.zg2uni(text);
        }
        return text;
    }

    public static String mercyOnZgUser(String text){
        if (isUnicode){
            Log.i("Lan","it is uni");
            return text;
        }else{
            Log.i("Lan","it is zawgyi");
            return Rabbit.uni2zg(text);
        }
    }
}
