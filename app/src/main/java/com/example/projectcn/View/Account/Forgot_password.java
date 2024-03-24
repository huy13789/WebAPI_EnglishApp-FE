package com.example.projectcn.View.Account;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.projectcn.R;
import com.example.projectcn.interfaces.UserAPI;
import com.example.projectcn.model.connect.RetrofitClient;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Forgot_password extends Activity {
    private CountDownTimer countDownTimer;
    private TextView countdownTimerTextView;
    private Button btnSendCode,btnSummit,btnBack;
    private TextInputEditText usernameInput, emailInput, resetCodeInput, newPasswordInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        countdownTimerTextView = findViewById(R.id.countdownTimer);

        btnSendCode = findViewById(R.id.btnSendCode);
        btnSummit = findViewById(R.id.btnRecoverPassword);
        btnBack = findViewById(R.id.btnBackToLogin);

        usernameInput = findViewById(R.id.username);
        emailInput = findViewById(R.id.emailInput);
        resetCodeInput = findViewById(R.id.resetCodeInput);
        newPasswordInput = findViewById(R.id.newPasswordInput);

        // Set onClickListener for the button
        btnSendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Disable the button to prevent multiple clicks
                btnSendCode.setEnabled(false);
                startCountdownTimer();
                sendResetPasswordEmail();

            }
        });
        btnSummit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPassword();

            }
        });
    }
    private void sendResetPasswordEmail() {
        UserAPI userServiceApi = RetrofitClient.getClient().create(UserAPI.class);

        String username = usernameInput.getText().toString().trim();
        String email = emailInput.getText().toString().trim();

        // Xác thực đầu vào
        if (username.isEmpty() || email.isEmpty()) {
            Toast.makeText(Forgot_password.this, "Tên người dùng và email không được để trống", Toast.LENGTH_SHORT).show();
            return;
        }

        // Hiển thị chỉ báo tiến trình
        ProgressDialog progressDialog = ProgressDialog.show(this, "Vui lòng đợi", "Đang xử lý...", true);

        Call<String> call = userServiceApi.sendResetPasswordEmail(username, email);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                progressDialog.dismiss(); // Ẩn chỉ báo tiến trình
                if (response.isSuccessful() && response.body() != null) {
                    String result = response.body();
                    AlertDialog.Builder builder = new AlertDialog.Builder(Forgot_password.this);
                    builder.setTitle("Xác nhận");
                    builder.setMessage(result);
                    builder.setPositiveButton("OK", null);
                    builder.show();
                } else {
                    Toast.makeText(Forgot_password.this, "Lỗi: " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                progressDialog.dismiss(); // Ẩn chỉ báo tiến trình
                //Toast.makeText(Forgot_password.this, "Lỗi kết nối: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("ForgotPW", t.getMessage());
            }
        });
    }


    private void resetPassword(){
        UserAPI userServiceApi = RetrofitClient.getClient().create(UserAPI.class);

        String username = usernameInput.getText().toString().trim();
        String email = emailInput.getText().toString().trim();
        String resetCode = resetCodeInput.getText().toString().trim();
        String newpw = newPasswordInput.getText().toString().trim();
        if (username.isEmpty() || email.isEmpty() || newpw.isEmpty()) {
            Toast.makeText(Forgot_password.this, "Tên người dùng và email không được để trống", Toast.LENGTH_SHORT).show();
            return;
        }
        ProgressDialog progressDialog = ProgressDialog.show(this, "Vui lòng đợi", "Đang xử lý...", true);
        Call<String> call = userServiceApi.resetPassword(email, resetCode, newpw);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                progressDialog.dismiss(); // Ẩn chỉ báo tiến trình
                if (response.isSuccessful() && response.body() != null) {
                    Toast.makeText(Forgot_password.this, "Thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Forgot_password.this, "Lỗi: " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                progressDialog.dismiss(); // Ẩn chỉ báo tiến trình
                //Toast.makeText(Forgot_password.this, "Lỗi kết nối: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("ForgotPW", t.getMessage());
            }
        });
    }

    private void startCountdownTimer() {
        // Cancel any existing timer
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

        // Change text color to black
        countdownTimerTextView.setTextColor(Color.BLACK);

        // Start a new countdown timer for 60 seconds
        countDownTimer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Update the TextView with the remaining time
                countdownTimerTextView.setText(millisUntilFinished / 1000 + "s");
            }

            @Override
            public void onFinish() {
                // Enable the button when the countdown finishes
                btnSendCode.setEnabled(true);

                // Reset the TextView to its initial state
                countdownTimerTextView.setText("60s");

                // Optional: Change text color back to the original color if needed
                countdownTimerTextView.setTextColor(Color.WHITE);
            }
        };

        // Start the countdown timer
        countDownTimer.start();
    }

}
