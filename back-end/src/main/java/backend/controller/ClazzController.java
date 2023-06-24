package backend.controller;


import backend.model.po.Clazz;
import backend.model.po.Course;
import backend.model.po.Major;
import backend.model.vo.InsertVo;
import backend.model.vo.OptionVo;
import backend.service.ClazzService;
import backend.service.CourseService;
import backend.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clazz")
public class ClazzController {
    @Resource
    ClazzService clazzService;
    @GetMapping("/list")
    public Result<List<Clazz>> list() {
        List<Clazz> clazzList = clazzService.list();
        return Result.success(clazzList);
    }
    @PostMapping("/insert")
    public Result<InsertVo> insert(@RequestBody Clazz clazz) {
        clazz.setClazzId(null);
        boolean save = clazzService.save(clazz);
        InsertVo insertVo = new InsertVo();
        insertVo.setInsert(save);
        if (save){
            insertVo.setInsertId(clazz.getClazzId());
        }
        return Result.success(insertVo);
    }
    @GetMapping("/remove")
    public Result<Boolean> remove(int clazzId) {
        boolean removeById = clazzService.removeById(clazzId);
        return Result.success(removeById);
    }
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody Clazz clazz) {
        boolean updateById = clazzService.updateById(clazz);
        return Result.success(updateById);
    }
    @GetMapping("/optionList")
    public Result<List<OptionVo>> optionList() {
        List<OptionVo> optionList = new ArrayList<>();
        List<Clazz> clazzList = clazzService.list();
        for (Clazz clazz:clazzList){
            String text = clazz.getName();
            Integer value = clazz.getClazzId();
            optionList.add(new OptionVo(text,value));
        }
        return Result.success(optionList);
    }
}
