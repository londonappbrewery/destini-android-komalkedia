package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int mStoryIndex = 1;
    // TODO: Steps 4 & 8 - Declare member variables here:
    private Button mButtonTop;
    private Button mButtonBottom;
    private TextView mStoryText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:

        mStoryText = findViewById(R.id.storyTextView);
        mButtonTop = findViewById(R.id.buttonTop);
        mButtonBottom = findViewById(R.id.buttonBottom);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateStory(1);
                Log.d("MainActivity", "Test one");
            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateStory(2);
                Log.d("MainActivity", "Test bottom");
            }
        });

    }

    private void updateStory(int ansType) {

        if (ansType == 1) {
            // top button
            switch (mStoryIndex) {
                case 1:
                case 2:
                    mStoryIndex = 3;
                    break;
                case 3:
                    mStoryIndex = 6;
                    break;
            }

        } else {
            // bottom button
            switch (mStoryIndex) {
                case 1:
                    mStoryIndex = 2;
                    break;
                case 2:
                    mStoryIndex = 4;
                    break;
                case 3:
                    mStoryIndex = 5;
                    break;
            }
        }

        switch (mStoryIndex) {
            case 2:
                mStoryText.setText(R.string.T2_Story);
                mButtonTop.setText(R.string.T2_Ans1);
                mButtonBottom.setText(R.string.T2_Ans2);
                break;
            case 3:
                mStoryText.setText(R.string.T3_Story);
                mButtonTop.setText(R.string.T3_Ans1);
                mButtonBottom.setText(R.string.T3_Ans2);
                break;
            case 4:
                mStoryText.setText(R.string.T4_End);
                break;
            case 5:
                mStoryText.setText(R.string.T5_End);
                break;
            case 6:
                mStoryText.setText(R.string.T6_End);
                break;
        }

        if (mStoryIndex == 4 || mStoryIndex == 5 || mStoryIndex == 6) {
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
        }
    }
}
