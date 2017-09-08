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

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        TextView txtAlready = (TextView) findViewById(R.id.tv_already);
        cstmTvAlready(txtAlready);
        Button btnLanjut = (Button) findViewById(R.id.btn_lanjut);
        btnLanjut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),
                        MainActivity.class);
                startActivity(i);
            }
        });
    }

    private void cstmTvAlready(TextView view) {
        SpannableStringBuilder spanTxt = new SpannableStringBuilder(
                "Sudah pernah daftar?? ");
        spanTxt.append("Klik disini");
        spanTxt.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(getApplicationContext(), "Login",
                        Toast.LENGTH_SHORT).show();
                Intent i = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(i);
            }
        }, spanTxt.length() - "Klik disini".length(), spanTxt.length(), 0);
        view.setMovementMethod(LinkMovementMethod.getInstance());
        view.setText(spanTxt, TextView.BufferType.SPANNABLE);
        view.setTextSize(18);
    }
}
