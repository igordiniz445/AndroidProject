package com.example.gamepc.agendamento3;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by NgocTri on 6/18/2016.
 */
public class QR_Code extends Activity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;
    public static String string;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_qr__code);
        onClick(findViewById(R.id.menu_qr));
    }

    public void onClick(View v){
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
//        mScannerView.stopCamera();
        finish();
    }

    @Override
    public void handleResult(Result result) {
        //Do anything with result here :D
        Log.w("handleResult", result.getText());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scan result");
        builder.setMessage(result.getText());
        String resultado = result.getText();
        //AlertDialog alertDialog = builder.create();
        //alertDialog.show();
        Intent chamaTelaFazerReserva = new Intent(QR_Code.this, FazerReserva.class);
        chamaTelaFazerReserva.putExtra(FazerReserva.QR_LAB, resultado);
        startActivity(chamaTelaFazerReserva);

        //Resume scanning
        //mScannerView.resumeCameraPreview(this);
    }
}