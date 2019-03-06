package em.backend.domain.team.listener;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = MemberEvent.class)
public class MemberEvent {

	private String id;
	private String name;
	private String idTeam;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getIdTeam() {
		return idTeam;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIdTeam(String idTeam) {
		this.idTeam = idTeam;
	}

}
