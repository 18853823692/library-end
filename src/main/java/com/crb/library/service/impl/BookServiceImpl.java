package com.crb.library.service.impl;

import com.crb.library.entity.Book;
import com.crb.library.mapper.BookMapper;
import com.crb.library.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author crb
 * @since 2022-05-19
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

}
