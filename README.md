<<<<<<< HEAD
# Ada Support Backend Challenge - Mikhail Gindin

## How to start the app
```console
mvn clean install
java -jar target/adaChat-1.0-SNAPSHOT.jar
```

#The Work Flow

## Create some users
### `/users` POST
```javascript
{
    "userName": "Tom"
}
```
### `/users` POST
```javascript
{
    "userName": "Bob"
}
```


## Create a conversation
### `/conversations` POST
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
### `/messages` POST
```javascript
{
	"sender": "Tom",
	"conversationId": "<paste the conversation ID here>",
	"message": "Hello Bob!"
}
```

## See all the messages in the conversation
### `/conversations/<paste the conversation ID here>` GET

<br />

That's it! Thanks for the challenge, it was a lot of fun :smiley:
