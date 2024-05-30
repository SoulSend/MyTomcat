# MyTomcat
Homemade simple tomcat

#### 由于底层的http请求和响应很繁琐，所以直接使用java官方提供的API来封装这个操作
先写一个前置的小项目 MyHttpServer来熟悉一下，后面会使用适配器模式来转换这里面的HttpExchange接口到HttpServletRequest。
