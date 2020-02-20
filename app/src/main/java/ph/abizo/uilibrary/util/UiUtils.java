package ph.abizo.uilibrary.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;


import ph.abizo.uilibrary.R;
import ph.abizo.uilibrary.callbacks.OnAlertDialogDismissed;

public class UiUtils {
    private Context context;

    private OnAlertDialogDismissed onAlertDialogDismissed;

    public UiUtils(Context context) {
        this.context = context;
    }

    public void showAlertDialog(final boolean hasIntent, String title, String body, final int requestCode) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title)
                .setMessage(body)
                .setCancelable(false)
                .setNeutralButton(context.getString(R.string.okay_hint), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        if (hasIntent) {
                            onAlertDialogDismissed.onNeutralButtonTapped(requestCode);
                        }
                    }
                });
        builder.show().setCanceledOnTouchOutside(false);
    }

    public void setOnAlertDialogDismissed(OnAlertDialogDismissed onAlertDialogDismissed) {
        this.onAlertDialogDismissed = onAlertDialogDismissed;
    }
}
