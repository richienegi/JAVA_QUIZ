package negi.ritikachaaras.java_quiz;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class QuizActivity extends AppCompatActivity {

    public static final String EXTRA_SCORE = "extraScore";
    private static final long COUNTDOWN_IN_MILLIS =30000;

    private static final String KEY_SCORE = "keyScore";
    private static final String KEY_QUESTION_COUNT = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFT = "keyMillisLeft";
    private static final String KEY_ANSWERED = "keyAnswered";
    private static final String KEY_QUESTION_LIST = "keyQuestionList";
    TextView textViewQuestion, textViewScore, textViewQuestionCount, textViewCountDown;
    RadioGroup rbGroup;
    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;
    CardView ans_card;
    Button buttonconfirmnext;
    ColorStateList textColorDefaultRb;
    ColorStateList textColorDefaultcd;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;
    long backPressTime;
    ArrayList<Question> questionList;
    int questionCounter;
    int questionCountTotal;
    TextView textViewDificulty;
    Question currentQuestion;
    int score;
    boolean answered;
    TextView ans;
    Toolbar t1;
    Animation animation1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        MobileAds.initialize(this,"ca-app-pub-4222616036206839~5222022814");

        t1 = findViewById(R.id.tool);

        setSupportActionBar(t1);
        animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.blink);


        ans_card = (CardView)findViewById(R.id.ans_card);
        textViewQuestion = findViewById(R.id.text_view_question);
        textViewScore = findViewById(R.id.text_view_score);
        textViewQuestionCount = findViewById(R.id.text_view_question_count);
        textViewCountDown = findViewById(R.id.text_view_countdown);
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        rb3 = findViewById(R.id.radio_button3);
        ans = findViewById(R.id.ans);
        buttonconfirmnext = findViewById(R.id.button_confirm_next);
        textColorDefaultRb = rb1.getTextColors();
        textViewDificulty = (TextView) findViewById(R.id.text_view_dificulty);
        textColorDefaultcd = textViewCountDown.getTextColors();

        Intent i = getIntent();
        String dificulity = i.getStringExtra(MainActivity.EXTRA_DIFICULTY);
        textViewDificulty.setText("Chapter: " + dificulity);
        if (savedInstanceState == null) {
            QuizDbHelper quizDbHelper = new QuizDbHelper(this);
            questionList = quizDbHelper.getQuestions(dificulity);
            questionCountTotal = questionList.size();
            Collections.shuffle(questionList);
            showNextQuestion();
        } else {
            questionList = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LIST);
            questionCountTotal = questionList.size();
            questionCounter = savedInstanceState.getInt(KEY_QUESTION_COUNT);
            currentQuestion = questionList.get(questionCounter - 1);
            score = savedInstanceState.getInt(KEY_SCORE);
            timeLeftInMillis = savedInstanceState.getLong(KEY_MILLIS_LEFT);
            answered = savedInstanceState.getBoolean(KEY_ANSWERED);

            if (!answered) {
                startCountDown();
            } else {
                updateCountDownText();
                showSolution();
            }
        }

        buttonconfirmnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 if (!answered) {
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(QuizActivity.this, "Please Select an Answere", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();

                }
            }
        });
    }


    private void showNextQuestion() {
        ans_card.setVisibility(View.GONE);
        ans.setText("");
        rb1.setTextColor(textColorDefaultRb);
        rb2.setTextColor(textColorDefaultRb);
        rb3.setTextColor(textColorDefaultRb);
        rbGroup.clearCheck();
        if (questionCounter < questionCountTotal) {
            currentQuestion = questionList.get(questionCounter);
            textViewQuestion.setText(currentQuestion.getQuestion1());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            questionCounter++;
            textViewQuestionCount.setText("Question :" + questionCounter + " / " + questionCountTotal);
            answered = false;
            buttonconfirmnext.setText("Confirm");
            timeLeftInMillis = COUNTDOWN_IN_MILLIS;
            startCountDown();
        } else {
            finishQuiz();
        }

    }

    private void startCountDown() {

        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();

            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText() {

        int minuts = (int) (timeLeftInMillis / 1000) / 60;
        int second = (int) (timeLeftInMillis / 1000) % 60;

        String timeformated = String.format(Locale.getDefault(), "%02d:%02d", minuts, second);
        textViewCountDown.setText(timeformated);
        if(timeLeftInMillis < 10000) {
             textViewCountDown.setTextColor(Color.RED);
            textViewCountDown.startAnimation(animation1);
        } else {
            textViewCountDown.setTextColor(textColorDefaultcd);
            textViewCountDown.clearAnimation();

        }
        //textViewCountDown.clearAnimation();
    }

    private void checkAnswer() {
        answered = true;
        countDownTimer.cancel();
        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNr = rbGroup.indexOfChild(rbSelected) + 1;
        if (answerNr == currentQuestion.getAnswerNr()) {
            score++;
            textViewScore.setText("Score :" + score);
            showSolution();
        } else {
            showSolution();
        }
    }

    @SuppressLint("ResourceAsColor")
    private void showSolution() {

        ans_card.setVisibility(View.VISIBLE);
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        switch (currentQuestion.getAnswerNr()) {
            case 1:
                rb1.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                break;

            case 3:
                rb3.setTextColor(Color.GREEN);
                break;
            default:
                Toast.makeText(this, "Nothing is Selected", Toast.LENGTH_SHORT).show();

        }
        if (questionCounter < questionCountTotal) {
            buttonconfirmnext.setText("NEXT");
            ans.setText(currentQuestion.getAns());
        } else {
            buttonconfirmnext.setText("Finish");
            ans.setText(currentQuestion.getAns());
        }

    }

    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORE, score);
        setResult(RESULT_OK, resultIntent);
        DialogDemo();

    }

    @Override
    public void onBackPressed() {
        if (backPressTime + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "Press Back Agian to Finish", Toast.LENGTH_SHORT).show();
        }
        backPressTime = System.currentTimeMillis();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt(KEY_SCORE, score);
        outState.putInt(KEY_QUESTION_COUNT, questionCounter);
        outState.putLong(KEY_MILLIS_LEFT, timeLeftInMillis);
        outState.putBoolean(KEY_ANSWERED, answered);
        outState.putParcelableArrayList(KEY_QUESTION_LIST, questionList);
    }

    public void DialogDemo() {

        // Create Object of Dialog class
        final Dialog login = new Dialog(this);
        // Set GUI of login screen
        login.setContentView(R.layout.dialogdemo);
        login.setTitle("Please enter your name");

        // Init button of login GUI
        Button btnLogin = (Button) login.findViewById(R.id.btnLogin);
        final TextView scoredata = (TextView) login.findViewById(R.id.txtUsername);

        scoredata.setText("You Scored:" + "\n" + score + " / " + questionCountTotal);
        // Attached listener for login GUI button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login.dismiss();
                finish();
            }


        });

        // Make dialog box visible.
        login.show();
    }


}

