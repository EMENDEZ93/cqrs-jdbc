package em.backend.domain.member.repository;

import em.backend.domain.member.entity.MemberEntity;

public interface IMemberEntityRepository {

	public void save();
	
	public void save(MemberEntity member);
	
}
