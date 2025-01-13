package com.example.pz_16;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<User> userList;
    private UserListAdapter userListAdapter;

    private FrameLayout userPanel;
    private TextView nameTextView, stateTextView, ageTextView;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация элементов
        ListView listView = findViewById(R.id.listView);
        userPanel = findViewById(R.id.userPanel);
        nameTextView = findViewById(R.id.NameTextView);
        stateTextView = findViewById(R.id.StateTextView);
        ageTextView = findViewById(R.id.AgeTextView);
        backButton = findViewById(R.id.backButton);

        // Инициализация данных
        initUserList();

        // Настройка адаптера
        userListAdapter = new UserListAdapter(this, userList);
        listView.setAdapter(userListAdapter);

        // Обработка кликов по элементам списка
        listView.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            User selectedUser = userList.get(position);
            showUserPanel(selectedUser);
        });

        // Обработка кнопки "Назад"
        backButton.setOnClickListener(v -> hideUserPanel());
    }

    private void initUserList() {
        userList = new ArrayList<>();
        userList.add(new User("Алексей", "Активный", 25));
        userList.add(new User("Мария", "Неактивный", 30));
        userList.add(new User("Дмитрий", "В сети", 22));
        userList.add(new User("Екатерина", "Не беспокоить", 28));
        userList.add(new User("Олег", "Оффлайн", 35));
    }

    private void showUserPanel(User user) {
        // Отображаем информацию о выбранном пользователе
        nameTextView.setText("Имя: " + user.getName());
        stateTextView.setText("Статус: " + user.getStatus());
        ageTextView.setText("Возраст: " + user.getAge());

        // Делаем панель видимой
        userPanel.setVisibility(View.VISIBLE);
    }

    private void hideUserPanel() {
        // Скрываем панель
        userPanel.setVisibility(View.GONE);
    }
}
