package kr.co.tjeit.sociallogin2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import kr.co.tjeit.sociallogin2.util.ContextUtil;

public class LoginActivity extends BaseActivity {

    private com.facebook.login.widget.LoginButton loginbutton;

    CallbackManager cm;
    ProfileTracker pt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindViews();
        setupEvents();
        setValues();

    }
//            XML에 설치된 페이스북 로그인 버튼 누르면
//        1. 실제로 로그인 반영 (버튼의 Text가 "로그아웃" 으로 바뀌는걸 확인)
//        2. 로그인 된 프로필을 추적후 저장 -> ContextUtil 활용  -> MainActivity로 이동
    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {
        cm = CallbackManager.Factory.create();
        loginbutton.registerCallback(cm, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

        pt = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                if(currentProfile != null){
                    ContextUtil.login(mContext,currentProfile.getId(),currentProfile.getName()
                            ,currentProfile.getProfilePictureUri(500,500).toString());
                    Intent intent = new Intent(mContext, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        };
    }

//    화면이 완전히 종료되면, 프로필 추적 중지
    @Override
    protected void onDestroy() {
        super.onDestroy();
        pt.stopTracking();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        cm.onActivityResult(requestCode,resultCode,data);
    }

    @Override
    public void bindViews() {
        this.loginbutton = (LoginButton) findViewById(R.id.login_button);

    }
}
