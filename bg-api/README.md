20190715 更新
1. 加入了鉴权与校验密码的部分, 大部分接口都需要使用token校验身份后访问, 具体方法见api文档
2. 增加拦截器统一拦截用户请求, 获取headers里面的token字段, 用于鉴权
3. 增加了visitor_permission表, 作为鉴权的白名单, 不需要token就可以访问.
4. 鉴权的方法基于controller里面的方法, user跟role是一对一关系, role包含很多permission, 一个permission对应一个controller里面的方法. 


20190601 更新
1. 增加了tables.sql表结构文件
2. 增加了PROJECT.md 项目说明文档文件.


20190528 更新
1. 注释掉测试部分代码
2. 删除docker配置

20190525 更新
将API文档独立到API.md里面

20190523更新
1. 添加注释
2. 删除部分无用代码
3. 删除eureka client
4. 使用dev配置文件

20190502
1. miguvoice的列表接口增加了pageinfo, get的时候要传递两个值, 一个是页数pageno,一个是每页数据数量pagesize
下面是url的范例:


118.89.61.144:8903/bgapi/featuredcontents/miguvoice/pageno=1&pagesize=10


20190427 
1. 增加接口查询最新的咪咕推荐资源
2. 增加将咪咕资源文件持久化接口
3. 增加list咪咕资源的接口.

20190323 1. 增加搜索热词的接口 , 接口地址在下面有说明, 另外, 当搜索的技能并不在数据库中时, 是不会记录这次搜索的, 也就是说, 热词只是针对已有的技能, 而不会对不存在的技能搜索进行记录.
         2. 检查推送sync消息是否存在问题(检查过, 没有问题); 
         3. 通过名称搜索技能时, 加上图片地址
         

20190228 增加滚动条banner功能, 增加根据技能名称搜索功能



Postman的连接:
[https://www.getpostman.com/collections/5e2e58122c3c228c2b97]


> 目前暂未加入token验证部分
> bug反馈: 罗勇