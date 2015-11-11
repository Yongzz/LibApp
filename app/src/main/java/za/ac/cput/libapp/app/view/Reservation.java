package za.ac.cput.libapp.app.view;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import za.ac.cput.libapp.app.R;
import za.ac.cput.libapp.app.domain.Impl.*;
import za.ac.cput.libapp.app.services.Impl.LoanServiceImpl;
import za.ac.cput.libapp.app.services.LoanService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class Reservation extends Activity implements View.OnClickListener {

    private EditText name=null;
    private EditText surname = null;
    private EditText address = null;
    private EditText returnDate = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        final Button btn=(Button)findViewById(R.id.btnCreateLoan);
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnCreateLoan:
                LoanService loanService = new LoanServiceImpl();
                name = (EditText) findViewById(R.id.txtFldMemberName);
                surname = (EditText) findViewById(R.id.txtMSurname);
                address = (EditText) findViewById(R.id.txtFldAdresss);
                returnDate = (EditText) findViewById(R.id.txtFldReturnDate);
                if (name.getText().toString().trim().equals("") &&
                        surname.getText().toString().trim().equals("") &&
                        address.getText().toString().trim().equals("") &&
                        returnDate.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Fill all fields please", Toast.LENGTH_LONG).show();
                }else {
                    Random rand = new Random();

                    int  memberId = rand.nextInt(999) + 100;
                    int  LibrarienId = rand.nextInt(999) + 100;
                    SimpleDateFormat stdf = new SimpleDateFormat("yyyy-MM-dd");
                    Member member = new Member.Builder("MBR"+memberId)
                            .firstName(name.getText().toString())
                            .lastName(surname.getText().toString())
                            .Address(new Address.Builder().houseNumber(1).suburb(address.getText().toString()).build())
                            .build();
                    Copy copy = new Copy.Builder("Test Copy").datePurchased("22-May-2015").datePurchased("This Copy is for Testing the app").build();
                    Librarian librarian = new Librarian.Builder("LBRRN"+LibrarienId).fName("Yongama").passoword("123").build();
                    Loan loan = new Loan.Builder(member, librarian).copy(copy).loanDate(stdf.format(new Date())).dueDate(returnDate.getText().toString()).build();
                    loanService.save(loan);
                    Toast.makeText(getApplicationContext(), "Successful saved loan", Toast.LENGTH_LONG).show();
                }

                /*List<Loan> loans = loanService.findAll();

                for (Loan l: loans) {
                    name.setText(l.getresID().toString());

                }*/
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reservation, menu);
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
