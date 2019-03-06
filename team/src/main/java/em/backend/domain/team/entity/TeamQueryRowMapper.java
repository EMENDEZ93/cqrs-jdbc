package em.backend.domain.team.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import em.backend.application.team.query.model.TeamQuery;

public class TeamQueryRowMapper implements RowMapper<TeamQuery> {

	@Override
	public TeamQuery mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		TeamQuery team = new TeamQuery();
		team.setTeam(rs.getString("team"));
		team.setMembers(rs.getInt("member_number"));
		return team;
	}

}
