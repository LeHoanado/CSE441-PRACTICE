package com.example.prac02;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private StaffViewModel staffViewModel;
    private EditText staff_id, fullname, birthdate, salary;
    private TextView TextView_result, TextView1_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        staff_id = findViewById(R.id.staff_id);
        fullname = findViewById(R.id.fullname);
        birthdate = findViewById(R.id.birthdate);
        salary = findViewById(R.id.salary);
        Button buttonAddNewStaff = findViewById(R.id.button);
        TextView_result = findViewById(R.id.textView_result);
        TextView1_status = findViewById(R.id.textView1_status);

        //Lắng nghe thay đổi dữ liệu
        staffViewModel.getStaffList().observe(this, this::updateStaffList);

        //Khởi tạo ViewModel
        staffViewModel = new ViewModelProvider(this).get(StaffViewModel.class);

        //Sự kiện khi ấn nút ADD NEW STAFF
        buttonAddNewStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isInputValid()) {
                    //Thông báo đã ấn nút
                    TextView1_status.setText("Đã ấn nút thêm mới");

                    String staffId = staff_id.getText().toString();
                    String fullName = fullname.getText().toString();
                    String birthDate = birthdate.getText().toString();
                    double Salary = Double.parseDouble(salary.getText().toString());

                    Staff newStaff = new Staff(staffId, fullName, birthDate, Salary);
                    staffViewModel.addStaff(newStaff);

                    clearInputs();
                } else {
                    //Thông báo chưa nhập đủ dữ liệu
                    TextView1_status.setText("Chưa nhập dữ liệu hoặc chưa nhập đủ dữ liệu");
                }
            }
        });

        //khi người dùng nhập dữ liệu nhưng chưa ấn nút
        setUpInputListener();
    }

    private void setUpInputListener() {
        View.OnFocusChangeListener inputListener = new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b) {
                    if(!TextUtils.isEmpty(staff_id.getText()) ||
                            !TextUtils.isEmpty(fullname.getText()) ||
                            !TextUtils.isEmpty(birthdate.getText()) ||
                            !TextUtils.isEmpty(salary.getText())) {
                        TextView1_status.setText("Đã nhập nhưng chưa ấn nút");
                    }
                }
            }
        };
    }

    //Xóa các trưường sau khi thêm
    private void clearInputs() {
        staff_id.setText("");
        fullname.setText("");
        birthdate.setText("");
        salary.setText("");
    }

    //Kiểm tra trạng thái EditText
    private boolean isInputValid() {
        return !TextUtils.isEmpty(staff_id.getText()) &&
                !TextUtils.isEmpty(fullname.getText()) &&
                !TextUtils.isEmpty(birthdate.getText()) &&
                !TextUtils.isEmpty(salary.getText());
    }

    //Cập nật danh sách sau khi thêm
    private void updateStaffList(List<Staff> staffList) {
        if(staffList.isEmpty()) {
            TextView_result.setText("No Result!");
        } else {
            StringBuilder result = new StringBuilder();
            for (Staff staff : staffList) {
                result.append(staff.getStaffId()).append("-")
                        .append(staff.getFullname()).append("-")
                        .append(staff.getBirthdate()).append("-")
                        .append(staff.getSalary()).append("\n");
            }
            TextView_result.setText(result.toString());
        }
    }
}