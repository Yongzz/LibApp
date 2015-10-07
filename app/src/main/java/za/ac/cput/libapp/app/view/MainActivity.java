package za.ac.cput.libapp.app.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import za.ac.cput.libapp.app.R;


public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btn=(Button)findViewById(R.id.btnBooks);
        final Button btnloans=(Button)findViewById(R.id.btnLoans);
        final Button btnnewbook=(Button)findViewById(R.id.btnNewBook);
        final Button btnnewloan=(Button)findViewById(R.id.btnNewLoan);
        final Button btnclose=(Button)findViewById(R.id.btnClose);
        btn.setOnClickListener(this);
        btnloans.setOnClickListener(this);
        btnnewbook.setOnClickListener(this);
        btnnewloan.setOnClickListener(this);
        btnclose.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        Intent intent;
        switch(v.getId()){

            case R.id.btnBooks:

                intent = new Intent(this , BookList.class);
                startActivity(intent);
                break;
            case R.id.btnLoans:

                 intent = new Intent(this , LoanList.class);
                startActivity(intent);
                break;
            case R.id.btnNewBook:

                intent = new Intent(this , AddBookActivity.class);
                startActivity(intent);
                break;
            case R.id.btnNewLoan:

                intent = new Intent(this , Reservation.class);
                startActivity(intent);
                break;
            case R.id.btnClose:

                intent = new Intent(this , LoginActivity.class);
                startActivity(intent);
                break;

        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
