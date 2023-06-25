package backend.controller;


import backend.model.dto.LoginTeaDto;
import backend.model.po.Tc;
import backend.model.vo.InsertVo;
import backend.model.vo.LoginVo;
import backend.service.TcService;
import backend.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/tc")
public class TcController {
    @Resource
    TcService tcService;
    @GetMapping("/list")
    public Result<List<Tc>> list() {
        List<Tc> tcList = tcService.list();
        return Result.success(tcList);
    }
    @PostMapping("/insert")
    public Result<InsertVo> insert(@RequestBody Tc tc) {
        tc.setTcId(null);
        boolean save = tcService.save(tc);
        InsertVo insertVo = new InsertVo();
        insertVo.setInsert(save);
        if (save){
            insertVo.setInsertId(tc.getTcId());
        }
        return Result.success(insertVo);
    }
    @GetMapping("/remove")
    public Result<Boolean> remove(int tcId) {
        boolean removeById = tcService.removeById(tcId);
        return Result.success(removeById);
    }
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody Tc tc) {
        boolean updateById = tcService.updateById(tc);
        return Result.success(updateById);
    }


}
