package cn.rehtt.base64;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64InputStream;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {
    Button button,button2;

    AutoCompleteTextView in,out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        button2=(Button)findViewById(R.id.button2);
        in=(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView2);
        out=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String a="";
                a= String.valueOf(in.getText());


                out.setText(toBase64(a));


            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a="";
                a= String.valueOf(in.getText());

               out.setText(toString(a));

            }

            private String toString(String a) {

                return toStringl(a);
            }


        });



    }


    public String toBase64(String s){
        byte[] bytes=null;
        try {
            bytes=s.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        org.apache.commons.codec.binary.Base64 base64=new org.apache.commons.codec.binary.Base64();
        bytes=base64.encode(bytes);
        String s1=new String(bytes);

        return s1;
    }

    public String toStringl(String s){
        byte[] bytes=s.getBytes();
        org.apache.commons.codec.binary.Base64 base64=new org.apache.commons.codec.binary.Base64();
        bytes=base64.decode(bytes);
        String q=new String(bytes);
        return  q;
    }




}
