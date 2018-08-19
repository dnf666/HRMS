package com.mis.hrm.web.member.apidoc;

import com.mis.hrm.member.model.Member;
import com.mis.hrm.project.util.ConstantValue;
import com.mis.hrm.util.Pager;
import com.mis.hrm.util.ToMap;

import java.util.ArrayList;
import java.util.Map;

public class MemberApiDoc {

    /**
     *   @api {POST} member 添加单个成员信息
     *   @apiGroup MEMBER-ADD
     *   @apiParam  {String} companyId 公司id
     *   @apiParam  {String} num 学号
     *   @apiParam  {String} name 姓名
     *   @apiParam  {String} phoneNumber 电话
     *   @apiParam  {String} email 邮箱
     *   @apiParam  {String} grade 年级（如2017级）
     *   @apiParam  {String} sex 性别
     *   @apiParam  {String} profession 专业
     *   @apiParam  {String} department 部门
     *   @apiSuccessExample {json} Success-Response:
     *       HTTP/1.1 200 OK
     *       {
     *         "code": "1",
     *         "msg": "success"
     *         "object": null
     *       }
     */
    public Map insertOneMember(Member member){
        return ToMap.toMap(ConstantValue.SUCCESS_CODE,ConstantValue.SUCCESS,null);
    }

    /**
     *   @api {DELETE} member 删除单个成员信息
     *   @apiDescription 根据companyId和num删除成员信息
     *   @apiGroup MEMBER-DELETE
     *   @apiParam  {String} companyId 公司id
     *   @apiParam  {String} num 学号
     *   @apiSuccessExample {json} Success-Response:
     *       HTTP/1.1 200 OK
     *       {
     *         "code": "1",
     *         "msg": "success"
     *         "object": null
     *       }
     */
    public Map deleteOneMember(Member member){
        return ToMap.toMap(ConstantValue.SUCCESS_CODE,ConstantValue.SUCCESS,null);
    }

    /**
     *   @api {PUT} member 更新单个成员信息
     *   @apiDescription 根据companyId和num更新成员信息
     *   @apiGroup MEMBER-UPDATE
     *   @apiParam  {String} companyId 公司id
     *   @apiParam  {String} num 学号
     *   @apiParam  {String} name 姓名
     *   @apiParam  {String} phoneNumber 电话
     *   @apiParam  {String} email 邮箱
     *   @apiParam  {String} grade 年级（如2017级）
     *   @apiParam  {String} sex 性别
     *   @apiParam  {String} profession 专业
     *   @apiParam  {String} department 部门
     *   @apiSuccessExample {json} Success-Response:
     *       HTTP/1.1 200 OK
     *       {
     *         "code": "1",
     *         "msg": "success"
     *         "object": null
     *       }
     */
    public Map updateOneMember(Member member){
        return ToMap.toMap(ConstantValue.SUCCESS_CODE,ConstantValue.SUCCESS,null);
    }

    /**
     *   @api {GET} member 查找单个成员信息
     *   @apiDescription 根据companyId和num查找成员信息
     *   @apiGroup MEMBER-QUERY
     *   @apiParam  {String} companyId 公司id
     *   @apiParam  {String} num 学号
     *   @apiSuccessExample {json} Success-Response:
     *       HTTP/1.1 200 OK
     *       {
     *         "code": "1",
     *         "msg": "success"
     *         "object":{
     *             "companyId": "信管工作室",
     *             "num": "001",
     *             "name": "大红",
     *             "phoneNumber": "21212222222",
     *             "email": "211@222.com",
     *             "grade": "2017级",
     *             "sex": "女",
     *             "profession": "信管",
     *             "department": "后台"
     *         }
     *       }
     */
    public Map selectOneMember(String companyId, String num){
        return ToMap.toMap(ConstantValue.SUCCESS_CODE,ConstantValue.SUCCESS,new Member());
    }

    /**
     *   @api {GET} member/count 获取成员总数
     *   @apiDescription 直接返回成员总数
     *   @apiGroup MEMBER-QUERY
     *   @apiSuccessExample {json} Success-Response:
     *       HTTP/1.1 200 OK
     *       {
     *         "code": "1",
     *         "msg": "success"
     *         "object": 12
     *       }
     */
    public Map countMembers(){
        return ToMap.toMap(ConstantValue.SUCCESS_CODE,ConstantValue.SUCCESS,0);
    }

    /**
     *   @api {GET} member/all/{page} 获取成员列表
     *   @apiDescription 分页获取全部成员信息
     *   @apiGroup MEMBER-QUERY
     *   @apiParam  {Integer} page 当前页码
     *   @apiSuccessExample {json} Success-Response:
     *       HTTP/1.1 200 OK
     *       {
     *         "code": "1",
     *         "msg": "success"
     *         "object":[{
     *             "companyId": "信管工作室",
     *             "num": "001",
     *             "name": "大红",
     *             "phoneNumber": "21212222222",
     *             "email": "211@222.com",
     *             "grade": "2017级",
     *             "sex": "女",
     *             "profession": "信管",
     *             "department": "后台"
     *         },
     *         {
     *             "companyId": "信管工作室",
     *             "num": "002",
     *             "name": "大白",
     *             "phoneNumber": "21212333333",
     *             "email": "222@222.com",
     *             "grade": "2017级",
     *             "sex": "女",
     *             "profession": "信管",
     *             "department": "后台"
     *         }]
     *       }
     */
    public Map getAllMembers(Integer page, Pager<Member> pager){
        return ToMap.toMap(ConstantValue.SUCCESS_CODE,ConstantValue.SUCCESS,new ArrayList<>());
    }

    /**
     *   @api {GET} member/byPhone/{page} 根据电话获取成员
     *   @apiDescription 根据电话的模糊分页查询
     *   @apiGroup MEMBER-QUERY
     *   @apiParam  {Integer} page 当前页码
     *   @apiParam  {String} phoneNumber 电话
     *   @apiSuccessExample {json} Success-Response:
     *       HTTP/1.1 200 OK
     *       {
     *         "code": "1",
     *         "msg": "success"
     *         "object":[{
     *             "companyId": "信管工作室",
     *             "num": "001",
     *             "name": "大红",
     *             "phoneNumber": "21212222222",
     *             "email": "211@222.com",
     *             "grade": "2017级",
     *             "sex": "女",
     *             "profession": "信管",
     *             "department": "后台"
     *         },
     *         {
     *             "companyId": "信管工作室",
     *             "num": "002",
     *             "name": "大白",
     *             "phoneNumber": "21212333333",
     *             "email": "222@222.com",
     *             "grade": "2017级",
     *             "sex": "女",
     *             "profession": "信管",
     *             "department": "后台"
     *         }]
     *       }
     */
    public Map findByPhoneNumber(String phoneNumber, Integer page, Pager<Member> pager){
        return ToMap.toMap(ConstantValue.SUCCESS_CODE,ConstantValue.SUCCESS,new ArrayList<>());
    }

    /**
     *   @api {GET} member/byEmail/{page} 根据邮箱获取成员
     *   @apiDescription 根据邮箱的模糊分页查询
     *   @apiGroup MEMBER-QUERY
     *   @apiParam  {Integer} page 当前页码
     *   @apiParam  {String} email 邮箱
     *   @apiSuccessExample {json} Success-Response:
     *       HTTP/1.1 200 OK
     *       {
     *         "code": "1",
     *         "msg": "success"
     *         "object":[{
     *             "companyId": "信管工作室",
     *             "num": "001",
     *             "name": "大红",
     *             "phoneNumber": "21212222222",
     *             "email": "211@222.com",
     *             "grade": "2017级",
     *             "sex": "女",
     *             "profession": "信管",
     *             "department": "后台"
     *         },
     *         {
     *             "companyId": "信管工作室",
     *             "num": "002",
     *             "name": "大白",
     *             "phoneNumber": "21212333333",
     *             "email": "222@222.com",
     *             "grade": "2017级",
     *             "sex": "女",
     *             "profession": "信管",
     *             "department": "后台"
     *         }]
     *       }
     */
    public Map findByEmail(String email, Integer page, Pager<Member> pager){
        return ToMap.toMap(ConstantValue.SUCCESS_CODE,ConstantValue.SUCCESS,new ArrayList<>());
    }

    /**
     *   @api {GET} member/byName/{page} 根据姓名获取成员
     *   @apiDescription 根据姓名的模糊分页查询
     *   @apiGroup MEMBER-QUERY
     *   @apiParam  {Integer} page 当前页码
     *   @apiParam  {String} name 姓名
     *   @apiSuccessExample {json} Success-Response:
     *       HTTP/1.1 200 OK
     *       {
     *         "code": "1",
     *         "msg": "success"
     *         "object":[{
     *             "companyId": "信管工作室",
     *             "num": "001",
     *             "name": "大红",
     *             "phoneNumber": "21212222222",
     *             "email": "211@222.com",
     *             "grade": "2017级",
     *             "sex": "女",
     *             "profession": "信管",
     *             "department": "后台"
     *         },
     *         {
     *             "companyId": "信管工作室",
     *             "num": "002",
     *             "name": "大白",
     *             "phoneNumber": "21212333333",
     *             "email": "222@222.com",
     *             "grade": "2017级",
     *             "sex": "女",
     *             "profession": "信管",
     *             "department": "后台"
     *         }]
     *       }
     */
    public Map findByName(String name, Integer page, Pager<Member> pager){
        return ToMap.toMap(ConstantValue.SUCCESS_CODE,ConstantValue.SUCCESS,new ArrayList<>());
    }


}