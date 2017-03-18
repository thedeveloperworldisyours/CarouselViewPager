package com.thedeveloperworldisyours.carouselviewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomFragment extends Fragment {

    public static Fragment newInstance(MainActivity context, int position, float scale) {
        Bundle bundle = new Bundle();
        bundle.putInt("pos", position);
        bundle.putFloat("scale", scale);
        return Fragment.instantiate(context, CustomFragment.class.getName(), bundle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        LinearLayout linearLayout = (LinearLayout)
                inflater.inflate(R.layout.item, container, false);

        int position = this.getArguments().getInt("position");
        TextView tv = (TextView) linearLayout.findViewById(R.id.item_text);
        tv.setText("Position = " + position);

        CustomLinearLayout root = (CustomLinearLayout) linearLayout.findViewById(R.id.root);
        float scale = this.getArguments().getFloat("scale");
        root.setScaleBoth(scale);

        return linearLayout;
    }
}
