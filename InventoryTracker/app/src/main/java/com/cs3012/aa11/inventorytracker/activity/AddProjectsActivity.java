package com.cs3012.aa11.inventorytracker.activity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.zxing.integration.IntentIntegrator;
import com.google.zxing.integration.IntentResult;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.cs3012.aa11.inventorytracker.R;
import com.cs3012.aa11.inventorytracker.barcodeScanner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;


public class AddProjectsActivity extends AppCompatActivity implements OnClickListener{

    private  Button button;
    private  Button finishButton;
    private TextView formatText, contentText, dateText;
    List<String> equipmentList;
    StringBuilder builder = new StringBuilder();
    Calendar calendar = Calendar.getInstance();
    int startYear = calendar.get(Calendar.YEAR);
    int startMonth = calendar.get(Calendar.MONTH);
    int startDay = calendar.get(Calendar.DAY_OF_MONTH);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_projects);
        dateText = (TextView) findViewById(R.id.date);
        button = (Button) findViewById(R.id.button2);
        finishButton = (Button) findViewById(R.id.finishButton);
        contentText = (TextView)findViewById(R.id.textOne);
        button.setOnClickListener(this);
        finishButton.setOnClickListener(this);
    }

        public void onClick(View v) {
            if(v.getId() == R.id.button2) {
                IntentIntegrator scanIntegrator = new IntentIntegrator(this);
                scanIntegrator.initiateScan();
            }
            else if(v.getId() == R.id.finishButton) {
                new DatePickerDialog(AddProjectsActivity.this, date, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {

            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, monthOfYear);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }

    };
    private void updateLabel() {

        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        dateText.setText(sdf.format(calendar.getTime()));
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            String scanContent = scanningResult.getContents();
            //ADD TO LIST

            equipmentList.add(scanContent);
            for (String details : equipmentList) {
                builder.append(details + "/n");
            }

            contentText.setText("Equipment added: " +builder.toString());
            button.setText("Add more equipment");
        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(), "No scan data received!" , Toast.LENGTH_SHORT);
            toast.show();
        }
    }


    }


