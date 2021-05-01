package com.example.raiq;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link lk#newInstance} factory method to
 * create an instance of this fragment.
 */
public class lk extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public lk() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment lk.
     */
    // TODO: Rename and change types and number of parameters
    public static lk newInstance(String param1, String param2) {
        lk fragment = new lk();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    Switch theme, notif;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_lk, container, false);
        final ImageButton show_hide_pass = view.findViewById(R.id.settings_password_change_see);
        final EditText password = view.findViewById(R.id.settings_password);

        final SharedPreferences sett = getContext().getApplicationContext().getSharedPreferences("Settings", 0);
        final SharedPreferences.Editor editor = sett.edit();

        theme = view.findViewById(R.id.settings_theme);
        notif = view.findViewById(R.id.settings_notif);

        if (sett.getBoolean("Notif",false) == true)
        {
            notif.setChecked(true);
        }
        else{
            notif.setChecked(false);
        }

        if (sett.getBoolean("DayThem",false) == true)
        {
            theme.setChecked(true);
        }
        else{
            theme.setChecked(false);
        }
        show_hide_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (show_hide_pass.getDrawable().getConstantState() == lk.this
                        .getResources().getDrawable(R.drawable.see_pass)
                        .getConstantState())
                {
                    show_hide_pass.setImageDrawable(getResources().getDrawable(R.drawable.pass_show));
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    password.setSelection(password.length());
                }
                else if (show_hide_pass.getDrawable().getConstantState() == lk.this
                        .getResources().getDrawable(R.drawable.pass_show)
                        .getConstantState())
                {
                    show_hide_pass.setImageDrawable(getResources().getDrawable(R.drawable.see_pass));
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    password.setSelection(password.length());
                }
            }
        });
        theme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true)
                {
                    editor.putBoolean("DayThem",true);
                    editor.apply();
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                else
                {
                    editor.putBoolean("DayThem",false);
                    editor.apply();
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });

        notif.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true)
                {
                    editor.putBoolean("Notif",true);
                    editor.apply();
                }
                else
                {
                    editor.putBoolean("Notif",false);
                    editor.apply();
                }
            }
        });
        return view;
    }
}