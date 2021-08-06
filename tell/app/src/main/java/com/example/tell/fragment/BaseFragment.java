package com.example.tell.fragment;

import android.content.Intent;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class BaseFragment  extends Fragment {
    public void showToast(String msg){
        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
    }

    public void navigation(Class cls){
        Intent in = new Intent(getActivity(),cls);
        startActivity(in);
    }

}
