package com.wjc.learn.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wjc.learn.draw_view.BaseViewActivity;
import com.wjc.learn.R;


public class LoginActivity extends Activity implements LoginContract.View {

    TextInputEditText email;
    TextInputEditText password;
    Button button;
    LoginContract.Presenter presenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter(this);

        email = (TextInputEditText) findViewById(R.id.et_email);
        password = (TextInputEditText) findViewById(R.id.et_password);
        button = (Button) findViewById(R.id.btn_server_login);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                presenter.onServerLoginClick(email.getText().toString(),
//                        password.getText().toString());
                openMainActivity();
            }
        });

    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void openMainActivity() {
        Intent intent = BaseViewActivity.getStartIntent(LoginActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void onError(int msg) {
        String message = getString(msg);
        if (message == null) {
            showSnackBar(getString(R.string.some_error));
        } else {
            showSnackBar(message);
        }
    }

    private void showSnackBar(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, R.color.white));
        snackbar.show();
    }


}
