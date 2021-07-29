# 个人主页项目说明



## 1. 项目资源：

### 项目访问路径：**（服务器于9.14到期）**

- **主页生成**： [http://47.106.67.138](http://47.106.67.138)
- **主页访问**（数字为用户编号uid）：[http://47.106.67.138/info/数字](http://47.106.67.138/info/数字)
- **开发者主页**： [http://47.106.67.138/info/2](http://47.106.67.138/info/2)
- **留言开发者**： [http://47.106.67.138/info/2#message](http://47.106.67.138/info/2#message)



### 开源链接：

- **GitHub地址**：[https://github.com/dlhjw/dlhjw_website](https://github.com/dlhjw/dlhjw_website)

  > 分SpringBoot版与Tars部署版，后缀名为Tars是Tars部署版

- **静态页面（生成页）**：[https://dlhjw.github.io](https://dlhjw.github.io)

- **静态页面（主页）**：[https://dlhjw.github.io/u](https://dlhjw.github.io/u)



### **公众号链接：**

- **第一阶段**： [https://mp.weixin.qq.com/s/bSbkjRGRQjUG3lgjRDMrkg](https://mp.weixin.qq.com/s/bSbkjRGRQjUG3lgjRDMrkg) 
- **第二阶段**： [https://mp.weixin.qq.com/s/R95voHz8QS6GVeaQo0gxzg](https://mp.weixin.qq.com/s/R95voHz8QS6GVeaQo0gxzg) 
- **业务设计**： [https://mp.weixin.qq.com/s/PYZUrw4SmUVE0RTwaQKzJw](https://mp.weixin.qq.com/s/PYZUrw4SmUVE0RTwaQKzJw) 
- **致用户（使用说明）**：[https://mp.weixin.qq.com/s/N_Mw8dciQGOeMETlQrtzWQ](https://mp.weixin.qq.com/s/N_Mw8dciQGOeMETlQrtzWQ) 



### 博客链接：

- **CSDN：**[https://blog.csdn.net/dlhjw1412](https://blog.csdn.net/dlhjw1412)

- **博客园**：[https://www.cnblogs.com/dlhjw](https://www.cnblogs.com/dlhjw)

- **简书**：[https://www.jianshu.com/u/d3dc1fbf7ed8](https://www.jianshu.com/u/d3dc1fbf7ed8)





## 2. Clone说明：

> 部署图文说明可以访问公众号：多氯环己烷，回复关键字“个人主页”。推文链接：

### SpringBoot版：

> clone代码后主要是做些配置即可，有中文注释，方法都很简单。 

1. 首先，在`application.yaml`文件配置您的数据库信息； 
2. 接着，在`myConfig.properties`文件配置您想将头像文件与证书文件的保存路径；
3. 然后运行主启动类`DlhjwWebsiteApplication`就可以在本地主机上跑起来了。 



### Tars部署版：

> Tars部署需要先完成上述数据库配置与文件路径配置。

1. 配置服务接口名；
2. 将项目打成jar包，发布到您的Tars Http服务后即可。 

