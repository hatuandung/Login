package com.htd.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.htd.login.databinding.ActivityLogoutBinding;
import com.htd.login.viewmodel.LogoutViewModel;

public class LogoutActivity extends AppCompatActivity {
    private ActivityLogoutBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_logout);
        binding.setLogoutViewModel(new LogoutViewModel());

    }
}