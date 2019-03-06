package em.backend.infrastructure.repository.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import em.backend.domain.member.entity.Article;
import em.backend.domain.member.entity.MemberEntity;
import em.backend.domain.member.repository.IMemberEntityRepository;

@Transactional
@Repository
public class MemberEntityRepository implements IMemberEntityRepository {

	@Autowired
	@Qualifier("mysqlJdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Override
	public void save() {
		Article ar = new Article();
		ar.setArticleId(1);
		ar.setCategory("ca");
		ar.setTitle("titl");

		String sql = "INSERT INTO articles (articleId, title, category) values (?, ?, ?)";
		jdbcTemplate.update(sql, ar.getArticleId(), ar.getTitle(), ar.getCategory());

	}

	@Override
	public void save(MemberEntity member) {
		String sql = "INSERT INTO member (id, first_name, id_team) values (?, ?, ?)";
		jdbcTemplate.update(sql, member.getId(), member.getName(), member.getIdTeam());

	}

}
