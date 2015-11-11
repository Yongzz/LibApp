package za.ac.cput.libapp.app.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import za.ac.cput.libapp.app.R;
import za.ac.cput.libapp.app.domain.Impl.Author;
import za.ac.cput.libapp.app.domain.Impl.Book;
import za.ac.cput.libapp.app.domain.Impl.Publisher;
import za.ac.cput.libapp.app.services.BookService;
import za.ac.cput.libapp.app.services.Impl.BookServiceImpl;


public class AddBookActivity extends Activity implements View.OnClickListener {


    private EditText tittle=null;
    private EditText isbn = null;
    private EditText subj = null;
    private EditText publisher = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);


        final Button btn=(Button)findViewById(R.id.btnSaveBook);
        btn.setOnClickListener(this);
        tittle = (EditText)findViewById(R.id.txtFldTittle);
        isbn   = (EditText)findViewById(R.id.txtFldAuthor);
        subj   = (EditText)findViewById(R.id.txtFldSubject);
        publisher  = (EditText)findViewById(R.id.txtFldPublisher);
        final TextView ISBN=(TextView)findViewById(R.id.txtFldAuthor);
      //  final TextView AUTHOR=(TextView)findViewById(R.id.tx);
        final TextView PUBLISHER=(TextView)findViewById(R.id.txtFldPublisher);
        final TextView TITLE=(TextView)findViewById(R.id.txtFldTittle);
        final TextView SUBJECT=(TextView)findViewById(R.id.txtFldSubject);
        final TextView AUTHOR = (TextView)findViewById(R.id.txtFldAuthor);
        Intent intent = getIntent();

        String title = intent.getStringExtra("title");
        String sub = intent.getStringExtra("subject");
        String isb = intent.getStringExtra("isbn");
        //String author = intent.getStringExtra("author");
        String publisher = intent.getStringExtra("publisher");
        SUBJECT.setText(sub);
        TITLE.setText(title);
        ISBN.setText(isb);
        AUTHOR.setText(isb);
       // AUTHOR.setText(author);
        if (getIntent().hasExtra("publisher"))
            PUBLISHER.setText(publisher.toString()+"");
        if (getIntent().hasExtra("Id"))
        {
            btn.setText("Update");
        }
        else
        {
            btn.setText("Save");
        }
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnSaveBook:
                Book book;

                BookService bookService = new BookServiceImpl();
                Intent intent  = getIntent();
                if (intent.hasExtra("Id")) {

                    Book booktoEdit = bookService.findById(Long.parseLong(intent.getStringExtra("Id")));
                    book = new Book.Builder(booktoEdit.getISBN())
                            .copy(booktoEdit)
                            .authors(new Author.Builder().fName(isbn.getText().toString()).build())
                            .tittle(tittle.getText().toString())
                            .subject(subj.getText().toString())
                            .publisher(new Publisher.Builder()
                                    .publisherName(publisher.getText().toString())
                                    .build())
                            .build();
                    bookService.save(book);
                    Toast.makeText(getApplicationContext(), "Successful updated a book", Toast.LENGTH_LONG).show();
                    Intent in = new Intent(this, MainActivity.class);
                    startActivity(in);
                }
                else
                {
                    if (!isbn.getText().toString().trim().equalsIgnoreCase("")
                            && !tittle.getText().toString().trim().equalsIgnoreCase("")
                            && !subj.getText().toString().trim().equalsIgnoreCase("")) {
                        book = new Book.Builder(isbn.getText().toString())
                                .authors(new Author.Builder().fName(isbn.getText().toString()).build())
                                .tittle(tittle.getText().toString())
                                .subject(subj.getText().toString())
                                .publisher(new Publisher.Builder()
                                        .publisherName(publisher.getText().toString())
                                        .build())
                                .build();
                        bookService.save(book);
                        Toast.makeText(getApplicationContext(), "Successful saved a book", Toast.LENGTH_LONG).show();

                        Intent in = new Intent(this, MainActivity.class);
                        startActivity(in);
                    } else
                        Toast.makeText(getApplicationContext(), "Please fill all fields", Toast.LENGTH_LONG).show();
                }
                isbn.setText("");
                tittle.setText("");
                subj.setText("");
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
