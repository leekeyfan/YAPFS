package cn.com.leco.welcome;

import android.content.Intent;
import android.os.Bundle;

import cn.com.leco.login.Login;
import cn.com.leco.welcome.slides.Slide_First;
import cn.com.leco.welcome.slides.Slide_Fourth;
import cn.com.leco.welcome.slides.Slide_Second;
import cn.com.leco.welcome.slides.Slide_Third;
import xyz.yhsj.library.activity.AppIntro;

public class Welcome_Guide extends AppIntro {
    @Override
    public void init(Bundle savedInstanceState) {
        addSlide(new Slide_First(), getApplicationContext());
        addSlide(new Slide_Second(), getApplicationContext());
        addSlide(new Slide_Third(), getApplicationContext());
        addSlide(new Slide_Fourth(), getApplicationContext());
    }

    @Override
    public void onSkipPressed() {

        startActivity(new Intent(Welcome_Guide.this, Login.class));
        finish();

    }

    @Override
    public void onDonePressed() {
        startActivity(new Intent(Welcome_Guide.this, Login.class));
        finish();
    }


}
