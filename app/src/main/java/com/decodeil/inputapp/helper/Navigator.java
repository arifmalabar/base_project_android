package com.decodeil.inputapp.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class Navigator {
    public static void push(Activity context, Class<?> cls)
    {
        Intent i = new Intent(context, cls);
        context.startActivity(i);
    }
    public static void push(Activity context, Class<?> cls, String[] data)
    {
        Intent i = new Intent(context, cls);
        i.putExtra("data", data);
        context.startActivity(i);
    }
    public static void pull(Activity act, Class<?> cls)
    {
        Intent i  = new Intent(act, cls);
        act.startActivity(i);
        act.finish();
    }
}
