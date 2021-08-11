package com.wayfinder.app.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.wayfinder.app.entity.Comment;
import com.wayfinder.app.mapper.CommentRowMapper;
@Repository
public class CommentDaoImpl implements CommentDao{
	
	public CommentDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
	}  
	NamedParameterJdbcTemplate template;  

	@Override
	public List<Comment> findByEventId(int eventId) {
		final String sql = "select * from comments where eventId=:eventId";
		
		SqlParameterSource param = new MapSqlParameterSource()
        		.addValue("eventId", eventId);

		return template.query(sql, param, new CommentRowMapper());
	}
	@Override
	public void insertComment(Comment comment) {
		final String sql = "insert into comments(commenterName, eventId, commentUnixTime, commentString) "
				+ "values(:commenterName, :eventId, :commentUnixTime, :commentString)";
		 
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
        		.addValue("commenterName", comment.getCommenterName()) // CommenterName only during creation
        		.addValue("commentUnixTime", comment.getCommentUnixTime()) // commentUnixTime only during creation
				.addValue("eventId", comment.getEventId())
				.addValue("commentString", comment.getCommentString());
        template.update(sql,param,holder);
	 
	}
	
	@Override
	public void deleteComment(int commentId) {
		 final String sql = "delete from comments where commentId=:commentId";

		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("commentId", commentId);
	
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  

	 
	}
	
}
