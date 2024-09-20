package vn.edu.usth.weather;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
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

import com.google.android.material.tabs.TabLayout;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class WeatherActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather); // Set your layout here
        // Create Adapter
        HomePagerAdapter adapter = new HomePagerAdapter(getSupportFragmentManager());
        // Create and set ViewPager
        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        // Create and set TabLayout
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        // Extract the MP3 file
        try {
            InputStream inputStream = getResources().openRawResource(R.raw.on_and_on);
            File outputFile = new File(getExternalFilesDir(Environment.DIRECTORY_MUSIC), "on_and_on.mp3");
            OutputStream outputStream = new FileOutputStream(outputFile);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }

            inputStream.close();
            outputStream.close();

            // Initialize MediaPlayer
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(outputFile.getAbsolutePath());
            mediaPlayer.prepare();
            // Play the MP3 file
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

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