package av.is.matchmaking.api;

/**
 * Created by OrigamiDream on 2018-08-16.
 */
public interface DefaultCommandResponse extends CommandResponse {
    
    @Override
    default void respond(Command command) {
    }
}
