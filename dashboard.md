# Dashboard

Dashboard是一个通过WebSocket进行数据传输，highcharts进行图表展示的实时数据与数据展示模块功能。
下面简单罗列一些开发的时候的技术和设计细节。

###一、Java版本和架构依赖
* 项目使用Tomcat作为Servlet容器，Tomcat在7.0.27添加了对WebSocket的支持，7.0.47之后修改了WebSocket的实现，建议使用该版本及以后的版本；
* Tomcat 7.0.x理论上是支持Java 6及以上版本，但是如果需要WebSocket支持，需要使用Java 7及以上版本；
* 由于现在各家WebSocket Server的API版本不一，在此使用Tomcat的WebSocket API及相关依赖。但是，在实际的使用中，由于项目是放到Tomcat容器中启动的，Tomcat的相关依赖在已经在Tomcat容器中了，所以，只需要增加一个"tomcat-coyote"依赖即可。其他相关依赖需要注明"<scope>provided</scope>"，以防冲突；
* PS：项目中使用的provided依赖：tomcat-catalina，tomcat-websocket-api，tomcat-jasper；
* 其他的，诸如Spring、数据库驱动、swallow、avatar、pigeon、cat、lion、以及logger、Test等，还有maven-war-plugin和maven-compiler-plugin等build plugins，不一而足。

###二、WebSocket Server端
因为是Tomcat 7.0.x，也就顺便使用annotation的方式进行配置Servlet了，不需要对web.xml进行额外配置。
* Servlet继承HttpServlet，并且标注WebServlet注解，urlPatterns参数为访问的路径，重写service方法，即可处理普通的HTTP请求。（包名：tomcat-servlet-api）
* Servlet标注ServerEndpoint注解，参数为访问路径，不需要继承类，方法上面注明，操作，比如：
```Java
@OnOpen
public void onOpen(Session session) {
}
@OnClose
public void onClose(Session session) {
}
@OnMessage
public void onMessage(Session session, String message) {
}
```
（包名：tomcat-websocket-api）

###三、WebSocket Client端
``` JavaScript
var socket = new WebSocket("ws://" + location.hostname + ":8080/events/socket");
```
``` JavaScript
socket.onopen = function () {
    console.log(socket.url);
};
socket.onmessage = function (event) {
    console.log(event);
};
socket.onclose = function (event) {
    console.log(event);
    //location.reload();
};
socket.onerror = function (event) {
    console.log(event);
};
```
```通过Event Handler进行事件处理。```

其他跟普通的Java Web项目构成相似。

###四、Nginx
由于公司tomcat搭建在8080端口，nginx搭建在80端口，所以，如果通过nginx通道链接WebSocket，需要添加反向代理的配置。
在服务器的/usr/local/nginx/conf/nginx.conf文件中，查找到/usr/local/nginx/conf/nginx_app.conf文件的配置，在config_location中加入：
```
proxy_http_version 1.1;
proxy_set_header Upgrade $http_upgrade;
proxy_set_header Connection "Upgrade";
```

> ***nginx不支持长链接，所以WebSocket链接会经常断掉，Dashboard中加入了ReconnectingWebSocket组件保证断掉之后重新连接WebSocket，实际操作中，建议直接链接8080，Tomcat服务器开放的端口。***

###五、Highcharts
Highcharts是一个图表绘制的前端框架，很强大，具体参照API即可，附一个我在用的API查询网站：
[Highcharts中文网](http://www.hcharts.cn/) && [中文 API](http://www.hcharts.cn/api/)(可能会有翻译不完全的）
