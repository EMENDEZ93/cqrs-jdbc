package em.backend.infrastructure.rest.member;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import em.backend.application.member.command.MemberEventHandler;
import em.backend.application.member.command.model.MemberCommand;

@RequestMapping("event")
@RestController
public class MemberRestController {

	@Autowired
	private MemberEventHandler memberEventHandler;
	
	@PostMapping()
	public void saveMember(@Valid @RequestBody MemberCommand member) {
        member.setId(UUID.randomUUID().toString());
        memberEventHandler.handle(member);
	}
	
}
