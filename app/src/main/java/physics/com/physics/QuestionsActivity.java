package physics.com.physics;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruno on 29/10/15.
 */
public class QuestionsActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);

        List<String> correctAnwsers = fillCorrectAnwsers();
        List<String> userAnswers = fillUserAnwsers();
        Toast.makeText(this, "" + correctAnwsers.size(),Toast.LENGTH_LONG).show();
        Toast.makeText(this, "" + userAnswers.size(),Toast.LENGTH_LONG).show();

        compare(correctAnwsers, userAnswers);
    }

    private List<String> fillCorrectAnwsers() {
        List<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("A");

        return list;
    }

    private List<String> fillUserAnwsers() {
        List<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("B"); //errada

        return list;
    }

    private void compare(List<String> correctAnwsers, List<String> userAnswers) {
        if(userAnswers.size() == correctAnwsers.size()) {
            for (int position = 0; position < correctAnwsers.size(); position++) {
                if(correctAnwsers.get(position).equals(userAnswers.get(position))) {
                    Log.d("QUESTIONS => ", userAnswers.get(position) +  " | Correta!");
                } else {
                    Log.d("QUESTIONS => ", userAnswers.get(position) +  " | Incorreta!"
                            + " | resposta correta: " + correctAnwsers.get(position));
                }
            }
        } else {
            Log.d("COMPARE_ERROR", "");
        }
    }
}
