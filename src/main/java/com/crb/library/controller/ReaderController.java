package com.crb.library.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crb.library.entity.Reader;
import com.crb.library.service.IReaderService;
import com.crb.library.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author crb
 * @since 2022-05-19
 */
@RestController
@RequestMapping("/reader")
public class ReaderController {

    @Resource
    private IReaderService readerService;

    @PostMapping("/addOrUpdateReader")
    public Result addOrUpdateReader(@RequestBody Reader reader){
        readerService.saveOrUpdate(reader);
        return Result.success("用户处理成功");
    }

    @GetMapping("/getReaders")
    public Result getReaders(@RequestParam Integer pageSize, @RequestParam Integer pageNumber){
        Page<Reader> page = new Page<>(pageNumber,pageSize);
        QueryWrapper<Reader> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("code");
        Page<Reader> result = readerService.page(page, queryWrapper);
        return Result.success(result);
    }

    @GetMapping("/getReader")
    public Result getReader (@RequestParam String select){
        QueryWrapper<Reader> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("code", select).or().like("name", select).orderByAsc("code");
        List<Reader> readers = readerService.list(queryWrapper);
        return Result.success(readers);
    }

    @GetMapping("/getReaderById")
    public Result getReaderById(@RequestParam Long id){
        Reader reader = readerService.getById(id);
        return Result.success(reader);
    }

    @DeleteMapping("/delReader")
    public Result delReader (@RequestParam Long id){
        readerService.removeById(id);
        return Result.success("用户删除成功");
    }

}
