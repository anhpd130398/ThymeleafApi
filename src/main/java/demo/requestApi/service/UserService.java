package demo.requestApi.service;

import demo.requestApi.entities.User;
import demo.requestApi.entities.pay.BaseResponse;
import demo.requestApi.entities.pay.RequestLogin;
import demo.requestApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public BaseResponse loginUser(RequestLogin login) {
        List<User> userList = userRepository.getByName(login.getUserName());
        if (userList.isEmpty()) {
            return new BaseResponse("login not success", "");
        } else {
            return new BaseResponse("login success", "");
        }
    }
}
