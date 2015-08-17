package com.sc.calculator.calculator;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.widget.ImageButton;
import android.widget.TextView;
import java.util.List;
import java.util.ArrayList;



public class MainCalc extends AppCompatActivity implements View.OnClickListener{

    TextView dis;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0; //buttons 0-9
    Button backButton,bd,bs,bres,bCle,ba,bm ;
    ImageButton imgButton;
    String str; //string that save the text from the display
    List signList = new ArrayList<>();//array of sign save the possition of every sign + - * /
    int num1, num2,res, sign = 0 ; //1=+ , 2 = - , 3 = / , 4 = *


    private void  calculate()
    {
        Log.i("Calculate Function:","");

        num2 = Integer.parseInt(dis.getText().toString());
        dis.setText("");

        if(sign==1)//+
        {
            res = num1+num2;
            if(res==20)
            {
                Log.i("Calculate()", "The resault was 20");
            }
        }
        if(sign==2)//-
        {
            res = num1-num2;
            if(res==17)
            {
                Log.i("Calculate()", "The resault was 17");
            }
        }
        if(sign==3)// /
        {
            if(num2!=0) {
                res = num1 / num2;
            }
        }
        if(sign==4)//*
        {
            res = num1*num2;
        }

        dis.setText(res+"");

    }

    private String validate()
    {

        /*
        About -   this function get the display text
        and search every sign like + - * /
        when founded - the posititon saved in SignList var
        signList - saved the index of the sign from the display
         */

        char c;

        String tav ;//store tav like + - * /  at String type

        str = dis.getText().toString(); // store the text from display in var STR


        if(str.isEmpty() == false) {

            for (int index = 0; index < str.length(); index++) {
                c = str.charAt(index);//get the specific tav at the current index

                tav = c + "";//cast CHAR to String

                if (tav.equals("+") || tav.equals("-") || tav.equals("*") || tav.equals("/")) {
                    signList.add(index);//add the position to list
                }

            }
                return "Success";

        }


     return "Fail";
    }

    private void show(String someText)
    {
        if(dis.getText()!=null) {
            String res =  dis.getText().toString();
            dis.setText(res+someText);

        }
    }
    private void setup()
    {
        b1 =(Button) findViewById(R.id.b1);
        b2=(Button) findViewById(R.id.b2);
        b3=(Button) findViewById(R.id.b3);
        b4=(Button) findViewById(R.id.b4);
        b5=(Button) findViewById(R.id.b5);
        b6 =(Button) findViewById(R.id.b6);
        b7 =(Button) findViewById(R.id.b7);
        b8=(Button) findViewById(R.id.b8);
        b9=(Button) findViewById(R.id.b9);
        b0 =(Button) findViewById(R.id.b0);
        ba=(Button) findViewById(R.id.addButton);
        bs=(Button) findViewById(R.id.subButton);
        dis = (TextView)findViewById(R.id.display);
        bres = (Button)findViewById(R.id.resButton);
        bd = (Button) findViewById(R.id.divButton);
        bCle = (Button) findViewById(R.id.clearButton);
        backButton = (Button)findViewById(R.id.backButton);
        bm = (Button)findViewById(R.id.mulButton);
        imgButton = (ImageButton) findViewById(R.id.imageButton);



        b1.setOnClickListener(this);//1
        b2.setOnClickListener(this);//2
        b3.setOnClickListener(this);//3
        b4.setOnClickListener(this);//4
        b5.setOnClickListener(this);//5
        b6.setOnClickListener(this);//6
        b7.setOnClickListener(this);//7
        b8.setOnClickListener(this);//8
        b9.setOnClickListener(this);//9
        b0.setOnClickListener(this); //0
        ba.setOnClickListener(this); //add
        bs.setOnClickListener(this);//sub
        bres.setOnClickListener(this); //res
        bd.setOnClickListener(this); //div
        backButton.setOnClickListener(this); //back
        bCle.setOnClickListener(this);//clear
        bm.setOnClickListener(this);//mul
        imgButton.setOnClickListener(this);

    }

     public void onClick(View v)
    {
        if(v.equals(b1))
        {
            show("1");

        }

        if(v.equals(b2))
        {
            show("2");
        }

        if(v.equals(b3))
        {
            Log.i("OnClick()","Button 3 was clicked!");
            show("3");
        }

        if(v.equals(b4))
        {
            show("4");

        }

        if(v.equals(b5))
        {
            show("5");
        }

        if(v.equals(b6))
        {
            show("6");
        }

        if(v.equals(b7))
        {
            show("7");
        }

        if(v.equals(b8))
        {
            show("8");
        }

        if(v.equals(b9))
        {
            show("9");
        }

        if(v.equals(b0)) {
            show("0");
        }

        if(v.equals(bres))
        {
           if(validate().equals("Success"))
           {
               calculate();
           }else
           {
               dis.setText("פעולה לא חוקית");
           }
        }

        if(v.equals(ba) || v.equals(bs) || v.equals(bd) || v.equals(bm))
        {

           num1 = Integer.parseInt(dis.getText().toString());

            if(v.equals(ba))//display the char add +
            {
                sign =1;
                show("+");

            }
            if(v.equals(bs))//display the char sub -
            {
                sign =2;
                show("-");

            }
            if(v.equals(bm))//display the char mul *
            {
                sign =3;
                show("*");

            }
            if(v.equals(bd))//display the char div /
            {
                sign =4;
                show("/");

            }
            dis.setText("");


        }

        if(v.equals(imgButton))
        {


            Log.i("onClick()", "imgButton clicked");
            imgButton.setImageResource(R.drawable.kitten);
            Drawable img = (Drawable)imgButton.getBackground();
            if(img.equals(R.drawable.dog_2))
            {
                Log.e("onClick()", "The img was NOT changed!");// nothing...
            }else
            {
                Log.i("onClick()", "The img was changed!"); //the image changed
            }

        }





    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calc);

          setup();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_calc, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
