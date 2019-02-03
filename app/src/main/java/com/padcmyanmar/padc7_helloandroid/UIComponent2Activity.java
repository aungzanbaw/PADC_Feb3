package com.padcmyanmar.padc7_helloandroid;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import java.util.Calendar;

public class UIComponent2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_component2);

        ToggleButton tbGuestRoomLight = findViewById(R.id.tb_like_fish);
        SeekBar sbBrightness = findViewById(R.id.sb_brightness);
        Switch swtDoorLock = findViewById(R.id.swt_door_lock);
        RatingBar rbStar = findViewById(R.id.rb_how_much_you_love_the_room);
        AutoCompleteTextView actvAdditionalDrinks = findViewById(R.id.actv_additional_drinks);
        final TextView tvSelectedDate = findViewById(R.id.tv_selected_date);
        Button btnSelectDate = findViewById(R.id.btn_select_date);

        tbGuestRoomLight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    Snackbar.make(buttonView, "Turing the light on", Snackbar.LENGTH_INDEFINITE).show();
                } else {
                    Snackbar.make(buttonView, "Turing the light off", Snackbar.LENGTH_INDEFINITE).show();
                }
            }
        });

        tbGuestRoomLight.isChecked();


        swtDoorLock.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    Snackbar.make(buttonView, "Door on", Snackbar.LENGTH_INDEFINITE).show();
                } else {
                    Snackbar.make(buttonView, "Door off", Snackbar.LENGTH_INDEFINITE).show();
                }
            }
        });


        sbBrightness.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Snackbar.make(seekBar, "Progress Changed", Snackbar.LENGTH_INDEFINITE).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Snackbar.make(seekBar, "Start tracking", Snackbar.LENGTH_INDEFINITE).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Snackbar.make(seekBar, "Stop tracking", Snackbar.LENGTH_INDEFINITE).show();
            }
        });

        rbStar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Snackbar.make(ratingBar, Float.toString(rating), Snackbar.LENGTH_INDEFINITE).show();
            }
        });

        ArrayAdapter<String> additionalDrinksAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_dropdown_item_1line,
                getResources().getStringArray(R.array.additional_drinks));
        actvAdditionalDrinks.setAdapter(additionalDrinksAdapter);


        btnSelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);
                // date picker dialog
                DatePickerDialog picker = new DatePickerDialog(getApplicationContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                tvSelectedDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

//        final TextView tvSelectedTime = findViewById(R.id.tv_selected_time);
//        Button btnSelectTime = findViewById(R.id.btn_select_time);
//        btnSelectTime.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final Calendar calendar = Calendar.getInstance();
//                int hour = calendar.get(Calendar.HOUR_OF_DAY);
//                int minutes = calendar.get(Calendar.MINUTE);
//                // time picker dialog
//                TimePickerDialog picker = new TimePickerDialog(getApplicationContext(),
//                        new TimePickerDialog.OnTimeSetListener() {
//                            @Override
//                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
//                                tvSelectedTime.setText(sHour + ":" + sMinute);
//                            }
//                        }, hour, minutes, true);
//                picker.show();
//            }
//        });

    }
}
