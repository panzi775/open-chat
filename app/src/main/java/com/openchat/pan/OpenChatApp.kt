package com.openchat.pan

import android.app.Application
import android.os.Parcel
import android.os.Parcelable
import com.tencent.imsdk.v2.V2TIMManager
import com.tencent.imsdk.v2.V2TIMSDKConfig

@HiltAndroidApp
class OpenChatApp() : Application(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun onCreate() {
        super.onCreate()
        // 腾讯云 IM SDK 初始化
        val config = V2TIMSDKConfig()
        config.logLevel = V2TIMSDKConfig.V2TIM_LOG_INFO
        // TODO: 替换为你的腾讯云 SDKAppID
        V2TIMManager.getInstance().initSDK(this, /*SDKAppID*/ 0, config)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<OpenChatApp> {
        override fun createFromParcel(parcel: Parcel): OpenChatApp {
            return OpenChatApp(parcel)
        }

        override fun newArray(size: Int): Array<OpenChatApp?> {
            return arrayOfNulls(size)
        }
    }
} 