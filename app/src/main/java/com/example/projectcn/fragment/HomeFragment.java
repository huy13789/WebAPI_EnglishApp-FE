package com.example.projectcn.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectcn.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.ml.common.modeldownload.FirebaseModelDownloadConditions;
import com.google.firebase.ml.naturallanguage.FirebaseNaturalLanguage;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslateLanguage;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslator;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslatorOptions;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // Khai báo các thành phần của giao diện
    Spinner fromSpinner, toSpinner;
    TextInputEditText sourceText;
    ImageView micTV;
    MaterialButton translateBtn;
    TextView translateTV;
    String[] languages = {"Select language", "English", "Vietnamese"};
    private static final int REQUEST_PERMISSION_CODE = 1;
    int fromLanguageCode, toLanguageCode = 0;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Tìm các thành phần giao diện bằng ID
        fromSpinner = view.findViewById(R.id.idFromSpinner);
        toSpinner = view.findViewById(R.id.idToSpinner);
        sourceText = view.findViewById(R.id.idEditSource);
        micTV = view.findViewById(R.id.idIVMic);
        translateBtn = view.findViewById(R.id.idBtnTranslation);
        translateTV = view.findViewById(R.id.idTranslated);

        // Tạo adapter cho Spinner và thiết lập Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), R.layout.spinner_item, languages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromSpinner.setAdapter(adapter);
        toSpinner.setAdapter(adapter);

        // Xử lý sự kiện khi người dùng chọn ngôn ngữ nguồn
        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fromLanguageCode = getLanguageCode(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Xử lý sự kiện khi người dùng chọn ngôn ngữ đích
        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                toLanguageCode = getLanguageCode(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Xử lý sự kiện khi người dùng nhấn nút Translate
        translateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                translateText();
            }
        });

        return view;
    }

    // Hàm dịch văn bản từ ngôn ngữ nguồn sang ngôn ngữ đích
    private void translateText() {
        String textToTranslate = sourceText.getText().toString();

        // Kiểm tra nếu người dùng chưa chọn ngôn ngữ
        if (fromLanguageCode == 0 || toLanguageCode == 0) {
            Toast.makeText(requireContext(), "Please select source and target languages", Toast.LENGTH_SHORT).show();
            return;
        }

        // Tạo các điều kiện download model từ Firebase ML Kit
        FirebaseTranslatorOptions options = new FirebaseTranslatorOptions.Builder()
                .setSourceLanguage(fromLanguageCode)
                .setTargetLanguage(toLanguageCode)
                .build();
        FirebaseTranslator translator = FirebaseNaturalLanguage.getInstance().getTranslator(options);
        FirebaseModelDownloadConditions conditions = new FirebaseModelDownloadConditions.Builder().build();

        // Download model nếu cần và dịch văn bản
        translator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        translator.translate(textToTranslate)
                                .addOnSuccessListener(new OnSuccessListener<String>() {
                                    @Override
                                    public void onSuccess(String translatedText) {
                                        // Hiển thị văn bản đã dịch lên TextView
                                        translateTV.setText(translatedText);
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(requireContext(), "Translation failed", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(requireContext(), "Failed to download language model", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    // Hàm trả về mã ngôn ngữ tương ứng với vị trí trong Spinner
    private int getLanguageCode(int position) {
        switch (position) {
            case 1:
                return FirebaseTranslateLanguage.EN;
            case 2:
                return FirebaseTranslateLanguage.VI;
            default:
                return 0;
        }
    }
}
