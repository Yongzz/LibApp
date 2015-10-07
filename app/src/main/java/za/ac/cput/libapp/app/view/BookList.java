package za.ac.cput.libapp.app.view;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import za.ac.cput.libapp.app.R;
import za.ac.cput.libapp.app.model.Book;
import za.ac.cput.libapp.app.services.BookService;
import za.ac.cput.libapp.app.services.Impl.BookServiceImpl;

import java.util.ArrayList;
import java.util.List;


public class BookList extends Activity implements AdapterView.OnItemClickListener {

    private List<Book> bookList;
    private static String text;
    ArrayAdapter<String> arrayAdapter;
    BookService bookService = new BookServiceImpl();
    public static final int Delete = Menu.FIRST + 1;
    public static final int Reserve  = Menu.FIRST + 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        final ListView lv = (ListView) findViewById(R.id.lvBooks);
        List<String> booktitles = new ArrayList<>();

        bookList  = bookService.findAll();

        for (Book b:bookList)
        {
            booktitles.add(b.getTittle());
        }
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                booktitles );
        lv.setAdapter(arrayAdapter);
        registerForContextMenu(lv);

        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
         text = ((TextView)view).getText().toString();
        final Intent i = new Intent(this,BookDetails.class);

        for (Book b:bookList)
        {
            if(b.getTittle().equalsIgnoreCase(text)) {
                i.putExtra("Id",b.getID()+"");
                i.putExtra("isbn",b.getISBN()+"");
                i.putExtra("title", b.getTittle()+"");
                i.putExtra("subject", b.getSubject()+"");
                i.putExtra("author", b.getISBN()+"");
                i.putExtra("publisher", b.getISBN()+"");
            }
        }
        startActivity(i);

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

            menu.setHeaderTitle("Options");
            menu.add(Menu.NONE, Delete, Menu.NONE, "Delete");
            menu.add(Menu.NONE, Reserve, Menu.NONE, "Issue Loan");
       /* menu.add("Delete");
        menu.add("Reserve");*/

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_book_list, menu);
        return true;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case Delete:

                for (Book b:bookList)
                {
                    if(b.getTittle().equalsIgnoreCase(text));
                    {
                        bookService.delete(b);
                    }
                    Toast.makeText(getApplicationContext(),"Successful Deleted a book", Toast.LENGTH_LONG).show();

                }
            case Reserve:
                         final Intent i = new Intent(this,Reservation.class);
                startActivity(i);
                /*bookList.remove(text);
                arrayAdapter.notifyDataSetChanged();*/
                return true;
            default:
        }
        return (true);
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
