### Users service 
+ Obtain access token 
    + POST `http://localhost:8080/oauth/token`
        + Type: Basic Auth / form-data 
        + Username: clientId 
        + Password
        + grant_type: password 
    + Response:
        
     {
          "access_token": "a633dd55-102f-4f53-bcbd-a857df54b821",
          "token_type": "bearer",
          "refresh_token": "d68d89ec-0a13-4224-a29b-e9056768c7f0",
          "expires_in": 43199,
          "scope": "openid"
        }

+ Execute request using access token 
    + Using access token : provide access token in the req header : Authorization with format "Bearer {access_token}" when sending req
    
    
    
+ Sending request with i18n 
    + GET `http://localhost:8080/welcome-internationalized` 
        + Headers : Accept-Language: fi  