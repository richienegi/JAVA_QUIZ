package negi.ritikachaaras.java_quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ExampleItem> examplelist;
    RecyclerView recyclerView;
    ExampleAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutMnager;
    TextView text_view_highscore;
    public static final String EXTRA_DIFICULTY="extraDifivulty";
    private static final int REQUEST_CODE_INT=1;
    public static final String SHERE_PREFS="sheredpref";
    public static final String KEY_HIGHESTSCORE="KeyHighscore";
    int highscore;
String dificulty="";
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar topToolBar = (Toolbar)findViewById(R.id.toolbar);

        setSupportActionBar(topToolBar);
        /*getSupportActionBar().setTitle("My title");*/

        examplelist = new ArrayList<>();
        examplelist.add(new ExampleItem("Basic & History"));
        examplelist.add(new ExampleItem("Control_Statements"));
        examplelist.add(new ExampleItem("Array"));
        examplelist.add(new ExampleItem("OOPs Concept"));
        examplelist.add(new ExampleItem("Exception-Handling"));
        examplelist.add(new ExampleItem("String & Wrapper Classes"));
        examplelist.add(new ExampleItem("Inner Classes"));
        examplelist.add(new ExampleItem("MultiThreading"));
        examplelist.add(new ExampleItem("Collection"));
        examplelist.add(new ExampleItem("JDBC"));
        recyclerView = findViewById(R.id.recyclerView);
        text_view_highscore=findViewById(R.id.text_view_highscore);

        recyclerView.setHasFixedSize(true);
        mLayoutMnager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(examplelist);
        recyclerView.setLayoutManager(mLayoutMnager);
        recyclerView.setAdapter(mAdapter);
        loadHighestScore();

        mAdapter.setItemOnClickListener(new ExampleAdapter.OnItemClickedListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
                switch(position)
                {
                    case 0:
                        dificulty="Basic";
                        break;
                    case 1:
                        dificulty="Control_Statements";
                        break;
                    case 2:
                        dificulty="Array";
                        break;
                    case 3:
                        dificulty="OOps_Concept";
                        break;
                    case 4:
                        dificulty="Exception_Handling";
                        break;
                    case 5:
                        dificulty="String & Wrapper Classes";
                        break;
                    case 6:
                        dificulty="Inner_Classes";
                        break;
                    case 7:
                        dificulty="Multi_Threading";
                        break;
                    case 8:
                        dificulty="Collection";

                    case 9:
                        dificulty="JDBC";
                        break;



                }


                startQuiz();

            }
        });
    }
        private void startQuiz() {
            Intent i=new Intent(MainActivity.this,QuizActivity.class);
            i.putExtra(EXTRA_DIFICULTY,dificulty);
            startActivityForResult(i,REQUEST_CODE_INT);
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode==REQUEST_CODE_INT)
            {
                if(resultCode==RESULT_OK)
                {
                    int score=data.getIntExtra(QuizActivity.EXTRA_SCORE,0);
                    if(score>highscore)
                    {
                        updateHighestScore(score);
                    }
                }
            }
        }
        public void loadHighestScore()
        {
            SharedPreferences preferences=getSharedPreferences(SHERE_PREFS,MODE_PRIVATE);
            highscore=preferences.getInt(KEY_HIGHESTSCORE,0);
            text_view_highscore.setText("Highest Score :"+highscore);
        }

        private void updateHighestScore(int highscorenew) {
            highscore=highscorenew;
            text_view_highscore.setText("Highest Score :"+highscore);
            SharedPreferences preferences=getSharedPreferences(SHERE_PREFS,MODE_PRIVATE);
            SharedPreferences.Editor editor=preferences.edit();
            editor.putInt(KEY_HIGHESTSCORE,highscore);
            editor.apply();
        }
    }




