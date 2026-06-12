@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI194B5B1
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.unicloud.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import kotlin.properties.Delegates
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
import io.dcloud.uniapp.extapi.setAppTheme as uni_setAppTheme
open class GenPagesMineIndex : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesMineIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesMineIndex
            val _cache = __ins.renderCache
            val style = computed(fun(): UTSJSONObject {
                return _uO("paddingTop" to (state.statusBarHeight + state.navbarHeight + "px"), "paddingBottom" to (state.safeAreaInsetsHeight + "px"))
            }
            )
            val onSetTheme = fun(kVal: String){
                setAppTheme(kVal)
                setIsFollowSystem(false)
                if (state.uniPlatform === "app") {
                    uni_setAppTheme(SetAppThemeOptions(theme = kVal as String, success = fun(_) {
                        console.log("设置appTheme为 " + kVal + " 成功", " at pages/mine/index.uvue:56")
                    }
                    , fail = fun(e: IAppThemeFail) {
                        console.log("设置appTheme为 " + kVal + " 失败,原因:", e.errMsg, " at pages/mine/index.uvue:59")
                    }
                    ))
                }
            }
            val onToAbout = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/explanation/index"))
            }
            val onToSetting = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/setting/index"))
            }
            val onToFeedback = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/feedback/index"))
            }
            return fun(): Any? {
                val _component_uni_badge_view = resolveEasyComponent("uni-badge-view", GenUniModulesUniBadgeViewComponentsUniBadgeViewUniBadgeViewClass)
                return _cE("view", _uM("class" to _nC(_uA(
                    "theme-" + unref(state).appTheme,
                    "page"
                )), "style" to _nS(unref(style))), _uA(
                    _cV(unref(GenComponnetsMyNavbarClass), null, _uM("right" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "nav-right"), _uA(
                                if (unref(state).appTheme == "dark") {
                                    _cE("text", _uM("key" to 0, "class" to "icon nav-icon", "onClick" to fun(){
                                        onSetTheme("light")
                                    }), _tD("\ue8C4"), 8, _uA(
                                        "onClick"
                                    ))
                                } else {
                                    _cE("text", _uM("key" to 1, "class" to "icon nav-icon", "onClick" to fun(){
                                        onSetTheme("dark")
                                    }
                                    ), _tD("\ue8C5"), 8, _uA(
                                        "onClick"
                                    ))
                                }
                                ,
                                _cV(_component_uni_badge_view, _uM("text" to "5"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE("text", _uM("class" to "icon nav-icon"), _tD("\ue8C7"))
                                    )
                                }
                                ), "_" to 1))
                            ))
                        )
                    }
                    ), "_" to 1)),
                    _cE("view", _uM("class" to "header"), _uA(
                        _cE("view", _uM("class" to "header-avatar"), _uA(
                            _cV(unref(GenComponnetsMyAvatarClass), _uM("src" to "/static/image/avatar.jpg", "mode" to "aspectFit", "style" to _nS(_uM("width" to "100%", "height" to "100%"))), null, 8, _uA(
                                "style"
                            ))
                        )),
                        _cE("view", _uM("class" to "h-right"), _uA(
                            _cE("text", _uM("class" to "h-text1"), "昵称"),
                            _cE("text", _uM("class" to "h-text2"), "等级")
                        ))
                    )),
                    _cV(unref(GenComponnetsMyCellGroupClass), _uM("inset" to true), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cV(unref(GenComponnetsMyCellClass), _uM("title" to "活动", "arrow" to true)),
                            _cV(unref(GenComponnetsMyCellClass), _uM("title" to "设置", "arrow" to true, "onClick" to onToSetting)),
                            _cV(unref(GenComponnetsMyCellClass), _uM("title" to "反馈", "arrow" to true, "onClick" to onToFeedback)),
                            _cV(unref(GenComponnetsMyCellClass), _uM("title" to "关于", "arrow" to true, "onClick" to onToAbout))
                        )
                    }
                    ), "_" to 1))
                ), 6)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("page" to _pS(_uM("backgroundColor" to "var(--navbar-background)", "height" to "100%", "width" to "100%")), "nav-right" to _pS(_uM("display" to "flex", "flexDirection" to "row", "marginRight" to 16)), "nav-icon" to _uM(".nav-right " to _uM("fontSize" to 24, "marginLeft" to 12), ".card " to _uM("lineHeight" to "24px")), "header" to _pS(_uM("marginTop" to 12, "marginRight" to 16, "marginBottom" to 12, "marginLeft" to 16, "display" to "flex", "flexDirection" to "row")), "header-avatar" to _uM(".header " to _uM("width" to 80, "height" to 80)), "h-right" to _uM(".header " to _uM("marginLeft" to 10, "display" to "flex", "justifyContent" to "center", "overflow" to "visible")), "h-text1" to _uM(".header " to _uM("color" to "var(--text-color-1)", "fontSize" to 16)), "h-text2" to _uM(".header " to _uM("marginTop" to 4, "fontSize" to 14, "color" to "var(--text-color-2)")), "card" to _pS(_uM("marginTop" to 12, "marginRight" to 16, "marginBottom" to 12, "marginLeft" to 16, "borderTopLeftRadius" to 16, "borderTopRightRadius" to 16, "borderBottomRightRadius" to 16, "borderBottomLeftRadius" to 16, "overflow" to "hidden")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
