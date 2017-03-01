package com.apps.mvbs.framentstestwithretain;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by mvbs on 22/02/17.
 */

public class FragmentOne extends Fragment {

    private static final String TAG = "f1";
    private String valorTemporario = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate( R.layout.fragmentone_main, container, false );
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView tv = (TextView) getView().findViewById(R.id.id_tv_frag1);
        Log.i(TAG, "Entrou no AC" + tv.getText());

        if ( valorTemporario.length() != 0 ){
            tv.setText(valorTemporario);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Button bt1 = (Button) getView().findViewById(R.id.id_bt1_frag1);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) getView().findViewById(R.id.id_tv_frag1);
                tv.setText("Black Seeeeeeeeeebooooooooooo!");
                valorTemporario = tv.getText().toString();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "Destruiu o fragmento (View)");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Destruiu o fragmento");
    }
}
