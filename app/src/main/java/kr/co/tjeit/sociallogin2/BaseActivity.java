package kr.co.tjeit.sociallogin2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by tjoeun on 2017-08-30.
 */

public abstract class BaseActivity extends AppCompatActivity {
    Context mContext = this;
    public abstract void setupEvents();
    public abstract void setValues();
    public abstract void bindViews();
}
