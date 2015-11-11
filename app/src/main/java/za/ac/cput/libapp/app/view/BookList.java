package za.ac.cput.libapp.app.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.ContextMenu;
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


public class BookList extends Activity implements AdapterView.OnItemClickListener {

    private List<Book> bookList = new ArrayList<>();
    private static String text;
    private  List<String> booktitles = new ArrayList<>();
    private static  int position;
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


        bookList  = bookService.findAll();

        for (Book b:bookList)
        {
            booktitles.add(b.getTittle()+" : "+b.getId()+"");
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
            if((b.getTittle()+" : "+b.getId()+"").equalsIgnoreCase(text)) {
                i.putExtra("Id",b.getId()+"");
                i.putExtra("isbn",b.getISBN()+"");
                i.putExtra("title", b.getTittle()+"");
                i.putExtra("subject", b.getSubject()+"");
                i.putExtra("author",(b.getAuthor()!= null)? b.getAuthor().getFName():"");
                i.putExtra("publisher", (b.getPublisher()!= null)? b.getPublisher().getPublisherName():"");
            }
        }
        startActivity(i);

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        position = info.position;
        text = booktitles.get(position);
        menu.setHeaderTitle(text);
        menu.add(Menu.NONE, Delete, Menu.NONE, "Delete");
        menu.add(Menu.NONE, Reserve, Menu.NONE, "Edit");

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

                bookList.remove(position);
                arrayAdapter.notifyDataSetChanged();
               /* for (Book b:bookList) {
                    if((b.getTittle()+" : "+b.getId()+"").equalsIgnoreCase(text));
                    {
                        bookService.delete(b);
                    }
                    Toast.makeText(getApplicationContext(),"Successful Deleted a book", Toast.LENGTH_LONG).show();

                }*/
                break;
            case Reserve:

                final Intent in = new Intent(this,AddBookActivity.class);
                for (Book b:bookList)
                {
                    if((b.getTittle()+" : "+b.getId()+"").equalsIgnoreCase(text)) {
                        in.putExtra("Id",b.getId()+"");
                        if(!(b.getAuthor() ==null))
                        in.putExtra("isbn", (b.getAuthor() !=null)? b.getAuthor().getFName() : "");
                        in.putExtra("title", b.getTittle() + "");
                        in.putExtra("subject", b.getSubject() + "");
                       // in.putExtra("author","" + "");
                        in.putExtra("publisher", (b.getPublisher() !=null)? b.getPublisher().getPublisherName(): "");
                    }
                }

                startActivity(in);

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
