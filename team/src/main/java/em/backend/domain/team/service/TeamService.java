package em.backend.domain.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import em.backend.application.team.query.model.TeamQuery;
import em.backend.domain.team.entity.TeamEntity;
import em.backend.domain.team.listener.MemberEvent;
import em.backend.domain.team.repository.ITeamEntityRepository;

@Service
public class TeamService {

	@Autowired
	private ITeamEntityRepository teamEntityRepository;
	
	public void save(TeamEntity team) {
		teamEntityRepository.save(team);
	}

	public boolean existsByTeam(MemberEvent team) {
		return teamEntityRepository.existsByTeam(team);
	}

	public TeamEntity getOneByTeam(MemberEvent team) {
		return teamEntityRepository.getOneByTeam(team);
	}

	public void updateMemberNumber(TeamEntity team) {
		teamEntityRepository.updateMemberNumber(team);
	}

	public List<TeamQuery> getAllTeamQuery() {
		return teamEntityRepository.getAllTeamQuery();
	}

}
