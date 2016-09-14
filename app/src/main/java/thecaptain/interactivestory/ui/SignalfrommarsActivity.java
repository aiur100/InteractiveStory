package thecaptain.interactivestory.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import thecaptain.interactivestory.R;

public class SignalfrommarsActivity extends AppCompatActivity {
    private EditText mPersonName;
    private Button   mStartButton;
    private View.OnClickListener mButtonClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signalfrommars);

        //interative items on main view instantiated
        mStartButton    = (Button) findViewById(R.id.startButton);
        mPersonName     = (EditText) findViewById((R.id.nameEditText));

        mButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mPersonName.getText().toString();
                startStory(name);

                //Toast is just a pop up window
                //Toast.makeText(SignalfrommarsActivity.this,name,Toast.LENGTH_LONG).show();
            }
        };
        mStartButton.setOnClickListener(mButtonClickListener);
    }

    private void startStory(String aName){
        Intent intent = new Intent(this,StoryActivity.class);
        intent.putExtra(getString(R.string.key_name),aName);
        startActivity(intent);

    }
}
