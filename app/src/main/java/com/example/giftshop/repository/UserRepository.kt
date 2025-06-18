package com.example.giftshop.repository

import com.example.giftshop.model.UserModel
import com.google.firebase.auth.FirebaseUser

interface UserRepository {
    //login
    //register
    //forgetPassword
    //updateProfile
    //getCurrentUser
    //addUserToDatabase
    //logout
//{
//   "success":true,
//    "message": "login successful"
//
//}
    fun login(email:String,password:String,
              callback:(Boolean,String)->Unit)

    //auth function
    //{
//   "success":true,
//    "message": "registration successful"
//    userID:"jsdjsjsj"
//}
    fun register(email:String, password: String,
                 callback: (Boolean, String,String) -> Unit)
    fun forgetPassword(email: String,
                       callback: (Boolean, String) -> Unit)
    fun updateProfile(userID: String,data:MutableMap<String,Any?>,
                      callback: (Boolean, String) -> Unit)
    fun getCurrentUser():FirebaseUser?
    //DATABASE FUNCTION
    //
    fun addUserToDatabase(userID:String,model: UserModel,
                          callback: (Boolean, String) -> Unit)
    fun getUserByID(userID: String, callback: (UserModel?,Boolean, String) -> Unit)
    fun logout(callback: (Boolean, String) -> Unit)
}