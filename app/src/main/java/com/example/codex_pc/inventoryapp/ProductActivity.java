package com.example.codex_pc.inventoryapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {

    ArrayList<Product> products;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        final SwipeRefreshLayout refreshLayout = findViewById(R.id.swiperefresh);

         products = ((MyAppData)this.getApplication()).getProducts();
        //Log.i("Check",products.get(0).getName());
        final ProductAdapter productAdapter = new ProductAdapter(this,products);
        ListView product_list_view = findViewById(R.id.product_list);
        product_list_view.setAdapter(productAdapter);
        FloatingActionButton addProducts = findViewById(R.id.add_products);
        addProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProductActivity.this, FormActivity.class));
            }
        });

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                products = ((MyAppData)getApplication()).getProducts();
                productAdapter.notifyDataSetChanged();
                refreshLayout.setRefreshing(false);
            }
        });

    }



}
