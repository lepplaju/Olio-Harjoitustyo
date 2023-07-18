package com.example.lutemon.adaptersAndHelpers;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

// This class will take care of displaying the text in the textView after any battle events.
// The responsibilities include things such as displaying critical hits, attack misses, and effectiveness
public class ChatboxController {
    private FrameLayout container;
    private LinearLayout buttonLayout;
    private TextView temporaryTextView;
    private Button button1, button2, button3, button4;
    private boolean buttonsAreVisible = true;
    private static final long TEMPORARY_TEXT_DURATION = 3000; // Duration in milliseconds

    private Handler handler = new Handler();
    private Runnable showButtonsRunnable = new Runnable() {
        @Override
        public void run() {
            showButtons();
        }
    };

    public ChatboxController(FrameLayout container, LinearLayout buttonLayout, TextView temporaryTextView,
                             Button button1, Button button2, Button button3, Button button4) {
        this.container = container;
        this.buttonLayout = buttonLayout;
        this.temporaryTextView = temporaryTextView;
        this.button1 = button1;
        this.button2 = button2;
        this.button3 = button3;
        this.button4 = button4;
    }

    public void showTextBox() {
        temporaryTextView.setText("");
        hideButtons();
        temporaryTextView.setVisibility(View.VISIBLE);
        handler.postDelayed(showButtonsRunnable, TEMPORARY_TEXT_DURATION);
    }

    public void hideButtons() {
        button1.setVisibility(View.GONE);
        button2.setVisibility(View.GONE);
        button3.setVisibility(View.GONE);
        button4.setVisibility(View.GONE);
        buttonsAreVisible = false;
    }

    private void showButtons() {
        temporaryTextView.setVisibility(View.GONE);
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        button4.setVisibility(View.VISIBLE);
        buttonsAreVisible = true;

    }

    public void setChatAttackMissed() {
        temporaryTextView.setText("Attack missed");
    }

    public void setChatBoxText(String infoString) {
        temporaryTextView.setText(infoString);
    }

    public void appendChatBoxText(String infoString) {
        temporaryTextView.append(infoString);
    }

    public void releaseResources() {
        handler.removeCallbacks(showButtonsRunnable);
    }
}

