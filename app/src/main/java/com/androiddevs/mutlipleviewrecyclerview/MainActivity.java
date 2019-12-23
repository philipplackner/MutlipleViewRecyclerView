package com.androiddevs.mutlipleviewrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ImageData> imageDataList = Arrays.asList(
            new ImageData("Kermit has a break",
                    "On this image you can see how Kermit " +
                            "takes a break on the meadow.",
                    R.drawable.kermit1),
            new ImageData("Kermit tries to open a bottle",
                    "Kermit wants to get drunk again, but sadly he" +
                            "is to weak to open his bottle of alcohol.",
                    R.drawable.kermit2),
            new ImageData("Kermit is drunk",
                    "Kermit managed to open the bottle, but" +
                            "now he is completely drunk and can't code " +
                            "Android apps anymore.",
                    R.drawable.kermit3),
            new ImageData("Kermit plays in the snow",
                    "Kermit is having fun with snow balls.",
                    R.drawable.kermit4),
            new ImageData("Kermit is rich",
                    "Kermit got a lot of money by his " +
                            "grandma. Now he is buying some food.",
                    R.drawable.kermit5)
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvItems = findViewById(R.id.rvItems);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(imageDataList);
        rvItems.setLayoutManager(new LinearLayoutManager(this));
        rvItems.setAdapter(adapter);
    }
}
