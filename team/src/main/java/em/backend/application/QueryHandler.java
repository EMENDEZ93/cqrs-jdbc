package em.backend.application;

import java.util.List;

public interface QueryHandler<O> {

	public List<O> handle();
	
}
