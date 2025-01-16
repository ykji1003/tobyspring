package tobyspring.helloboot;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HelloRepositoryJdbc implements HelloRepository {

    private JdbcTemplate jdbcTemplate;

    public HelloRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override // queryForObject 1개의 row를 리턴한다. 결과가 없으면 어떻게될까???
    public Hello findHello(String name) {
        try {
            return jdbcTemplate.queryForObject("select * from member where name = '" + name + "'",
                    (rs, rowNum) -> new Hello(
                            rs.getString("name"), rs.getInt("count")
                    ));
        } catch(EmptyResultDataAccessException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void increaseCount(String name) {
        Hello hello = findHello(name);
        if(hello == null) {
            jdbcTemplate.update("insert into member values(?,?)", name, 1);
        } else {
            jdbcTemplate.update("update member set count = ? where name = ?", hello.getCount() + 1, name);
        }
    }

}
