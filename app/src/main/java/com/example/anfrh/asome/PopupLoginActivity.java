package com.example.anfrh.asome;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.Nullable;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PopupLoginActivity extends Activity {

    EditText et_email; // 사용자의 이메일 주소를 입력받는 edittext
    EditText et_password;  // 사용자의 비밀번호를 입력받는 edittext
    Button bt_login; // 버튼 클릭시 데이터 넘어감.
    TextView tv_register; // 이메일로 로그인하는 버튼입니다.

    String user_email,user_password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_popup_login);

        et_email = (EditText) findViewById(R.id.et_email);
        et_password = (EditText) findViewById(R.id.et_password);
        tv_register = (TextView) findViewById(R.id.tv_register);
        bt_login = (Button) findViewById(R.id.bt_login);

        // 이메일로 회원가입 클릭 시
        // 회원가입 화면으로 이동
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(getApplicationContext(),UserRegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });


        // 로그인 버튼 클릭 시 로그인 프로세스 진행
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User_Login();
            }
        });
    }


    // [목적] : 사용자의 이메일, 비밀번호가 정규식에 맞는지 체크하고 정규식처리에 문제가 없다면 저장되어있는값과 서버에 값을 비교해서 로그인을 진행합니다.
    // [경로] : 경로는 LogincheckAsync에서 자체로그인이기 때문에
    // http://www.giljabee.com/api/android_api/login/GET/giljabee_login.php로 이동합니다.
    public void User_Login() {

        // 이메일, 비밀번호 형식이 맞지 않을 때 형식에 맞지않는다라는 메시지를 출력하고 버튼을 다시 활성화 합니다.
        if (!validate()) {
            Toast.makeText(getBaseContext(), "형식에 맞지 않습니다.", Toast.LENGTH_LONG).show();
            bt_login.setEnabled(true);
            return;
        }

        bt_login.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(PopupLoginActivity.this, R.style.com_facebook_auth_dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("로그인 중입니다." );
        progressDialog.show();

        user_email = et_email.getText().toString();
        user_password = et_password.getText().toString();

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        bt_login.setEnabled(true);
                        setResult(RESULT_OK, null);
                        loginMemberURLs();
                        // onSignupFailed();
                        progressDialog.dismiss();
                    }
                }, 500);
    }


    // [목적] : 사용자가 입력한 email, password의 정규식이 맞는지 맞지않는지 체크합니다.
    //         email, password에 형식이 맞지않다면 하단에 설명처럼 메시지를 남깁니다.
    public boolean validate() {
        boolean valid = true;

        user_email = et_email.getText().toString();
        user_password = et_password.getText().toString();

        //[조건문 프로세스]사용자가 입력한 이메일이 값이 없거나 형식에 맞지않으면 vaild값을 false를 줘서 일치하지 않는다라는 값을 주게됩니다.
        //               valid가 true라면 이메일은 정규식 검사가 정상적으로 처리된겁니다.
        if (user_email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(user_email).matches()) {
            et_email.setError("이메일 형식에 맞게 입력해주세요.");
            valid = false;
        } else {
            et_email.setError(null);
        }

        //[조건문 프로세스] 사용자가 입력한 패스워드 값이 없거나 형식에 맞지않으면 vaild값을 false를 줘서 일치하지 않는다라는 값을 주게됩니다.
        //                valid가 true라면 패스워드는 정규식 검사가 정상적으로 처리된겁니다.
        if (user_password.isEmpty() || user_password.length() < 8 ) {
            et_password.setError("8글자 이상으로 입력해주세요.");
            valid = false;
        } else {
            et_password.setError(null);
        }

        return valid;
    }

    // [목적] : 사용자가 입력한 email, password를 서버 DB의 user테이블에 값이 일치하는지 아닌지 여부를 확인하기 위해서
    //          http통신을 사용하여 값을 전달하기위해 사용합니다.
    private void loginMemberURLs() {
 /*       LoginCheckAsync async = new LoginCheckAsync(this, user_email, user_password, "Giljabee", "Gil", this);
        async.execute();*/
    }
}
