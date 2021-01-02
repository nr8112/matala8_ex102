package com.example.matala8_ex102;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.graphics.Color.WHITE;

public class MainActivity extends AppCompatActivity {
        final String[]colors={"red","green","blue"};
        private ConstraintLayout l;
        AlertDialog.Builder adb;

    /**
     * onCreate...
     * @param savedInstanceState
     */
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            l = findViewById(R.id.li);
        }
//---------------------------------------------------------------------------------------
        /**
         * one color choice
         * @param view the view
         */
        public void oneColorChoise(View view) {


            adb = new AlertDialog.Builder(this);
            adb.setTitle("Choose one color");
            adb.setCancelable(false);
            adb.setItems(colors, new DialogInterface.OnClickListener() {
                @Override

                /**
                 * Determines what color comes out. If you chose green then 255 will be equal to green then green will choose
                 */

                public void onClick(DialogInterface dialog, int which) {  // which=num 0-2
                    int[]rgb= {0,0,0};

                    rgb[which]=255;
                    l.setBackgroundColor(Color.rgb(rgb[0],rgb[1],rgb[2]));
                }
            });

            adb.setNegativeButton("exit", new DialogInterface.OnClickListener() {  //Exit
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }});
            AlertDialog ad = adb.create();
            ad.show();
        }


    //---------------------------------------------------------------------------------------

        /**
         * combination of colors. "choices" I know this is not the written form of the word.
         * But it made me laugh because I asked my sister how to write a choice in the plural and that's what she said.
         * @param view the view
         */
        public void choices(View view) {


            adb = new AlertDialog.Builder(this);
            adb = new AlertDialog.Builder(this);
            adb.setCancelable(false);
            adb.setTitle("Choose colors");
            final int[]rgbD={0,0,0};
            adb.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    if(isChecked) rgbD[which]=255;
                    else if(rgbD[which]==255) rgbD[which]=0;
                }
            });

            adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    l.setBackgroundColor(Color.rgb(rgbD[0],rgbD[1],rgbD[2]));
                }
            });

            adb.setNegativeButton("exit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog ad = adb.create();
            ad.show();
        }


//-------------------------------------------------------------------------------------
        /**
         *  Reset color to white.
         * @param view the view
         */
        public void back(View view) {

            l.setBackgroundColor(WHITE);
        }

//---------------------------------------------------------------------------------------

        /**
         * gets the user input and show it in toast
         * @param view the view
         */
        public void text(View view) {
           final EditText e= new EditText(this);

            adb = new AlertDialog.Builder(this);
            adb.setTitle("Enter text:"); //כותרת
            e.setHint("Type your text here"); // הסבר
            adb.setView(e);
            adb.setCancelable(false); //אין אפשרות לצאת לי ללחוץ אל אחד הכפתורים

            adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String str= e.getText().toString();

                    Toast.makeText(MainActivity.this, "you'r text"+str, Toast.LENGTH_LONG).show(); // הודעת tost

                }
            });
            adb.setNegativeButton("exit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog ad = adb.create();
            ad.show();
        }
//---------------------------------------------------------------------------------------
    /**
     * General menu
     * @param menu
     * @return
     */
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.main,menu);


            return true;
        }

        /**
         * goes to the credits activity.
         */
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

            adb = new AlertDialog.Builder(this);
            String st = item.getTitle().toString();
            if (st.endsWith("Credits")) {
                Intent si = new Intent(this, cred.class);
                startActivity(si);
            }
            return true;
        }
    //---------------------------------------------------------------------------------------
    }