package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    int i = 2;
    int price = 0;
    int x = 0;
    int y = 0;
    int z = 0;
    String q1 = " ";
    String q2 = " ";
    String q3 = " ";
    String Name = "";
    String phone = "";
    String text = "";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void increment(View view)
    {
        if (i == 100)
        {
            Toast.makeText(getApplicationContext(), getString(R.string.no_more_coffee), Toast.LENGTH_SHORT).show();
            return;
        } else
        {
            i++;
            display(i);
        }
    }

    public void decrement(View view)

    {
        if (i == 1)
        {
            Toast.makeText(getApplicationContext(), getString(R.string.no_less_coffee), Toast.LENGTH_SHORT).show();
        } else
        {
            i--;
            display(i);
        }
    }


    public void submitOrder(View view)
    {
        displayPrice(i);
        disp();

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, (getString(R.string.order_details_of) + Name));
        intent.putExtra(Intent.EXTRA_TEXT, text);
        {
            if (intent.resolveActivity(getPackageManager()) != null)
                startActivity(intent);
        }


        x = 0;
        y = 0;
        z = 0;
        q1 = " ";
        q2 = " ";
        q3 = " ";
        Name = " ";
        phone="";

    }


    public void display(int number)
    {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(" " + number);
    }


    public void displayPrice(int number)
    {

        EditText n = (EditText) findViewById(R.id.et1);
        Name = n.getText().toString();


        EditText p = (EditText) findViewById(R.id.et2);
        phone = p.getText().toString();

        // priceTextView.setText(NumberFormat.getCurrencyInstance().format(price));
        price = number * (10 + x + y + z);
        String s = getString(R.string.total) + price;


        text = getString(R.string.nam)+ Name + Html.fromHtml("<br>") + getString(R.string.contact_number) + phone + Html.fromHtml("<br>") + s + Html.fromHtml("<br>") + q1 + Html.fromHtml("<br>") + q2 + Html.fromHtml("<br>") + q3;


        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(text);
    }


    public void disp()
    {
        Toast.makeText(getApplicationContext(), getString(R.string.thankyou), Toast.LENGTH_SHORT).show();
    }


    public void Check(View view)
    {

        boolean checked = ((CheckBox) view).isChecked();


        CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
        CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);

        switch (view.getId())
        {

            case R.id.checkBox1:
                if (checked)
                {
                    q1 = getString(R.string.topping_whippedcream);
                    x = 3;
                } else
                {
                }
                break;


            case R.id.checkBox2:
                if (checked)
                {
                    q2 =getString(R.string.topping_choc);
                    y = 2;
                } else
                {
                }
                break;

            case R.id.checkBox3:
                if (checked)
                {
                    q3 = getString(R.string.topping_sugar);
                    z = 1;
                } else
                {
                }
        }


    }

    public void Maps(View view)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:12°59'7.19 N ,79°58'11.39 E"));
        if (intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }
    }


    public void Message(View view)
    {

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:"));  // This ensures only SMS apps respond
        intent.putExtra("sms_body", text);
        if (intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }
    }

      public void Phone(View view)
      {
       Intent intent = new Intent(Intent.ACTION_DIAL);
       intent.setData(Uri.parse("tel:" + phone));
            if (intent.resolveActivity(getPackageManager()) != null)
            {
              startActivity(intent);
            }
      }


  /*  public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
    }
*/


   /* public void orientation()
    {
        Display dis=((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        int orien=dis.getOrientation();
        switch(orien)
        {
            case Configuration.ORIENTATION_PORTRAIT:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                break;
            case Configuration.ORIENTATION_LANDSCAPE:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                break;
        }
    }*/





}
