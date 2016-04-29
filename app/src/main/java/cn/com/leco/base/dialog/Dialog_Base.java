package cn.com.leco.base.dialog;

import com.orhanobut.dialogplus.DialogPlus;

import com.orhanobut.dialogplus.DialogPlus;

import android.content.Context;
import android.widget.BaseAdapter;

import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.Holder;
import com.orhanobut.dialogplus.OnItemClickListener;
import com.orhanobut.dialogplus.ViewHolder;



/**
 * Created by LOVE on 2015/6/23 023.
 */
public class Dialog_Base {

    public static DialogPlus create(Context context, cn.com.leco.base.dialog.Dialog_header header, cn.com.leco.base.dialog.Dialog_footer footer, Holder holder, int gravity, BaseAdapter adapter, OnItemClickListener itemClickListener, boolean expanded) {

        DialogPlus.Builder builder = new DialogPlus.Builder(context).setContentHolder(holder).setHeader(header).setFooter(footer).setCancelable(false).setGravity(gravity).setOnItemClickListener(itemClickListener).setExpanded(expanded);

        if (adapter != null) {
            builder.setAdapter(adapter);
        }

        DialogPlus dialog = builder.create();

        return dialog;

    }


    public static DialogPlus infoDialog(Context context, String title, String msg, int gravity, cn.com.leco.base.dialog.Dialog_footer.onBtnClickListener mlistener) {

        cn.com.leco.base.dialog.Dialog_footer footer = new cn.com.leco.base.dialog.Dialog_footer(context);

        DialogPlus.Builder builder = new DialogPlus.Builder(context).setContentHolder(new ViewHolder(new cn.com.leco.base.dialog.Dialog_Content(context, msg))).setHeader(new cn.com.leco.base.dialog.Dialog_header(context, title)).setFooter(footer).setCancelable(false).setGravity(gravity);

        DialogPlus dialog = builder.create();

        footer.setListener(null, "确定", mlistener);


        return dialog;


    }

    public static DialogPlus actionDialog(Context context, String title, String msg, int gravity, cn.com.leco.base.dialog.Dialog_footer.onBtnClickListener mlistener) {

        cn.com.leco.base.dialog.Dialog_footer footer = new cn.com.leco.base.dialog.Dialog_footer(context);

        DialogPlus.Builder builder = new DialogPlus.Builder(context).setContentHolder(new ViewHolder(new cn.com.leco.base.dialog.Dialog_Content(context, msg))).setHeader(new cn.com.leco.base.dialog.Dialog_header(context, title)).setFooter(footer).setCancelable(false).setGravity(gravity);

        DialogPlus dialog = builder.create();

        footer.setListener("取消", "确定", mlistener);


        return dialog;


    }


}
