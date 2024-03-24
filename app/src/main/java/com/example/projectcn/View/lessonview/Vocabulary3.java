package com.example.projectcn.View.lessonview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectcn.R;

import java.util.ArrayList;

public class Vocabulary3 extends AppCompatActivity {
    ListView listviewimp;
    SearchView searchView;
    ArrayList<String> arrayCourse;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vocabularyview3);
        listviewimp = (ListView) findViewById(R.id.listviewimp);
        searchView = findViewById(R.id.editTextSearch);
        arrayCourse = new ArrayList<>();
        arrayCourse.add("Important - Quan trọng (Adjective)");
        arrayCourse.add("Words - Từ ngữ (Noun)");
        arrayCourse.add("Language - Ngôn ngữ (Noun)");
        arrayCourse.add("Vocabulary - Từ vựng (Noun)");
        arrayCourse.add("Communication - Giao tiếp (Noun)");
        arrayCourse.add("Understanding - Hiểu biết (Noun)");
        arrayCourse.add("Knowledge - Kiến thức (Noun)");
        arrayCourse.add("Meaningful - Có ý nghĩa (Adjective)");
        arrayCourse.add("Significant - Quan trọng (Adjective)");
        arrayCourse.add("Essential - Cần thiết (Adjective)");
        arrayCourse.add("Grammar - Ngữ pháp (Noun)");
        arrayCourse.add("Context - Ngữ cảnh (Noun)");
        arrayCourse.add("Synonym - Từ đồng nghĩa (Noun)");
        arrayCourse.add("Antonym - Từ trái nghĩa (Noun)");
        arrayCourse.add("Connotation - Ý nghĩa cảm xúc (Noun)");
        arrayCourse.add("Pronunciation - Phát âm (Noun)");
        arrayCourse.add("Usage - Sử dụng (Noun)");
        arrayCourse.add("Fluency - Thành thạo (Noun)");
        arrayCourse.add("Articulation - Sự diễn đạt (Noun)");
        arrayCourse.add("Example - Ví dụ (Noun)");
        arrayCourse.add("Cultivate - Nuôi dưỡng (Verb)");
        arrayCourse.add("Enhance - Nâng cao (Verb)");
        arrayCourse.add("Eloquent - Lưu loát (Adjective)");
        arrayCourse.add("Precise - Chính xác (Adjective)");
        arrayCourse.add("Comprehensive - Toàn diện (Adjective)");
        arrayCourse.add("Innovative - Đổi mới (Adjective)");
        arrayCourse.add("Refine - Sửa lại (Verb)");
        arrayCourse.add("Elaborate - Tường thuật chi tiết (Verb)");
        arrayCourse.add("Evaluate - Đánh giá (Verb)");
        arrayCourse.add("Examine - Kiểm tra (Verb)");
        arrayCourse.add("Comprehend - Hiểu biết (Verb)");
        arrayCourse.add("Infer - Suy luận (Verb)");
        arrayCourse.add("Validate - Xác nhận (Verb)");
        arrayCourse.add("Modify - Sửa đổi (Verb)");
        arrayCourse.add("Revise - Điều chỉnh (Verb)");
        arrayCourse.add("Analyze - Phân tích (Verb)");
        arrayCourse.add("Illuminate - Làm sáng tỏ (Verb)");
        arrayCourse.add("Manifest - Biểu hiện (Verb)");
        arrayCourse.add("Augment - Tăng cường (Verb)");
        arrayCourse.add("Exemplify - Làm mẫu (Verb)");
        arrayCourse.add("Discern - Phân biệt (Verb)");
        arrayCourse.add("Elucidate - Giải thích (Verb)");
        arrayCourse.add("Endorse - Tán thành (Verb)");
        arrayCourse.add("Fabricate - Chế tạo (Verb)");
        arrayCourse.add("Generate - Tạo ra (Verb)");
        arrayCourse.add("Hypothesize - Giả định (Verb)");
        arrayCourse.add("Integrate - Tích hợp (Verb)");
        arrayCourse.add("Justify - Bào chữa (Verb)");
        arrayCourse.add("Leverage - Tận dụng (Verb)");
        ArrayAdapter adapter = new ArrayAdapter(
                Vocabulary3.this,
                android.R.layout.simple_list_item_1,
                arrayCourse);
        listviewimp.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Handle the submission if needed
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Filter the list based on the user input
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}
