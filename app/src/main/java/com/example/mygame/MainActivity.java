package com.example.mygame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GameModel model=new GameModel(this,this);
        controller=new Controller(this,this,model);

    }

    public void onClicked(View v) {
        controller.onClicked(v);
    }


    public void onClickS(View v) {
        controller.onClickS(v);
    }

    public void onClickO(View v) {
        controller.onClickO(v);
    }
    public void resetGame() {
     controller.resetGame();
    }

    public void gameOver(View view) {
        controller.gameOver(view);
    }
}


