package com.emir.albayrak.ws.business.concretes;

import com.emir.albayrak.ws.business.abstracts.LoginService;
import com.emir.albayrak.ws.dataaccess.UserRepository;
import com.emir.albayrak.ws.model.User;
import com.emir.albayrak.ws.model.LoginCredentials;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utility.CustomLog;
import utility.result.DataResult;
import utility.result.ErrorDataResult;
import utility.result.SuccessDataResult;

@Service
public class LoginManager implements LoginService {
    private UserRepository userRepository;
    private CustomLog customLog = new CustomLog(getClass());


    @Autowired
    public LoginManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public DataResult<User> findUserByLoginCredentials(LoginCredentials loginCredentials) {
        User user = userRepository.findByUsernameAndPassword
                (loginCredentials.getUsername(), loginCredentials.getPassword());
        String msg;
        if (user == null) {
            customLog.error("Login Credentials is wrong");
            msg = "Kullanıcı adı veya parola hatalı. Lütfen tekrar deneyiniz";
            return new ErrorDataResult<>(user, msg);
        }
        customLog.error("Login is successfully");
        msg = "Giriş Başarılı";

        return new SuccessDataResult<>(user, msg);
    }
}
