package sakref.yohan.mareu.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.DialogFragment;

import butterknife.BindView;
import sakref.yohan.mareu.R;
import sakref.yohan.mareu.model.Room;
import sakref.yohan.mareu.service.DummyMeetingApiService;

public class FilterDialogFragment extends DialogFragment{


    public interface NoticeDialogListener {
        public void onDialogPositiveClick(String date, String salle);
    }

    NoticeDialogListener listener;



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            listener = (NoticeDialogListener) context;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(this.toString()
                    + " must implement NoticeDialogListener");
        }
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {



        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        //TODO : Binder avec butterknife

        View mView = inflater.inflate(R.layout.dialog_filters, null);
        Spinner mSpinner = (Spinner) mView.findViewById(R.id.filter_spinner_room);
        ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(getActivity(), R.array.Room, android.R.layout.simple_spinner_item);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapterSpinner);


        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(mView)
                .setTitle("Filtre de reunion")
                // Add action buttons
                .setPositiveButton("Filtrer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //TODO : implementer la date et la salle de ma vue
                        //listener.onDialogPositiveClick(date, salle);
                    }
                })
                .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        FilterDialogFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }
}