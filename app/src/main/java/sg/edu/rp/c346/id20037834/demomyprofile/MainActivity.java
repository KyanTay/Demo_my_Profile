package sg.edu.rp.c346.id20037834.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvName;
    TextView tvGPA;
    EditText etName;
    EditText etGPA;
    EditText etAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.textViewName);
        tvGPA = findViewById(R.id.textViewGPA);
        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
        etAge = findViewById(R.id.etAge);
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefEdit = prefs.edit();

        String strName = etName.getText().toString();
        String strGPA = etGPA.getText().toString();
        String strAge = etAge.getText().toString();
        Float gpa = Float.parseFloat(strGPA);
        Integer age = Integer.parseInt(strAge);

        prefEdit.putString("name", strName);
        prefEdit.putFloat("gpa", gpa);
        prefEdit.putInt("age", age);
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefEdit = getPreferences(MODE_PRIVATE);
        String strName = prefEdit.getString("name" , "No name set");
        Float gpa = prefEdit.getFloat("gpa" , 0f);
        Integer age = prefEdit.getInt("age", 0);

        String strGPA = gpa.toString();
        String strAge = age.toString();

        etName.setText(strName);
        etGPA.setText(strGPA);
        etAge.setText(strAge);
    }
}