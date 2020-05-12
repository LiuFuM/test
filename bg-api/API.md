### 晓言后台接口说明
测试阶段的主机:端口为
http://118.89.61.144:8903
接口采用RESTful风格, 支持GET,POST,PUT,DELETE调用方法.


#### 滚动条

滚动条实体类Banner包含:
id: id;
name 名称; 
description: 描述;
url: 链接地址;
type 类型; 
status 状态, 1: 启用, 0: 禁用;
createTime 创建时间;

**GET /bgapi/banners/** : 搜索全部滚动条

这个接口不需要鉴权, 可以直接访问. visitor_permission的function为getAllBanners

返回示例:
`
[
    {
        "id": "82c33c9e-3b19-11e9-9fad-525400820e38",
        "name": "xxxx",
        "description": "fdsafdsa",
        "url": "afsdasfdsa",
        "type": 2,
        "status": 1,
        "createTime": 1551333172000,
        "resourceAddressList": [
            {
                "id": "68c3bbb4-3445-11e9-9fad-525400820e38",
                "address": "fdsafadsfasd17",
                "targetId": "82c33c9e-3b19-11e9-9fad-525400820e38",
                "description": "APP_BANNER",
                "targetName": null
            }
        ]
    },
`


**PUT /bgapi/banners/{id}/status/0** : 根据id, 禁用滚动条

这个接口的权限名称为: disableBanner


**POST /bgapi/banners/** : 增加滚动条

这个接口的权限名称为: addBanner


#### 开发者

开发者实体类Developer包含:

id: id;
name: 名称;
type: 类型(预留);
createTime: 创建时间;

接口:

**GET /bgapi/developers/** : 获取全部开发者

这个接口不需要权限, visitor_permission的function为: getAllDevelopers

**POST /bgapi/developers/** : 新增开发者

接口权限名为: addDeveloper

**DELETE /bgapi/developers/{id}** : 根据id删除开发者

接口权限名为: deleteDeveloper

**PUT /bgapi/developers/{id}** : 更新开发者

接口权限名为: updateDeveloper


#### 语料

语料实体类SkillExample包括:
id: id; 
skillId: 技能id; 
example: 语料内容;
createTime: 创建时间;
updateTime: 更新时间;
ifMulti: 是否多轮语料;

接口:

**GET /bgapi/skills/{id}/skillexamples/** : 根据技能id搜索该技能语料

这个接口无需访问权限, 方法名为: getSkillExampleBySkillId

返回值示例:

`
[
    {
        "id": "4038e4d7-31e8-11e9-9fad-525400820e38",
        "skillId": "47ebace0-31e6-11e9-9fad-525400820e38",
        "example": "我要学英语",
        "createTime": 1550320919000,
        "updateTime": 1550320919000,
        "ifMulti": 0
    },
    {
        "id": "497fad95-31e8-11e9-9fad-525400820e38",
        "skillId": "47ebace0-31e6-11e9-9fad-525400820e38",
        "example": "来个英语句子",
        "createTime": 1550320934000,
        "updateTime": 1550320934000,
        "ifMulti": 0
    },
`

**POST /bgapi/skillexamples/** : 新增语料

权限名称为: addSkillExample

**PUT /bgapi/skillexamples/{id}** : 更新语料

权限名称为: updateSkillExample


**DELETE /bgapi/skillexamples/{id}** : 删除语料

权限名称为: removeSkillExample


#### 推荐内容

推荐内容FeaturedContent实体类包括:

id: id; 
name: 名称; 
description: 描述;
type: 类型:1, 推荐视频, 2, 推荐音乐, 3 推荐有声内容, 4, 推荐技能 ;
createTime: 创建时间;
updateTime: 更新时间;
resourceAddressList: 资源(图片)地址表;

接口:

**GET /bgapi/featuredcontents/** : 获取所有推荐内容

这个接口不用鉴权, function为: getAllFC


**GET /bgapi/featuredcontents/miguvoice/last** : 获取咪咕有声最新的资源文件名

权限名称: getLastUpdateMiguResourceFileName

返回示例:
`{
    "success": true,
    "msg": "",
    "obj": "20190427.txt"
}
`

**GET /bgapi/featuredcontents/miguvoice/pageno={pageno}&pagesize={pagesize}** : 分页获取所有咪咕有声资源

权限名称: listAllMiguVoice

返回示例:

`{
     "success": true,
     "msg": "",
     "obj": {
         "pageNum": 1,
         "pageSize": 10,
         "total": 684,
         "pages": 69,
         "list": [
             {
                 "id": "800526317",
                 "name": "百家讲坛：诗歌爱情",
                 "categoryId": "100000065",
                 "categoryName": "百家讲坛",
                 "textAuthor": "中央电视台科教频道",
                 "voiceAuthor": "杨雨",
                 "coverImageUrl": "http://cdn.cmread.com/coverFile/800526317/5527c1c8aa93c38405538b4cb914d00572fe3e25a57a/cover600800.jpg",
                 "createTime": "2019-04-27 22:59:46.0"
             },
             ...`

 


**PUT /bgapi/bgapi/featuredcontents/miguvoice/** : 更新咪咕有声推荐资源内容(整个表更新)

权限名称: updateMiguVoiceFileToDB

**GET /bgapi/featuredcontents/types/{type}** : 根据类型获取推荐内容

接口不需要鉴权, function为getAllFCByType


返回值类似:

`
  {
        "id": "f22abdb6-350e-11e9-9fad-525400820e38",
        "name": "新喜剧之王",
        "description": "新喜剧之王电影推荐",
        "type": 1,
        "createTime": 1550696192000,
        "updateTime": 1550696192000,
        "resourceAddressList": [
            {
                "id": "d9bc3cfe-367e-11e9-9fad-525400820e38",
                "address": "20190222//085005//a.jpg",
                "targetId": "f22abdb6-350e-11e9-9fad-525400820e38",
                "description": "APP_ICON",
                "targetName": null
            }
        ]
    },
`


**DELETE /bgapi/featuredcontents/{id}"** : 删除推荐内容

权限名称为removeFeaturedContent

**POST /bgapi/featuredcontents/** : 增加推荐内容

权限名称为addFeaturedContent

返回示例:
`{
    "success": true,
    "msg": "",
    "obj": null
}`

#### 文件上传

接口:

**POST /file/upload** :

权限名称为: fileUpload

#### 资源地址

资源地址ResourceAddress实体类包括:
id: id;
address: 地址;
targetId: 引用资源对象id; 
description: 描述 APP_ICON: App端图标  DEV_ICON: 设备端图标  APP_BG: App端背景图  DEV_BG: 设备端背景图
targetName: 引用资源对象名称;

**GET /bgapi/resourceaddresses/** : 获取所有资源地址

接口无需鉴权, function为getAllResourceAddress

**POST /bgapi/resourceaddresses/** : 新增资源地址

权限地址为: addResourceAddresse

**DELETE /resourceaddresses/{id}** : 删除资源地址

权限地址为: removeResourceAddress


#### 技能

技能Skill实体类包括:
id: id;
description: 描述;
name: 名称;
rate: 评分; 
type: 类型: 1. 影音阅读  2. 生活服务  3. 效率工具 4. 教育百科  5. 商业金融  6. 游戏娱乐 7. 健康健身;
timesSearched: 被搜索次数;
createTime: 创建时间;
updateTime: 更新时间;
skillIconList: 技能图标资源列表;


**GET /bgapi/skillsname/** : 获取技能名称

无需鉴权, function为getAllSkillName

返回示例
`[
    {
        "id": "8704fb4c-31e6-11e9-9fad-525400820e38",
        "description": null,
        "name": "飞机票",
        "rate": 0,
        "type": 0,
        "createTime": null,
        "updateTime": null,
        "skillExamples": [],
        "developer": null
    },
    ....
`


**GET: /bgapi/skills/** : 获取所有技能

无需鉴权, function为getAllSkills

返回示例:

`
[
    {
        "id": "8704fb4c-31e6-11e9-9fad-525400820e38",
        "description": "本技能支持查询国内热门城市之间的航班，我们会根据出行时间、起始地、目的地搜索相关飞机票信息。",
        "name": "飞机票",
        "rate": 3,
        "type": 3,
        "createTime": 1550320178000,
        "updateTime": 1550320178000,
        "skillIconList": [
            {
                "id": "d8e69f58-39c7-11e9-9fad-525400820e38",
                "address": "20190226//131011//a.jpg",
                "targetId": "8704fb4c-31e6-11e9-9fad-525400820e38",
                "description": "DEV_ICON",
                "targetName": null
            },
            {
                "id": "f981ab43-39cd-11e9-9fad-525400820e38",
                "address": "20190226//135402//a.jpg",
                "targetId": "8704fb4c-31e6-11e9-9fad-525400820e38",
                "description": "APP_ICON",
                "targetName": null
            }
        ],
        "skillExamples": [
            {
                "id": "4f1d7ea1-31e7-11e9-9fad-525400820e38",
                "skillId": "8704fb4c-31e6-11e9-9fad-525400820e38",
                "example": "看一下去哈尔滨的航班",
                "createTime": 1550320514000,
                "updateTime": 1550320514000,
                "ifMulti": 0
            },
            {
                "id": "5ff0e3c6-31e7-11e9-9fad-525400820e38",
                "skillId": "8704fb4c-31e6-11e9-9fad-525400820e38",
                "example": "订一张重庆到乌鲁木齐的机票",
                "createTime": 1550320542000,
                "updateTime": 1550320542000,
                "ifMulti": 0
            },`


**POST /bgapi/skills/search** : 根据技能名称进行搜索

无需鉴权 function为searchSkills

**GET /bgapi/skills/hot/** : 获取热门技能

无需鉴权 function为listHotSkills

**POST /bgapi/skills/search** : 技能搜索

无需鉴权 function为searchSkills

**DELETE /bgapi/skills/{id}** : 根据id删除技能

权限名称: removeSkill

**POST /bgapi/developers/{id}/skills/** : 增加技能

权限名称: addSkill

**PUT /bgapi/skills/{id}** : 更新技能

权限名称: updateSkill


#### 权限

**POST /bgapi/permissions/** : 增加权限

权限名称: addPermission

**GET /bgapi/permissions/** : 获取全部权限

无需鉴权, functin为getAllPermission

**DELETE /bgapi/permissions/{id}** : 根据id删除权限

权限名称: removePermission

**GET /bgapi/roles/{roleId}/permissions/** : 根据角色获取权限

权限名称: getPermissionByRole

**DELETE /bgapi/roles/{roleId}/permissions/{permissionId}** : 解除指定角色的权限

权限名称: removePermissionOfRole

**POST /bgapi/roles/{roleId}/permissions/{permissionId}** : 给角色增加权限

权限名称: addPermissionForRole


#### 角色

**GET /bgapi/roles/** : 获取所有的角色

无需鉴权, function为listAllRoles

**POST /bgapi/roles/** : 增加角色

权限名称: addRoles

**DELETE /bgapi/roles/** : 删除角色

权限名称: removeRoles


#### 用户

**POST /bgapi/users/password/** : 用户自行修改密码

权限名称: updateSelfPassword

**POST /bgapi/users/** : 增加用户

权限名称: addUser

**PUT /bgapi/users/** : 更新用户

权限名称: updateUser

**GET /bgapi/users/** : 获取所有用户

权限名称: listAllUsers

**POST /bgapi/users/role/{roleId}** : 给新用户增加角色

权限名称: addRole2User

**PUT /bgapi/users/role/{roleId}** : 更新用户角色

权限名称: updateUserRole

**POST /bgapi/users/enable** : 启用用户

权限名称: enableUser

**POST /bgapi/users/disable** : 禁用用户

权限名称: disableUser

**POST /bgapi/users/login** : 用户登陆

用户登陆接口会返回token, token要放在请求的headers里面才能起作用

接口无需鉴权, visitor_permission的function为login

**GET /bgapi/users/{username}** : 根据登陆用户名搜索用户信息

权限名称: findUserByUsername


#### 咪咕有声资源的分类

**GET /bgapi/miguvoice/categories/** : 获取所有咪咕有声分类

接口无需鉴权, visitor_permission的function为getAllMiguCategory

**/bgapi/miguvoice/category/{categoryID}/pageno={pageno}&pagesize={pagesize}** : 分页根据类别id列出咪咕推荐有声资源

接口无需鉴权, visitor_permission的function为分页根据类别id列出咪咕推荐有声资源


