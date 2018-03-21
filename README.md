# MVPKotlin


# MVP结合DataBinding


## 参考XDroid[enter link description here](https://github.com/limedroid/XDroidMvp)结合DataBinding，删减部分功能，简化代码


*使用说明*

BaseBindingActivity
```
class MainActivity : BaseBindingActivity<VMain>() {

    override fun newV(): VMain {
        return VMain()
    }

    override fun initData(savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)
        v.initUI()
    }
}
```

VBase:
```
class VMain : VBase<MainActivity,ActivityMainBinding>(){

    override fun initUI() {
        super.initUI()
    }

    override val layoutId: Int
        get() = R.layout.activity_main

}
```



后续加入Rxjava+retorfit+okhttp网络架构~