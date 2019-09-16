package com.my.consumeuserstest.presentation.useradd

interface UserAddContract {

    interface View {
        fun onAddUserError(throwable: Throwable)
        fun onAddUserSuccess()
    }

    interface Presenter {
        fun sendUser(userFirstName: String, userLastName: String, userEmail: String)
    }
}