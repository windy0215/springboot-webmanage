package com.itwindy.mapper;

import com.itwindy.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author windy
 * @create 2023-07-08 13:08
 */
@Mapper
public interface DeptMapper {
    /**
     * 查询全部部门
     * @return
     */
    @Select("select * from dept")
    List<Dept> listt();

    /**
     * 删除部门
     * @param id
     */
    @Delete("delete from dept where id=#{id}")
    void delete(Integer id);

    /**
     * 添加新部门
     * @param dept
     */
    @Insert("insert into dept(name, create_time, update_time) values (#{name},#{createTime},#{updateTime})")
    void add(Dept dept);





    /**
     * 根据id返回部门的名字
     */
    @Select("select * from dept where id=#{id}")
    Dept getbyid(Integer id);




    /**
     * 修改部门信息
     * @param dept
     */
    @Update("update dept set name=#{name},update_time=#{updateTime} where id=#{id}")
    void update(Dept dept);

}
