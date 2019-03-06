package em.backend.application.team.command;

import java.util.UUID;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import em.backend.application.CommandHandler;
import em.backend.domain.team.entity.TeamEntity;
import em.backend.domain.team.listener.MemberEvent;
import em.backend.domain.team.service.TeamService;

@Component
public class MemberQueueListener implements CommandHandler<MemberEvent> {

	@Autowired
	private TeamService teamService;

	@RabbitListener(queues = "Members", containerFactory = "jsaFactory")
	public void recievedMessage(MemberEvent even) {
		System.out.println("Recieved Message: " + even.getId());
		handle(even);
	}

	@Override
	public void handle(MemberEvent command) {
		TeamEntity team = null;

		if (!teamService.existsByTeam(command)) {
			team = new TeamEntity();
			team.setId(UUID.randomUUID().toString());
			team.setName(command.getIdTeam());
			team.setMemberNumber(1);
			teamService.save(team);
		} else {
			team = teamService.getOneByTeam(command);
			team.setMemberNumber( team.getMemberNumber() + 1);	
		    teamService.updateMemberNumber(team);
		}

	}

	@Override
	public void commandHandler(MemberEvent command) {
		System.out.println("save event");
	}

}
