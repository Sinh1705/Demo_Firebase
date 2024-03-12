package com.example.demo_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private EditText edtData;
    private Button btnPushData , btnGetData;
    private TextView txtgetData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtData = findViewById(R.id.edt_data);
        btnPushData = findViewById(R.id.btn_pushData);
        btnGetData = findViewById(R.id.btn_getData);
        txtgetData = findViewById(R.id.tv_get_data);

        btnPushData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickPush();
            }
        });

        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readDatabase();
            }
        });
    }

    private void onClickPush() {
        //wirte and push len firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message"); //key

        myRef.setValue(edtData.getText().toString().trim()); //value
    }

    private void readDatabase(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.addValueEventListener(new ValueEventListener() {

            //hàm nhận dữ liệu
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                txtgetData.setText(value);
            }


            //khi có trường hợp lỗi
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //demo trên nhánh 2
            }

        });

    }
}