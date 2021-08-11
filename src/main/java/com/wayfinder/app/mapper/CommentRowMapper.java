package com.wayfinder.app.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.wayfinder.app.entity.Comment;

public class CommentRowMapper implements RowMapper<Comment> {

	@Override
	public Comment mapRow(ResultSet rs, int arg1) throws SQLException {
		Comment comment = new Comment();
		comment.setCommentId(rs.getInt("commentId"));
		comment.setCommenterName(rs.getString("commenterName"));
		comment.setEventId(rs.getInt("eventId"));
		comment.setCommentUnixTime(rs.getLong("commentUnixTime"));
		comment.setCommentString(rs.getString("commentString"));
		
        return comment;
	}


}
