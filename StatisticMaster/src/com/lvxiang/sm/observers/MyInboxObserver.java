package com.lvxiang.sm.observers;

import android.database.ContentObserver;
import android.os.Handler;
import com.lx.sm.model.Constants;

public class MyInboxObserver extends ContentObserver{

	private Handler handler;
	
	public MyInboxObserver(Handler handler) {
		super(handler);
		this.handler = handler;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onChange(boolean b){
		handler.sendEmptyMessage(Constants.MSG_INBOX_CHANGED);
	}
	
}
