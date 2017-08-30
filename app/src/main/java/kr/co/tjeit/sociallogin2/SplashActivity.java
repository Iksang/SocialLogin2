package kr.co.tjeit.sociallogin2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kr.co.tjeit.sociallogin2.util.ContextUtil;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        bindViews();
        setupEvents();
        setValues();
        startProperActivity();
    }
//        적절한 액티비티를 시작하도록 해주는 메쏘드.
//    1. 로그인이 되어있는 상태라면 MainActivity로 이동
//    2. 로그인이 되어있지 않다면, LoginActivity로 이동
//    이 두가지의 동작은 2초 후에 발생
//    이동한 후에는 액티비티 종료
    void startProperActivity() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;

                if(ContextUtil.getLoginUser(mContext)==null){
                    intent = new Intent(mContext, LoginActivity.class);
                }
                else{
                    intent = new Intent(mContext, MainActivity.class);
                }
                startActivity(intent);
                finish();
            }
        },2000);
    }


    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {

    }
}
