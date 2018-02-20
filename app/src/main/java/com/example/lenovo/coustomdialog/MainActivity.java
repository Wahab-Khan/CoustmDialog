package com.example.lenovo.coustomdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements DialogFragment.OkClickLisner{

    TextView nameT,ageT;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameT = findViewById(R.id.name);
        ageT = findViewById(R.id.age);
        button = findViewById(R.id.open_dialog_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
    }

    void openDialog(){
        DialogFragment dialogFragment = new DialogFragment();
        dialogFragment.show(getSupportFragmentManager(),"test");
    }

    @Override
    public void applyText(String name, int age) {
        nameT.setText(name.toString());
        ageT.setText(Integer.toString(age));
    }
}
