package com.my.consumeuserstest.presentation.useredit

import android.os.Bundle
import com.my.consumeuserstest.R
import com.my.consumeuserstest.TestApplication
import com.my.consumeuserstest.domain.utlis.Constants.KEY_USER_EMAIL
import com.my.consumeuserstest.domain.utlis.Constants.KEY_USER_FIRST_NAME
import com.my.consumeuserstest.domain.utlis.Constants.KEY_USER_ID
import com.my.consumeuserstest.domain.utlis.Constants.KEY_USER_LAST_NAME
import com.my.consumeuserstest.presentation.mvp.BaseView
import kotlinx.android.synthetic.main.user_add.*
import javax.inject.Inject

class UserEditView : BaseView(), UserEditContract.View {

    @Inject
    lateinit var presenter: UserEditPresenter

    override fun getLayoutId(): Int {
        return R.layout.user_add
    }

    override fun init(savedInstanceState: Bundle?) {

        val userId: Int = intent.getIntExtra(KEY_USER_ID, 0)
        prepareViews()

        with(presenter) {
            start(this@UserEditView)
        }

        btnCreateOrUpdateUser.setOnClickListener {
            presenter.updateUser(
                userId,
                tvInputFirstName.editText?.text.toString(),
                tvInputLastName.editText?.text.toString(),
                tvInputEmail.editText?.text.toString()
            )
        }
    }

    private fun prepareViews() {
        val userFirstName: String? = intent.getStringExtra(KEY_USER_FIRST_NAME)
        val userLastName: String? = intent.getStringExtra(KEY_USER_LAST_NAME)
        val userEmail: String? = intent.getStringExtra(KEY_USER_EMAIL)

        tvInputEmail.editText?.setText(userEmail)
        tvInputFirstName.editText?.setText(userFirstName)
        tvInputLastName.editText?.setText(userLastName)
    }

    override fun injectDependencies() {
        DaggerUserEditComponent.builder()
            .appComponent(TestApplication.component)
            .userEditModule(UserEditModule())
            .build()
            .inject(this)
    }

    override fun stopScreen() {
        presenter.destroy()
    }

    override fun onUpdateUserError(throwable: Throwable) {
        //show Toast.makeText
    }

    override fun onUpdateUserSuccess() {
        //progress hide
    }
}