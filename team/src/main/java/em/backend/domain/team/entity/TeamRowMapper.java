package em.backend.domain.team.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TeamRowMapper implements RowMapper<TeamEntity> {

	@Override
	public TeamEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		TeamEntity team = new TeamEntity();
		team.setId( rs.getString("id") );
		team.setName( rs.getString("team") );
		team.setMemberNumber( rs.getInt("member_number") );
		return team;
	}

}
