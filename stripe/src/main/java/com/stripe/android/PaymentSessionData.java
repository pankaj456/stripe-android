package com.stripe.android;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

class PaymentSessionData implements Parcelable {

    private static final String NO_PAYMENT = "NO_PAYMENT";

    private long mCartTotal = 0L;
    @NonNull private String mSelectedPaymentMethodId = NO_PAYMENT;
    private long mShippingTotal = 0L;

    PaymentSessionData() { }

    @Nullable
    public String getSelectedPaymentMethodId() {
        return mSelectedPaymentMethodId.equals(NO_PAYMENT) ? null : mSelectedPaymentMethodId;
    }

    public void setSelectedPaymentMethodId(@Nullable String selectedPaymentMethodId) {
        mSelectedPaymentMethodId = selectedPaymentMethodId == null
                ? NO_PAYMENT
                : selectedPaymentMethodId;
    }

    public long getCartTotal() {
        return mCartTotal;
    }

    public void setCartTotal(long cartTotal) {
        mCartTotal = cartTotal;
    }

    public long getShippingTotal() {
        return mShippingTotal;
    }

    public void setShippingTotal(long shippingTotal) {
        mShippingTotal = shippingTotal;
    }

    /************** Parcelable *********************/
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(mCartTotal);
        parcel.writeString(mSelectedPaymentMethodId);
        parcel.writeLong(mShippingTotal);
    }

    public static final Parcelable.Creator<PaymentSessionData> CREATOR
            = new Parcelable.Creator<PaymentSessionData>() {
        public PaymentSessionData createFromParcel(Parcel in) {
            return new PaymentSessionData(in);
        }

        public PaymentSessionData[] newArray(int size) {
            return new PaymentSessionData[size];
        }
    };

    private PaymentSessionData(Parcel in) {
        mCartTotal = in.readLong();
        mSelectedPaymentMethodId = in.readString();
        mShippingTotal = in.readLong();
    }
}
