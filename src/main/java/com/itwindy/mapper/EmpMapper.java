package com.itwindy.mapper;

import com.itwindy.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author windy
 * @create 2023-07-08 13:08
 */
@Mapper
public interface EmpMapper {
    /**
     * 查询总记录数
     */
//    @Select("select count(*) from emp")
//    Long count();
//
//    @Select("select * from emp limit #{start},#{pageSize}")
//    List<Emp> page(Integer start,Integer pageSize);
    /**
     * 员工信息的查询
     */
//    @Select("select * from emp")
    public List<Emp> list(@Param("name") String name,@Param("gender") Short gender, @Param("begin") LocalDate begin,@Param("end") LocalDate end);


    void delete(@Param("ids") List<Integer> ids);

    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);



    @Select("select * from emp where id=#{id}")
    Emp getByid(Integer id);


    void update(Emp emp);


    /**
     * 根据用户名和密码查询
     * @param emp
     * @return
     */
    @Select("select * from emp where username=#{username} and password=#{password}")
    Emp getByUsernameAndPassword(Emp emp);


    /**
     * 根据部门id删除员工信息
     */
    @Delete("delete from emp where dept_id = #{deptId}")
    void deleteByDeptId(Integer deptId);
}
