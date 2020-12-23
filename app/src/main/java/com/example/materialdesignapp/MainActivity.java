package com.example.materialdesignapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

public class MainActivity extends AppCompatActivity implements TextWatcher {

    @Nullable
    @BindView(R.id.next_button)
    MaterialButton loginButton;

    @BindView(R.id.userName)
    TextInputEditText userName;

    @BindView(R.id.password_edit_text)
    TextInputEditText password;

    @BindView(R.id.userNameLayout)
    TextInputLayout userNameLayout;

    @BindView(R.id.password_text_input_layout)
    TextInputLayout passwordLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        ButterKnife.bind(this);

       //On text change listener
        userName.addTextChangedListener(this);

        password.addTextChangedListener(this);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userName.getText().toString().isEmpty()){
                    userNameLayout.setError("Enter User Name");
                    return;
                }
                if(password.getText().toString().isEmpty()){
                    passwordLayout.setError("Enter Password");
                    return;
                }
                startActivity(new Intent(getApplicationContext(), HomePageActivity.class));
            }
        });
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if(s.hashCode() == userName.getText().hashCode()){
            userNameLayout.setError(null);
        }
        else if(s.hashCode() == password.getText().hashCode()){
            passwordLayout.setError(null);
        }
    }
}