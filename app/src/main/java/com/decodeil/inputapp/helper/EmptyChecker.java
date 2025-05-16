package com.decodeil.inputapp.helper;

import android.widget.EditText;

public class EmptyChecker {
    public static void checkEmptyFields(EditText[] editTexts) throws Exception
    {
        for (EditText editText:editTexts) {
            if (editText.getText().toString().trim().equals("")){
                throw new Exception("Field belum diisi");
            }
        }
    }
}
