package com.example.cesarbernasoli.party2tonight3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.google.zxing.qrcode.encoder.QRCode;

import static android.widget.Toast.makeText;

public class tab3Fragment extends Fragment {

    private static final int QR_SCANNER_REQUEST_CODE = 312;
    private Button btnReader;
    private static final String TAG = "Tab3Fragment";




    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        final View view = inflater.inflate(R.layout.qrcode_activity,container,false);


        btnReader = (Button) view.findViewById(R.id.btnReader);
        btnReader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scan();
            }
        });
        return  view;

    }


    @Override
    public void onResume() {
        super.onResume();

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        Log.d(TAG, "onActivityResult: request: " + requestCode);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result != null){
            if (result.getContents() !=  null){
                alert(result.getContents());
            }else{
                alert("Scan cancelado");
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }

    }


    private void scan() {
        Log.d(TAG, "scan: start");


        IntentIntegrator integrator = new IntentIntegrator(getActivity());
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Camera Scan");
        integrator.setCameraId(0);
        integrator.initiateScan();

        integrator.initiateScan();
    }

    private void alert(String msg){
        makeText(getActivity().getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }

}