# Meshed Cloud IAM
统一身份管理系统

## 本地开发
启动参数(程序实参)添加
```shell
--spring.profiles.active=dev
```



+---meshed-cloud-iam-adapter
|       |   |                   +---mobile
|       |   |                   +---wap
|       |   |                   \---web
+---meshed-cloud-iam-app
|       |   |                   +---account
|       |   |                   |   +---config
|       |   |                   |   +---executor
|       |   |                   |   |   +---command
|       |   |                   |   |   \---query
|       |   |                   |   \---remote
|       |   |                   \---rbac
|       |   |                       +---executor
|       |   |                       |   +---command
|       |   |                       |   \---query
|       |   |                       \---remote
+---meshed-cloud-iam-domain
|       |   |                   \---domain
|       |   |                       +---account
|       |   |                       |   +---ability
|       |   |                       |   +---constant
|       |   |                       |   +---domainservice
|       |   |                       |   \---gateway
|       |   |                       \---rbac
|       |   |                           +---ability
|       |   |                           +---constant
|       |   |                           +---domainservice
|       |   |                           \---gateway
+---meshed-cloud-iam-infrastructure
|       |   |                   +---config
|       |   |                   \---gatewayimpl
|       |   |                       \---database
|       |   |                           +---dataobject
|       |   |                           \---mapper
