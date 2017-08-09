package com.jan.flc.firstlinecode.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jan.flc.firstlinecode.R;
import com.jan.flc.firstlinecode.activity.FragmentContentActivity;
import com.jan.flc.firstlinecode.adapter.PersonLVAdapter;
import com.jan.flc.firstlinecode.data.DouyuF4;

import java.util.List;

/**
 * Created by huangje on 17-3-14.
 */

public class F4ListFragment extends Fragment {

    private List<DouyuF4> items = DouyuF4.getRandomPerson(20);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_f4list, container, false);
        ListView lv = (ListView) root.findViewById(R.id.lv);
        PersonLVAdapter adapter = new PersonLVAdapter(getActivity(), R.layout.item_person_hor, items);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (getActivity().findViewById(R.id.rightFragment) != null) {
                    F4ContentFragment fragment = new F4ContentFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt("Id", items.get(position).getId());
                    fragment.setArguments(bundle);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.rightFragment, fragment).commit();
                } else {
                    Intent intent = new Intent(getActivity(), FragmentContentActivity.class);
                    intent.putExtra("Id", items.get(position).getId());
                    startActivity(intent);
                }
            }
        });
        return root;
    }
}
