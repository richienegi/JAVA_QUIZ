package negi.ritikachaaras.java_quiz;


import com.google.gson.annotations.SerializedName;

public class Quiz {

    @SerializedName("id")
    int id;

    @SerializedName("question")
    String question;

    @SerializedName("option1")
    String option1;

    @SerializedName("option2")
    String option2;

    @SerializedName("option3")
    String option3;



    @SerializedName("answer")
    String answer;


    @SerializedName("description")
    String description;

    public Quiz(int id, String question, String option1, String option2, String option3, String answer, String description) {
        this.id = id;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.answer = answer;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getAnswer() {
        return answer;
    }

    public String getDescription() {
        return description;
    }
}
