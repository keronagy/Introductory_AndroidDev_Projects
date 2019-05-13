package com.example.kyrillosnagywadieyas.lab6;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class FragmentB extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.v("onCreateViewFragment","onCreateViewFragment");
        View view =inflater.inflate(R.layout.fragment_b,container,false);

        return view;
    }
}
