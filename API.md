#接口定义文档#
	服务器地址：http://42.96.205.36：8080
	数据传送：
		1. 所有数据都以json格式传送
		2. 所有图片都为jpg格式
		3. 所有后台的响应数据可以在datamodel中找到对应的类
	
##1. 登录(post)
	URL地址：/user/login
	参数：username(string), password(string)
	参数示例：{"username":"tiankk", "password":"tiankk"}
	返回数据：包括status(boolean), message(string)
##2. 注册(post)
	URL地址：/user/register
	参数示例：{"username":"tiankk", "password":"tiankk", "gender":1, "phone":"18819473274", "tags":"action"}
	返回数据：status(boolean), message(string)
	备注：传递参数时，username和password是必须的，其他可以没有
##3. 电影-正在热映-电影列表(get)
	URL地址：/movie/onView
	参数示例：无参数
	返回数据示例：
		[{"name":"疯狂动物城", "intro":"简介", "avatar":"缩略图"},
		{"name":"愤怒的小鸟", "intro":"...", "avatar", "缩略图"}]
	备注：
		1. 返回的数据是个ArrayList<Movie>，对应的类为datamodel中的MovieList;
		2. avatar为图片经过base64编码后所得的图片 
##4. 电影-正在热映-电影海报(get)
	URL地址：/movie/onViewPosters
	参数示例：无参数
	返回数据：[{"movieName":"疯狂动物城", "movieImage":"..."}，
			{"movieName":"愤怒的小鸟", "movieImage":"..."}]
	备注：
		1. 返回数据是ArrayList<Poster>, 对应的类为datamodel中的PosterList;
		2. movieImage为图片经过base64编码后所得的图片
