# Ada Support Backend Challenge - Mikhail Gindin

## How to start the app
```console
mvn clean install
java -jar target/adaChat-1.0-SNAPSHOT.jar
```

## Create some users
### `localhost:8080/users` POST
```javascript
{
    "userName": "Tom"
}
```
### `localhost:8080/users` POST
```javascript
{
    "userName": "Bob"
}
```


## Create a conversation
### `localhost:8080/conversations` POST
```javascript
{
	"users": [
			{
				"userName": "Tom"
			},
			{
				"userName": "Bob"
			}
	]
}
```
Copy the returned conversation ID to your clipboard.

<br />

## Send a message
### `localhost:8080/messages` POST
```javascript
{
	"sender": "Tom",
	"conversationId": "<paste the conversation ID here>",
	"message": "Hello Bob!"
}
```

## See all the messages in the conversation
### `localhost:8080/conversations/<paste the conversation ID here>` GET

<br />

That's it! Thanks for the challenge, it was a lot of fun :smiley:
