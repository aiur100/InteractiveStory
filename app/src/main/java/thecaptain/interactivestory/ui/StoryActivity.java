package thecaptain.interactivestory.ui;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import thecaptain.interactivestory.R;
import thecaptain.interactivestory.model.Page;
import thecaptain.interactivestory.model.Story;

public class StoryActivity extends AppCompatActivity {

    private Story mStory        = new Story();
    private Page  mCurrentPage;
    private String mName;
    private int   mCurPageNumber = 0;
    private ImageView mImageView;
    private TextView mTextView;
    private Button mChoice1;
    private Button mChoice2;
    private View.OnClickListener mChoiceListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        Intent intent = getIntent();
        mName   = intent.getStringExtra(getString(R.string.key_name));
        if(mName == null){
            mName = "Friend";
        }

        /**
         * setting attributes
         */
        mImageView  = (ImageView) findViewById(R.id.storyImageView);
        mTextView   = (TextView) findViewById(R.id.storyTextView);
        mChoice1    = (Button)  findViewById(R.id.choice_1);
        mChoice2    = (Button)  findViewById(R.id.choice_2);;

        //load initial page - which is 0
        loadPage(mCurPageNumber);

        mChoiceListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int choiceId = v.getId();
                switch(choiceId){
                    case R.id.choice_1:
                        loadPage(mCurrentPage.getChoice1().getNextPage());
                        break;
                    case R.id.choice_2:
                        loadPage(mCurrentPage.getChoice2().getNextPage());
                        break;
                }
            }
        };

        mChoice1.setOnClickListener(mChoiceListener);
        mChoice2.setOnClickListener(mChoiceListener);
    }

    private void loadPage(int page){
        mCurrentPage = mStory.getPage(page);
        if(mCurrentPage.isIsFinal() == false){
            mImageView.setImageResource(mCurrentPage.getImageId());
            String text = mCurrentPage.getText();
            text        = String.format(text, mName);
            mTextView.setText(text);
            mChoice1.setText(mCurrentPage.getChoice1().getText());
            mChoice2.setText(mCurrentPage.getChoice2().getText());
        }
        else{
            mImageView.setImageResource(mCurrentPage.getImageId());
            String text = mCurrentPage.getText();
            text        = String.format(text, mName);
            mTextView.setText(text);
            mChoice1.setVisibility(View.GONE);
            mChoice2.setVisibility(View.GONE);
        }
    }

    public Page getCurrentPage() {
        return mCurrentPage;
    }

    public void setCurrentPage(Page mCurrentPage) {
        this.mCurrentPage = mCurrentPage;
    }
}
