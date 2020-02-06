package com.zxj.jhentai.Entitys;

import android.os.Parcel;
import android.os.Parcelable;

public class RecommendIndicatorEntity implements Parcelable {
    public String title;
    public String parseUrl;
    public RecommendIndicatorEntity(String title,String parseUrl){
        this.title = title;
        this.parseUrl = parseUrl;
    }

    protected RecommendIndicatorEntity(Parcel in) {
        title = in.readString();
        parseUrl = in.readString();
    }

    public static final Creator<RecommendIndicatorEntity> CREATOR = new Creator<RecommendIndicatorEntity>() {
        @Override
        public RecommendIndicatorEntity createFromParcel(Parcel in) {
            return new RecommendIndicatorEntity(in);
        }

        @Override
        public RecommendIndicatorEntity[] newArray(int size) {
            return new RecommendIndicatorEntity[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(parseUrl);
    }
}
