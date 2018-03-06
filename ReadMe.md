#springboot samples

+ 使用yml格式配置文件
> `application.yml` 

+ 整合mybatis + pageHelper分页
> com.iphotowalking.samples.web.CustomerController

+ 整合redis

+ 使用RestTemplate
> 替代 httpclient     例见：
`com.iphotowalking.samples.web.TestController.testRest`

+ Maven管理SpringBoot Profile
> 打包命令：mvn clean package -Dmaven.test.skip=true -Pdev
上面的命令会根据Maven Profile的 dev构建环境包，如果需要prod包，则把-P的参数替换成prod即可。

+ apidocs
> 文档：http://apidocjs.com/#getting-started