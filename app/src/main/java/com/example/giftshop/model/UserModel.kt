package com.example.giftshop.model

import android.provider.ContactsContract.CommonDataKinds.Email

data class UserModel(
    var userId: String="",
    var email: String="",
    var firstName: String="",
    var lastName: String="",
    var gender: String="",

)
