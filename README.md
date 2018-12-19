JCE is a Tencent internal protocol between client and server

* [通信协议之序列化](http://blog.chinaunix.net/uid-27105712-id-3266286.html)

* [腾讯游戏APP协议迭代的那些事](https://juejin.im/post/5aba01cc51882555691902cb)

头部 1 到 2 字节，包含 tag 与 type

```
struct head_one_byte {
  int tag: 4;
  int type: 4;
}

struct head_two_bytes {
  int tag: 4; // 必须 0xF
  int type: 4;
  int real_tag: 8; // 故最多 256 个一级成员
}
```


tag 代表位置，让某些 field 可以省略

type 中基本类型包含长度信息，复杂类型需要额外的长度信息


```
int8        = 0,  len1
int16       = 1,  len2
int32       = 2,  len4
int64       = 3,  len8
float       = 4,  len4
double      = 5,  len8
string1     = 6,  extra len: int8: 最大 255
string4     = 7,  extra len: int32: 理论最大 2^32-1（实际限制是 100 MB)
map         = 8,  extra len: int32: 1代表1对子成员
list        = 9,  extra len: int32: 1代表1个子成员
structBegin = 10,
structEnd   = 11,
zeroTag     = 12,
simpleList  = 13, 子成员只能是 int8
```
