package com.example.projectcn.View.lessonview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectcn.R;

import java.util.ArrayList;

public class Vocabulary5 extends AppCompatActivity {
    ListView listviewcommunicate;
    SearchView searchView;
    ArrayList<String> arrayCourse;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vocabularyview5);
        listviewcommunicate = (ListView) findViewById(R.id.listviewcommunicate);
        searchView = findViewById(R.id.editTextSearch);
        arrayCourse = new ArrayList<>();
        arrayCourse.add("Speak (verb) - nói");
        arrayCourse.add("Listen (verb) - nghe");
        arrayCourse.add("Conversation (noun) - cuộc trò chuyện");
        arrayCourse.add("Message (noun, verb) - tin nhắn, gửi tin nhắn");
        arrayCourse.add("Chat (noun, verb) - trò chuyện, nói chuyện");
        arrayCourse.add("Discuss (verb) - thảo luận");
        arrayCourse.add("Express (verb) - diễn đạt");
        arrayCourse.add("Dialogue (noun) - đối thoại");
        arrayCourse.add("Communicate (verb) - giao tiếp");
        arrayCourse.add("Interact (verb) - tương tác");
        arrayCourse.add("Convey (verb) - truyền đạt");
        arrayCourse.add("Converse (verb) - nói chuyện");
        arrayCourse.add("Articulate (verb, adjective) - phát âm rõ ràng, diễn đạt rõ ràng");
        arrayCourse.add("Confer (verb) - hội ý, thảo luận");
        arrayCourse.add("Debate (noun, verb) - tranh luận, cuộc tranh luận");
        arrayCourse.add("Negotiate (verb) - đàm phán");
        arrayCourse.add("Persuade (verb) - thuyết phục");
        arrayCourse.add("Clarify (verb) - làm rõ");
        arrayCourse.add("Understand (verb) - hiểu");
        arrayCourse.add("Explain (verb) - giải thích");
        arrayCourse.add("Share (verb) - chia sẻ");
        arrayCourse.add("Broadcast (verb, noun) - phát sóng, chương trình truyền hình, truyền thanh");
        arrayCourse.add("Collaborate (verb) - cộng tác");
        arrayCourse.add("Engage (verb) - tham gia");
        arrayCourse.add("Conveyance (noun) - sự truyền đạt");
        arrayCourse.add("Gesture (noun, verb) - cử chỉ, ra dấu hiệu");
        arrayCourse.add("Translate (verb) - dịch");
        arrayCourse.add("Signify (verb) - biểu thị, ý nghĩa");
        arrayCourse.add("Suggest (verb) - gợi ý");
        arrayCourse.add("Convey (verb) - truyền đạt");
        arrayCourse.add("Elaborate (verb, adjective) - mở rộng, chi tiết");
        arrayCourse.add("Utter (verb, adjective) - phát ngôn, hoàn toàn");
        arrayCourse.add("Correspond (verb) - tương ứng, trao đổi");
        arrayCourse.add("Greet (verb) - chào hỏi");
        arrayCourse.add("React (verb) - phản ứng");
        arrayCourse.add("Inquire (verb) - hỏi, điều tra");
        arrayCourse.add("Compliment (noun, verb) - lời khen, khen ngợi");
        arrayCourse.add("Criticize (verb) - phê phán");
        arrayCourse.add("Advise (verb) - tư vấn");
        arrayCourse.add("Empathize (verb) - cảm thông");
        arrayCourse.add("Argue (verb) - tranh cãi");
        arrayCourse.add("Notify (verb) - thông báo");
        arrayCourse.add("Report (verb, noun) - báo cáo, thông tin");
        arrayCourse.add("Conduct (verb, noun) - thực hiện, hành vi");
        arrayCourse.add("Correspondence (noun) - thư từ, tương ứng");
        arrayCourse.add("Stammer (verb, noun) - nói lắp bắp, lắp lễnh");
        arrayCourse.add("Brief (verb, adjective) - tóm tắt, ngắn gọn");
        arrayCourse.add("Announce (verb) - thông báo");
        arrayCourse.add("Interpret (verb) - giải thích, phiên dịch");
        arrayCourse.add("Silent (adjective) - im lặng");

        ArrayAdapter adapter = new ArrayAdapter(
                Vocabulary5.this,
                android.R.layout.simple_list_item_1,
                arrayCourse);
        listviewcommunicate.setAdapter(adapter);
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
