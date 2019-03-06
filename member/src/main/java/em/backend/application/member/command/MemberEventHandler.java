package em.backend.application.member.command;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import em.backend.application.member.CommandHandler;
import em.backend.application.member.command.model.MemberCommand;
import em.backend.domain.member.entity.MemberEntity;
import em.backend.domain.member.event.MemberEvent;
import em.backend.domain.member.service.MemberService;

@Component
public class MemberEventHandler implements CommandHandler<MemberCommand> {

	@Autowired
	private MemberService memberService;

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Override
	public void handle(MemberCommand command) {
		MemberEntity member = new MemberEntity();
		member.setName(command.getName());
		member.setIdTeam(command.getIdTeam());
		member.setId(command.getId());
		memberService.save(member);

		commandHandler(command);
	}

	@Override
	public void commandHandler(MemberCommand command) {

		MemberEvent event = new MemberEvent();
		event.setId(command.getId());
		event.setName(command.getName());
		event.setIdTeam(command.getIdTeam());

		amqpTemplate.convertAndSend("Members", event);
		System.out.println("Send msg = " + event);
	}

}
