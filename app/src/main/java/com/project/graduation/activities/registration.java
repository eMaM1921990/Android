package com.project.graduation.activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.project.graduation.R;
import com.project.graduation.managers.DBHelper;
import com.project.graduation.managers.userHandler;
import com.project.graduation.model.users;

import org.w3c.dom.Text;

public class registration extends Activity {

    EditText username,password,repassword;
    Button creatUserBtn;
    String userName;
    String userPassword;
    users dto=new users();
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db=new DBHelper(getApplicationContext());
        setContentView(R.layout.activity_registration);
        username=(EditText)findViewById(R.id.userame);
        password=(EditText)findViewById(R.id.password);
        repassword=(EditText)findViewById(R.id.repassword);
        creatUserBtn=(Button)findViewById(R.id.register);
        creatUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName=username.getText().toString();
                userPassword=password.getText().toString();
                dto.setUserName(userName);
                dto.setPassword(userPassword);
                db.InsertNewUser(dto);
                db.closeDB();


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registration, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
