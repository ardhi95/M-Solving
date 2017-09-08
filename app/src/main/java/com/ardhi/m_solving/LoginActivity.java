package com.ardhi.m_solving;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView txtLupa = (TextView) findViewById(R.id.tv_lupa);
        TextView txtRegis = (TextView) findViewById(R.id.tv_regis);
        cstmTvLupa(txtLupa);
        cstmTvRegis(txtRegis);
        Button btnLanjut = (Button) findViewById(R.id.button);
        btnLanjut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),
                        MainActivity.class);
                startActivity(i);
            }
        });
    }
    private void cstmTvLupa(TextView view) {
        SpannableStringBuilder spanTxt = new SpannableStringBuilder(
                "Lupa pasword mas? ");
        spanTxt.append("Klik disini");
        spanTxt.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(getApplicationContext(), "Ganti Pasword",
                        Toast.LENGTH_SHORT).show();
            }
        }, spanTxt.length() - "Klik disini".length(), spanTxt.length(), 0);
        view.setMovementMethod(LinkMovementMethod.getInstance());
        view.setText(spanTxt, TextView.BufferType.SPANNABLE);
        view.setTextSize(18);
    }
    private void cstmTvRegis(TextView view) {
        SpannableStringBuilder spanTxt = new SpannableStringBuilder(
                "Belum daftar?? ");
        spanTxt.append("Klik disini");
        spanTxt.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(getApplicationContext(), "Daftar",
                        Toast.LENGTH_SHORT).show();
                Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        }, spanTxt.length() - "Klik disini".length(), spanTxt.length(), 0);
        view.setMovementMethod(LinkMovementMethod.getInstance());
        view.setText(spanTxt, TextView.BufferType.SPANNABLE);
        view.setTextSize(18);
    }
}
