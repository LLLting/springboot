package com.how2java.springboot.mapper;

import com.how2java.springboot.pojo.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: liu.ting
 * 2019/7/8 17:02
 */
@Mapper
@Component
public interface CategoryMapper {

    @Select("select * from category_ ")
    List<Category> findAll();

    @Insert(" insert into category_ (name) values (#{name})")
    public int save(Category category);

    @Delete("delete from category_ where id = #{id}")
    public void delete(int id);

    @Select("select * from category_ where id = #{id}")
    public Category get (int id);

    @Update("update category_ set naem =#{name} where id = #{id}")
    public int update(Category category);
}
