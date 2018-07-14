package com.joker.repository;

import com.joker.domain.User;
import com.joker.mapper.UserMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(UserMapper.class)
public interface UserRepository {
    @SqlUpdate("insert into user(id, name) values(:id,:name)")
    public void save(@Bind("id") Long id, @Bind("name") String name);

    @SqlQuery("Select * from user where id=:id")
    public User get(@Bind("id") Long id);

    @SqlUpdate("create table user (id int primary key, name varchar(100))")
    void createUserTable();
}
