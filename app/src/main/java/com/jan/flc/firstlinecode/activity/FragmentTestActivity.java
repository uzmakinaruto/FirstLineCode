package com.jan.flc.firstlinecode.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jan.flc.firstlinecode.R;
import com.jan.flc.firstlinecode.fragment.F4ContentFragment;
import com.jan.flc.firstlinecode.fragment.F4ListFragment;
import com.jan.flc.firstlinecode.fragment.F4WeiboFragment;

public class FragmentTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmenttest_activity);
        getSupportFragmentManager().beginTransaction().replace(R.id.leftFragment, new F4ListFragment()).commit();
        if (findViewById(R.id.rightFragment) != null) {
            F4ContentFragment fragment = new F4ContentFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("Id", 0);
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.rightFragment, fragment).commit();
        }
    }
}
