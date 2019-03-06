package em.backend.application.team.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import em.backend.application.QueryHandler;
import em.backend.application.team.query.model.TeamQuery;
import em.backend.domain.team.service.TeamService;

@Component
public class TeamQueryHandler implements QueryHandler<TeamQuery> {

	@Autowired
	private TeamService teamService;
	
	@Override
	public List<TeamQuery> handle() {
		return teamService.getAllTeamQuery();
	}

}
