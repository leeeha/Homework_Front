import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.gdsc.homework.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import org.w3c.dom.Text;

import java.util.Objects;

public class NewTask extends BottomSheetDialogFragment {
    public static final String TAG = "ActionBottomDialog";

    private EditText edtTask;
    private Button btnSave;
    boolean inUpdate = false;

    public static NewTask newInstance(){
        return new NewTask();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL, R.style.DialogStyle);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_category_item, container, false);
        Objects.requireNonNull(getDialog()).getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        edtTask = requireView().findViewById(R.id.edtTask);
        btnSave = requireView().findViewById(R.id.btnSave);

        // todo: 사용자가 입력한 문자열을 저장하기

        final Bundle bundle = getArguments();
        if(bundle != null) { // 입력된 텍스트가 있어야 주황색 들어오도록
            inUpdate = true;
            String task = bundle.getString("task");
            edtTask.setText(task);
            if(task.length() > 0){
                btnSave.setTextColor(ContextCompat.getColor(requireContext(), R.color.orange));
            }
        }

        edtTask.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int st, int cnt, int end) {

            }

            @Override
            public void onTextChanged(CharSequence s, int st, int before, int cnt) {
                // 내용이 있어야만 버튼 사용이 가능하도록
                if(s.toString().equals("")){
                    btnSave.setEnabled(false);
                    btnSave.setTextColor(Color.GRAY);
                }else{
                    btnSave.setEnabled(true);
                    btnSave.setTextColor(ContextCompat.getColor(requireContext(), R.color.orange));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edtTask.getText().toString();
                if(inUpdate){ // 입력한 텍스트가 있으면
                    // 그 내용을 디비의 항목에 적용

                }else{ // 아직 입력된 텍스트는 없지만, 추가 버튼을 누른 경우


                }

                // 저장 버튼 누르고나서 다이얼로그 없애기
                dismiss();
            }
        });
    }
}
