package com.amikhailov.springstudying.mobileappws.userservice;

import com.amikhailov.springstudying.mobileappws.ui.model.UserRest;
import com.amikhailov.springstudying.mobileappws.ui.model.request.UserDetailsRequestModel;

public interface UserService {
   UserRest createUser(UserDetailsRequestModel userDetails);
}
