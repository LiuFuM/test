###项目说明

#### 项目使用Java 1.8, MyBatis+SpringBoot 1.5.19框架, 后台数据库为MySQL.


#### 表结构参考tables.sql文件, 具体的column名参考注释.


#### 开发用的数据库信息(地址, 用户名密码, 参考application-dev.properties文件配置.)


#### 咪咕有声推荐内容上传持久化的部分:

* 目前上传的目录已经做成配置项, 放在application-dev.properties配置文件中

* 推荐资源文件会定期由移动的负责人员上传, 只需要在前端页面点击按钮调用接口就能自动将全部旧的内容去除, 替换为新的推荐内容.

* 实际调用的接口为:

    GET /bgapi/featuredcontents/miguvoice/last 查询最新的推荐内容文件名
    PUT /featuredcontents/miguvoice/ 更新数据库

* 咪咕推荐的文本以下面的格式编码:
    分类ID##分类名称##内容ID##内容名##作者##主播##封面


#### 项目目录注释如下:

* config: 项目配置文件类
* controller: 接口控制器类
* entity: 数据表实体类
* mapper: 映射接口类
* page: 分页信息
* plugin: 插件
* service: 服务接口
* service\impl: 实现类
* utils: 工具类
* resources\mybatis\mapper: 映射文件
* resources\mybatis\mybatis-config.xml: mybatis配置
* resources\application-dev.properties: 数据库相关配置
* resources\application.yml: 项目配置
* BgApiApplication 启动main文件.
* API.md 接口说明
* README.md 更新说明
* PROJECT.md 项目说明

#### 关于认证与鉴权

这个后台接口会同时被用户端App(包括安卓/iOS), 设备端App(安卓), 以及一个前端页面访问, 有部分GET类的接口, 比如获取所有滚动条, 搜索所有技能等, 都可以无需鉴权, 直接访问.
而前端的运营平台则需要登陆之后才能访问.
权限细分到控制器的方法, 以方法名保存在permission表中.
permission, user, role的关系遵循惯例, 一个user只有一个role, 一个role包含多个permission.
例如用户marc, 只有一个角色(role), 比如admin, 这个角色可以访问addUser, removeSkills等等接口即权限.

原有的前端页面的菜单访问权限后面有个menu关键字, 以区别其他的接口权限.
  
值得再次说明的是, app跟设备端访问的接口, 基本上无需鉴权. 具体的function, 见visitor_permission表.

** 即, visitor_permission里面的function的方法, 是app跟设备app都直接能访问的, 无需token. **


#### 有关运营平台

具体功能如下:

* 推荐视频：主要用于在App/设备端上展示咪咕视频信息的相关内容。

* 推荐音乐：主要用于在App/设备端上展示咪咕音乐信息的相关内容。

* 推荐有声：主要用于在App/设备端上展示咪咕听书信息的相关内容。

* 推荐技能：主要用于在App/设备端上展示灵犀助手技能的相关内容。

以上推荐内容, 都在featured_content表中, 用type来区分

1: "视频"  2: "音乐" 3: "有声内容" 4: "技能"


* 滚动条banner：用于在App/设备端上向各省市移动公司推广时支持展示最新移动资费政策，点击后需要能够支持H5详细介绍页面。

* 咪咕有声资源部分, 是由中移动的运营人员定期将资源的纯文本文件, 通过ftp放置在服务器的指定目录, 然后通过运营页面读取最新的txt文件名, 然后将内容按规则插入到migu_voice表中.
这部分跟推荐有声资源是独立且分开的. 可以理解成这是推荐有声的一个细化.

* 语料管理, Skill_Examples表, 即每个技能有一个唤醒的方法, 这些提示称之为语料, 语料分为单轮跟多轮, 单论语料仅仅唤醒, 多轮语料有对答的过程

#### 有关文件上传

文件上传的目录在配置文件里面

image.folder=/usr/local/website/

用户通过前端运营页面上传过来的图片, 将保存在这个设定的目录中.

同时这个目录是前端的项目部署的根目录, 这样, 在前端的页面中, 以及设备端/App获取滚动条的图片, 技能的图标时, 首先拿到接口里面的图片url地址, 然后获取对应的图片资源.

例如, App/设备端, 通过

/bgapi/banners接口, 拿到所有的滚动条数据, 如下所示:

`
...
        {
            "id": "49cdda0b-4c76-11e9-9fad-525400820e38",
            "name": "banner2",
            "description": "undefined",
            "url": "www.youku.com",
            "type": 1,
            "status": 1,
            "createTime": 1553240653000,
            "resourceAddressList": [
                {
                    "id": "4d7584e9-4c76-11e9-9fad-525400820e38",
                    "address": "20190322/074420/banner1@2x.png",
                    "targetId": "49cdda0b-4c76-11e9-9fad-525400820e38",
                    "description": "APP_BANNER",
                    "targetName": null
                }
            ]
        },
...        
`

里面的resourceAddressList就是图片资源的信息.

address键值就是图片的地址, 只需要将这个地址与部署服务器的ip拼接起来, 就是资源图片的访问下载地址.

其他包含图片资源地址的数据, 基本都是这个原理.

