package com.my.consumeuserstest.presentation.useredit

interface UserEditContract {

    interface View {
        fun onUpdateUserError(throwable: Throwable)
        fun onUpdateUserSuccess()
    }

    interface Presenter {
        fun updateUser(userId: Int, userFirstName: String, userLastName: String, userEmail: String)
    }
}