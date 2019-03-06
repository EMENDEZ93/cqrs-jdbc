package em.backend.domain.team.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import em.backend.application.team.query.model.TeamQuery;
import em.backend.domain.team.entity.TeamEntity;
import em.backend.domain.team.entity.TeamQueryRowMapper;
import em.backend.domain.team.entity.TeamRowMapper;
import em.backend.domain.team.listener.MemberEvent;

@Transactional
@Repository
public class MemberEntityRepository implements ITeamEntityRepository {

	@Autowired
	@Qualifier("mysqlJdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public void save(TeamEntity team) {
		String sql = "INSERT INTO team (id, team, member_number) values (?, ?, ?)";
		jdbcTemplate.update(sql, team.getId(), team.getName(), team.getMemberNumber());
	}

	@Override
	public boolean existsByTeam(MemberEvent team) {
		String sql = "SELECT EXISTS(SELECT team FROM team WHERE team=? )";
		return jdbcTemplate.queryForObject(sql, Boolean.class, team.getIdTeam());
	}

	@Override
	public TeamEntity getOneByTeam(MemberEvent team) {
		String sql = "SELECT * FROM team WHERE team=:team";
		return namedParameterJdbcTemplate.queryForObject(sql, new MapSqlParameterSource("team", team.getIdTeam()), new TeamRowMapper());
	}

	@Override
	public void updateMemberNumber(TeamEntity team) {
		String sql = "UPDATE team SET member_number=? WHERE team=?";
		jdbcTemplate.update(sql, team.getMemberNumber(), team.getName());		
	}

	@Override
	public List<TeamQuery> getAllTeamQuery() {
		String sql = "SELECT * FROM team";
		return jdbcTemplate.query(sql,new TeamQueryRowMapper());		
	}

}
