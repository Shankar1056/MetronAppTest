package partner.softgalli.sqlitetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;

import partner.softgalli.sqlitetest.adapter.MetronAdapter;
import partner.softgalli.sqlitetest.database.MetronDatabase;
import partner.softgalli.sqlitetest.model.Employee;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Employee> list = new ArrayList<>();
    private MetronAdapter metronAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MetronDatabase database = new MetronDatabase(MainActivity.this);
        list = database.getEmployeeDetails();


        findViewById(R.id.addEmployeeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddEmployee.class));
            }
        });
        findViewById(R.id.sort).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (list.size()>0) {
                    Collections.sort(list, new CustomComparator());
                    metronAdapter.notifyDataSetChanged();
                }
            }
        });


        RecyclerView rvEmployee = (RecyclerView)findViewById(R.id.rvEmployee);
        rvEmployee.setLayoutManager(new LinearLayoutManager(this));
        metronAdapter = new MetronAdapter(MainActivity.this,list);
        if (list.size()>0){
            rvEmployee.setAdapter(metronAdapter);
        }


    }

     class CustomComparator implements java.util.Comparator<Employee> {


         @Override
         public int compare(Employee o1, Employee o2) {
             return o1.getAge().compareTo(o2.getAge());
         }
     }
}
