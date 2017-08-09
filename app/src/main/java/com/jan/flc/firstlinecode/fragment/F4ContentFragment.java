package com.jan.flc.firstlinecode.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jan.flc.firstlinecode.R;
import com.jan.flc.firstlinecode.data.DouyuF4;

/**
 * Created by huangje on 17-3-14.
 */

public class F4ContentFragment extends Fragment {

    private int id;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        id = getArguments().getInt("Id");
        View root = inflater.inflate(R.layout.fragment_f4content, container, false);
        TextView name = (TextView) root.findViewById(R.id.tv);
        Button button = (Button) root.findViewById(R.id.weiboBtn);
        ImageView image = (ImageView) root.findViewById(R.id.iv);
        name.setText(DouyuF4.NAMES[id]);
        image.setImageResource(DouyuF4.IMAGES_BIG[id]);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                F4WeiboFragment fragment = new F4WeiboFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("Id", id);
                fragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.rightFragment, fragment).commit();
            }
        });
        return root;
    }
}
