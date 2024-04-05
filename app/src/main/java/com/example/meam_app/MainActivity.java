package com.example.meam_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.meam_app.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // Initialize the binding object
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        // Set the content view to the root view of the binding object
        setContentView(binding.getRoot());

        // Rest of the code
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            int arr[] = {
                    R.drawable.img_2,
                    R.drawable.img,
                    R.drawable.img_1,
                    R.drawable.img_3,
                    R.drawable.img_4,
                    R.drawable.img_5
            };

            binding.imageView.setImageResource(arr[0]);
            binding.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int temp = arr.length;
                    Random random = new Random();

                    int number = random.nextInt(temp);
                    binding.imageView.setImageResource(arr[number]);
                }
            });
            return insets;

        });
    }
}