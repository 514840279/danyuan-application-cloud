# keystore

Keytool 是一个有效的安全钥匙和证书的管理工具.
Java 中的 keytool.exe （位于 JDK\Bin 目录下）可以用来创建数字证书，所有的数字证书是以一条一条(采用别名区别)的形式存入证书库的中，证书库中的一条证书包含该条证书的私钥，公钥和对应的数字证书的信息。证书库中的一条证书可以导出数字证书文件，数字证书文件只包括主体信息和对应的公钥。 
Keytool 把钥匙和证书储存到一个keystore.默任的实现keystore的是一个文件.它用一个密码保护钥匙.

关于证书的几个概念
一个证书是一个实体的数字签名,还包含这个实体的公共钥匙值. 
公共钥匙 : 是一个详细的实体的数字关联,并有意让所有想同这个实体发生信任关系的其他实体知道.公共钥匙用来检验签名; 
数字签名:是实体信息用实体的私有钥匙签名（加密）后的数据.这条数据可以用这个实体的公共钥匙来检验签名（解密）出实体信息以鉴别实体的身份; 
签名:用实体私有钥匙加密某些消息，从而得到加密数据; 
私有钥匙:是一些数字,私有和公共钥匙存在所有用公共钥匙加密的系统的钥匙对中.公共钥匙用来加密数据，私有钥匙用来计算签名.公钥加密的消息只能用私钥解密，私钥签名的消息只能用公钥检验签名。 
实体:一个实体可以是一个人,一个组织,一个程序,一台计算机,一个商业,一个银行,或其他你想信任的东西.

我们也可以用如下命令生成一个自签名的证书：

    keytool -genkey -dname "CN=fingki,OU=server,O=server,L=bj,ST=bj,C=CN" -alias myCA -keyalg RSA -keysize 1024 -keystore myCALib -keypass 654321 -storepass 123456 -validity 3650
1
这条命令将生成一个别名为myCA的自签名证书，证书的keypair的密码为654321，证书中实体信息为 “CN=fingki,OU=server,O=server,L=bj,ST=bj,C=CN”，存储在名为myCALib的keystore中（如果没有将自动生成一个），这个keystore的密码为123456，密钥对产生的算法指定为RSA，有效期为10年。

详细分析如下:

Keystore的别名: 

所有的keystore入口(钥匙和信任证书入口)是通过唯一的别名访问.别名是不区分大小写的.如别名Hugo和 
hugo指向同一个keystore入口. 
可以在加一个入口到keystore的时候使用-genkey参数来产生一个钥匙对(公共钥匙和私有钥匙)时指定别 
名.也可以用-import参数加一个证书或证书链到信任证书. 

1. keytool -genkey -alias duke -keypass dukekeypasswd 
其中duke为别名,dukekeypasswd为duke别名的密码.这行命令的作用是产生一个新的公共/私有钥匙对. 
假如你想修改密码,可以用: 
keytool -keypasswd -alias duke -keypass dukekeypasswd -new newpass 
将旧密码dukekeypasswd改为newpass. 
可以用-keystore指定其名时,将产生指定的keystore. 
2. 检查一个keystore: 
keytool -list -v -keystore keystore 
Enter keystore password:your password(输入密码) 
3. 输出keystore到一个文件:testkey: 
keytool -export -alias duke -keystore keystore -rfc -file testkey 
系统输出: 
Enter keystore password:your password(输入密码) 
Certificate stored in file 
例如：keytool -export -keystore monitor.keystore -alias monitor -file monitor.cer 
将把证书库 monitor.keystore 中的别名为 monitor 的证书导出到 monitor.cer 证书文件中，它包含证书主体的信息及证书的公钥，不包括私钥，可以公开。 
4. 输入证书到一个新的truststore: 
keytool -import -alias dukecert -file testkey -keystore truststore 
Enter keystore password:your new password.(输入truststore新密码) 
将keystore导入证书中这里向Java默认的证书 cacerts导入Rapa.cert 
keytool -import -alias RapaServer -keystore cacerts -file Rapa.cert -keystore cacerts 
5. 证书条目的删除 
keytool的命令行参数 -delete 可以删除密钥库中的条目，如： keytool -delete -alias RapaServer -keystore d2aApplet.keystore，这条命令将 d2aApplet.keystore 中的 RapaServer 这一条证书删除了。 
6. 将证书导出到证书文件 
keytool -export -alias myCA -file myCA.cer -keystore myCALib -storepass 123456 -rfc 
使用该命令从名为myCALib的keystore中，把别名为myCA的证书导出到证书文件myCA.cer中。(其中-storepass指定keystore的密码，-rfc指定以可查看编码的方式输出，可省略)。 
7. 通过证书文件查看证书信息 
keytool -printcert -file myCA.cer 
8. 密钥库中证书条目口令的修改 
Keytool -keypasswd -alias myCA -keypass 654321 -new newpass -storepass 123456 -keystore myCALib 
9. 删除密钥库中的证书条目 
keytool -delete -alias myCA -keystore myCALib 
10. 把一个证书文件导入到指定的密钥库 
keytool -import -alias myCA -file myCA.cer -keystore truststore 
(如果没有名为truststore的keystore，将自动创建,将会提示输入keystore的密码) 
11. 更改密钥库的密码 
keytool -storepasswd -new 123456 -storepass 789012 -keystore truststore 
其中-storepass指定原密码，-new指定新密码。

用法总结:
keystore好像一个数据库.每种操作,都要先指定keystore名与密码,以及操作的对象别名如: 

..... -alias AAA -keystore jServer.keystore -storepass 123456
操作的一般格式: 
keytool + 操作类型[-genkey,-list -v,-printcert -file,-import -flie,-export -file,-delete,- 
keypasswd -new,-storepasswd -new] + 再加上上面的格式.
实例
```
  C:\keytool>keytool -genkey -alias jason -keystore jServer.keystore -keyalg RSA 
  输入keystore密码：  1234 
  Keystore 密码太短 -至少必须为6个字符 
  输入keystore密码：  123456 
  您的名字与姓氏是什么？ 
    [Unknown]：  huang 
  您的组织单位名称是什么？ 
    [Unknown]：  access 
  您的组织名称是什么？ 
    [Unknown]：  access 
  您所在的城市或区域名称是什么？ 
    [Unknown]：  sz 
  您所在的州或省份名称是什么？ 
    [Unknown]：  gd 
  该单位的两字母国家代码是什么 
    [Unknown]：  china 
  CN=huang, OU=access, O=access, L=sz, ST=gd, C=china 正确吗？ 
    [否]：  y 
  输入<jason>的主密码 
          （如果和 keystore 密码相同，按回车）：  74123 
  主密码太短 -至少必须为 6 个字符 
  输入<jason>的主密码 
        （如果和 keystore 密码相同，按回车）：  456789 
  C:\keytool>keytool -list -v -keystore jServer.keystore 
  输入keystore密码：  123456 
  Keystore 类型： jks 
  Keystore 提供者： SUN 
  您的 keystore 包含 1 输入 
  别名名称： jason 
  创建日期： 2009-6-24 
  输入类型：KeyEntry 
  认证链长度： 1 
  认证 [1]: 
  Owner: CN=huang, OU=access, O=access, L=sz, ST=gd, C=china 
  发照者： CN=huang, OU=access, O=access, L=sz, ST=gd, C=china 
  序号： 4a40fd0f 
  有效期间： Wed Jun 24 00:04:31 CST 2009 至： Tue Sep 22 00:04:31 CST 2009 
  认证指纹： 
          MD5：  4A:67:84:5E:C2:5E:3E:16:05:1D:A9:F4:72:79:13:48 
          SHA1： 01:4A:5A:76:8E:1B:00:D3:5E:FD:CA:3A:D0:52:4E:57:BA:03:26:B9 

  ******************************************* 
  ******************************************* 
```
```
  C:\keytool>keytool -export -alias jason -keystore jServer.keystore -rfc -file jasonfile 
  输入keystore密码：  123456 
  保存在文件中的认证 <jasonfile> 
  C:\keytool>keytool -export -alias jason -keystore jServer.keystore -storepass 123456 -rfc -f 
  ile jasonfile2 
  保存在文件中的认证 <jasonfile2> 
  C:\keytool>keytool -export -alias jason -keystore jServer.keystore -storepass 123456 -rfc -f 
  ile jasonfile.cer 
  保存在文件中的认证 <jasonfile.cer> 
  C:\keytool>keytool -printcert -file jasonfile.cer 
  Owner: CN=huang, OU=access, O=access, L=sz, ST=gd, C=china 
  发照者： CN=huang, OU=access, O=access, L=sz, ST=gd, C=china 
  序号： 4a40fd0f 
  有效期间： Wed Jun 24 00:04:31 CST 2009 至： Tue Sep 22 00:04:31 CST 2009 
  认证指纹： 
          MD5：  4A:67:84:5E:C2:5E:3E:16:05:1D:A9:F4:72:79:13:48 
          SHA1： 01:4A:5A:76:8E:1B:00:D3:5E:FD:CA:3A:D0:52:4E:57:BA:03:26:B9 
  C:\keytool>keytool -keypasswd -alias jason -keypass 456789 -new 20070423 -keystore jServer - 
  storepass 123456 
  keytool错误： java.lang.Exception: Keystore 文件不存在： jServer 
  C:\keytool>keytool -keypasswd -alias jason -keypass 456789 -new 20070423 -keystore jServer.k 
  eystore -storepass 123456 
  C:\keytool>keytool -list -v -alias jason -storepass 123456 
  keytool错误： java.lang.Exception: Keystore 文件不存在： C:\Documents and Settings\Administr 
  ator\.keystore 
  C:\keytool>keytool -list -v -alias jason -keystore jServer.keystore -storepass 123456 
  别名名称： jason 
  创建日期： 2009-6-24 
  输入类型：KeyEntry 
  认证链长度： 1 
  认证 [1]: 
  Owner: CN=huang, OU=access, O=access, L=sz, ST=gd, C=china 
  发照者： CN=huang, OU=access, O=access, L=sz, ST=gd, C=china 
  序号： 4a40fd0f 
  有效期间： Wed Jun 24 00:04:31 CST 2009 至： Tue Sep 22 00:04:31 CST 2009 
  认证指纹： 
          MD5：  4A:67:84:5E:C2:5E:3E:16:05:1D:A9:F4:72:79:13:48 
          SHA1： 01:4A:5A:76:8E:1B:00:D3:5E:FD:CA:3A:D0:52:4E:57:BA:03:26:B9 
  C:\keytool>keytool -delete -alias jason -keystore jServer.keystore -storepass 123456 
  C:\keytool>keytool -list -v -alias jason -keystore jServer.keystore -storepass 123456 
  keytool错误： java.lang.Exception: 别名 <jason> 不存在 
  C:\keytool>keytool -import -alias hwj -file jasonfile.cer -keystore jServer.keystore -storep 
  ass 123456 
  Owner: CN=huang, OU=access, O=access, L=sz, ST=gd, C=china 
  发照者： CN=huang, OU=access, O=access, L=sz, ST=gd, C=china 
  序号： 4a40fd0f 
  有效期间： Wed Jun 24 00:04:31 CST 2009 至： Tue Sep 22 00:04:31 CST 2009 
  认证指纹： 
          MD5：  4A:67:84:5E:C2:5E:3E:16:05:1D:A9:F4:72:79:13:48 
          SHA1： 01:4A:5A:76:8E:1B:00:D3:5E:FD:CA:3A:D0:52:4E:57:BA:03:26:B9 
  信任这个认证？ [否]：  y 
  认证已添加至keystore中 
  C:\keytool>keytool -list -v -alias jason -keystore jServer.keystore -storepass 123456 
  keytool错误： java.lang.Exception: 别名 <jason> 不存在 
  C:\keytool>keytool -list -v -alias hwj -keystore jServer.keystore -storepass 123456 
  别名名称： hwj 
  创建日期： 2009-6-24 
  输入类型： trustedCertEntry 
  Owner: CN=huang, OU=access, O=access, L=sz, ST=gd, C=china 
  发照者： CN=huang, OU=access, O=access, L=sz, ST=gd, C=china 
  序号： 4a40fd0f 
  有效期间： Wed Jun 24 00:04:31 CST 2009 至： Tue Sep 22 00:04:31 CST 2009 
  认证指纹： 
          MD5：  4A:67:84:5E:C2:5E:3E:16:05:1D:A9:F4:72:79:13:48 
          SHA1： 01:4A:5A:76:8E:1B:00:D3:5E:FD:CA:3A:D0:52:4E:57:BA:03:26:B9 
  C:\keytool>keytool -storepasswd -new 20070423 -keystore jServer.keystore -storepass 123456 
```