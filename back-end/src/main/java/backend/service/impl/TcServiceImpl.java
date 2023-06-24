package backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import backend.model.po.Tc;
import backend.service.TcService;
import backend.mapper.TcMapper;
import org.springframework.stereotype.Service;

/**
* @author lenovo
* @description 针对表【tc】的数据库操作Service实现
* @createDate 2023-06-24 00:35:56
*/
@Service
public class TcServiceImpl extends ServiceImpl<TcMapper, Tc>
    implements TcService{

}




