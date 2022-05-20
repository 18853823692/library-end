package com.crb.library.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crb.library.entity.Book;
import com.crb.library.service.IBookService;
import com.crb.library.util.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

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
@RequestMapping("/book")
public class BookController {

    @Resource
    private IBookService bookService;

    @PostMapping("/addOrUpdateBook")
    public Result addOrUpdateBook(@RequestBody Book book){
        bookService.saveOrUpdate(book);
        return Result.success("图书处理成功");
    }

    @GetMapping("/getBooks")
    public Result getBooks(@RequestParam Integer pageSize,@RequestParam Integer pageNumber){
        Page<Book> page = new Page<>(pageNumber,pageSize);
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("code");
        Page<Book> result = bookService.page(page, queryWrapper);
        return Result.success(result);
    }

    @GetMapping("/getBook")
    public Result getBook (@RequestParam String select){
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("code", select).or().like("name", select).orderByAsc("code");
        List<Book> books = bookService.list(queryWrapper);
        return Result.success(books);
    }

    @GetMapping("/getBookById")
    public Result getBookById (@RequestParam Long id){
        Book book = bookService.getById(id);
        return Result.success(book);
    }

    @DeleteMapping("/delBook")
    public Result delBook (@RequestParam Long id){
        bookService.removeById(id);
        return Result.success("图书删除成功");
    }

}
