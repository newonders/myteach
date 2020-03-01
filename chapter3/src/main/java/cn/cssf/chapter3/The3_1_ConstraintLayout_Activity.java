package cn.cssf.chapter3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class The3_1_ConstraintLayout_Activity extends AppCompatActivity {

    TextView displayTv;
    Button buttonLeft, buttonRight, buttonConfirm;
    Switch aSwitch;
    ProgressBar progressBar;
    EditText editText;
    RadioGroup radioGroup;
    ImageView imageView;
    SeekBar seekBar;
    CheckBox chineseCb, mathCb, englighCb;
    RatingBar ratingBar;
    String chinese = "", math = "", english = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the3_1_constraint_layout);
        displayTv = findViewById(R.id.textView);
        buttonLeft = findViewById(R.id.leftButton);
        buttonRight = findViewById(R.id.rightButton);
        buttonConfirm = findViewById(R.id.confirmButton);
        aSwitch = findViewById(R.id.switch1);
        progressBar = findViewById(R.id.progressBar3);
        editText = findViewById(R.id.editText2);
        radioGroup = findViewById(R.id.radioGroup);
        imageView = findViewById(R.id.imageView2);
        seekBar = findViewById(R.id.seekBar);
        chineseCb = findViewById(R.id.chineseCb);
        mathCb = findViewById(R.id.mathCb);
        englighCb = findViewById(R.id.englishCb);
        ratingBar = findViewById(R.id.ratingBar);

        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayTv.setText("左");
            }
        });
        buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayTv.setText("右");
            }
        });
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    displayTv.setText("开");
                else displayTv.setText("关");
            }
        });
        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = editText.getText().toString();
                if (TextUtils.isEmpty(s)){
                    s = "0";
                }
                progressBar.setProgress(Integer.valueOf(s),true);
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radioButton2)
                    imageView.setImageResource(R.drawable.xjlp36);
                else imageView.setImageResource(R.drawable.xjlp37);
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                displayTv.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });
        chineseCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    chinese = "语文";
                else chinese = "";
                displayTv.setText(chinese+math+english);
            }
        });
        englighCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    english = "英语";
                else english = "";
                displayTv.setText(chinese+math+english);
            }
        });
        mathCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    math = "数学";
                else math = "";
                displayTv.setText(chinese+math+english);
            }
        });
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(getApplicationContext(),String.valueOf(v),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
