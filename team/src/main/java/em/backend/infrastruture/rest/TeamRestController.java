package em.backend.infrastruture.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import em.backend.application.team.query.TeamQueryHandler;
import em.backend.application.team.query.model.TeamQuery;

@RestController
public class TeamRestController {

	@Autowired
	private TeamQueryHandler teamQueryHandler;
	
	@GetMapping
	public List<TeamQuery> getAllTeamQuery() {
		return teamQueryHandler.handle();
	}
	
}
