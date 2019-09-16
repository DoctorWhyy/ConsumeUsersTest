package com.my.consumeuserstest.presentation.useradd

import android.os.Bundle
import com.my.consumeuserstest.R
import com.my.consumeuserstest.TestApplication
import com.my.consumeuserstest.presentation.mvp.BaseView

import kotlinx.android.synthetic.main.user_add.*
import javax.inject.Inject

class UserAddView : BaseView(), UserAddContract.View {

    @Inject
    lateinit var presenter: UserAddPresenter

    override fun onAddUserError(throwable: Throwable) {
        //show toast
    }

    override fun onAddUserSuccess() {
        //progress.show(false)
    }

    override fun init(savedInstanceState: Bundle?) {
        with(presenter) {
            start(this@UserAddView)
        }

        btnCreateOrUpdateUser.setOnClickListener {
            presenter.sendUser(
                tvInputFirstName.editText?.text.toString(),
                tvInputFirstName.editText?.text.toString(),
                tvInputEmail.editText?.text.toString()
            )
        }
    }

    override fun stopScreen() {
        presenter.destroy()
    }

    override fun getLayoutId(): Int {
        return R.layout.user_add
    }

    override fun injectDependencies() {
        DaggerUserAddComponent.builder()
            .appComponent(TestApplication.component)
            .userAddModule(UserAddModule())
            .build()
            .inject(this)
    }
}