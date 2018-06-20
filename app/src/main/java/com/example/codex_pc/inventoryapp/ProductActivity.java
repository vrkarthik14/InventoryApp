package com.example.codex_pc.inventoryapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);


        ArrayList<Product> products = ((MyAppData)this.getApplication()).getProducts();
        //Log.i("Check",products.get(0).getName());
        ProductAdapter productAdapter = new ProductAdapter(this,products);
        ListView product_list_view = findViewById(R.id.product_list);
        product_list_view.setAdapter(productAdapter);

    }



}
