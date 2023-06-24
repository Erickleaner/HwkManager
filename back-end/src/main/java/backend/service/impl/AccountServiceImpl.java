package backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import backend.model.po.Account;
import backend.service.AccountService;
import backend.mapper.AccountMapper;
import org.springframework.stereotype.Service;

/**
* @author lenovo
* @description 针对表【account】的数据库操作Service实现
* @createDate 2023-06-24 00:35:56
*/
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account>
    implements AccountService{

}




