package com.example.tell.adapter;

import android.content.Context;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tell.R;
import com.example.tell.entity.Email;

import java.io.Serializable;
import java.util.List;

public class EmailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<Email> datas;
    private OnItemClickListener click;


    public EmailAdapter(Context context, List<Email> datas) {
        this.mContext = context;
        this.datas = datas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_email_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;
        Email email = datas.get(position);
        vh.fro.setText(email.getFro());
        vh.sendto.setText(email.getSendto());
        vh.detail.setText(email.getDetail());
        vh.email=email;
//        email.setSendto(sendto.getText().toString());
//        email.setDetail(detail.getText().toString());
//        email.setFro(fro.getText().toString());


    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.click = onItemClickListener;
    }

     class ViewHolder extends RecyclerView.ViewHolder {
        private TextView sendto;
        private TextView detail;
        private TextView fro;
        private Email email;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            email = new Email();
            sendto = itemView.findViewById(R.id.sendTo);
            detail = itemView.findViewById(R.id.detail);
            fro = itemView.findViewById(R.id.fro);

            itemView.setOnClickListener(view -> {
                click.onItemClick(email);
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Serializable obj);
    }
}
