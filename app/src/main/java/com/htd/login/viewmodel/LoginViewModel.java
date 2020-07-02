package com.htd.login.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.htd.login.BR;
import com.htd.login.LogoutActivity;
import com.htd.login.MainActivity;
import com.htd.login.model.User;

public class LoginViewModel extends BaseObservable {
    private User user;
    SharedPreferences sharedPreferences;


    private String successMessage = "Đăng nhập thành công";
    private String errMessage = "Mật khẩu gồm 1 ký tự đặc biệt, và ít nhất 1 chữ số";

    @Bindable
    public String toastMessage = null;

    public String getToastMessage() {
        return toastMessage;
    }

    public void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    public void setEmail(String email) {
        user.setEmail(email);
        notifyPropertyChanged(BR.email);
    }

    @Bindable
    public String getEmail() {
        return user.getEmail();
    }

    public void setPassword(String password) {
        user.setPassword(password);
        notifyPropertyChanged(BR.password);
    }

    @Bindable
    public String getPassword() {
        return user.getPassword();
    }

    public LoginViewModel() {
        user = new User("", "");
    }

    //
    public void onLoginClicked() {
        if (checkString(getPassword())) {
            setToastMessage(successMessage);
        } else {
            setToastMessage(errMessage);
        }

    }

//    public void onLoginClicked(Activity activity) {
//        if (checkString(getPassword())) {
//            activity.startActivity(new Intent(activity, LogoutActivity.class));
//        } else setToastMessage("Fail");
//    }

    private static boolean checkString(String input) {
        String specialChars = "~`!@#$%^&*()-_=+\\|[{]};:'\",<.>/?";
        char currentCharacter;
        boolean length = false;
        boolean numberPresent = false;
        boolean upperCasePresent = false;
        boolean lowerCasePresent = false;
        boolean specialCharacterPresent = false;

        for (int i = 0; i < input.length(); i++) {
            currentCharacter = input.charAt(i);
            if (Character.isDigit(currentCharacter)) {
                numberPresent = true;
            } else if (Character.isUpperCase(currentCharacter)) {
                upperCasePresent = true;
            } else if (Character.isLowerCase(currentCharacter)) {
                lowerCasePresent = true;
            } else if (specialChars.contains(String.valueOf(currentCharacter))) {
                specialCharacterPresent = true;
            }
        }

        if (input.length() > 6) length = true;

        return numberPresent && upperCasePresent && lowerCasePresent && specialCharacterPresent && length;
    }

//    @Bindable
//    public Boolean getRemember() {
//
//    }
//
//    public void setRemember() {
//
//    }
//
//    public void remember() {
//        Context context = null;
//
//        sharedPreferences = context.getSharedPreferences("dataLogin", Context.MODE_PRIVATE);
//
//        setEmail(sharedPreferences.getString("email", ""));
//        setPassword(sharedPreferences.getString("password", ""));
//
//    }
}
