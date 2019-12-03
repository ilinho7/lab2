package ru.mirea.ilinho7.dialogsr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.zip.DataFormatException;

public class MainActivity extends AppCompatActivity  implements DatePickerDialog.OnDateSetListener, android.app.TimePickerDialog.OnTimeSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        String date = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        TextView textView = (TextView) findViewById(R.id.tv);
        textView.setText(date);
    }
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextView textView = (TextView)findViewById(R.id.tv);
        textView.setText(hourOfDay + ":" + minute);
        }

    public void Date(View view) {
        DialogFragment datePicker = new ru.mirea.ilinho7.dialogsr.DatePickerDialog();
        datePicker.show(getSupportFragmentManager(),"datePicker");
    }

    public void Time(View view) {
        DialogFragment timePicker = new TimePickerDialog();
        timePicker.show(getSupportFragmentManager(),"time picker");
    }

    public void Progress(View view) {
        ProgressDialog progress = new ProgressDialog(this);
        progress.setMax(100);
        progress.setTitle("Progress");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.show();
    }
}
