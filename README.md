# viewpagertransformerdemo
viewpager切换动画演示

viewpager提供了一个setPageTransformer来实现切换动画：
```
ViewPager pager = ...;
pager.setPageTransformer(true, new PageTransformer()
{
   public void transformPage(...)
  {
  }
});
```
本实例展示了一些常见的通过pageTransformer来实现的效果
