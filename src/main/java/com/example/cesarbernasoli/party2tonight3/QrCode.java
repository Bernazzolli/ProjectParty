package com.example.cesarbernasoli.projectparty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class QRCode extends Fragment {

    private static final String TAG = "QR CODE";

    private static final int QR_SCANNER_REQUEST_CODE = 312;
    private Button btnReader,btnGenerator;
    final Activity activity = getActivity();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_qrcode,container,false);
        btnReader = (Button) view.findViewById(R.id.btnReader);
        btnGenerator = (Button) view.findViewById(R.id.btnGenerator);

        btnReader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // alert("Ainda em desenvolvimento");
                IntentIntegrator integrator = new IntentIntegrator(getActivity());
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Camera Scan");
                integrator.setCameraId(0);
                integrator.initiateScan();
            }
        });

        btnGenerator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // scan();
                alert("Ainda em desenvolvimento");
            }
        });


        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);

        if(result != null)
        {
            alert("result != null");
         if(result.getContents() != null)
         {
             alert("result.getCOntent() != null");
         }
         else
         {
             alert("Scan Cancelado");
         }
        }
        else
        {
            alert("ultimo else ");
        }
    }

    public void alert(String mensagem) {

        Toast.makeText(getActivity().getApplicationContext(),mensagem,Toast.LENGTH_LONG).show();

    }
}
