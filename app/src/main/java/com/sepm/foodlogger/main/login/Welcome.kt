package com.gojek.gojekbeta.main.login

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Welcome(val header: String, val description: String): Parcelable
