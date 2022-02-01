package com.gdsc.homework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gdsc.homework.R;
import com.gdsc.homework.model.Person;

import java.util.ArrayList;

// Person 배열을 리사이클러뷰로 보여주자!
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private final ArrayList<Person> localDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvNickName;
        TextView tvWorkList;

        ViewHolder(View itemView){
            super(itemView);

            tvName = itemView.findViewById(R.id.name);
            tvNickName = itemView.findViewById(R.id.nickName);
            tvWorkList = itemView.findViewById(R.id.workList);
        }
    }

    public CustomAdapter(ArrayList<Person> dataSet) {
        localDataSet = dataSet;
    }

    @NonNull
    @Override // 아이템뷰 레이아웃을 인플레이트 시키고, 그 아이템뷰를 저장하는 뷰홀더 객체 생성
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override // 뷰홀더의 아이템뷰에 있는 모든 뷰에 대해 바인딩 (데이터 표시)
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        Person person = localDataSet.get(position);
        holder.tvName.setText(person.getName());
        holder.tvNickName.setText(person.getNickName());
        //holder.tvWorkList.setText(person.getWorkList()); // 임시 방편으로 캐스팅
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
