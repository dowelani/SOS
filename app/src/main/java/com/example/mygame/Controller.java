package com.example.mygame;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class Controller {
    private RadioButton playerOneName, playerTwoName;
    private int points1, points2;
    Button b1, b2;
    private boolean isPlayer1Turn = true; // Indicates current player's turn
    private String S_O = "";
    Activity main;
    Context context;
    GameModel model;
    private TextView winner;
    public Controller(Context context, Activity main,GameModel model) {
        this.main=main;
        this.context=context;
        this.model=model;
        playerOneName = (RadioButton) main.findViewById(R.id.radioButton);
        playerTwoName = (RadioButton) main.findViewById(R.id.radioButton2);
        playerOneName.setChecked(true);
        b1 = main.findViewById(R.id.button3);
        b2 = main.findViewById(R.id.button4);
        points1 = 0;
        points2 = 0;
    }
    public void onClicked(View v) {
        Button currentButton = main.findViewById(v.getId());
        winner=main.findViewById(R.id.winner);
        if (!S_O.equals("")) {
            if (isPlayer1Turn) {
                Boolean isSos = false;
                currentButton.setText(S_O);
                model.getGrid().add(currentButton);
                currentButton.setTextColor(Color.BLACK);
                ArrayList<String> checkSos = model.getPossibleWin().get(v.getId());
                for (String sos : checkSos) {
                    String[] sosArray = sos.split(",");
                    Button button = main.findViewById(context.getResources().getIdentifier(sosArray[0], "id", context.getPackageName()));
                    Button button1 = main.findViewById(context.getResources().getIdentifier(sosArray[1], "id", context.getPackageName()));
                    Button button2 = main.findViewById(context.getResources().getIdentifier(sosArray[2], "id", context.getPackageName()));
                    if (button.getText().equals("S") && button1.getText().equals("O") && button2.getText().equals("S")) {
                        if ((button.getTextColors().getDefaultColor() == (Color.BLUE))) {
                            button.setTextColor(Color.GREEN);
                        } else if ((button.getTextColors().getDefaultColor() == (Color.BLACK))) {
                            button.setTextColor(Color.RED);
                        }

                        if ((button1.getTextColors().getDefaultColor() == (Color.BLUE))) {
                            button1.setTextColor(Color.GREEN);
                        } else if ((button1.getTextColors().getDefaultColor() == (Color.BLACK))) {
                            button1.setTextColor(Color.RED);
                        }

                        if ((button2.getTextColors().getDefaultColor() == (Color.BLUE))) {
                            button2.setTextColor(Color.GREEN);
                        } else if ((button2.getTextColors().getDefaultColor() == (Color.BLACK))) {
                            button2.setTextColor(Color.RED);
                        }
                        points1 = points1 + 1;
                        isSos = true;
                    }
                }

                b1.setText(points1+ "");
                if (!isSos) {
                    playerOneName.setChecked(false);
                    playerTwoName.setChecked(true);
                    isPlayer1Turn = false;
                }
            } else {
                Boolean isSos = false;
                currentButton.setText(S_O);
                model.getGrid().add(currentButton);
                currentButton.setTextColor(Color.BLACK);
                ArrayList<String> checkSos =model.getPossibleWin().get(v.getId());
                for (String sos : checkSos) {
                    String[] sosArray = sos.split(",");
                    Button button = main.findViewById(context.getResources().getIdentifier(sosArray[0], "id", context.getPackageName()));
                    Button button1 = main.findViewById(context.getResources().getIdentifier(sosArray[1], "id", context.getPackageName()));
                    Button button2 = main.findViewById(context.getResources().getIdentifier(sosArray[2], "id", context.getPackageName()));
                    if (button.getText().equals("S") && button1.getText().equals("O") && button2.getText().equals("S")) {
                        if ((button.getTextColors().getDefaultColor() == (Color.RED))) {
                            button.setTextColor(Color.GREEN);
                        } else if ((button.getTextColors().getDefaultColor() == (Color.BLACK))) {
                            button.setTextColor(Color.BLUE);
                        }
                        if ((button1.getTextColors().getDefaultColor() == (Color.RED))) {
                            button1.setTextColor(Color.GREEN);
                        } else if ((button1.getTextColors().getDefaultColor() == (Color.BLACK))) {
                            button1.setTextColor(Color.BLUE);
                        }
                        if ((button2.getTextColors().getDefaultColor() == (Color.RED))) {
                            button2.setTextColor(Color.GREEN);
                        } else if ((button2.getTextColors().getDefaultColor() == (Color.BLACK))) {
                            button2.setTextColor(Color.BLUE);
                        }
                        points2 = points2 + 1;
                        isSos = true;
                    }
                }

                b2.setText(points2 +"");
                if (!isSos) {
                    playerOneName.setChecked(true);
                    playerTwoName.setChecked(false);
                    isPlayer1Turn = true;
                }
            }
        }
        if(model.getGrid().size()>=25) {
            if (points1 > points2) {
                winner.setText("Game over, Player 1 has won!");
            } else if (points2 > points1) {
                winner.setText("Game over, Player 2 has won!");
            } else {
                winner.setText("Game over, It's a draw!");
            }
            winner.setVisibility(View.VISIBLE); // Display the message
        }
        S_O = "";
    }


    public void onClickS(View v) {
        S_O = "S";
    }

    public void onClickO(View v) {
        S_O = "O";
    }
    public void resetGame() {
        // Clear button texts and colors
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                model.getGridButtons()[row][col].setText("");
                model.getGridButtons()[row][col].setTextColor(Color.BLACK);
            }
        }

        // Reset player turns and points
        isPlayer1Turn = true;
        points1 = 0;
        points2 = 0;

        b2.setText(points2+"");
        b1.setText(points1+"");
        // Reset player name radio buttons
        playerOneName.setChecked(true);
        playerTwoName.setChecked(false);

        // Hide the game over message
        winner.setVisibility(View.GONE);
        model.getGrid().clear();
    }

    public void gameOver(View view) {
        resetGame();
    }
}
