package com.example.administrator.android7thclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class ActionBarActivity extends AppCompatActivity {

    TextView[] textViewArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);

        textViewArray = new TextView[10];

        textViewArray[0] = (TextView)findViewById(R.id.textView1);
        textViewArray[1] = (TextView)findViewById(R.id.textView2);
        textViewArray[2] = (TextView)findViewById(R.id.textView3);
        textViewArray[3] = (TextView)findViewById(R.id.textView4);
        textViewArray[4] = (TextView)findViewById(R.id.textView5);
        textViewArray[5] = (TextView)findViewById(R.id.textView6);
        textViewArray[6] = (TextView)findViewById(R.id.textView7);
        textViewArray[7] = (TextView)findViewById(R.id.textView8);
        textViewArray[8] = (TextView)findViewById(R.id.textView9);
        textViewArray[9] = (TextView)findViewById(R.id.textView10);
        textViewArray[10] = (TextView)findViewById(R.id.textView11);
        textViewArray[11] = (TextView)findViewById(R.id.textView12);
        textViewArray[12] = (TextView)findViewById(R.id.textView13);
        textViewArray[13] = (TextView)findViewById(R.id.textView14);
        textViewArray[14] = (TextView)findViewById(R.id.textView15);
        textViewArray[15] = (TextView)findViewById(R.id.textView16);
        textViewArray[16] = (TextView)findViewById(R.id.textView17);
        textViewArray[17] = (TextView)findViewById(R.id.textView18);
        textViewArray[18] = (TextView)findViewById(R.id.textView19);
        textViewArray[19] = (TextView)findViewById(R.id.textView20);
        textViewArray[20] = (TextView)findViewById(R.id.textView21);

        for(int i=0; i<=20; i++) {
            textViewArray[i].setText("");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuId = item.getItemId();
        switch (menuId) {
            case R.id.item_settings :
                Toast.makeText(ActionBarActivity.this, "메뉴 클릭됨", Toast.LENGTH_SHORT).show();
                for(int i=0; i<=20; i++) {
                    textViewArray[i].setText("");
                }
                break;
            case R.id.item_fuck :
                Toast.makeText(ActionBarActivity.this, "FUCK !", Toast.LENGTH_LONG).show();
                for(int i=0; i<=20; i++) {
                    textViewArray[i].setText("FUCK!!");
                }
                break;
        }
        return super.onOptionsItemSelected(item);

    }
}
