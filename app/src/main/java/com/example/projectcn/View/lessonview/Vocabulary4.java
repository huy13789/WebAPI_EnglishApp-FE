package com.example.projectcn.View.lessonview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectcn.R;

import java.util.ArrayList;

public class Vocabulary4 extends AppCompatActivity {
    ListView listviewpopular;
    ArrayList<String> arrayCourse;
    ArrayAdapter<String> adapter;
    SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vocabularyview4);
        listviewpopular = (ListView) findViewById(R.id.listviewcommunicate);
        searchView = findViewById(R.id.editTextSearch);
        arrayCourse = new ArrayList<>();
        arrayCourse.add("Time (noun) - thời gian");
        arrayCourse.add("Love (noun, verb) - tình yêu, yêu");
        arrayCourse.add("Good (adjective) - tốt");
        arrayCourse.add("Man (noun) - người đàn ông");
        arrayCourse.add("Woman (noun) - người phụ nữ");
        arrayCourse.add("Day (noun) - ngày");
        arrayCourse.add("Year (noun) - năm");
        arrayCourse.add("Way (noun) - cách, đường");
        arrayCourse.add("Work (verb, noun) - làm việc, công việc");
        arrayCourse.add("Life (noun) - cuộc sống");
        arrayCourse.add("Child (noun) - đứa trẻ");
        arrayCourse.add("World (noun) - thế giới");
        arrayCourse.add("School (noun) - trường học");
        arrayCourse.add("Water (noun) - nước");
        arrayCourse.add("Food (noun) - thức ăn");
        arrayCourse.add("Friend (noun) - bạn bè");
        arrayCourse.add("Family (noun) - gia đình");
        arrayCourse.add("Money (noun) - tiền");
        arrayCourse.add("Job (noun) - công việc");
        arrayCourse.add("House (noun) - nhà");
        arrayCourse.add("Place (noun) - nơi");
        arrayCourse.add("Hand (noun) - bàn tay");
        arrayCourse.add("Problem (noun) - vấn đề");
        arrayCourse.add("Part (noun) - phần");
        arrayCourse.add("Head (noun) - đầu");
        arrayCourse.add("Eye (noun) - mắt");
        arrayCourse.add("Place (noun) - địa điểm");
        arrayCourse.add("Government (noun) - chính phủ");
        arrayCourse.add("Company (noun) - công ty");
        arrayCourse.add("Number (noun) - số");
        arrayCourse.add("Group (noun) - nhóm");
        arrayCourse.add("Problem (noun) - vấn đề");
        arrayCourse.add("Fact (noun) - sự thật");
        arrayCourse.add("Friend (noun) - bạn bè");
        arrayCourse.add("Love (verb, noun) - yêu, tình yêu");
        arrayCourse.add("City (noun) - thành phố");
        arrayCourse.add("Country (noun) - quốc gia");
        arrayCourse.add("President (noun) - tổng thống");
        arrayCourse.add("Month (noun) - tháng");
        arrayCourse.add("Business (noun) - kinh doanh");
        arrayCourse.add("Power (noun) - quyền lực");
        arrayCourse.add("Game (noun) - trò chơi");
        arrayCourse.add("Music (noun) - âm nhạc");
        arrayCourse.add("Problem (noun) - vấn đề");
        arrayCourse.add("Story (noun) - câu chuyện");
        arrayCourse.add("Case (noun) - trường hợp");
        arrayCourse.add("System (noun) - hệ thống");
        arrayCourse.add("Fact (noun) - sự thật");
        arrayCourse.add("Example (noun) - ví dụ");
        arrayCourse.add("Moment (noun) - khoảnh khắc");
        ArrayAdapter adapter = new ArrayAdapter(
                Vocabulary4.this,
                android.R.layout.simple_list_item_1,
                arrayCourse);
        listviewpopular.setAdapter(adapter);
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
