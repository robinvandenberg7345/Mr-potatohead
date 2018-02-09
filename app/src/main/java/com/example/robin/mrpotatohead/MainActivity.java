package com.example.robin.mrpotatohead;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // Create lists containing the bodyparts and the corresponding ids
    String[] parts = {"nose", "arms", "ears", "eyes", "eyebrows", "glasses",
            "hat", "mouth", "mustache", "shoes"};
    int[] partsId = new int[]{R.id.nose, R.id.arms, R.id.ears, R.id.eyes,
            R.id.eyebrows, R.id.glasses, R.id.hat, R.id.mouth, R.id.mustache, R.id.shoes};

    // reinstate visibility of object
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // reinstate visibility of object if saved
        if (savedInstanceState != null) {
            for (int i = 0; i < parts.length; i++) {
                ImageView image = findViewById(partsId[i]);

                if (image != null) {
                    image.setVisibility(savedInstanceState.getInt(parts[i]));
                }
            }
        }
    }

    // save visibility of objects
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        for (int i = 0; i < parts.length; i++) {
            ImageView image = findViewById(partsId[i]);
            outState.putInt(parts[i], image.getVisibility());
        }
    }

    // change visibility of objects when clicked
    public void checkClicked(View v) {
        Log.d("potato", "checkClicked: ");
        CheckBox checkbox = (CheckBox) v;
        String nameCheckBox = checkbox.getText().toString();
        boolean checked = checkbox.isChecked();

        //  show bodyparts when boxes are checked
        for (int i = 0; i < parts.length; i++) {
            if (nameCheckBox.equals(parts[i]))
                if (checked) {
                    ImageView image = findViewById(partsId[i]);
                    image.setVisibility(View.VISIBLE);
                } else {
                    ImageView image = findViewById(partsId[i]);
                    image.setVisibility(View.INVISIBLE);
                }
        }
    }
}