package partner.softgalli.sqlitetest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import partner.softgalli.sqlitetest.R;
import partner.softgalli.sqlitetest.model.Employee;

public class MetronAdapter extends RecyclerView.Adapter<MetronAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Employee> employees;

    public MetronAdapter(Context context, ArrayList<Employee> employees) {
        this.context = context;
        this.employees = employees;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_item,
                parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {


        holder.employeeId.setText("Employee Id: "+employees.get(position).getId());
        holder.employeeage.setText("Employee Age: "+employees.get(position).getAge());
        holder.employeeaddress.setText("Employee Address: "+employees.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return employees.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView employeeId, employeeage, employeeaddress;

        public ViewHolder(View itemView) {
            super(itemView);
            employeeId = (TextView)itemView.findViewById(R.id.employeeId);
            employeeage = (TextView)itemView.findViewById(R.id.employeeage);
            employeeaddress = (TextView)itemView.findViewById(R.id.employeeaddress);

        }
    }
}
