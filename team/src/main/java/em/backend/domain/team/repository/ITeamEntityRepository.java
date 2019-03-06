package em.backend.domain.team.repository;

import java.util.List;

import em.backend.application.team.query.model.TeamQuery;
import em.backend.domain.team.entity.TeamEntity;
import em.backend.domain.team.listener.MemberEvent;

public interface ITeamEntityRepository {

	public void save(TeamEntity team);

	public boolean existsByTeam(MemberEvent team);

	public TeamEntity getOneByTeam(MemberEvent team);
	
	public void updateMemberNumber(TeamEntity team);
	
	public List<TeamQuery> getAllTeamQuery();

	
}
