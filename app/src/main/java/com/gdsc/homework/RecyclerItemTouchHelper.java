package com.gdsc.homework;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.gdsc.homework.adapter.MyAdpater;

// 수정, 완료 버튼은 개인 탭에만 있으면 되고
// 전체 탭은 요일별 담당자를 확인하는 용도로만 쓰자.
// 아이템 수정, 완료는 개인 탭에서만 가능해!!!
public class RecyclerItemTouchHelper extends ItemTouchHelper.SimpleCallback {
    MyAdpater adapter;

    public RecyclerItemTouchHelper(MyAdpater adapter){
        super(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        this.adapter = adapter;
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView,
                          @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        final int position = viewHolder.getAdapterPosition();
        if(direction == ItemTouchHelper.LEFT){
            AlertDialog.Builder builder = new AlertDialog.Builder(adapter.getContext());
            builder.setTitle("Complete Task");
            builder.setMessage(""); // 완료 아이콘으로 바꾸자.
            builder.setPositiveButton("Confirm",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            adapter.completeItem(position);
                        }
                    });
            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    adapter.notifyItemChanged(viewHolder.getAdapterPosition());
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }else{
            adapter.editItem(position);
        }
    }

    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView,
                            @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY,
                            int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

        Drawable icon;
        ColorDrawable background;
        int backgroundCornerOffset = 20;
        View itemView = viewHolder.itemView;

        if(dX > 0){
            icon = ContextCompat.getDrawable(adapter.getContext(), R.drawable.ic_btn_edit);
            background = new ColorDrawable(ContextCompat.getColor(adapter.getContext(), R.color.white));
        }else{
            icon = ContextCompat.getDrawable(adapter.getContext(), R.drawable.ic_btn_check);
            background = new ColorDrawable(ContextCompat.getColor(adapter.getContext(), R.color.orange));
        }

        int iconMargin = (itemView.getHeight() - icon.getIntrinsicHeight()) / 2;
        int iconTop = itemView.getTop() + (itemView.getHeight() - icon.getIntrinsicHeight()) / 2;
        int iconButton = iconTop + icon.getIntrinsicHeight();

        if(dX > 0){ // right
            int iconLeft = itemView.getLeft() + iconMargin;
            int iconRight = itemView.getLeft() + iconMargin + icon.getIntrinsicWidth();
            icon.setBounds(iconLeft, iconTop, iconRight, iconButton);

            background.setBounds(itemView.getLeft(), itemView.getTop(), itemView.getLeft() + ((int)dX) + backgroundCornerOffset, itemView.getBottom());
        } else if(dX < 0) { // left
            int iconLeft = itemView.getRight() - iconMargin - icon.getIntrinsicHeight();
            int iconRight = itemView.getRight() - iconMargin;
            icon.setBounds(iconLeft, iconTop, iconRight, iconButton);

            background.setBounds(itemView.getRight() + (int)dX - backgroundCornerOffset, itemView.getTop(),
                    itemView.getRight(), itemView.getBottom());
        }else{
            background.setBounds(0, 0,0,0);
        }

        background.draw(c);
        icon.draw(c);
    }

}
