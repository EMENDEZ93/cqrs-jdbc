package em.backend.application.member;

public interface CommandHandler<T> {

	public void handle(T command);
	
	public void commandHandler(T command);
	
}
