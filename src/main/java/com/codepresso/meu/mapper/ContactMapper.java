package com.codepresso.meu.mapper;

import com.codepresso.meu.vo.Contact;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ContactMapper {

    Integer saveContact(@Param("contact") Contact contact);
}
