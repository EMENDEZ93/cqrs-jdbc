package em.backend.domain.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import em.backend.domain.member.entity.MemberEntity;
import em.backend.domain.member.repository.IMemberEntityRepository;

@Service
public class MemberService  {

	@Autowired
	private IMemberEntityRepository memberEntityRepository;

	public void save(MemberEntity memberEntity) {
		memberEntityRepository.save(memberEntity);
	}

}
