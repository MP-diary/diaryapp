package com.example.test01.scheduler;

import android.view.View;
import android.widget.AdapterView;

/**
 * ?��?��?��?�� ?��?��?��?��?�� ?�� 처리?��?�� 리스?�� ?���? ?��?��
 * 
 * @author Mike
 */
public interface OnDataSelectionListener {

	/**
	 * ?��?��?��?�� ?��?��?��?��?�� ?�� ?��출되?�� 메소?��
	 * 
	 * @param parent Parent View
	 * @param v Target View
	 * @param row Row Index
	 * @param column Column Index
	 * @param id ID for the View
	 */
	public void onDataSelected(AdapterView parent, View v, int position, long id);
	
}
