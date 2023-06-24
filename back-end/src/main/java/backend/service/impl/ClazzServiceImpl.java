package backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import backend.model.po.Clazz;
import backend.service.ClazzService;
import backend.mapper.ClazzMapper;
import org.springframework.stereotype.Service;

/**
* @author lenovo
* @description 针对表【clazz】的数据库操作Service实现
* @createDate 2023-06-24 00:35:56
*/
@Service
public class ClazzServiceImpl extends ServiceImpl<ClazzMapper, Clazz>
    implements ClazzService{

}




