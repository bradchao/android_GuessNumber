package tw.brad.guessnumber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private View btnGuess;
    private EditText editInput;
    private TextView textInfo;

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
    }

    private void doGuess(){
        // TODO 進行猜數字的程序
    }

    private void createAnswer(int n){
        // TODO 產生指定參數位數(n)的謎底
    }

    private String checkAB(){
        // TODO 以謎底字串及editInput的字串比對, 回傳 ?A?B
        return "";
    }

}
