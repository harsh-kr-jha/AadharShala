package com.example.aadharshala2.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.util.Patterns;

import com.example.aadharshala2.data.LoginRepository;
import com.example.aadharshala2.data.Result;
import com.example.aadharshala2.data.model.LoggedInUser;
import com.example.aadharshala2.R;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();
    private MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();
    private LoginRepository loginRepository;

    LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    LiveData<LoginFormState> getLoginFormState() {
        return loginFormState;
    }

    LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }

    public void login(String username) {
        // can be launched in a separate asynchronous job
//        Result<LoggedInUser> com.example.aadharshala2.result = loginRepository.login(username);
//            api call
//
//        if (status == 'y'){
//            askforotp();
//            if (askforotp();) {
//           launch new dashboard activity
//       } else {
//            loginResult.setValue(new LoginResult(R.string.login_failed));
//       }
//        }else
//        {
//            print error code
//        }


//        if (com.example.aadharshala2.result instanceof Result.Success) {
//            LoggedInUser data = ((Result.Success<LoggedInUser>) com.example.aadharshala2.result).getData();
//            loginResult.setValue(new LoginResult(new LoggedInUserView(data.getDisplayName())));
//        } else {
//            loginResult.setValue(new LoginResult(R.string.login_failed));
//        }
    }

    public void loginDataChanged(String username) {
        if (!isUserNameValid(username)) {
            loginFormState.setValue(new LoginFormState(R.string.invalid_username, null));
        } else {
            loginFormState.setValue(new LoginFormState(true));
        }
    }

    // A placeholder username validation check
    private boolean isUserNameValid(String username) {
        if (username.length() == 12 || username.length() == 10)
            return true;
        else return false;

    }
    private boolean isOtpValid(){
//        change fragment to ask for otp view
//
//                send otp to api
//
//                return status== y;
//
//         get token for this aadhar.. from local database..
//        store it in  final user_token and set boolean login to 1;
        return  true;
    }

//    // A placeholder password validation check
//    private boolean isPasswordValid(String password) {
//        return password != null && password.trim().length() > 5;
//    }
}