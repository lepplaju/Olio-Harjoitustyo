package com.example.lutemon.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lutemon.R;
import com.example.lutemon.adaptersAndHelpers.ChatboxController;
import com.example.lutemon.adaptersAndHelpers.DamageResult;
import com.example.lutemon.classes.Enemy;
import com.example.lutemon.classes.GameFile;
import com.example.lutemon.classes.Inventory;
import com.example.lutemon.classes.Lutemon;
import com.example.lutemon.classes.Move;
import com.example.lutemon.classes.SaveFileManager;

import java.util.ArrayList;
import java.util.Random;

public class BattlePage extends AppCompatActivity {

    private SaveFileManager saveFileManager;
    private boolean enemyLutemonIsAlive = true, userLutemonIsAlive = true;
    private Enemy enemy;
    private Lutemon enemyLutemon, userLutemon;
    private ArrayList<Move> userMoves;

    private TextView userLutemonHp, userLutemonName, enemyLutemonHp, enemyLutemonName, chatboxText;
    private ImageView userImage, enemyImage;
    private Inventory inventory;

    private Button move1Btn, move2Btn, move3Btn, move4Btn, exitBtn;
    private ProgressBar enemyHealthBar, userHealthBar;
    private FrameLayout bottomScreenFrame;
    private LinearLayout buttonContainer;

    private ChatboxController chatboxController;
    private DamageResult userDmgResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_page);

        Intent intent = getIntent();
        enemy = (Enemy) intent.getSerializableExtra("enemy");

        saveFileManager = SaveFileManager.getInstance();
        GameFile gameFile = saveFileManager.getGameFile();
        inventory = gameFile.getInventory();

        setFields();
        setButtons();
        setChatBox();
    }

    private void setFields() { // part of onCreate
        enemyLutemon = enemy.getLutemons().get(0);
        userLutemon = inventory.getLutemon(0);

        enemyHealthBar = findViewById(R.id.enemyHealthBar);
        userHealthBar = findViewById(R.id.userHealthBar);
        enemyLutemonHp = findViewById(R.id.enemyHpTxt);
        enemyLutemonName = findViewById(R.id.enemyLutemonTxtView);
        userLutemonName = findViewById(R.id.userLutemonTxtView);
        userLutemonHp = findViewById(R.id.userHpTxt);
        userImage = findViewById(R.id.userImage);
        enemyImage = findViewById(R.id.enemyImage);

        enemyImage.setImageResource(enemyLutemon.getImage());
        userImage.setImageResource(userLutemon.getImage());

        enemyHealthBar.setMax(enemyLutemon.getMaxHealth());
        enemyHealthBar.setProgress(enemyLutemon.getHealth());
        userHealthBar.setMax(userLutemon.getMaxHealth());
        userHealthBar.setProgress(userLutemon.getHealth());
        enemyLutemonHp.setText(enemyLutemon.getHealth() + "/" + enemyLutemon.getMaxHealth());
        enemyLutemonName.setText(enemyLutemon.getName() + " : level " + enemyLutemon.getLevel());
        userLutemonHp.setText(userLutemon.getHealth() + "/" + userLutemon.getMaxHealth());
        userLutemonName.setText(userLutemon.getName() + " : level " + userLutemon.getLevel());
    }


    private void setButtons() { // part of onCreate
        userMoves = userLutemon.getMoves();
        move1Btn = findViewById(R.id.move1Btn);
        move2Btn = findViewById(R.id.move2Btn);
        move3Btn = findViewById(R.id.move3Btn);
        move4Btn = findViewById(R.id.move4Btn);
        exitBtn = findViewById(R.id.exitBtn);

        move1Btn.setText(String.valueOf(userMoves.get(0).getName()));
        move2Btn.setText(String.valueOf(userMoves.get(1).getName()));
        move3Btn.setText(String.valueOf(userMoves.get(2).getName()));
        move4Btn.setText(String.valueOf(userMoves.get(3).getName()));
        move1Btn.setOnClickListener(listener);
        move2Btn.setOnClickListener(listener);
        move3Btn.setOnClickListener(listener);
        move4Btn.setOnClickListener(listener);
        exitBtn.setOnClickListener(listener);
        exitBtn.setVisibility(View.GONE);
    }

    private void setChatBox() { // The class "ChatboxController" takes care of hiding the buttons, giving text feedback and modifying the textView states during a battle
        bottomScreenFrame = findViewById(R.id.frameContainer);
        chatboxText = findViewById(R.id.textToReplaceButtons);
        buttonContainer = findViewById(R.id.buttonContainer);
        chatboxController = new ChatboxController(bottomScreenFrame, buttonContainer, chatboxText, userLutemonName, userLutemonHp, userHealthBar, move1Btn, move2Btn, move3Btn, move4Btn, exitBtn);
    }

    private View.OnClickListener listener = new View.OnClickListener() { // Here we define the move-button listeners
        @Override
        public void onClick(View view) {
            int viewId = view.getId();
            if (viewId == R.id.move1Btn) {
                userDmgResult = userLutemon.attack(userLutemon, enemyLutemon, userMoves.get(0));
                chatboxController.showTextBox();
            } else if (viewId == R.id.move2Btn) {
                userDmgResult = userLutemon.attack(userLutemon, enemyLutemon, userMoves.get(1));
                chatboxController.showTextBox();
            } else if (viewId == R.id.move3Btn) {
                userDmgResult = userLutemon.attack(userLutemon, enemyLutemon, userMoves.get(2));
                chatboxController.showTextBox();
            } else if (viewId == R.id.move4Btn) {
                userDmgResult = userLutemon.attack(userLutemon, enemyLutemon, userMoves.get(3));
                chatboxController.showTextBox();
            } else if (viewId == R.id.exitBtn) {
                Intent intent = new Intent(BattlePage.this, MainActivity.class);
                startActivity(intent);
            }


            if (enemyLutemonIsAlive && userLutemonIsAlive) userAnimation();

        }
    };


    public void userAnimation() { // The attack animation is defined here. Enemy attack animation starts once user attack is finished
        int[] userLocation = new int[2];
        int[] enemyLocation = new int[2];

        userImage.getLocationInWindow(userLocation);
        enemyImage.getLocationInWindow(enemyLocation);

        float startX = userLocation[0];
        float startY = userLocation[1];
        float endX = enemyLocation[0];
        float endY = enemyLocation[1];

        Animation attackAnimation = new TranslateAnimation(0, endX - startX, 0, endY - startY);
        attackAnimation.setDuration(200);
        attackAnimation.setFillAfter(true);
        attackAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (enemyLutemonIsAlive) {
                            damageVisuals();
                        }

                    }
                }, 200);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Animation moveBackAnimation = new TranslateAnimation(endX - startX, 0, endY - startY, 0);
                moveBackAnimation.setDuration(200);
                moveBackAnimation.setFillAfter(true);
                userImage.startAnimation(moveBackAnimation);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (enemyLutemonIsAlive) {
                            enemyAnimation();
                        }
                    }

                }, 1000);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        userImage.startAnimation(attackAnimation);
    }


    private void enemyAnimation() {
        int[] userLocation = new int[2];
        int[] enemyLocation = new int[2];

        userImage.getLocationInWindow(userLocation);
        enemyImage.getLocationInWindow(enemyLocation);

        float startX = enemyLocation[0];
        float startY = enemyLocation[1];
        float endX = userLocation[0];
        float endY = userLocation[1];

        Animation enemyAttackAnimation = new TranslateAnimation(0, endX - startX, 0, endY - startY);
        enemyAttackAnimation.setDuration(300);
        enemyAttackAnimation.setFillAfter(true);
        enemyAttackAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                if (userLutemonIsAlive) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            enemyDamageVisuals();
                        }
                    }, 200);

                }


            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Animation moveEnemyBackAnimation = new TranslateAnimation(endX - startX, 0, endY - startY, 0);
                moveEnemyBackAnimation.setDuration(300);
                moveEnemyBackAnimation.setFillAfter(true);
                enemyImage.startAnimation(moveEnemyBackAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        enemyImage.startAnimation(enemyAttackAnimation);


    }

    public void destroyEnemyLutemon() { // If the enemy lutemon dies, we go here
        enemyImage.setImageResource(0);
        enemyLutemonName.setText("");
        enemyLutemonHp.setText("");
        enemyHealthBar.setVisibility(View.GONE);
        chatboxController.setChatBoxText(enemyLutemon.getName() + " Fainted");
        chatboxController.releaseResources();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                endLevel();
            }
        }, 1500);


    }

    public void destroyUserLutemon() { // If the user lutemon dies, we go here
        userImage.setImageResource(0);
        chatboxController.setChatBoxText(userLutemon.getName() + " Fainted");
        chatboxController.releaseResources();
        userLutemonName.setText("");
        userLutemonHp.setText("");
        userHealthBar.setVisibility(View.GONE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                endLevelWithLoss();
            }
        }, 1500);
    }


    @Override
    public void onBackPressed() {
        // This method is here to override the back button in a phone navigation bar.
    }

    private void damageVisuals() { // In this function we handle the text feedback once a user has attacked
        if (userDmgResult.isHit()) {
            chatboxController.setChatBoxText(userLutemon.getName() + " used " + userDmgResult.getMoveName());
            if (userDmgResult.isCriticalHit()) {
                chatboxController.appendChatBoxText(" Critical hit! ");
            }
            if (!userDmgResult.getEffectiveness().equals("Normal")) {
                chatboxController.appendChatBoxText(" it was " + userDmgResult.getEffectiveness() + " effective");
            }
        } else if (!userDmgResult.isHit()) {
            chatboxController.setChatBoxText(userLutemon.getName() + " used " + userDmgResult.getMoveName() + " and it missed");
        }
        enemyLutemonHp.setText(enemyLutemon.getHealth() + "/" + enemyLutemon.getMaxHealth());
        enemyHealthBar.setProgress(enemyLutemon.getHealth());
        if (enemyLutemon.getHealth() <= 0) {
            enemyLutemonIsAlive = false;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    destroyEnemyLutemon();
                }
            }, 600);
        }
    }

    private void enemyDamageVisuals() { // In this function we handle the enemy attack turn
        Random random = new Random();
        int attackId = random.nextInt(4);
        DamageResult enemyDmgResult = enemyLutemon.attack(enemyLutemon, userLutemon, enemyLutemon.getMoves().get(attackId));

        if (enemyDmgResult.isHit()) {
            chatboxController.setChatBoxText(enemyLutemon.getName() + " used " + enemyDmgResult.getMoveName());
            if (enemyDmgResult.isCriticalHit()) {
                chatboxController.appendChatBoxText(" Critical hit! ");
            }
            if (!enemyDmgResult.getEffectiveness().equals("Normal")) {
                chatboxController.appendChatBoxText(enemyDmgResult.getEffectiveness());
            }
        }
        if (enemyDmgResult.isHit() == false) {
            chatboxController.setChatBoxText(enemyLutemon.getName() + " used " + enemyDmgResult.getMoveName() + " and it missed");
            return;
        }
        userLutemonHp.setText(userLutemon.getHealth() + "/" + userLutemon.getMaxHealth());
        userHealthBar.setProgress(userLutemon.getHealth());
        if (userLutemon.getHealth() <= 0) {
            userLutemonIsAlive = false;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    destroyUserLutemon();
                }
            }, 600);
        }

    }

    public void endLevel() { // We go here if the battle is won
        chatboxController.hideButtons();
        int gainedExp = userLutemon.addExp(enemyLutemon, enemy);
        chatboxController.setChatBoxText(userLutemon.getName() + " gained " + gainedExp + " experience points");
        GameFile gameFile = saveFileManager.getGameFile();
        if (enemy.getIsTrainer() == true && gameFile.getHighestLevelAvailable() == enemy.getTrainerLevel()) {
            gameFile.levelCompleted();
        }


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                userLutemon.checkLevelUp(chatboxController);

            }
        }, 2000);
    }

    public void endLevelWithLoss() { // We go here if the battle is lost
        chatboxController.hideButtons();
        chatboxController.setChatBoxText(userLutemon.getName() + " is dead and will be placed in the graveyard");
        inventory.moveLutemonToGraveyard(userLutemon);
        chatboxController.showExitBtn();
    }
}
