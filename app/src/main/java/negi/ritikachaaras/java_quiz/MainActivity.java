package negi.ritikachaaras.java_quiz;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {
    ArrayList<ExampleItem> examplelist;
    RecyclerView recyclerView;
    ExampleAdapter mAdapter;
    private PrefManager prefManager;
    RecyclerView.LayoutManager mLayoutMnager;
    TextView text_view_highscore;
    public static final String EXTRA_type = "extraDifivulty";
    String mtitle="";
    private static final int REQUEST_CODE_INT = 1;
    public static final String SHERE_PREFS = "sheredpref";
    public static final String KEY_HIGHESTSCORE = "KeyHighscore";
    int highscore;
    String timer="30000";
    String type = "";
    String mtitile="";
    private AdView mAdView;
    AdRequest adRequest;
    ImageView msettime;
    private InterstitialAd interstitial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefManager = new PrefManager(MainActivity.this);
        text_view_highscore = findViewById(R.id.text_view_highscore);
        loadHighestScore();
        msettime=(ImageView)findViewById(R.id.settime);
msettime.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        showAlertDialog();
    }
});



        Bundle networkExtrasBundle = new Bundle();
        networkExtrasBundle.putInt("rdp", 1);
        adRequest = new AdRequest.Builder()
                .addNetworkExtrasBundle(AdMobAdapter.class, networkExtrasBundle)
                .build();

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("gad_rdp", 1);
        editor.commit();


        mAdView = (AdView) findViewById(R.id.adView);


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

        Toolbar topToolBar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(topToolBar);
        /*getSupportActionBar().setTitle("My title");*/

        examplelist = new ArrayList<>();
        examplelist.add(new ExampleItem("All"));
        examplelist.add(new ExampleItem("Basic & History"));
        examplelist.add(new ExampleItem("Control Statements"));
        examplelist.add(new ExampleItem("Array"));
        examplelist.add(new ExampleItem("OOPs Concept"));
        examplelist.add(new ExampleItem("Exception Handling"));
        examplelist.add(new ExampleItem("String & Wrapper Classes"));
        examplelist.add(new ExampleItem("Inner Classes"));
        examplelist.add(new ExampleItem("MultiThreading"));
        examplelist.add(new ExampleItem("Collection"));
        examplelist.add(new ExampleItem("JDBC"));
        recyclerView = findViewById(R.id.recyclerView);


        recyclerView.setHasFixedSize(true);
        mAdapter = new ExampleAdapter(examplelist);
        recyclerView.setAdapter(mAdapter);

        mLayoutMnager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(mLayoutMnager);




        mAdapter.setItemOnClickListener(new ExampleAdapter.OnItemClickedListener() {
            @Override
            public void onItemClick(int position) {

                switch (position) {
                    case 0:
                        type = "All";
                        mtitle="Java Quiz";
                        break;
                    case 1:
                        type = "Basic";
                        mtitle="Basic & History";
                        break;
                    case 2:
                        type = "Control";
                        mtitle="Control Statements";
                        break;
                    case 3:
                        type = "Array";
                        mtitle="Array";
                        break;
                    case 4:
                        type = "OOps_Concept";
                        mtitle="OOPs Concept";
                        break;
                    case 5:
                        type = "Exception_Handling";
                        mtitle="Exception Handling";
                        break;
                    case 6:
                        type = "String_Wrapper";
                        mtitle="String & Wrapper Classes";
                        break;
                    case 7:
                        type = "Inner_Classes";
                        mtitle="Inner Classes";
                        break;
                    case 8:
                        type = "Multi_Threading";
                        mtitle="MultiThreading";
                        break;
                    case 9:
                        type = "Collection";
                        mtitle="Collection";
                        break;
                    case 10:
                        type = "JDBC";
                        mtitle="JDBC";
                        break;


                }
                Toast.makeText(MainActivity.this,examplelist.get(position).getMtext1(), Toast.LENGTH_SHORT).show();


                startQuiz();

            }
        });
        TimerTask tt = new TimerTask() {

            @Override
            public void run() {
                MainActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        mAdView.loadAd(adRequest);
                    }
                });

            }
        };

        Timer t = new Timer();
        t.scheduleAtFixedRate(tt, 0, 1000 * 45);
    }

    private void startQuiz() {
       /* Intent i = new Intent(MainActivity.this, QuizActivity.class);*/
        Intent i = new Intent(MainActivity.this, Questions.class);
        i.putExtra(EXTRA_type, type);
        i.putExtra("mtitle", mtitle);
        startActivity(i);
       // startActivityForResult(i, REQUEST_CODE_INT);
    }



    public void loadHighestScore() {

        highscore=Integer.parseInt(prefManager.getScore());
        text_view_highscore.setText("Highest Score :" + highscore);
        Log.d("heighest_score:",String.valueOf(highscore));
    }

  /*  @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    private void updateHighestScore(int highscorenew) {
        highscore = highscorenew;
        text_view_highscore.setText("Highest Score :" + highscore);
        SharedPreferences preferences = getSharedPreferences(SHERE_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(KEY_HIGHESTSCORE, highscore);
        editor.apply();

    }*/

    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }
    private void showAlertDialog() {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.timealert, null);
        AdView adView = alertLayout.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setView(alertLayout);
        alertDialog.setTitle("Set Total Timer(Minute):");
       final String [] items = {"4:00","4:30","5:00","5:30","6:00","6:30","7:00"};
        int checkedItem = 1;

        alertDialog.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
             switch (which)
             {
                 case 0:
                     timer="240000";
                     break;
                 case 1:
                     timer="270000";
                     break;
                 case 2:
                     timer="300000";
                     break;
                 case 3:
                     timer="330000";
                     break;
                 case 4:
                 timer="360000";
                 break;
                 case 5:
                     timer="390000";
                     break;
                 case 6:
                     timer="420000";
                     break;

             }
            }
        });
        alertDialog.setPositiveButton("Save",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        prefManager.setTime(timer);
                        Toast.makeText(MainActivity.this,"Timer Updated", Toast.LENGTH_SHORT).show();
                    }
                });
        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        AlertDialog alert = alertDialog.create();
        alert.setCanceledOnTouchOutside(false);
        alert.show();
    }
}




