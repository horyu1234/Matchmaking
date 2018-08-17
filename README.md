#Matchmaking

<h6>A simple Matchmaking API for minecraft/jvm-environment programs</h6>

###Requires
- Redis (latest)
<br/>
<br/>

###Compile
This API uses Maven as a build management tool.
To compile the sources, use following command:
```
mvn clean install
```
<br/>

###How to use
To create your new matchmaking structure, write following code:
```
MatchmakingManager matchmaking = Matchmaking.getInstance().getManager("matchmaking-01");
```
You can get list of allocated matchmaking managers by:
```
Collection<MatchmakingManager> managers = Matchmaking.getInstance().getManagers();
```
To connect your own redis server, write following code:
```
matchmaking.registerConnection(new SimpleRedisConnection(RedisType.MASTER, "new-name", "127.0.0.1", 6379));
```
Basically, The API supports default connections to use Redis without registration.
```
MatchmakingManager.DEFAULT_WRITE_CONNECTION
MatchmakingManager.DEFAULT_READ_CONNECTION
```

**Creating a new Redis handler**
```
public class NewHandler extends Command implements CommandResponse {
    
    private final String myHandlerName;
    private final String myMessage;
    
    public NewHandler(String myHandlerName, String myMessage) {
        this.myHandlerName = myHandlerName;
        this.myMessage = myMessage;
    }
    
    public String getMyHandlerName() {
        return myHandlerName;
    }
    
    public String getMyMessage() {
        return myMessage;
    }
    
    @Override
    public void respond(Command command) {
        if(command instanceof NewHandler) {
            NewHandler newHandler = (NewHandler) command;
            System.out.println(newHandler.getMyHandlerName());
            System.out.println(newHandler.getMyMessage());
        }
    }
}
```
**Registering your new Redis handler**
```
matchmaking.registerRedis("myHandlerKey", NewHandler.class);
```

You can get additional examples at [here.](https://github.com/OrigamiDream/Matchmaking/tree/master/example/src/main/java/av/is/matchmaking/example)