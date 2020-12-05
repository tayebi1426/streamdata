package ir.streamdata.service.impl;

import ir.streamdata.model.dto.CustomUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class JdbcUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(JdbcUserDetailsService.class);

    private static final Set<GrantedAuthority> TEMP_USER_AUTHORITIES = new HashSet<>(Arrays.asList(new SimpleGrantedAuthority("USER"), new SimpleGrantedAuthority("ADMIN_USER")));

    private static final String FETCH_USER_QUERY =
            "select u.id,username,u.password,u.locked,u.expired from USER u where u.username=:username";

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<CustomUserDetails> userRowMapper = (rs, i) ->
            new CustomUserDetails(rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    !rs.getBoolean("locked"),
                    !rs.getBoolean("expired"),
                    !rs.getBoolean("expired"),
                    TEMP_USER_AUTHORITIES);

    public JdbcUserDetailsService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            return jdbcTemplate.queryForObject(FETCH_USER_QUERY, new String[]{username}, userRowMapper);
        } catch (EmptyResultDataAccessException e) {
            logger.debug(e.getLocalizedMessage(), e);
            throw new UsernameNotFoundException("user not found!");
        }
    }
}

