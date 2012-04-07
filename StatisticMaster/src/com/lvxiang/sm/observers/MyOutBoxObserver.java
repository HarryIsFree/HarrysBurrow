package com.lvxiang.sm.observers;

import android.database.ContentObserver;
import android.os.Handler;
import com.lx.sm.model.Constants;

public class MyOutBoxObserver extends ContentObserver{

	private Handler mHandler;
	
	public MyOutBoxObserver(Handler handler) {
		super(handler);
		this.mHandler = handler;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onChange(boolean b){
		mHandler.sendEmptyMessage(Constants.MSG_OUTBOX_CHANGED);
	}

}
