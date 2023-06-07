package sg.edu.rp.c346.id22012732.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText task;
    Button btnAdd;
    Button btnClear;
    Button btnDelete;
    ListView lvTask;
    ArrayList<String> taskList;
    ArrayAdapter<String> taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        task = findViewById(R.id.task);
        btnAdd = findViewById(R.id.buttonAdd);
        btnClear = findViewById(R.id.buttonClear);
        btnDelete = findViewById(R.id.buttonDelete);
        lvTask = findViewById(R.id.listView);
        taskList = new ArrayList<>();
        taskAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);
        lvTask.setAdapter(taskAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String insertTask = task.getText().toString();
                taskList.add(insertTask);
                taskAdapter.notifyDataSetChanged();
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskList.clear();
                taskAdapter.notifyDataSetChanged();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String deleteTask = task.getText().toString();
                int position = taskList.indexOf(deleteTask);
                if (position != -1) {
                    taskList.remove(position);
                    taskAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}