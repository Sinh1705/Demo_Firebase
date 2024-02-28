package com.example.demo_firebase;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.SignInMethodQueryResult;

public class SignUpActivity extends AppCompatActivity {
    
    private EditText edtEmail , edtPassword;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        
        edtEmail = findViewById(R.id.edt_singup_email);
        edtPassword = findViewById(R.id.edt_singup_pass);
        btnSignUp = findViewById(R.id.btn_signup);
        intiListener();
    }

    private void intiListener() {
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickSignUp();
            }
        });
    }

    private void onClickSignUp() {
        String stremail = edtEmail.getText().toString().trim();
        String strpass = edtPassword.getText().toString().trim();
        FirebaseAuth auth = FirebaseAuth.getInstance();

        // Kiểm tra xem địa chỉ email đã được đăng ký hay chưa
        auth.fetchSignInMethodsForEmail(stremail)
                .addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
                    @Override
                    public void onComplete(@NonNull Task<SignInMethodQueryResult> task) {
                        if (task.isSuccessful()) {
                            SignInMethodQueryResult result = task.getResult();
                            if (result != null && result.getSignInMethods() != null && !result.getSignInMethods().isEmpty()) {
                                // Email đã tồn tại, hiển thị thông báo hoặc thực hiện hành động phù hợp
                                Toast.makeText(SignUpActivity.this, "Email đã tồn tại", Toast.LENGTH_SHORT).show();
                            } else {
                                // Email chưa được đăng ký, tiếp tục quá trình đăng ký
                                auth.createUserWithEmailAndPassword(stremail, strpass)
                                        .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                                            @Override
                                            public void onComplete(@NonNull Task<AuthResult> task) {
                                                if (task.isSuccessful()) {
                                                    // Quá trình đăng ký thành công
                                                    FirebaseUser firebaseUser = auth.getCurrentUser();
                                                    UpdateUI(firebaseUser);
                                                } else {
                                                    // Quá trình đăng ký thất bại
                                                    Toast.makeText(SignUpActivity.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                                    UpdateUI(null);
                                                }
                                            }
                                        });
                            }
                        } else {
                            // Xử lý lỗi nếu có
                            Exception exception = task.getException();
                            Toast.makeText(SignUpActivity.this, "Lỗi: " + exception.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }



    private void UpdateUI(FirebaseUser user ){

        if(user != null){
            Intent intent = new Intent(SignUpActivity.this,SigninActivity.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(SignUpActivity.this,"Chưa nhập thông tin đăng ký",Toast.LENGTH_SHORT).show();
        }
    }
}