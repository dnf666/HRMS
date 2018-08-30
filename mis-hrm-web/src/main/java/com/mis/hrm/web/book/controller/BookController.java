package com.mis.hrm.web.book.controller;


import com.mis.hrm.book.po.Book;
import com.mis.hrm.book.service.BookService;

import com.mis.hrm.web.book.util.BookModelControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    /**
     *   @api {GET} book-list-1 通过公司id
     *   @apiDescription 通过公司id得到书录
     *   @apiGroup BOOK-QUERY
     *   @apiParam  {String} companyId 公司id
     *   @apiSuccessExample {json} Success-Response:
     *       HTTP/1.1 200 OK
     *       {
     *         "code": "1",
     *         "msg": "success"
     *         "object":[{
     * 	            "bookId": "dddddfffffsssss",
     * 	            "bookName": "你的灯亮着吗？",
     * 	            "category": "思维",
     * 	            "companyId": "信管工作室",
     * 	            "quantity": 2,
     * 	            "version": "2.0"
     *              }, {
     * 	            "bookId": "reerrrrrrr",
     * 	            "bookName": "你的灯亮着吗？",
     *          	"category": "思维",
     *          	"companyId": "信管工作室",
     *           	"quantity": 2,
     *           	"version": "2.0"
     *              }]
     *              }
     */
    @GetMapping("book-list-1")
    public Map getBooksByCompanyId(Book book){
        Map<String, Object> result;
        result = BookModelControllerUtil.getResult(bookService::selectBooksByCompanyId, book);
        return result;
    }

    /**
     *   @api {GET} book-list-2 通过公司id和类别
     *   @apiDescription 通过公司id和分类得到书录
     *   @apiGroup BOOK-QUERY
     *   @apiParam  {String} companyId 公司id
     *   @apiParam  {String} category 分类
     *   @apiSuccessExample {json} Success-Response:
     *       HTTP/1.1 200 OK
     *       {
     *         "code": "1",
     *         "msg": "success"
     *         "object":[{
     * 	            "bookId": "dddddfffffsssss",
     * 	            "bookName": "你的灯亮着吗？",
     * 	            "category": "思维",
     * 	            "companyId": "信管工作室",
     * 	            "quantity": 2,
     * 	            "version": "2.0"
     *              }, {
     * 	            "bookId": "reerrrrrrr",
     * 	            "bookName": "你的灯亮着吗？",
     *          	"category": "思维",
     *          	"companyId": "信管工作室",
     *           	"quantity": 2,
     *           	"version": "2.0"
     *              }]
     *              }
     */
    @GetMapping("book-list-2")
    public Map getBooksByCompanyAndCateGory(Book book){
        Map<String, Object> result;
        result = BookModelControllerUtil.getResult(bookService::selectBooksByComapnyIdAndCategory, book);
        return result;
    }

    /**
     *   @api {GET} book-list-3 通过公司id和书名
     *   @apiDescription 通过公司id和书名得到书录
     *   @apiGroup BOOK-QUERY
     *   @apiParam  {String} companyId 公司id
     *   @apiParam  {String} bookName 书的名称
     *   @apiSuccessExample {json} Success-Response:
     *       HTTP/1.1 200 OK
     *       {
     *         "code": "1",
     *         "msg": "success"
     *         "object":[{
     * 	            "bookId": "dddddfffffsssss",
     * 	            "bookName": "你的灯亮着吗？",
     * 	            "category": "思维",
     * 	            "companyId": "信管工作室",
     * 	            "quantity": 2,
     * 	            "version": "2.0"
     *              }, {
     * 	            "bookId": "reerrrrrrr",
     * 	            "bookName": "你的灯亮着吗？",
     *          	"category": "思维",
     *          	"companyId": "信管工作室",
     *           	"quantity": 2,
     *           	"version": "2.0"
     *              }]
     *              }
     */
    @GetMapping("book-list-3")
    public Map getBooksByCompanyAndBookName(Book book){
        Map<String, Object> result;
        result = BookModelControllerUtil.getResult(bookService::selectBooksByCompanyIdAndBookName, book);
        return result;
    }

    /**
     *   @api {GET} book-list-4 通过书的id
     *   @apiDescription 通过书的id得到书的信息
     *   @apiGroup BOOK-QUERY
     *   @apiParam  {String} bookId 书的id
     *   @apiSuccessExample {json} Success-Response:
     *       HTTP/1.1 200 OK
     *       {
     *         "code": "1",
     *         "msg": "success"
     *         "object":{
     * 	            "bookId": "dddddfffffsssss",
     * 	            "bookName": "你的灯亮着吗？",
     * 	            "category": "思维",
     * 	            "companyId": "信管工作室",
     * 	            "quantity": 2,
     * 	            "version": "2.0"
     *              }
     *       }
     */
    @GetMapping("book-list-4")
    public Map getBookByBookId(Book book){
        Map<String, Object> result;
        result = BookModelControllerUtil.getResult(bookService::selectByPrimaryKey, book);
        return result;
    }

    /**
     *   @api {PUT} book 通过书的id更新书的信息
     *   @apiDescription 通过书的id更新书的信息，同时返回更新后的信息
     *   @apiGroup BOOK-UPDATE
     *   @apiParam  {String} bookId 书的id
     *   @apiParam  {String} companyId 公司id
     *   @apiParam  {String} bookName 书名
     *   @apiParam  {String} category 类别
     *   @apiParam  {String} quantity 数量
     *   @apiParam  {String} version 版本
     *   @apiSuccessExample {json} Success-Response:
     *       HTTP/1.1 200 OK
     *       {
     *         "code": "1",
     *         "msg": "success"
     *         "object":{
     * 	            "bookId": "dddddfffffsssss",
     * 	            "bookName": "你的灯亮着吗？",
     * 	            "category": "思维",
     * 	            "companyId": "信管工作室",
     * 	            "quantity": 2,
     * 	            "version": "2.0"
     *              }
     *       }
     */
    @PutMapping("book")
    public Map updateBookByBookId(Book book){
        Map<String, Object> result;
        result = BookModelControllerUtil.getResult(bookService::updateByPrimaryKey, book);
        return result;
    }

    /**
     *   @api {POST} book 插入一书本的信息
     *   @apiDescription 插入一本书的信息
     *   @apiGroup BOOK-ADD
     *   @apiParam  {String} companyId 公司id
     *   @apiParam  {String} bookName 书名
     *   @apiParam  {String} category 类别
     *   @apiParam  {String} quantity 数量
     *   @apiParam  {String} version 版本
     *   @apiSuccessExample {json} Success-Response:
     *       HTTP/1.1 200 OK
     *       {
     *         "code": "1",
     *         "msg": "success"
     *         "object": null
     *       }
     */
    @PostMapping("book")
    public Map addBookInfo(Book book){
        Map<String, Object> result;
        result = BookModelControllerUtil.getResult(bookService::insert, book);
        return result;
    }

    /**
     *   @api {DELETE} book/{bookId} 通过bookId
     *   @apiDescription 通过bookId删除一本书的信息
     *   @apiGroup BOOK-DELETE
     *   @apiParam  {String} bookId 书的id
     *   @apiSuccessExample {json} Success-Response:
     *       HTTP/1.1 200 OK
     *       {
     *         "code": "1",
     *         "msg": "success"
     *         "object": null
     *       }
     */
    @DeleteMapping("book/{bookId}")
    public Map deleteBookInfoByBookId(@PathVariable("bookId") String bookId){
        Map<String, Object> result;
        Book book = Book.builder().bookId(bookId).build();
        result = BookModelControllerUtil.getResult(bookService::deleteByPrimaryKey, book);
        return result;
    }
}
