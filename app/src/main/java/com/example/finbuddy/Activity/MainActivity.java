package com.example.finbuddy.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;

import com.alan.alansdk.AlanCallback;
import com.alan.alansdk.AlanConfig;
import com.alan.alansdk.button.AlanButton;
import com.alan.alansdk.events.EventCommand;
import com.example.finbuddy.Fragments.HomeScreen;
import com.example.finbuddy.R;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private AlanButton alanButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        NavController navController =
                Navigation.findNavController(MainActivity.this, R.id.home_nav_host);
        navController.setGraph(R.navigation.main_navigation);


        AlanConfig config = AlanConfig.builder().setProjectId("c5760c72621223c7e29e5acb850505082e956eca572e1d8b807a3e2338fdd0dc/stage").build();
        alanButton = findViewById(R.id.alan_button);
        alanButton.initWithConfig(config);

        AlanCallback alanCallback = new AlanCallback() {
            /// Handle commands from Alan Studio
            @Override
            public void onCommand(final EventCommand eventCommand) {
                try {
                    JSONObject command = eventCommand.getData();
                    String commandName = command.getJSONObject("data").getString("command");
                    Log.d("AlanButton", "onCommand: commandName: " + commandName);
                } catch (JSONException e) {
                    Log.e("AlanButton", e.getMessage());
                }
            }
        };

/// Register callbacks
        alanButton.registerCallback(alanCallback);

    }
}