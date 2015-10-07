package za.ac.cput.libapp.app.view;

import android.app.Activity;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import za.ac.cput.libapp.app.EntryAdapter;
import za.ac.cput.libapp.app.ListEntry;
import za.ac.cput.libapp.app.R;
import za.ac.cput.libapp.app.model.Book;
import za.ac.cput.libapp.app.model.Loan;
import za.ac.cput.libapp.app.services.Impl.LoanServiceImpl;
import za.ac.cput.libapp.app.services.LoanService;

import java.util.ArrayList;
import java.util.List;


public class LoanList extends Activity implements AdapterView.OnItemClickListener {

    LoanService loanService = new LoanServiceImpl();
    List<Loan> loans = new ArrayList<>();
    EntryAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_list);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        final ListView lv = (ListView) findViewById(R.id.loan_list);
        List<String> booktitles = new ArrayList<>();
        ArrayList<ListEntry> entryList = new ArrayList<>();
        loans  = loanService.findAll();

        for (Loan ln:loans)
        {
            entryList.add(new ListEntry(ln.getDueDate(),ln.getMember().getFirstName()));
        }
        arrayAdapter = new EntryAdapter(this,entryList);
        lv.setAdapter(arrayAdapter);
        registerForContextMenu(lv);

       // lv.setOnItemClickListener((AdapterView.OnItemClickListener) this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        /*String text = ((TextView)view).getText().toString();
        final Intent i = new Intent(this,BookDetails.class);

//        for (Book b:bookList)
//        {
//            if(b.getTittle().equalsIgnoreCase(text)) {
                i.putExtra("Id",text);
//                i.putExtra("isbn",b.getISBN()+"");
//                i.putExtra("title", b.getTittle()+"");
//                i.putExtra("subject", b.getSubject()+"");
//                i.putExtra("author", b.getISBN()+"");
//                i.putExtra("publisher", b.getISBN()+"");
           // }
     //   }
        startActivity(i);*/

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_loan_list, menu);
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
