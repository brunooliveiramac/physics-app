package physics.com.physics.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import physics.com.physics.R;
import physics.com.physics.helper.DiffractionHelper;
import physics.com.physics.helper.TaskHelper;
import physics.com.physics.task.AnswerTask;

/**
 * Created by bruno on 30/10/15.
 */
public class DiffractionQuestionsFragment extends Fragment {

    TaskHelper taskHelper = new TaskHelper() {
        @Override //setting image and verify
        public void processFinish(HashMap<Long, String> output) {
           helper.settingImagensAndExplanation(output);
           helper.openDialog(DiffractionQuestionsFragment.this, output);
        }};


    private View view;
    private DiffractionHelper helper;

    private RadioGroup radioGroupQ1;
    private RadioGroup radioGroupQ2;

    private Button confirm;
    private Button clean;

    private HashMap<Long,String> map = new HashMap<Long, String>();



    public DiffractionQuestionsFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.diffraction_questions_layout, container, false);

        helper = new DiffractionHelper(view);
        helper.initializeUIElements();

        radioGroupQ1 = (RadioGroup)view.findViewById(R.id.rgroupq1);
        radioGroupQ2 = (RadioGroup)view.findViewById(R.id.rgroupq2);

        confirm = (Button)view.findViewById(R.id.confirmQuestions);
        clean = (Button)view.findViewById(R.id.cleanQuestions);


            radioGroupQ1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    for(int i=0; i<group.getChildCount(); i++) {
                        String userAns = null;
                        group.getChildAt(i).setEnabled(false);
                        RadioButton  btnq1 = (RadioButton) group.getChildAt(i);
                        if(btnq1.getId() == checkedId) {
                            userAns =btnq1.getText().toString();
                            map.put(1L, userAns);
                        }
                    }
                }});



            radioGroupQ2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    for(int i=0; i<group.getChildCount(); i++) {
                        String userAns = null;
                        group.getChildAt(i).setEnabled(false);
                        RadioButton btn = (RadioButton) group.getChildAt(i);
                        if(btn.getId() == checkedId) {
                            userAns = btn.getText().toString();
                            map.put(2L, userAns);
                        }
                    }
                }});

            confirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(map.size() < 2){
                        Log.d("Responda Todas!", "");
                    }else{
                        new AnswerTask(map,taskHelper).execute();
                    }
                }
            });

            clean.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        setRetainInstance(true);
                }
            });

        return view;
    }

    public void onRadioButtonClicked(View v){

    }





}
