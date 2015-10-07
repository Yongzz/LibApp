package za.ac.cput.libapp.app.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import za.ac.cput.libapp.app.R;
import za.ac.cput.libapp.app.model.Book;
import za.ac.cput.libapp.app.respositories.rest.RestBookAPI;
import za.ac.cput.libapp.app.services.BookService;
import za.ac.cput.libapp.app.services.Impl.BookServiceImpl;


public class AddBookActivity extends Activity implements View.OnClickListener {


    private EditText tittle=null;
    private EditText isbn = null;
    private EditText subj = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);


        final Button btn=(Button)findViewById(R.id.btnSaveBook);
        btn.setOnClickListener(this);
        tittle = (EditText)findViewById(R.id.txtFldTittle);
        isbn   = (EditText)findViewById(R.id.txtFldISBN);
        subj   = (EditText)findViewById(R.id.txtFldSubject);



    }
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnSaveBook:
                Book book;

                BookService bookService = new BookServiceImpl();
                /*Intent intent  = getIntent();
                if (intent.hasExtra("Id")) {

                    Book booktoEdit = bookService.findById(Long.parseLong(intent.getStringExtra("Id")));
                    book = new Book.Builder(booktoEdit.getISBN())
                            .copy(booktoEdit)
                            .tittle(tittle.getText().toString())
                            .subject(subj.getText().toString())
                            .build();


                }else {}*/
                if (!isbn.getText().toString().trim().equalsIgnoreCase("")
                        && !tittle.getText().toString().trim().equalsIgnoreCase("")
                        && !subj.getText().toString().trim().equalsIgnoreCase("")) {
                    book = new Book.Builder(isbn.getText().toString())
                            .tittle(tittle.getText().toString())
                            .subject(subj.getText().toString())
                            .build();
                    bookService.save(book);
                    Toast.makeText(getApplicationContext(), "Successful saved a book", Toast.LENGTH_LONG).show();
                    isbn.setText("");
                    tittle.setText("");
                    subj.setText("");

                    Intent in = new Intent(this, MainActivity.class);
                    startActivity(in);
                } else
                    Toast.makeText(getApplicationContext(), "Please fill all fields", Toast.LENGTH_LONG).show();


                // System.out.print(book.toString());
                break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_book, menu);
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
