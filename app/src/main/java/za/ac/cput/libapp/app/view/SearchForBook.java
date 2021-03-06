package za.ac.cput.libapp.app.view;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import za.ac.cput.libapp.app.R;
import za.ac.cput.libapp.app.domain.Impl.Book;
import za.ac.cput.libapp.app.services.BookService;
import za.ac.cput.libapp.app.services.Impl.BookServiceImpl;

import java.util.ArrayList;
import java.util.List;


public class SearchForBook extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_for_book);

        final Button btn=(Button)findViewById(R.id.btnSearch);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnSaveBook :
                List<String> booktitles = new ArrayList<>();
                BookService bookService = new BookServiceImpl();
                List<Book> bookList  = bookService.findAll();
                for (Book b:bookList)
                {
                    booktitles.add(b.getTittle());
                }
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search_for_book, menu);
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
