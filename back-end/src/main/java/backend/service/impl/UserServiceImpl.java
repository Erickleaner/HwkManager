package backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import backend.model.po.User ;
import backend.service.UserService;
import backend.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @author lenovo
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2023-06-25 21:47:31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
}




