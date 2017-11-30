#spring cloud 技术栈整理
##计划集成进去的东西：
###分布式相关
    分布式锁
    分布式调用
    服务自动注册发现：Ribbon，Eureka 
    
### 稳定性相关
    Hystrix     
###代码质量检测  
    单元测试覆盖：jacoco
    代码质量管理系统：sonarqube
###加快工程开发
     swagger：减少前后端交互的过程，类似的工具还有小幺鸡
     lambok：减少setter，getter代码，更关注业务         
###服务监控
    zippkin：查看分布式调用链 
###服务  
    搜索

### 
    权限验证：EnableOAuth2Sso
###部署： 
    docker
    
### 代码规则，
 每个moudule定义错误码的起始头信息，    
 关键字段约定
    通用的字段：
 ```
 1:开始时间：
 2:结束时间：
 3:页码：
 4:一页显示条数：
 5:偏移量：
 ```       
    
    