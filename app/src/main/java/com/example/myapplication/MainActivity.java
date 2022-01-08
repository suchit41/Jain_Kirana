package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adaptor.CategoryAdaptor;
import com.example.myapplication.Adaptor.DiscountProductAdaptor;
import com.example.myapplication.Adaptor.RecentlyViewedAdapter;
import com.example.myapplication.model.AllCategoryModel;
import com.example.myapplication.model.Category;
import com.example.myapplication.model.DiscountedProducts;
import com.example.myapplication.model.RecentlyViewed;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageView allCategory;
RecyclerView discountRecycleView;
RecyclerView categoryRecyclerView,recentlyViewedRecycler;
DiscountProductAdaptor discountProductAdaptor;
List<DiscountedProducts>discountedProductsList;
CategoryAdaptor categoryAdaptor;
List<Category>categoryList;
RecentlyViewedAdapter recentlyViewedAdapter;
List<RecentlyViewed> recentlyViewedList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        allCategory =findViewById(R.id.allCategoryImage);
        discountRecycleView=findViewById(R.id.discountedRecycle);
       categoryRecyclerView=findViewById(R.id.categoryRecycler);
       recentlyViewedRecycler = findViewById(R.id.recently_item);



        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AllCategoryModel.class);
                startActivity(i);
            }
        });

       //adding data
       discountRecycleView = findViewById(R.id.discountedRecycle);
        discountedProductsList= new ArrayList<>();
        discountedProductsList.add(new DiscountedProducts(1,R.drawable.discountimage));
        discountedProductsList.add(new DiscountedProducts(2,R.drawable.discountimage2));
        discountedProductsList.add(new DiscountedProducts(3,R.drawable.image4));
        discountedProductsList.add(new DiscountedProducts(4,R.drawable.discountimage3));
        discountedProductsList.add(new DiscountedProducts(5,R.drawable.discountimage2));
        discountedProductsList.add(new DiscountedProducts(6,R.drawable.image4));
        categoryList = new ArrayList<>();

       // categoryList.add(new Category(1,fi));
       // categoryList.add(new Category(1,R.drawable.ic_baseline_local_offer_24));
       categoryList.add(new Category(1,R.drawable.allcombine));
        categoryList.add(new Category(2,R.drawable.fruit));
        categoryList.add(new Category(3,R.drawable.chai_paati));
        categoryList.add(new Category(4,R.drawable.hair_oil));
       categoryList.add(new Category(5,R.drawable.ic_baseline_local_offer_24));


      recentlyViewedList = new ArrayList<>();
       recentlyViewedList.add(new RecentlyViewed("Watermelon", "Watermelon has high water content and also provides some fiber.", "₹ 80", "1", "KG", R.drawable.card4, R.drawable.b4));
        recentlyViewedList.add(new RecentlyViewed("Papaya", "Papayas are spherical or pear-shaped fruits that can be as long as 20 inches.", "₹ 85", "1", "KG", R.drawable.card3, R.drawable.b3));
       recentlyViewedList.add(new RecentlyViewed("Strawberry", "The strawberry is a highly nutritious fruit, loaded with vitamin C.", "₹ 30", "1", "KG", R.drawable.card2, R.drawable.b1));
       recentlyViewedList.add(new RecentlyViewed("Kiwi", "Full of nutrients like vitamin C, vitamin K, vitamin E, folate, and potassium.", "₹ 30", "1", "KG", R.drawable.card1, R.drawable.b2));
        recentlyViewedList.add(new RecentlyViewed("Basmati Rice", "Best basmati rice for daily cooking Pristine white grain that do not stick to each other or break when cooked After cooking, rice elongates twice in size and becomes flavorful", "₹ 80", "1", "PC", R.drawable.rice1, R.drawable.rice1));
        recentlyViewedList.add(new RecentlyViewed("Kiwi", "Full of nutrients like vitamin C, vitamin K, vitamin E, folate, and potassium.", "₹ 30", "1", "PC", R.drawable.card1, R.drawable.b2));


        setDiscountRecycler(discountedProductsList);
        setCategoryRecycler(categoryList);
        setRecentlyViewedRecycler(recentlyViewedList);
    }

    private void setDiscountRecycler(List<DiscountedProducts>dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        discountRecycleView.setLayoutManager(layoutManager);
        discountProductAdaptor = new DiscountProductAdaptor(this,dataList);
        discountRecycleView.setAdapter(discountProductAdaptor);
    }
    private void setCategoryRecycler(List<Category> categoryDataList) {
        RecyclerView.LayoutManager layoutManager  = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
      categoryRecyclerView.setLayoutManager(layoutManager);
       categoryAdaptor = new CategoryAdaptor(this,categoryDataList);
      categoryRecyclerView.setAdapter(categoryAdaptor);
    }
                    private void setRecentlyViewedRecycler(List<RecentlyViewed> recentlyViewedDataList) {
                      RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
                        recentlyViewedRecycler.setLayoutManager(layoutManager);
                      recentlyViewedAdapter = new RecentlyViewedAdapter(this,recentlyViewedDataList);
                      recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);
    }
}