package com.example.codex_pc.inventoryapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class SupplierActivity extends AppCompatActivity {

    ArrayList<Supplier> suppliers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier);

        final SwipeRefreshLayout refreshLayout2 = findViewById(R.id.swiperefresh2);

        suppliers = ((MyAppData)this.getApplication()).getSuppliers();
        //Log.i("Check",products.get(0).getName());
        final SupplierAdapter supplierAdapter = new SupplierAdapter(this,suppliers);
        ListView product_list_view = findViewById(R.id.supplier_list);
        product_list_view.setAdapter(supplierAdapter);

        FloatingActionButton addSuppliers = findViewById(R.id.add_suppliers);
        addSuppliers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SupplierActivity.this, FormActivity.class));
            }
        });

        refreshLayout2.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                suppliers= ((MyAppData)getApplication()).getSuppliers();
                supplierAdapter.notifyDataSetChanged();
                refreshLayout2.setRefreshing(false);
            }
        });




    }


}
