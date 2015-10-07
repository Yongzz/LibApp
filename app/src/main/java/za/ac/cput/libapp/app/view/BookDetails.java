package za.ac.cput.libapp.app.view;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import za.ac.cput.libapp.app.R;


public class BookDetails extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        final TextView ISBN=(TextView)findViewById(R.id.txtISBN);
        final TextView AUTHOR=(TextView)findViewById(R.id.txtAuthor);
        final TextView PUBLISHER=(TextView)findViewById(R.id.txtPublisher);
        final TextView TITLE=(TextView)findViewById(R.id.txtTitle);
        final TextView SUBJECT=(TextView)findViewById(R.id.txtSubject);
        Intent intent = getIntent();

        String title = intent.getStringExtra("title");
        String sub = intent.getStringExtra("subject");
        String isb = intent.getStringExtra("isbn");
        String author = intent.getStringExtra("author");
        String publisher = intent.getStringExtra("publisher");
        SUBJECT.setText(sub);
        TITLE.setText(title);
        ISBN.setText(isb);
        AUTHOR.setText(author);
        PUBLISHER.setText(publisher);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_book_details, menu);
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
