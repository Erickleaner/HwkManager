package backend.controller;


import backend.model.po.Course;
import backend.model.po.Major;
import backend.model.vo.OptionVo;
import backend.service.CourseService;
import backend.service.MajorService;
import backend.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/major")
public class MajorController {
    @Resource
    MajorService majorService;
    @GetMapping("/optionList")
    public Result<List<OptionVo>> list() {
        List<OptionVo> optionList = new ArrayList<>();
        List<Major> majorList = majorService.list();
        for (Major major:majorList){
            String text = major.getName();
            Integer value = major.getMajorId();
            optionList.add(new OptionVo(text,value));
        }
        return Result.success(optionList);
    }
}
