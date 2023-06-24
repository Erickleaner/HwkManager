package backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import backend.model.po.Major;
import backend.service.MajorService;
import backend.mapper.MajorMapper;
import org.springframework.stereotype.Service;

/**
* @author lenovo
* @description 针对表【major】的数据库操作Service实现
* @createDate 2023-06-24 00:35:56
*/
@Service
public class MajorServiceImpl extends ServiceImpl<MajorMapper, Major>
    implements MajorService{

}




