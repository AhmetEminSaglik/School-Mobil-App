package com.emir.albayrak.ws.business.concretes;

import com.emir.albayrak.ws.business.abstracts.model.UserService;
//import com.emir.albayrak.ws.dataaccess.FakeUserRepository;
import com.emir.albayrak.ws.dataaccess.UserRepository;
import com.emir.albayrak.ws.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import utility.CustomLog;
import utility.exception.InvalidSignupUsernameException;
import utility.result.DataResult;
import utility.result.ErrorDataResult;
import utility.result.SuccessDataResult;

import java.util.List;

@Service
public class UserManager implements UserService {

    private UserRepository userRepository;
    private CustomLog customLog = new CustomLog(getClass());


    @Autowired
    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public DataResult<User> save(User user) {
        String msg;
        if (userRepository.findByUsername(user.getUsername()) != null) {
            customLog.info("BURADA THROW YAPILLIYOR ");
            msg = InvalidSignupUsernameException.customErrorMsg;
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDataResult<>(null, msg));
            return new ErrorDataResult<>(null, msg);
        }
        msg = "Kullanıcı başarılı bir şekilde eklendi";
        user = userRepository.save(user);
        return new SuccessDataResult<>(user, msg);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
