package com.apps.mvbs.framentstestwithretain;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "programa";
    private FragmentOne f1 = new FragmentOne();
    private FragmentTwo f2 = new FragmentTwo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //Gerenciador de criacao das fragments
        final android.app.FragmentManager fragmentManager = getFragmentManager();

        //Botoes da aplicacao principal
        Button botaoMainFragOne = (Button) findViewById(R.id.id_bt1);
        Button botaoMainFragTwo = (Button) findViewById(R.id.id_bt2);

        //Criacao do primeiro Fragmento
        botaoMainFragOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ( !f1.isAdded() ) {

                    FragmentTransaction fragmentTransactionOne = fragmentManager.beginTransaction();
                    fragmentTransactionOne.add(R.id.id_fl1, f1);
                    fragmentTransactionOne.commit();
                }else {

                    FragmentTransaction fragmentTransactionOne = fragmentManager.beginTransaction();
                    fragmentTransactionOne.replace(R.id.id_fl1, f1);
                    fragmentTransactionOne.addToBackStack(null);
                    fragmentTransactionOne.commit();
                }
            }
        });

        botaoMainFragTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ( !f2.isAdded() ) {

                    FragmentTransaction fragmentTransactionTwo = fragmentManager.beginTransaction();
                    fragmentTransactionTwo.add(R.id.id_fl2, f2);

                    fragmentTransactionTwo.commit();
                }else {

                    FragmentTransaction fragmentTransactionTwo = fragmentManager.beginTransaction();
                    fragmentTransactionTwo.replace(R.id.id_fl2, f2);
                    fragmentTransactionTwo.commit();
                }

            }
        });
    }
}
