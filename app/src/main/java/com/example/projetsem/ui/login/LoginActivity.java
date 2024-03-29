package com.example.projetsem.ui.login;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projetsem.MainMenuActivity;
import com.example.projetsem.R;
import com.example.projetsem.ui.login.LoginViewModel;
import com.example.projetsem.ui.login.LoginViewModelFactory;
import com.example.projetsem.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {


    private TextView btn;
    private EditText email, password;
    private Button btnlogin;
    private Button forgotpassword;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.username);
        email.setBackgroundColor(Color.TRANSPARENT);
        email.setTextColor(Color.rgb(0, 0, 0));
        password = findViewById(R.id.password);
        password.setBackgroundColor(Color.TRANSPARENT);
        password.setTextColor(Color.rgb(0, 0, 0));
        forgotpassword = findViewById(R.id.button2);
        forgotpassword.setBackgroundColor(Color.TRANSPARENT);
        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Veuillez vous approcher de l'espace internet", Toast.LENGTH_SHORT).show();
            }
        });
        btnlogin = findViewById(R.id.btnlogin);
        btnlogin.setBackgroundColor(Color.TRANSPARENT);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getText().toString();
                String pass = password.getText().toString();

                String Mail1 = "admin";
                String Pass1 = "admin";

                String Mail2 = "admin@etu.usthb.dz";
                String Pass2 = "admin";

                if (mail.equals(Mail1) && pass.equals(Pass1) || mail.equals(Mail2) && pass.equals(Pass2)) {
                    Toast.makeText(getApplicationContext(), "Login Success \n Welcome : ", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, MainMenuActivity.class));
                } else if(mail.isEmpty() || !mail.contains("@") || !mail.contains("usthb")){
                    Toast.makeText(getApplicationContext(), "Please enter a valid USTHB email address", Toast.LENGTH_SHORT).show();
                }else if(pass.isEmpty() || pass.length() < 2){
                    Toast.makeText(getApplicationContext(), "Please enter a valid password", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public boolean checkFormat(){
        String mail = email.getText().toString();
        String pass = password.getText().toString();
            if (mail.isEmpty() || !mail.contains("@") || !mail.contains("usthb")) {
                //email.setError("Please enter a valid USTHB email address");
                Toast.makeText(getApplicationContext(), "Please enter a valid USTHB email address", Toast.LENGTH_SHORT).show();
                return false;
            }
            if (pass.isEmpty() || pass.length() < 2) {
                //password.setError("Please enter a valid password");
                Toast.makeText(getApplicationContext(), "Please enter a valid password", Toast.LENGTH_SHORT).show();
                return false;
            }
            return true;
    }

}