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
        TextView tvWorkList;

        // 뷰홀더는 리스트의 한 아이템 뷰를 나타내며 필요에 따라 재사용됨.
        ViewHolder(View itemView){
            super(itemView);

            tvName = itemView.findViewById(R.id.name);
            tvWorkList = itemView.findViewById(R.id.workList);
        }
    }

    public CustomAdapter(ArrayList<Person> dataSet) {
        localDataSet = dataSet;
    }

    @NonNull
    @Override // 재사용할 수 있는 뷰홀더가 없을 때, 새로운 뷰홀더 객체 생성
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_item_family, parent, false);
        return new ViewHolder(view);
    }

    @Override // 뷰홀더의 아이템뷰에 있는 모든 뷰의 내용 변경 (바인딩)
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        Person person = localDataSet.get(position);
        holder.tvName.setText(person.getName());
        //holder.tvWorkList.setText(person.getWorkList());
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
