package com.example.lenovo.coustomdialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by lenovo on 20/02/2018.
 */

public class DialogFragment extends AppCompatDialogFragment {
    EditText name,age;
    OkClickLisner onKeyListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            onKeyListener =(OkClickLisner) context;
        } catch (Exception e) {
//            throw new ClassCastException(context.toString() + "must implement dialg fragment");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog,null);

        name = view.findViewById(R.id.name_edittext);
        age = view.findViewById(R.id.age_edittext);

        builder
                .setView(view)
                .setTitle("Enter yor name niga ")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    String n;
                    int a;
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//                          if(!name.equals("") && !age.equals("")) {
                        try{
                            n = name.getText().toString();
                            a = Integer.parseInt(age.getText().toString());
//                        }

                            onKeyListener.applyText(n,a);
                        } catch (Exception e) {
                            Toast.makeText(getContext(),"niga ",Toast.LENGTH_SHORT).show();
                        }

                    }
                });


        return builder.create();
    }

    public interface OkClickLisner{
        void applyText(String name,int age);
    }
}
