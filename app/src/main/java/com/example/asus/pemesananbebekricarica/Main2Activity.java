package com.example.asus.pemesananbebekricarica;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {

    TextView txtJumlahPesanan, txtHarga, txtGetNama;
    EditText edtNama;
    CheckBox cbx_Bebek, cbx_Ayam;
    int jumlah, total, harga=10, Bebek, Ayam;
    String nama, statusBebek = "tidak", statusAyam = "tidak";
    boolean iscbx_bebek, iscbx_ayam;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
         txtJumlahPesanan = (TextView) findViewById(R.id.txt_jumlah);
        txtHarga = (TextView) findViewById(R.id.txt_getPrice);
        edtNama = (EditText) findViewById(R.id.txt_Nama);
        txtGetNama = (TextView) findViewById(R.id.txt_getNama);
        cbx_Bebek = (CheckBox) findViewById(R.id.cbx_Bebek);
        cbx_Ayam = (CheckBox) findViewById(R.id.cbx_Ayam);

        final Button btnShare = (Button) findViewById(R.id.btnShare);

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnShare =
                btnShare.share();
            }
        });
    }
    public void pilihanmenu(){
    if (cbx_Bebek.isChecked()){
        iscbx_bebek=true;
        statusBebek="Bebek";
        Bebek=1;
    }else{
        iscbx_bebek=false;
        statusBebek="";
        Bebek=0;
    }
        if (cbx_Ayam.isChecked()){
            iscbx_ayam=true;
            statusAyam="Bebek";
            Ayam=2;
        }else{
            iscbx_ayam=false;
            statusAyam="";
            Ayam=0;
        }
    }
    public void tambah(View view){
    jumlah = jumlah + 1;
    txtJumlahPesanan.setText("" + jumlah);
    }
    public void kurang(View view){
        jumlah = jumlah - 1;
        txtJumlahPesanan.setText(""+jumlah);
    }

    public void order(View view) { display(harga);}

    public void display(int harga){

        pilihanmenu();
        total = jumlah*harga;
        if(iscbx_bebek){
            total += (jumlah * Bebek);
        }
        if (iscbx_ayam){
            total += (jumlah * Ayam);
        }
        Log.i( "harga :", "" +total);
        nama = edtNama.getText().toString();
        txtGetNama.setText("Nama : " + nama +
                    "\n" + statusBebek +
                    "\n" + statusAyam +
                    "\nTerimakasih");
        txtHarga.setText("Harga : Rp." +total +"000");
        }
        public void share(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL, "apridochelsea@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Pemesanan Bebek Rica Rica");
        intent.putExtra(Intent.EXTRA_TEXT,
                 "Nama : " + nama +
                    "\n" + statusBebek +
                    "\n" + statusAyam +
                    "\n" + "Harga : Rp."+ total +"000"+
                    "\n" + "Terimakasih");

        startActivity(Intent.createChooser(intent,  "Send Mail"));
        }
}

