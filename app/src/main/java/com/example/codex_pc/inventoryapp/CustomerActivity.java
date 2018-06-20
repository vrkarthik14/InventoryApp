package com.example.codex_pc.inventoryapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        ArrayList<Customer> customers= ((MyAppData)this.getApplication()).getCustomers();
        //Log.i("Check",products.get(0).getName());
        CustomerAdapter customerAdapter = new CustomerAdapter(this,customers);
        ListView product_list_view = findViewById(R.id.customer_list);
        product_list_view.setAdapter(customerAdapter);

        FloatingActionButton addCustomers = findViewById(R.id.add_customers);
        addCustomers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CustomerActivity.this, FormActivity.class));
            }
        });


    }
}
