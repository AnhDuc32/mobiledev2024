package vn.edu.usth.weather;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

public class WeatherActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather); // Set your layout here
        HomePagerAdapter adapter = new HomePagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        Log.i("MyApp", "onCreate called"); // Log a message
    }
    @Override
    protected void onStart() {
        super.onStart();
        // Start background tasks or register listeners
        Log.i("MyApp", "onStart called");
    }
    @Override
    protected void onResume() {
        super.onResume();
        // Resume animations, start media playback, etc.
        Log.i("MyApp", "onResume called");
    }
    @Override
    protected void onPause() {
        super.onPause();
        // Save data or release resources
        Log.i("MyApp", "onPause called");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Clean up resources, close connections, etc.
        Log.i("MyApp", "onDestroy called");
    }
}