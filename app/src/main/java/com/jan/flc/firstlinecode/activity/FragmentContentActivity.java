package com.jan.flc.firstlinecode.activity;

import android.os.Bundle;

import com.jan.flc.firstlinecode.R;
import com.jan.flc.firstlinecode.fragment.F4ContentFragment;

/**
 * Created by huangje on 17-3-14.
 */

public class FragmentContentActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmenttest_content_activity);
        int id = getIntent().getIntExtra("Id", 0);
        F4ContentFragment fragment = new F4ContentFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("Id", id);
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.rightFragment, fragment).commit();
    }
}
