package physics.com.physics.helper;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import physics.com.physics.R;
import physics.com.physics.model.Image;
import physics.com.physics.task.ResourceImageTask;

/**
 * Created by bruno on 03/11/15.
 */
public class DiffractionHelper {

    private View view;

    private ResourceHelper resourceHelper;

    private ImageView imageQuestion1;
    private ImageView imageQuestion2;

    private ImageView imageViewCorrectQuestion1;
    private ImageView imageViewWorongQuestion1;


    List<ImageView> viewImages = new ArrayList<>();


    private static final String BASE_URL = "http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/content";


    public DiffractionHelper(){

    }

    public DiffractionHelper(View view) {
        this.view = view;
        resourceHelper = new ResourceHelper();

    }


    public void initializeUIElements() {
        imageViewCorrectQuestion1 = (ImageView) view.findViewById(R.id.r1);
        imageViewWorongQuestion1 = (ImageView) view.findViewById(R.id.r1W);

        viewImages.add(imageViewCorrectQuestion1);
        viewImages.add(imageViewWorongQuestion1);

        imageQuestion1 = (ImageView)view.findViewById(R.id.image_test_question1);
        imageQuestion2 = (ImageView)view.findViewById(R.id.image_test_question2);

        new ResourceImageTask(imageQuestion1, BASE_URL + "/2/image/1")
                .execute();
        new ResourceImageTask(imageQuestion2, BASE_URL + "/2/image/1")
                .execute();

    }

    public HashMap<Long, String> compareAnswers(HashMap<Long, String> mapServer, HashMap<Long, String> userAnswers){
           HashMap<Long, String> finalAnswers = new HashMap<Long, String>();
        for (HashMap.Entry pair : mapServer.entrySet()) {
            Long key = (Long)pair.getKey();
            if(userAnswers.containsKey(key)){
                if(userAnswers.get(key).contains(pair.getValue().toString())){
                    finalAnswers.put(Long.parseLong(pair.getKey().toString()), "C");
                    Log.d("Questão: ", pair.getKey().toString());
                    Log.d("Correta! ", pair.getValue().toString());
                }else{
                    finalAnswers.put(Long.parseLong(pair.getKey().toString()), "E");
                    Log.d("Questão: ", pair.getKey().toString());
                    Log.d("Incorreta! ", "Correta seria: " + pair.getValue().toString());
                }
            }
        }
        return finalAnswers;
    }


    public void settingImagensAndExplanation(HashMap<Long, String> output) {
        Long i = 1L; //incica questão 1
        ListIterator it = viewImages.listIterator(); //intarador na lista de imageview de cadas questão (correct, wrong)
        while(it.hasNext()){
                for (HashMap.Entry pair : output.entrySet()) { //pair para chave e valor que recebemos, verificamos respostas corretas e erradas
                            if(pair.getKey().equals(i) && pair.getValue().equals("C")){ //se chave igual a questão "i" e valor igual a "C" (Correta)
                                Object v = it.next(); //Pega primeiro objeto do interador
                                if(v instanceof ImageView){ //verifica se é uma imageview
                                    ((ImageView) v).setImageResource(R.mipmap.ic_action_done_all);//seta imageview "Correct" na questão
                                }
                                it.nextIndex();//manda para próximo indice...proxima imagem e vai para o fim do for indo para proxima questão
                            }
                            else{
                                Object v = it.next();
                                if(v instanceof ImageView){
                                    ((ImageView) v).setImageResource(R.mipmap.ic_navigation_close);//seta imagem incorreta
                                }
                                it.nextIndex();//próximo
                            }
                i++;//incremeta o numero da questão
                }
        }
    }


    public void openDialog(Fragment fragment, HashMap<Long, String> explanation){
        List<String> listCorrects = new ArrayList<>(explanation.values());
        int total = 1;
        for(int i = 1; i < listCorrects.size() ; i++){
           if(listCorrects.get(i).contains("C")){
              total = total + 1;
           }
        }
        AlertDialog.Builder alertDialogBuilder  = new AlertDialog.Builder(fragment.getContext());
        alertDialogBuilder.setTitle("Explanations: ");
        alertDialogBuilder
                .setIcon(R.mipmap.ic_icon_dialog)
                .setMessage("Parabéns! Você acertou: "+total+" de 10 questões!")
                .setCancelable(false)
                .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        alertDialog.getWindow().setLayout(900, 600);
    }






}
