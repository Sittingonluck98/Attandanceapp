package com.mcadproject.attandanceapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.text.format.DateFormat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyCalendar extends DialogFragment {
    Calendar calendar = Calendar.getInstance();

    public interface OnCalendarOkClickListener {
        void onClick(int year, int month, int day);
    }

    public OnCalendarOkClickListener onCalendarOkClickListener;

    public void setOnCalendarOkClickListener(OnCalendarOkClickListener onCalendarOkClickListener) {
        this.onCalendarOkClickListener = onCalendarOkClickListener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new DatePickerDialog(getActivity(), ((view, year, month, dayOfMonth) -> {
            onCalendarOkClickListener.onClick(year, month, dayOfMonth);
        }), calendar.get(calendar.YEAR), calendar.get(calendar.MONTH), calendar.get(calendar.DAY_OF_MONTH));
    }

    void setDate(int year, int month, int day) {
        calendar.set(calendar.YEAR, year);
        calendar.set(calendar.MONTH, month);
        calendar.set(calendar.DAY_OF_MONTH, day);
    }

    String getDate() {
        //return DateFormat.format("dd.MM.yy", Calendar).toString();
       // return (new SimpleDateFormat("dd.MM.yy")).format(calendar).toString();
        return DateFormat.format("dd.MM.yyyy",calendar).toString();
    }
}

