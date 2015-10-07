package za.ac.cput.libapp.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Yongama on 2015/10/03.
 */
public class EntryAdapter extends ArrayAdapter<ListEntry> {



    public EntryAdapter(Context context, ArrayList<ListEntry> list) {
        super(context, 0, list);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ListEntry listEntry = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_book, parent, false);
        }
        // Lookup view for data population
        TextView name = (TextView) convertView.findViewById(R.id.label);
        TextView isbn = (TextView) convertView.findViewById(R.id.sub);
        // Populate the data into the template view using the data object
        name.setText("Borrowed By : "+listEntry.uniqueValue);
        isbn.setText("Due Date : " +listEntry.value);
        // Return the completed view to render on screen
        return convertView;
    }
}
