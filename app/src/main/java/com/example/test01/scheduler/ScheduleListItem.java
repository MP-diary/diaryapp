package com.example.test01.scheduler;

public class ScheduleListItem  {

    /**
     * Data array
     */
    private String[] mData;

    /**
     * Item ID
     */
    private String mId;


    public ScheduleListItem(String scheduleId, String scheduleDate, String scheduleTime, String scheduleText)
    {
        mId = scheduleId;
        mData = new String[3];
        mData[0] = scheduleDate;
        mData[1] = scheduleTime;
        mData[2] = scheduleText;

    }

    public String getId() {return mId;}

    public void setId(String itemId) { mId = itemId; }

    /**
     * Get data
     */
    public String getData(int index) {
        if (mData == null || index >= mData.length) {
            return null;
        }

        return mData[index];
    }


}
