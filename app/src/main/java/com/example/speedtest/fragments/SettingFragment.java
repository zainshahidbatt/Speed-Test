package com.example.speedtest.fragments;

import static com.example.speedtest.utils.LogUtils.LOGE;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.speedtest.R;
import com.example.speedtest.utils.RateDialog;

public class SettingFragment extends Fragment {
    private RadioButton rbMBps;
    private RadioButton rbkBps;
    private RadioButton rbMbps;
    private RadioButton rbkbps;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_setting, container, false);

        TextView tvNotification = rootView.findViewById(R.id.tv_notification_label);
        tvNotification.post(() -> {
            int length = tvNotification.getMeasuredWidth();
            float angle = 45;
            Shader textShader = new LinearGradient(0, 0, (int) (Math.sin(Math.PI * angle / 180) * length),
                    (int) (Math.cos(Math.PI * angle / 180) * length),
                    new int[]{0xFF30E3CA, 0xFFa5dee5},
                    null,
                    Shader.TileMode.CLAMP);
            tvNotification.getPaint().setShader(textShader);
            tvNotification.invalidate();
        });
        TextView tvDataRateUnits = rootView.findViewById(R.id.tv_data_rate_label);
        tvDataRateUnits.post(() -> {
            int length = tvDataRateUnits.getMeasuredWidth();
            float angle = 45;
            Shader textShader = new LinearGradient(0, 0, (int) (Math.sin(Math.PI * angle / 180) * length),
                    (int) (Math.cos(Math.PI * angle / 180) * length),
                    new int[]{0xFF30E3CA, 0xFFa5dee5},
                    null,
                    Shader.TileMode.CLAMP);
            tvDataRateUnits.getPaint().setShader(textShader);
            tvDataRateUnits.invalidate();
        });
        TextView tvAbout = rootView.findViewById(R.id.tv_about_label);
        tvAbout.post(() -> {
            int length = tvAbout.getMeasuredWidth();
            float angle = 45;
            Shader textShader = new LinearGradient(0, 0, (int) (Math.sin(Math.PI * angle / 180) * length),
                    (int) (Math.cos(Math.PI * angle / 180) * length),
                    new int[]{0xFF30E3CA, 0xFFa5dee5},
                    null,
                    Shader.TileMode.CLAMP);
            tvAbout.getPaint().setShader(textShader);
            tvAbout.invalidate();
        });
        TextView tvRateUs = rootView.findViewById(R.id.tv_rate_us_label);
        tvRateUs.post(() -> {
            int length = tvRateUs.getMeasuredWidth();
            float angle = 45;
            Shader textShader = new LinearGradient(0, 0, (int) (Math.sin(Math.PI * angle / 180) * length),
                    (int) (Math.cos(Math.PI * angle / 180) * length),
                    new int[]{0xFF30E3CA, 0xFFa5dee5},
                    null,
                    Shader.TileMode.CLAMP);
            tvRateUs.getPaint().setShader(textShader);
            tvRateUs.invalidate();
        });
        TextView tvPrivacyPolicy = rootView.findViewById(R.id.tv_privacy_policy_label);
        tvPrivacyPolicy.post(() -> {
            int length = tvPrivacyPolicy.getMeasuredWidth();
            float angle = 45;
            Shader textShader = new LinearGradient(0, 0, (int) (Math.sin(Math.PI * angle / 180) * length),
                    (int) (Math.cos(Math.PI * angle / 180) * length),
                    new int[]{0xFF30E3CA, 0xFFa5dee5},
                    null,
                    Shader.TileMode.CLAMP);
            tvPrivacyPolicy.getPaint().setShader(textShader);
            tvPrivacyPolicy.invalidate();
        });
        ConstraintLayout constraintLayout = rootView.findViewById(R.id.cl_data_rate_units);
        constraintLayout.setOnClickListener(v -> showAlertDialogButtonClicked());
        ConstraintLayout rateUs = rootView.findViewById(R.id.cl_rate_us);
        rateUs.setOnClickListener(v -> {
            RateDialog rateDialog = new RateDialog(getActivity());
            rateDialog.displayRatingDialogue();
        });
        ConstraintLayout cLPrivacyPolicy = rootView.findViewById(R.id.cl_privacy_policy);
        cLPrivacyPolicy.setOnClickListener(v -> {
            //add Your Privacy Policy here
        });
        return rootView;
    }


    private void showAlertDialogButtonClicked() {
        AlertDialog.Builder builder
                = new AlertDialog.Builder(getContext(), R.style.MyDialogTheme);
        final View customLayout
                = getLayoutInflater()
                .inflate(R.layout.dialog_datarate_units, null);
        builder.setView(customLayout);
        rbMBps = customLayout.findViewById(R.id.rb_MBps);
        rbkBps = customLayout.findViewById(R.id.rb_kBps);
        rbMbps = customLayout.findViewById(R.id.rb_Mbps);
        rbkbps = customLayout.findViewById(R.id.rb_kbps);
        SharedPreferences sharedPref = getActivity().getSharedPreferences(
                "setting", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        switch (sharedPref.getString("UNIT", "Mbps")) {
            case "MBps":
                rbMBps.setChecked(true);
                rbkBps.setChecked(false);
                rbMbps.setChecked(false);
                rbkbps.setChecked(false);
                break;
            case "kBps":
                rbMBps.setChecked(false);
                rbkBps.setChecked(true);
                rbMbps.setChecked(false);
                rbkbps.setChecked(false);
                break;
            case "Mbps":
                rbMBps.setChecked(false);
                rbkBps.setChecked(false);
                rbMbps.setChecked(true);
                rbkbps.setChecked(false);
                break;
            case "kbps":
                rbMBps.setChecked(false);
                rbkBps.setChecked(false);
                rbMbps.setChecked(false);
                rbkbps.setChecked(true);
                break;
            default:
                LOGE("TAG", "ERROR");
                break;
        }
        rbMBps.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                editor.remove("UNIT");
                editor.putString("UNIT", "MBps");
                editor.apply();
                rbkBps.setChecked(false);
                rbMbps.setChecked(false);
                rbkbps.setChecked(false);
            }
        });
        rbkBps.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                editor.remove("UNIT");
                editor.putString("UNIT", "kBps");
                editor.apply();
                rbMBps.setChecked(false);
                rbMbps.setChecked(false);
                rbkbps.setChecked(false);
            }
        });
        rbMbps.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                editor.remove("UNIT");
                editor.putString("UNIT", "Mbps");
                editor.apply();
                rbkBps.setChecked(false);
                rbMBps.setChecked(false);
                rbkbps.setChecked(false);
            }
        });
        rbkbps.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                editor.remove("UNIT");
                editor.putString("UNIT", "kbps");
                editor.apply();
                rbkBps.setChecked(false);
                rbMbps.setChecked(false);
                rbMBps.setChecked(false);
            }
        });
        builder
                .setPositiveButton(
                        "OK",
                        (dialog, which) -> {
                        });
        builder.setNegativeButton("Cancel",
                (dialog, which) -> {
                });
        AlertDialog dialog
                = builder.create();
        dialog.show();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
