package pdwy.com.taskcollaboration.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import pdwy.com.taskcollaboration.R;


/**
 * 通用ProgressDialog
 * Author： by MR on 2017/3/15.
 */
public class ProgressDialogUtils {



	/**
	 * @param infoDialog
	 */
	public static void Close(Dialog infoDialog) {
		if (infoDialog != null) {
			infoDialog.dismiss();
		}
		infoDialog = null;
	}

}
