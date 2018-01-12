package zx.com.smallicon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import zx.com.smallicon.view.CoverManager;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        CoverManager.getInstance().init(this);

        CoverManager.getInstance().setMaxDragDistance(350);
        CoverManager.getInstance().setEffectDuration(150);
    }
}
