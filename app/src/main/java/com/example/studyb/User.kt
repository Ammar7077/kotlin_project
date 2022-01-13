package com.example.studyb

class User{
    var phoneNumber: Int? =0
    var name: String?= ""
    var email: String?= ""
    var username: String?= ""
    var pass: String? =""
    var country:String?= ""

    constructor(name:String?, email:String?,username:String?,pass:String?,country:String?, phoneNumber:Int?){
        this.name = name
        this.email= email
        this.username= username
        this.pass= pass
        this.country= country
        this.phoneNumber= phoneNumber

    }

}