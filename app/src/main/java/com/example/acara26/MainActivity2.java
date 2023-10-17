package com.example.acara26;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class MainActivity2 extends AppCompatActivity {
    TextView showtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        showtext = (TextView) findViewById(R.id.gettext);
    }

    public void back(View view) {
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
    }

    public void getPublic(View view) {
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File myfile = new File(folder, "mydata1.txt");
        String text = getdata(myfile);
        if (!text.equals("")) {
            showtext.setText(text);
        } else {
            showtext.setText("No Data");
        }
    }
 public void getPrivate(View view) {
     File folder = getExternalFilesDir("Fachruddin");
     File myFile = new File(folder, "mydata2.txt");
     String text = getdata(myFile);
     if (!text.equals("")) {
     showtext.setText(text);

 }else {
        showtext.setText("no data");
    }
 }
private String getdata(File myfile){
    FileInputStream fileInputStream = null;
    try{
        fileInputStream = new FileInputStream(myfile);
        int i = -1;
        StringBuffer buffer = new StringBuffer();
        while ((i = fileInputStream.read())!= -1){
            buffer.append((char) i);
        }
        return buffer.toString();
    }catch (Exception e){
        e.printStackTrace();
    } finally {
        if (fileInputStream != null){
            try {
                fileInputStream.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
return null;
}
}