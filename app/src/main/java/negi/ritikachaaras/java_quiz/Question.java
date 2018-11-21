package negi.ritikachaaras.java_quiz;

import android.os.Parcel;
import android.os.Parcelable;

public class Question implements Parcelable {
    public static final String Basic = "Basic";
    public static final String Control="Control_Statements";
    public static final String Array="Array";
    public static final String OOps_Concept="OOps_Concept";
    public static final String Exception_Handling="Exception_Handling";
    public static final String String_Wrapper="String & Wrapper Classes";
    public static final String Inner_Classes="Inner_Classes";
    public static final String Multi_Threading="Multi_Threading";
    public static final String Collection= "Collection";
    public static final String JDBC= "JDBC";

    public static final String DIFICULTY_HARD = "Hard";
    private String question1;
    private String option1;
    private String option2;
    private String option3;
    private int answerNr;
    public String Ans;
    private String dificulity;

    public Question() {

    }

    public Question(String question1, String option1, String option2, String option3, int answerNr,String dificulity,String Ans) {
        this.question1 = question1;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.answerNr = answerNr;
        this.dificulity=dificulity;
        this.Ans=Ans;
    }

    protected Question(Parcel in) {
        question1 = in.readString();
        option1 = in.readString();
        option2 = in.readString();
        option3 = in.readString();
        answerNr = in.readInt();
        dificulity=in.readString();
        Ans=in.readString();
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public int getAnswerNr() {
        return answerNr;
    }

    public void setAnswerNr(int answerNr) {
        this.answerNr = answerNr;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question1);
        dest.writeString(option1);
        dest.writeString(option2);
        dest.writeString(option3);
        dest.writeInt(answerNr);
        dest.writeString(dificulity);
        dest.writeString(Ans);
    }

    public String getAns() {
        return Ans;
    }

    public void setAns(String ans) {
        Ans = ans;
    }

    public String getDificulity() {
        return dificulity;
    }

    public void setDificulity(String dificulity) {
        this.dificulity = dificulity;
    }
    public static String[]getAllDificultyLevel()
    {
        return new String[]{
                Basic,
                Control,
                DIFICULTY_HARD
        };
    }
}
