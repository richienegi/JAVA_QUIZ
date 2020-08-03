package negi.ritikachaaras.java_quiz;


import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Questions extends AppCompatActivity implements View.OnClickListener {
    LinearLayout li;
    String type="";
    boolean showing=false;
    String title="";
static int countor=0;
    TextView mtimer,mquestion_no,mquestion;
    Button mans1,mans2,mans3,mskip,mnext;
    private CountDownTimer countDownTimer;
    Animation animation1;
static int totalq=0;
    AdView mAdView;
    AdRequest adRequest;
    String ans="";
    static ArrayList<String> answerselected=new ArrayList<>();
    int  questionindex=0;
    static ArrayList<QuizClass> result;
    private long timeLeftInMillis;
    ProgressDialog progressBar;
    int i=0;
    PrefManager prefManager;
    InterstitialAd mInter[];
    private static long COUNTDOWN_IN_MILLIS =300000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        loadInter();

        prefManager=new PrefManager(this);
        COUNTDOWN_IN_MILLIS=Long.parseLong(prefManager.getTime());
        Bundle networkExtrasBundle = new Bundle();
        networkExtrasBundle.putInt("rdp", 1);
        adRequest = new AdRequest.Builder()
                .addNetworkExtrasBundle(AdMobAdapter.class, networkExtrasBundle)
                .build();

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("gad_rdp", 1);
        editor.commit();


        if(savedInstanceState!=null) {
            savedInstanceState.clear();
        }

        type=getIntent().getStringExtra("extraDifivulty");
        title=getIntent().getStringExtra("mtitle");

TextView QuizType=findViewById(R.id.quiztype);
QuizType.setText(title);

        li=findViewById(R.id.main);
       /* getActionBar().hide();*/
        progressBar = new ProgressDialog(Questions.this);
        mtimer=findViewById(R.id.timeer);
        mquestion=findViewById(R.id.question);
        mquestion_no=findViewById(R.id.no_of_question);
        mans1=findViewById(R.id.ans1);
        mans2=findViewById(R.id.ans2);
        mans3=findViewById(R.id.ans3);
        mskip=findViewById(R.id.skip);
        mnext=findViewById(R.id.next);
        mans1.setOnClickListener(this);
        mans2.setOnClickListener(this);
        mans3.setOnClickListener(this);
        animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        timeLeftInMillis = COUNTDOWN_IN_MILLIS;
        demo();

        mskip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getQuestion();
                answerselected.add("skipped");
                i++;

            }
        });
        mnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getQuestion();
                answerselected.add(ans);
                if(result.get(i).answer.equals(answerselected.get(i)))
                {
                    countor++;
                }
                i++;
            }
        });

        mAdView = (AdView) findViewById(R.id.adView);

        mAdView.loadAd(adRequest);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id)
        {
            case R.id.ans1:
                mans1.setBackground(ContextCompat.getDrawable(getApplication(),R.drawable.selected_button));
                mans2.setBackground(ContextCompat.getDrawable(getApplication(),R.drawable.default_button));
                mans3.setBackground(ContextCompat.getDrawable(getApplication(),R.drawable.default_button));
                mnext.setClickable(true);
                mnext.setEnabled(true);
                ans=mans1.getText().toString();
                break;
            case R.id.ans2:
                mans1.setBackground(ContextCompat.getDrawable(getApplication(),R.drawable.default_button));
                mans2.setBackground(ContextCompat.getDrawable(getApplication(),R.drawable.selected_button));
                mans3.setBackground(ContextCompat.getDrawable(getApplication(),R.drawable.default_button));
                mnext.setClickable(true);
                mnext.setEnabled(true);
                ans=mans2.getText().toString();
                break;
            case R.id.ans3:
                mans1.setBackground(ContextCompat.getDrawable(getApplication(),R.drawable.default_button));
                mans2.setBackground(ContextCompat.getDrawable(getApplication(),R.drawable.default_button));
                mans3.setBackground(ContextCompat.getDrawable(getApplication(),R.drawable.selected_button));
                mnext.setClickable(true);
                mnext.setEnabled(true);
                ans=mans3.getText().toString();
                break;

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
                showDialog(Questions.this);

            }
        }.start();
    }
    private void updateCountDownText() {

        int minuts = (int) (timeLeftInMillis / 1000) / 60;
        int second = (int) (timeLeftInMillis / 1000) % 60;

        String timeformated = String.format(Locale.getDefault(), "%02d:%02d", minuts, second);
        mtimer.setText(timeformated);
        if(timeLeftInMillis < 30000) {
            mtimer.setTextColor(Color.RED);
            mtimer.startAnimation(animation1);
        } else {
            mtimer.setTextColor(Color.BLACK);
            mtimer.clearAnimation();

        }
        //textViewCountDown.clearAnimation();
    }
    public void answerSheet()
    {


        displayInterstitial();
        Intent i=new Intent(Questions.this,AnswerSheet.class);
        startActivity(i);
        finish();


    }

    public void showDialog(Activity activity){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.timerup);

        TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
        text.setText("Time Over");

        Button dialogButton = (Button) dialog.findViewById(R.id.btn_dialog);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

                answerSheet();
            }
        });

        dialog.show();

    }


    public void demo()
    {
        progressBar.setCancelable(false);//you can cancel it by pressing back button
        progressBar.setMessage("Data Loading ...");
        progressBar.show();//displays the progress bar
        OkHttpClient client = new OkHttpClient.Builder()
                .cache(null)
                .build();
        result = new ArrayList<QuizClass>();
        result.clear();
        answerselected.clear();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiQuizE.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        ApiQuizE apiQuizE = retrofit.create(ApiQuizE.class);


        Call<List<Quiz>> call = apiQuizE.getQuestion(type);
        call.enqueue(new Callback<List<Quiz>>() {
            @Override
            public void onResponse(Call<List<Quiz>> call, Response<List<Quiz>> response) {
                List<Quiz> riv= response.body();

                for (int i = 0; i < riv.size(); i++) {
                    QuizClass ci = new QuizClass();
                    ci.id =riv.get(i).getId();
                    ci.question =riv.get(i).getQuestion();
                    ci.option1 =riv.get(i).getOption1();
                    ci.option2 =riv.get(i).getOption2();
                    ci.option3=riv.get(i).getOption3();
                    ci.answer=riv.get(i).getAnswer();
                    ci.description=riv.get(i).getDescription();
                    result.add(ci);
                }
                progressBar.dismiss();
                li.setVisibility(View.VISIBLE);
                totalq=result.size();
                startCountDown();
                getQuestion();

            }

            @Override
            public void onFailure(Call<List<Quiz>> call, Throwable t) {
                Toast.makeText(Questions.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("myerror",t.getMessage());
                progressBar.dismiss();
            }
        });
    }




    public  void getQuestion()
    {
        if(questionindex<result.size()) {
            mnext.setClickable(false);
            mnext.setEnabled(false);
            mquestion_no.setText(String.valueOf(questionindex+1)+"/"+ String.valueOf(result.size()));
            mans1.setBackground(ContextCompat.getDrawable(getApplication(), R.drawable.default_button));
            mans2.setBackground(ContextCompat.getDrawable(getApplication(), R.drawable.default_button));
            mans3.setBackground(ContextCompat.getDrawable(getApplication(), R.drawable.default_button));
            mquestion.setText(result.get(questionindex).question);
            mans1.setText(result.get(questionindex).option1);
            mans2.setText(result.get(questionindex).option2);
            mans3.setText(result.get(questionindex).option3);
            questionindex++;
            switch (questionindex)
            {
                case 7:
                    if(mInter[1].isLoaded()) {
                        mInter[1].show();
                        showing = true;
                    }
                    break;
                case 20:
                    if(mInter[2].isLoaded()) {
                        mInter[2].show();
                        showing = true;
                    }
                    break;
            }
        }
        else {
            answerSheet();
        }

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    private void loadInter() {
        Bundle networkExtrasBundle = new Bundle();
        networkExtrasBundle.putInt("rdp", 1);
        AdRequest adIRequest = new AdRequest.Builder()
                .addNetworkExtrasBundle(AdMobAdapter.class, networkExtrasBundle)
                .build();
        AdRequest adIRequest2 = new AdRequest.Builder()
                .addNetworkExtrasBundle(AdMobAdapter.class, networkExtrasBundle)
                .build();
        AdRequest adIRequest3 =new AdRequest.Builder()
                .addNetworkExtrasBundle(AdMobAdapter.class, networkExtrasBundle)
                .build();

        mInter = new InterstitialAd[3];

        mInter[0] = new InterstitialAd(Questions.this);
        mInter[0].setAdUnitId(getString(R.string.inter_finish));
        mInter[0].loadAd(adIRequest);

        mInter[1] = new InterstitialAd(Questions.this);
        mInter[1].setAdUnitId(getString(R.string.inter_1));
        mInter[1].loadAd(adIRequest2);

        mInter[2] = new InterstitialAd(Questions.this);
        mInter[2].setAdUnitId(getString(R.string.inter_2));
        mInter[2].loadAd(adIRequest3);

        mInter[1].setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                showing=false;
                startCountDown();
            }
        });
        mInter[2].setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                showing=false;
                startCountDown();
            }
        });
    }
    public void displayInterstitial() {
        // Toast.makeText(this, "loaded", Toast.LENGTH_SHORT).show();
        mInter[0].show();
        finish();
    }
}
