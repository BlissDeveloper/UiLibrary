package ph.abizo.uilibrary.callbacks;

public interface OnAlertDialogDismissed {
    void onNeutralButtonTapped(int requestCode);

    void onPositiveButtonTapped(int requestCode);

    void onNegativeButtonTapped(int requestCode);
}
