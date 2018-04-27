package partner.softgalli.sqlitetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import partner.softgalli.sqlitetest.database.MetronDatabase;
import partner.softgalli.sqlitetest.model.Employee;

public class AddEmployee extends AppCompatActivity {
    private EditText input_id, input_age, input_address;
    private Button saveButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addemployee);

        final MetronDatabase database = new MetronDatabase(AddEmployee.this);

        input_id = (EditText)findViewById(R.id.input_id);
        input_age = (EditText)findViewById(R.id.input_age);
        input_address = (EditText)findViewById(R.id.input_address);
        saveButton = (Button)findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input_id.getText().toString().trim().equals("")){
                    Toast.makeText(AddEmployee.this, "Enter Employee Id", Toast.LENGTH_SHORT).show();
                    return;
                }if (input_age.getText().toString().trim().equals("")){
                    Toast.makeText(AddEmployee.this, "Enter Employee Age", Toast.LENGTH_SHORT).show();
                    return;
                }if (input_id.getText().toString().trim().equals("")){
                    Toast.makeText(AddEmployee.this, "Enter Employee Address", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    Employee employee = new Employee(input_id.getText().toString(), input_age.getText().toString(), input_address.getText().toString());

                    database.insertUserData(employee);

                    startActivity(new Intent(AddEmployee.this, MainActivity.class));
                    finishAffinity();
                }
            }
        });
    }
}
