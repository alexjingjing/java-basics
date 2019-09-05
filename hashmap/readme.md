# HashMap

HashMap是重要的Java考点。
核心考点主要集中在线程安全。

**在src的HashMapTest中**，已经写好了代码，证明HashMap的非线程安全了。

理解下来主要是在put方法中，如果线程A、B计算hash后，得到的元素所在索引一致时，会出现覆盖现象。

### 其他考点
- 可以用对象作为key吗？<br>
答：可以。建议实现hashCode和equals方法。因为hashCode用来定位放在哪个index上，equals方法来判断同个index上是否有相同对象。
hashCode使用唯一值，如id之类的，如果hashCode可变，会导致无法找到该对象。
**建议：**使用Integer或String这样的不可变类型作为主键，如果使用对象，重写hashCode和equals函数。hashCode根据id或者其他唯一主键进行计算。
