package tw.brad.guessnumber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    private View btnGuess;
    private EditText editInput;
    private TextView textInfo;
    private String strAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editInput = (EditText)findViewById(R.id.editInput);
        textInfo = (TextView)findViewById(R.id.textInfo);

        btnGuess = findViewById(R.id.btnGuess);
        btnGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doGuess();
            }
        });

        strAnswer = createAnswer(3);
    }

    private void doGuess(){
        // TODO 進行猜數字的程序
        String strGuess = editInput.getText().toString();
        String result = checkAB(strAnswer, strGuess);
        textInfo.append(strGuess + " => " + result + "\n");
        editInput.setText("");
    }

    /**
     * @param n 表示產生指定參數位數(n)的謎底
     * @return 產生 n 位數不重複數字的謎底字串
     */
    private String createAnswer(int n){
        HashSet<Integer> set = new HashSet<>();
        while (set.size()<n){
            set.add((int)(Math.random()*10));
        }
        StringBuffer sb = new StringBuffer(n);
        for (Integer i : set) sb.append(Integer.toString(i));
        return sb.toString();
    }

    /**
     * @param a 謎底字串
     * @param g 比對字串
     * @return 比對結果字串
     */
    private String checkAB(String a, String g){
        int A, B; A = B = 0;
        for (int i=0; i<g.length(); i++){
            if (g.charAt(i) == a.charAt(i)){
                A++;
            }else if (a.indexOf(g.charAt(i)) != -1){
                B++;
            }
        }
        return A + "A" + B + "B";
    }

}
