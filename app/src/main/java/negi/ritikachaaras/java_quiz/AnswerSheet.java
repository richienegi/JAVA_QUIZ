package negi.ritikachaaras.java_quiz;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Timer;
import java.util.TimerTask;

import static negi.ritikachaaras.java_quiz.Questions.countor;
import static negi.ritikachaaras.java_quiz.Questions.totalq;


public class AnswerSheet extends AppCompatActivity {
RecyclerView list;
AdView mAdView;
int score=0;
AdRequest adRequest;
    PrefManager prefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_sheet);

        prefManager=new PrefManager(this);
        score=Integer.parseInt(prefManager.getScore());
        DialogDemo();

        mAdView=findViewById(R.id.adView);
        Bundle networkExtrasBundle = new Bundle();
        networkExtrasBundle.putInt("rdp", 1);
        adRequest = new AdRequest.Builder()
                .addNetworkExtrasBundle(AdMobAdapter.class, networkExtrasBundle)
                .build();

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("gad_rdp", 1);
        editor.commit();
        mAdView.loadAd(adRequest);



        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                mAdView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
//                Toast.makeText(MainActivity.this, "Failed to load"+i, Toast.LENGTH_SHORT).show();
                // Log.d("FailedAdd",String.valueOf(i));
            }

            @Override
            public void onAdImpression() {
                super.onAdImpression();
                //Toast.makeText(MainActivity.this, "Hits", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
//                Toast.makeText(MainActivity.this, "Opened", Toast.LENGTH_SHORT).show();
            }
        });



        list = findViewById(R.id.list);
       // AnswerList an = new AnswerList(getApplication(), Questions.result, Questions.answerselected);
        AnswerAdapter an=new AnswerAdapter(getApplication(), Questions.result, Questions.answerselected);
        list.setAdapter(an);
        LinearLayoutManager lm = new LinearLayoutManager(this);//to show card view, recycler View
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        list.setLayoutManager(lm);
        list.setItemAnimator(new DefaultItemAnimator());//


        TimerTask tt = new TimerTask() {

            @Override
            public void run() {
                AnswerSheet.this.runOnUiThread(new Runnable() {
                    public void run() {
                        mAdView.loadAd(adRequest);
                    }
                });

            }
        };

        Timer t = new Timer();
        t.scheduleAtFixedRate(tt, 0, 1000 * 45);

    }
        public void DialogDemo() {

            // Create Object of Dialog class
            final Dialog login = new Dialog(this);
            login.setCancelable(false);
            // Set GUI of login screen
//        login.setTitle("Please enter your name");
            login.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            login.setContentView(R.layout.dialogdemo);
            // Init button of login GUI
            Button btnLogin = (Button) login.findViewById(R.id.btnLogin);
            final TextView scoredata = (TextView) login.findViewById(R.id.txtUsername);

            scoredata.setText("You Scored:" + "\n" + countor + " / " + totalq);
            if(countor>score)
            {
                prefManager.setScore(String.valueOf(countor));
            }
            // Attached listener for login GUI button
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    login.dismiss();
                    countor=0;
                    //finish();
                }


            });

            // Make dialog box visible.
            login.show();
        }




}
