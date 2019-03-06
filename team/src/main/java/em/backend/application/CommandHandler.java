package em.backend.application;

public interface CommandHandler<T> {

	public void handle(T command);

	public void commandHandler(T command);

}
