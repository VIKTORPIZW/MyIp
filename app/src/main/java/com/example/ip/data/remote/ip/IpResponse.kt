package com.example.ip.data.remote.ip

import com.google.gson.annotations.SerializedName

data class IpResponse(
    @SerializedName("ip")
    var ip: String
)
