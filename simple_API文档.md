
#rules:
    URL: http://42.96.205.36:8080
    all string --- utf-8 format
    all data --- json format
    
1. register(post)
    address:
        "/user/register"
    post(in json format): 
        String username(length < 20),
        String password(length < 16),
        int gender(-1-unkown, 0-male, 1-female),
        String phone(length < 12),
        String tags(length < 50);
    hint:
        only "username" and "password" are necessary in post body,
        others are optional,
    response:
        bool status,
        String message;

2. login(post)
    address:
        "/user/login"
    post:
        String username(length < 20),
        String password(length < 16);
    response:
        bool status,
        String message;

3. 正在
