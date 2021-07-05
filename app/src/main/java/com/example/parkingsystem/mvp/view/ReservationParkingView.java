package com.example.parkingsystem.mvp.view;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import androidx.fragment.app.FragmentManager;
import com.example.parkingsystem.R;
import com.example.parkingsystem.databinding.ActivityReserverParkingLotBinding;
import com.example.parkingsystem.fragments.DateReservationDialogFragment;
import com.example.parkingsystem.mvp.contract.ReservationParkingContract;
import com.example.parkingsystem.mvp.view.base.ActivityView;

public class ReservationParkingView extends ActivityView implements ReservationParkingContract.ReservationActivityView {

    private final String DIALOG_FRAGMENT_DATE_PICKER = "dialog fragment date picker";
    private ActivityReserverParkingLotBinding binding;

    public ReservationParkingView(Activity activity, ActivityReserverParkingLotBinding binding) {
        super(activity);
        this.binding = binding;
    }

    @Override
    public void showDialogDataPiker(boolean startDatePiker) {
        FragmentManager fragmentManager = getFragmentManager();
        DateReservationDialogFragment dateDialogFragment = DateReservationDialogFragment.newInstance(startDatePiker);
        dateDialogFragment.show(fragmentManager, DIALOG_FRAGMENT_DATE_PICKER);
    }

    @Override
    public String getParkingLot() {
        return binding.editTextReserverParkingPlace.getText().toString();
    }

    @Override
    public String getParkingCode() {
        return binding.editTextReserverParkingCode.getText().toString();
    }

    @Override
    public void toastShowTextData(int lote, int code, String dateStart, String dateEnd) {
        Context context = getContext();
        Activity activity = getActivity();
        if (context != null && activity != null)
            Toast.makeText(context, context.getString(R.string.toast_resaervation_parking, lote, code, dateStart, dateEnd), Toast.LENGTH_SHORT).show();
            activity.onBackPressed();
    }
}
