package com.sdoukou.qnrproject.service;

import com.sdoukou.qnrproject.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface IUserService {
    User getUserByUsername(String username) throws UsernameNotFoundException;
}
