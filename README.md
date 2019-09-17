# 常用工具 收集工程

- ###audio
    > 音频工具包
- ###bean
    > 实体类转换工具包 map->obj; xml->obj； 序列化和反序列化
- ###common
    > 通用工具包 接口返回模板 日历扩展实体类 Pattern 预编译工具类 常用状态码
- ###encrypt
    > 加解密工具包 AES对称|3DES加解密 Base64编码 基础加密组件 MD5工具 RSA非对称加解密
- ###io
    > io工具包 加载资源文件 文件键值获取 文件复制|下载|文件流的获取
- ###latitude
    > 经纬度工具包 地球经纬度获取
- ###net
    > 互联网链接工具包 ftp工具 IP获取 网络设备硬件获取 IP所在地获取
- ###picture
    > 图片工具包 图片相似度比较 二维码创建解析
- ###time
    > 时间工具包 当前时间的获取 时间的比较 时间格式化
- ###util
    > 常用工具包 数组的去重|取集|转化|移除元素|合并字符 集合的转换Map|拆分| 汉语拼音转换 结巴分词 字符串工具
- ###zip
    > 压缩解压缩工具包 文件压缩解压缩


- ###BooleanUtil
     > __BooleanUtil__   多个判断 判断 
    - boolean **isALLFalse** (boolean... flag)
        ```
        多个标志 判断是否都为false 全为fasle返回true
        ```
    - boolean __isALLTrue__ (boolean... flag)
        > 多个标志 判断是否都为true 全为true返回true
- ###ConfigProUtil
    > __ConfigProUtil__ 根据类文件加载资源文件。项目class根目录下
    - Properties __getProperties__( String name,Class<?> className)
        > 获取配置文件对象
- ###ConfigUtil###
    > __ConfigUtil__ 获取文件中的键对应的值
- ###HanyuUtil
    > __HanyuUtil__ 汉语转拼音
    - String **getCharacterPinYin** (char c)
        > 转换单个字符为拼音 只取一个发音，如果是多音字，仅取第一个发音
    - String **getStringPinYin** (String str) 
        > 字符串转换一个拼音的字符串
- ###HttpClientUtil__
    > http 请求工具类
    - String **processGet** (String URL, Map<String, String> parameterMap,
      			Map<String, String> headerMap)
    - String **processPost** (String URL, String params,
      			Map<String, String> headerMap) 
    - String **processPostJson** (String URL, String params,
      			Map<String, String> headerMap) 
    - String **processGet** (String URL)
- ###CollectionUtils
    > 集合工具类
    -  ```<K, V> Map<K, V> list2Map(List<V> list, String keyMethodName, Class<V> c)```
        > list中元素的方法作为Map的K键，元素作为Map的V值。 CollectionUtil.list2Map(strings, "toString", String.class);
    -  ```<T> List<List<T>> split(List<T> resList, int count)```
        > 拆分集合 分批带零头
    -  ```<T> List<List<T>> splitList(List<T> listSrc, Integer multipleNum)```
        > 拆分集合 分批带零头
    -  ```<T> List<List<T>> splitListEq (List<T> listSrc, Integer multipleNum)```
        > 总数量均匀分配，多余的放最后一部分
- ###NetUtil
    > **NetUtil** 网络工具类
    - String **getIpAddr** (HttpServletRequest request) 
        > 获取真实 IP 地址
    - String **getNativeIp** ()
        > 获得 本机IP
    - Map<String,String> **getLocalIpAddr** ()
        > 获取 本机IP 多个硬件获取IP可以返回一个list
- ###ResultStatus
    > **ResultStatus** 状态码
- ###StrUtil
    > **StrUtil** 字符串 工具类
    - boolean **isEmpty** (String str)
        > 字符串为空 返回 true
    - boolean **isNotEmpty** (String str)
        > 字符串不为空 返回 true
    - boolean **isLessEmpty** (Object... args)
        > 至少有一个为空返回 true
    - boolean **isLessEmpty** (Object... args)
        >  至少有一个为空返回 true
    - boolean **isLessNotEmpty** (Object... args)
        > 至少有一个不为空返回 true
    - boolean **isAllNotEmpty** (Object... args)
        > 都不为空返回 true
    - List **strSplitToList** (String str, String regex) 
        > 传入原字符 和 截取标准 将字符串截取为list
    - List<String> **getBetweenSub** (String soap, String rgex) 
        > 正则表达式匹配两个指定字符串中间的内容
    - List<String> **subStrList** (String str, String regex)
        > 根据正则标准截取字符串，返回符合标准的所有的字符串的集合。
    - String **getSubConTogether** (String str, String regex) 
        > 根据正则标准截取字符串，返回符合标准的所有的字符串组成新的字符串。
    - String **getFirstSub** (String soap, String rgex)
        > 返回单个字符串，若匹配到多个的话就返回第一个字符串
    - int **getCharacterPosition** (String string, String matString, int n)
        > 获取特定字符在字符串中的位置
    - String **removeDigital** (String value )
        > 剔除数字
- ###PatternCompile
    > **PatternUtil** Pattern 预编译工具类
    - **NUMBER_PATTERN** 
        > 数字
    - **NUMBER_PATTERN_D**
        > 任意数字
    - **azAZ_PATTERN**
        >  [a-zA-Z] 大小写字母
    - **CHINESE_PATTERN**
        > 匹配中文 [\u4e00-\u9fa5]
    - **LIMIT_PATTERN**
        > 汉字 大小字母 数字 下划线 的组合 4到10个
    - **NUM_AZ_PATTERN**
        > 由数字、26个英文字母或者下划线组成的字符串
    - **EMAIL_PATTERN**
        > 邮件地址匹配
    - **MOBILENUM_PATTERN**
        > 手机号
    - **ID_PATTERN**
        > 身份证
    - **URL_PATTERN**
        > URL
    - **USERNAME_PATTERN**
        > 匹配帐号是否合法(字母开头，允许5-16字节，允许字母数字下划线)
    - **PHONENUM_PATTERN**
        > 国内电话号码
    - **IPV4_PATTERN**
        > IPv4
    - **QQ_PATTERN**
        > QQ
    - **POSTAL_PATTERN**
        > 中国邮政编码
