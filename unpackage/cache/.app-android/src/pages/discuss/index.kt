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
import io.dcloud.uniapp.extapi.hideToast as uni_hideToast
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesDiscussIndex : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDiscussIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDiscussIndex
            val _cache = __ins.renderCache
            val title = ref("discuss")
            val scrollTop = ref<Number>(0)
            val refresherTriggered = ref<Boolean>(false)
            val discussListC = ref<UTSArray<DiscussItem>>(discussListFun())
            val loadinghandle = ref<Boolean>(false)
            val activeIndex2 = ref(0)
            val listBadge = ref(_uA<BadgeItem>(BadgeItem(name = "推荐", isDot = true), BadgeItem(name = "关注", dotNum = 10), BadgeItem(name = "我的收藏", dotNum = 999), BadgeItem(name = "AI")))
            val activeTab = ref<Number>(0)
            val onRefresherrefresh = fun(){
                refresherTriggered.value = true
                setTimeout(fun(){
                    discussListC.value = discussListFun()
                    refresherTriggered.value = false
                }
                , 2000)
            }
            val onChangeTab = fun(item: BadgeItem, index: Number){
                activeTab.value = index
                onRefresherrefresh()
            }
            val onHandle = fun(item: DiscussItem, kVal: String){
                if (!loadinghandle.value) {
                    uni_showToast(ShowToastOptions(title = kVal, icon = "none"))
                    loadinghandle.value = true
                    setTimeout(fun(){
                        loadinghandle.value = false
                        val index = discussListC.value.findIndex(fun(discuss): Boolean {
                            return discuss.id === item.id
                        }
                        )
                        val keyIs = "is" + (kVal.charAt(0).toUpperCase() + kVal.slice(1))
                        val keyNum = "" + kVal + "Num"
                        if (_uA(
                            "good",
                            "like"
                        ).includes(kVal)) {
                            if (discussListC.value[index][keyIs] as Boolean) {
                                discussListC.value[index][keyNum] = discussListC.value[index][keyNum] as Number - 1
                            } else {
                                discussListC.value[index][keyNum] = discussListC.value[index][keyNum] as Number + 1
                            }
                            discussListC.value[index][keyIs] = !(discussListC.value[index][keyIs] as Boolean)
                        } else {
                            discussListC.value[index][keyNum] = discussListC.value[index][keyNum] as Number + 1
                        }
                        uni_hideToast()
                    }
                    , 2000)
                }
            }
            onPageScroll(fun(options: OnPageScrollOptions){
                scrollTop.value = options.scrollTop
            }
            )
            return fun(): Any? {
                val _component_uni_fab_button = resolveEasyComponent("uni-fab-button", GenUniModulesUniFabButtonComponentsUniFabButtonUniFabButtonClass)
                return _cE("view", _uM("class" to _nC(_uA(
                    "rice-theme-" + unref(state).appTheme,
                    "page"
                )), "style" to _nS(_uM("paddingTop" to ("" + unref(state).statusBarHeight + "px")))), _uA(
                    _cE("view", _uM("class" to "tabs"), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(unref(listBadge), fun(item, index, __index, _cached): Any {
                            return _cE("view", _uM("class" to "tab", "key" to item.name, "onClick" to fun(){
                                onChangeTab(item, index)
                            }
                            ), _uA(
                                _cE("text", _uM("class" to "item-text"), _tD(item.name), 1),
                                if (unref(activeTab) === index) {
                                    _cE("view", _uM("key" to 0, "class" to "tab-indicator"))
                                } else {
                                    _cC("v-if", true)
                                }
                            ), 8, _uA(
                                "onClick"
                            ))
                        }
                        ), 128)
                    )),
                    _cE("scroll-view", _uM("direction" to "vertical", "style" to _nS(_uM("flex" to "1")), "refresher-enabled" to true, "enable-passive" to true, "refresher-triggered" to unref(refresherTriggered), "onRefresherrefresh" to onRefresherrefresh), _uA(
                        _cE("view", _uM("class" to "card"), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(unref(discussListC), fun(item, index, __index, _cached): Any {
                                return _cE("view", _uM("key" to item.id, "class" to _nC(_uA(
                                    "item",
                                    if (index > 0) {
                                        "item-index"
                                    } else {
                                        ""
                                    }
                                ))), _uA(
                                    _cE("view", _uM("class" to "item-top"), _uA(
                                        _cV(unref(GenComponnetsMyAvatarClass)),
                                        _cE("view", _uM("class" to "item-text"), _uA(
                                            _cE("text", _uM("class" to "item-tit"), _tD(item.name), 1)
                                        ))
                                    )),
                                    _cE("text", _uM("class" to "item-content"), _tD(item.content), 1),
                                    _cE("view", _uM("class" to "item-bottom"), _uA(
                                        _cE("view", _uM("class" to "item-hand", "onClick" to fun(){
                                            onHandle(item, "good")
                                        }
                                        ), _uA(
                                            if (isTrue(item.isGood)) {
                                                _cE("text", _uM("key" to 0, "class" to "icon"), _tD("\ue8AD"))
                                            } else {
                                                _cE("text", _uM("key" to 1, "class" to "icon"), _tD("\ue8C3"))
                                            }
                                            ,
                                            _cE("text", _uM("class" to "item-hand-num"), " " + _tD(item.goodNum), 1)
                                        ), 8, _uA(
                                            "onClick"
                                        )),
                                        _cE("view", _uM("class" to "item-hand", "onClick" to fun(){
                                            onHandle(item, "like")
                                        }
                                        ), _uA(
                                            if (isTrue(item.isLike)) {
                                                _cE("text", _uM("key" to 0, "class" to "icon"), _tD("\ue6d4"))
                                            } else {
                                                _cE("text", _uM("key" to 1, "class" to "icon"), _tD("\ue6d7"))
                                            }
                                            ,
                                            _cE("text", _uM("class" to "item-hand-num"), " " + _tD(item.likeNum), 1)
                                        ), 8, _uA(
                                            "onClick"
                                        )),
                                        _cE("view", _uM("class" to "item-hand"), _uA(
                                            _cE("text", _uM("class" to "icon"), _tD("\ue6B3")),
                                            _cE("text", _uM("class" to "item-hand-num"), " " + _tD(item.viewNum), 1)
                                        )),
                                        _cE("view", _uM("class" to "item-hand", "onClick" to fun(){
                                            onHandle(item, "share")
                                        }
                                        ), _uA(
                                            _cE("text", _uM("class" to "icon"), _tD("\ue716")),
                                            _cE("text", _uM("class" to "item-hand-num"), " " + _tD(item.shareNum), 1)
                                        ), 8, _uA(
                                            "onClick"
                                        ))
                                    ))
                                ), 2)
                            }
                            ), 128)
                        ))
                    ), 44, _uA(
                        "refresher-triggered"
                    )),
                    _cV(_component_uni_fab_button, _uM("class" to "fab-btn"))
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
                return _uM("page" to _pS(_uM("backgroundColor" to "var(--rice-navbar-background)", "height" to "100%", "width" to "100%")), "tabs" to _pS(_uM("height" to 44, "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "paddingTop" to 0, "paddingRight" to 4, "paddingBottom" to 0, "paddingLeft" to 4)), "tab" to _uM(".tabs " to _uM("paddingTop" to 0, "paddingRight" to 12, "paddingBottom" to 0, "paddingLeft" to 12, "position" to "relative", "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "height" to "100%")), "tab-indicator" to _uM(".tabs " to _uM("width" to 20, "height" to 3, "position" to "absolute", "bottom" to 4, "left" to "50%", "transform" to "translateX(-50%)", "zIndex" to 1, "borderTopLeftRadius" to 100, "borderTopRightRadius" to 100, "borderBottomRightRadius" to 100, "borderBottomLeftRadius" to 100, "backgroundColor" to "var(--rice-primary-color)")), "item-text" to _uM(".tabs " to _uM("color" to "var(--text-color1)"), ".card .item .item-top " to _uM("marginLeft" to 5)), "card" to _pS(_uM("paddingTop" to 0, "paddingRight" to 16, "paddingBottom" to 12, "paddingLeft" to 16)), "item-index" to _uM(".card " to _uM("marginTop" to 8)), "item" to _uM(".card " to _uM("paddingTop" to 12, "paddingRight" to 16, "paddingBottom" to 12, "paddingLeft" to 16, "backgroundColor" to "var(--background-color3)", "borderTopLeftRadius" to 6, "borderTopRightRadius" to 6, "borderBottomRightRadius" to 6, "borderBottomLeftRadius" to 6)), "item-top" to _uM(".card .item " to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center")), "item-tit" to _uM(".card .item .item-top .item-text " to _uM("color" to "var(--text-color1)")), "item-content" to _uM(".card .item " to _uM("paddingTop" to 12, "paddingRight" to 0, "paddingBottom" to 12, "paddingLeft" to 0, "color" to "var(--text-color2)")), "item-bottom" to _uM(".card .item " to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-around")), "item-hand" to _uM(".card .item " to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "item-hand-num" to _uM(".card .item .item-hand " to _uM("color" to "var(--text-color1)", "fontSize" to 12)), "fab-btn" to _pS(_uM("position" to "absolute", "right" to 16, "bottom" to 16)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
