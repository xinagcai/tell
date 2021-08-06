package com.example.tell.fragment;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tell.R;
import com.example.tell.activity.DetailActivity;
import com.example.tell.adapter.EmailAdapter;
import com.example.tell.dao.DBOpenHelper;
import com.example.tell.entity.Email;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EmailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EmailFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private DBOpenHelper helper;
    private EmailAdapter emailAdapter;
    private List<Email> emails;

    public EmailFragment() {
        // Required empty public constructor
    }

    public static EmailFragment newInstance() {
        EmailFragment fragment = new EmailFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_email, container, false);
        recyclerView = v.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        getEmailList();
        emailAdapter = new EmailAdapter(getActivity(), emails);
        recyclerView.setAdapter(emailAdapter);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        emailAdapter.setOnItemClickListener(obj -> {
            Email email = (Email) obj;
            Intent intent = new Intent(getContext(), DetailActivity.class);
            intent.putExtra("emailEntity", email);
            startActivity(intent);
        });
    }

    private void getEmailList() {
        helper = new DBOpenHelper(getContext());
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from email where sendto = ?", new String[]{"香菜收"});
        emails = new ArrayList<>();
        if (cursor.getCount() == 0) {
            showToast("没有信息");
        } else {
            while (cursor.moveToNext()) {
                Email email = new Email();
                email.setFro(cursor.getString(cursor.getColumnIndex("fro")));
                email.setDetail(cursor.getString(cursor.getColumnIndex("detail")));
                email.setSendto(cursor.getString(cursor.getColumnIndex("sendto")));
                emails.add(email);
            }
            cursor.close();
            db.close();
        }
    }
}